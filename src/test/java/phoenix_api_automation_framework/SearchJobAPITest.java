package phoenix_api_automation_framework;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.services.JobService;
import com.constants.Roles;
import com.utils.SpecUtil;

import Pojo_classes_automation_framework.SearchJob;

public class SearchJobAPITest {

	
	
	private JobService service;
	SearchJob payload;
	
	@BeforeMethod
	public void setup()
	{
		service=new JobService();
		
		payload=new SearchJob("JOB_366727");
		
	}
	
	@Test
	public void verifySearchJob()
	{
		 
		service.SearchJob(Roles.FD,payload)
		.then().spec(SpecUtil.responsespec())
		.body("message", Matchers.equalTo("Success"));
	}
		
}
