package com.api.services;

import com.constants.Roles;
import com.utils.SpecUtil;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class AuthService {

	private static Logger logger = LogManager.getLogger(AuthService.class);
	private static final String LOGIN_ENDPOINT = "login";

	public Response login(Object cred) {
		logger.info("Calling Login method from Auth Service");
		Response res = given().spec(SpecUtil.requestspec(cred)).when().post(LOGIN_ENDPOINT);
		return res;
	}

}
