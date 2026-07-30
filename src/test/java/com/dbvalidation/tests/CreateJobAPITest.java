package com.dbvalidation.tests;

import com.api.db.dao.CustomerDao;
import com.api.db.dao.CustomerProductDao;
import com.api.db.dao.Customer_AddressDao;
import com.api.db.dao.JobHeadDao;
import com.api.db.dao.MapJobProblemDao;
import com.constants.Model_name;
import com.constants.OEM;
import com.constants.Platform;
import com.constants.Problems;
import com.constants.Product;
import com.constants.Roles;
import com.constants.ServiceLocation;
import com.constants.Warranty;
import com.database.models.CustomerAddressDatabaseModel;
import com.database.models.CustomerDataBaseModel;
import com.database.models.CustomerProductDatabaseModel;
import com.database.models.JobHeadModel;
import com.database.models.MapJobProblemModel;
import com.utils.DateTimeUtil;
import com.utils.FakerDataGenerator;
import com.utils.Generate14digit_random;
import com.utils.SpecUtil;

import Pojo_classes_automation_framework.Customer;
import Pojo_classes_automation_framework.Customer_Address;
import Pojo_classes_automation_framework.Customer_Product;
import Pojo_classes_automation_framework.Problem;
import Pojo_classes_automation_framework.createJobPayload;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateJobAPITest {

	createJobPayload reqbody;
	Customer customer;
	Customer_Address customer_address;
	Customer_Product customer_product; 

	@BeforeMethod(description="create payload for createjobAPI", groups= {"api","regression","smoke"})
	public void setupPayload() {
		
		
		String imei=Generate14digit_random.getNumber();
	
		 customer = new Customer("Bat", "man", "8888111111", "",
		 "random1233@gmail.com", ""); 
		 customer_address = new
		 Customer_Address("2344", "Galaxy", "Baker street 2111", "Baker street",
		 "Goa", "11111", "India", "Goa"); 
		 customer_product = new Customer_Product(DateTimeUtil.getTimewithDaysAgo(10),imei,imei,imei
				,DateTimeUtil.getTimewithDaysAgo(10),
		  Product.NEXUS_2.getCode(), Model_name.Nexus2_blue.getCode()); 
		 
			List<Problem> problemlist = new ArrayList<Problem>();

		  Problem problem = new Problem(Problems.OVERHEATING.getCode(),
		  "Heating Issue");
		  
		  problemlist.add(problem);
		  
		  reqbody = new createJobPayload(ServiceLocation.SERVICELOCATION_A.getCode(),
		  Platform.FRONT_DESK.getCode(), Warranty.INWARRANTY.getCode(),
		  OEM.GOOGLE.getCode(), customer, customer_address, customer_product,
		 problemlist);
		 
	}

	@Test(description="verify createjobAPI", groups= {"api","regression","smoke"})
	public void verifycreateJob() {

		Response response=given().spec(SpecUtil.requestspecwithAuth(Roles.FD, reqbody)).when().post("/job/create/").then()
				.spec(SpecUtil.responsespec()).body("message", Matchers.equalTo("Job created successfully. "))
				.body("data.job_number",Matchers.startsWith("JOB_")).extract().response();

		
		int custid=response.jsonPath().getInt("data.tr_customer_id");
		
		int tr_job_head_id=response.jsonPath().getInt("data.id");
		
		  CustomerDataBaseModel customerdb=CustomerDao.getCustominfo(custid);
		  
		  CustomerAddressDatabaseModel customer_add=Customer_AddressDao.getCustomerAddress(customerdb.getTr_customer_address_id());
	
		  CustomerProductDatabaseModel cust_prod=CustomerProductDao.getcustomerProductdbinfo(custid);
		  
		  MapJobProblemModel probdb=MapJobProblemDao.getProbleminfo(tr_job_head_id);
		  
		  
		  JobHeadModel jobhead=JobHeadDao.getJobHeadinfo(tr_job_head_id);
		  
		  Assert.assertEquals(customerdb.getFirst_name(),customer.first_name());
		  Assert.assertEquals(customer_add.getFlat_number(),customer_address.getFlat_number());
		  Assert.assertEquals(cust_prod.getImei1(),customer_product.getImei1());
		  
		  Assert.assertEquals(probdb.getMst_problem_id(), reqbody.getProblems().get(0).id());
		  Assert.assertEquals(probdb.getRemark(), reqbody.getProblems().get(0).remark());
		  
		  
		  Assert.assertEquals(jobhead.getMst_oem_id(), reqbody.getMst_oem_id());
		  
		  System.out.println(customerdb.getTr_customer_address_id());
		 
	}
	

}
