package phoenix_api_automation_framework;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.api.services.DashboardService;
import com.constants.Roles;
import com.utils.SpecUtil;

import Pojo_classes_automation_framework.DashboardDetail;

public class DashboardDetailAPITest {

	
	private DashboardService service;
	
	DashboardDetail reqbody;
	
	@BeforeMethod
	public void setup()
	{
		service=new DashboardService();
		reqbody=new DashboardDetail("created_today");
		
	}
	
	
	@Test
	public void verifyDashboardDetailAPI()
	{
		service.Details(Roles.FD, reqbody)
		.then().spec(SpecUtil.responsespec())
		.body("message",Matchers.equalTo("Success"));
		
	}
	
	
}
