package com.api.services;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.constants.Roles;
import com.utils.SpecUtil;

import io.restassured.response.Response;

public class JobService {

	private final String Create_JOB_ENPOINT="/job/create";
	private final String SearchJOB_ENDPOINT="/job/search";
	private static Logger logger=LogManager.getLogger(JobService.class);
	
	public Response Job(Roles role,Object Payload) {
		
		logger.info("Calling Create Job from Job service");
	Response res=given().spec(SpecUtil.requestspecwithAuth(role, Payload)).when().post(Create_JOB_ENPOINT);
	
	return res;
	}
	
	
	public Response SearchJob(Roles role,Object Payload)
	{
		logger.info("Calling SearchJob from Job service");

		Response res=given().spec(SpecUtil.requestspecwithAuth(role, Payload))
		.when().post(SearchJOB_ENDPOINT);
		
		return res;
	}
	
	
}
