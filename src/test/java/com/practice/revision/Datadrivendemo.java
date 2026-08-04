package com.practice.revision;

import static io.restassured.RestAssured.given;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hamcrest.Matchers;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.api.db.dao.createJobDao;
import com.constants.Roles;
import com.utils.CSVReadUtil;
import com.utils.CreateJobBeanMapper;
import com.utils.ExcelReaderUtil;
import com.utils.FakerDataGenerator;
import com.utils.JsonReaderUtil;
import com.utils.SpecUtil;

import Pojo_classes_automation_framework.CreateJobBean;
import Pojo_classes_automation_framework.createJobPayload;
import Pojo_classes_automation_framework.logincred;
import Pojo_classes_automation_framework.logincredp;

public class Datadrivendemo {


	@DataProvider(name="dataproviderLogin")
	public Iterator<createJobPayload> dataProvider()
	{    
		                   List<CreateJobBean> bean= createJobDao.getCreateJobpayloadBean();
		 List<createJobPayload> list=new ArrayList<>();
		          createJobPayload temp=null;
		                   for(int i=0;i<bean.size();i++)
		                   { 
		                	   temp=CreateJobBeanMapper.createJobBeanmappingtoPayload(bean.get(i));
		                	   
		                	   list.add(temp);
		                	   
		                   }
		                
		                  
		                
		                   
		return list.iterator();
	}


      @Test(dataProvider="dataproviderLogin")
	public void loginAPITest(createJobPayload s)
	{
    		given().spec(SpecUtil.requestspecwithAuth(Roles.FD, s)).when().post("/job/create/").then()
			.log().all();

	}
	
}


