package com.api.phoenix.datadriven_Tests;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import com.constants.Roles;
import com.utils.SpecUtil;

import Pojo_classes_automation_framework.CreateJobBean;
import Pojo_classes_automation_framework.createJobPayload;

public class CreateJobAPIDatabaseTest {

	
	

	
	@Test(description="verify createjobAPI", groups= {"api","regression","smoke"},dataProviderClass = com.api.phoenix_DataProviders.dataProviders.class,
			dataProvider="createJobfrmdatabasedata")
	public void verifycreateJobDatadriven(createJobPayload reqbody ) {

		given().spec(SpecUtil.requestspecwithAuth(Roles.FD, reqbody)).when().post("/job/create/").then()
				.spec(SpecUtil.responsespec()).body("message", Matchers.equalTo("Job created successfully. "))
				.body("data.job_number",Matchers.startsWith("JOB_"));

		
	}

}
