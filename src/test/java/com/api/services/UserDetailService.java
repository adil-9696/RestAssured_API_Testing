package com.api.services;

import static io.restassured.RestAssured.given;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.constants.Roles;
import com.utils.SpecUtil;

import io.restassured.response.Response;

public class UserDetailService {

	private final String UserDetail_ENDPOINT="userdetails";
	private static Logger logger=LogManager.getLogger(UserDetailService.class);
	
	public Response UserDetails(Roles role)
	{
		logger.info("Calling Userdetails from Userdetails service");

		Response res=given().spec(SpecUtil.requestspecwithAuth(role)).when().get(UserDetail_ENDPOINT);
	return res;
	}
	
	
}
