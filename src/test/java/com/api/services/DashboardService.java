package com.api.services;

import com.constants.Roles;
import com.utils.SpecUtil;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DashboardService {

	private static Logger logger=LogManager.getLogger(DashboardService.class);
	private final String Count_ENDPOINT="/dashboard/count";
	
	private final String Details_ENDPOINT="/dashboard/details";
	
	
	public Response Count(Roles role)
	{
		logger.info("Calling count from Dashboard service");
		 Response res=given().spec(SpecUtil.requestspecwithAuth(role)).when().get(Count_ENDPOINT);
	return res;
	}
	
	
	public Response Count()
	{
		  
		 Response res=given().spec(SpecUtil.requestspecwithMissingAuth()).when().get(Count_ENDPOINT);
	return res;
	}
	
	
	public Response Details(Roles role,Object Payload)
	{logger.info("Calling Details from Dashboard service");
		Response res=given().spec(SpecUtil.requestspecwithAuth(role, Payload))
		.when().post(Details_ENDPOINT);
	return res;
	}
	
	
}
