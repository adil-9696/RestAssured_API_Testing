package phoenix_api_automation_framework;

import com.constants.Model_name;
import com.constants.OEM;
import com.constants.Platform;
import com.constants.Problems;
import com.constants.Product;
import com.constants.Roles;
import com.constants.ServiceLocation;
import com.constants.Warranty;
import com.utils.DateTimeUtil;
import com.utils.SpecUtil;

import Pojo_classes_automation_framework.Customer;
import Pojo_classes_automation_framework.Customer_Address;
import Pojo_classes_automation_framework.Customer_Product;
import Pojo_classes_automation_framework.Problem;
import Pojo_classes_automation_framework.createJobPayload;
import static io.restassured.RestAssured.*;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateJobAPITest {

	createJobPayload reqbody;

	@BeforeMethod(description="create payload for createjobAPI", groups= {"api","regression","smoke"})
	public void setupPayload() {
		Customer customer = new Customer("Bat", "man", "8888111111", "", "random1233@gmail.com", "");
		Customer_Address customer_address = new Customer_Address("2344", "Galaxy", "Baker street 2111", "Baker street",
				"Goa", "11111", "India", "Goa");
		Customer_Product customer_product = new Customer_Product(DateTimeUtil.getTimewithDaysAgo(10), "09965141301233",
				"09965141301233", "09965141301233", DateTimeUtil.getTimewithDaysAgo(10), Product.NEXUS_2.getCode(),
				Model_name.Nexus2_blue.getCode());
		List<Problem> problemlist = new ArrayList<Problem>();

		Problem problem = new Problem(Problems.OVERHEATING.getCode(), "Heating Issue");

		problemlist.add(problem);

		reqbody = new createJobPayload(ServiceLocation.SERVICELOCATION_A.getCode(), Platform.FRONT_DESK.getCode(),
				Warranty.INWARRANTY.getCode(), OEM.GOOGLE.getCode(), customer, customer_address, customer_product,
				problemlist);

	}

	@Test(description="verify createjobAPI", groups= {"api","regression","smoke"})
	public void verifycreateJob() {

		given().spec(SpecUtil.requestspecwithAuth(Roles.FD, reqbody)).when().post("/job/create/").then()
				.spec(SpecUtil.responsespec()).body("message", Matchers.equalTo("Job created successfully. "))
				.body("data.job_number",Matchers.startsWith("JOB_"));

	}

}
