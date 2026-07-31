package com.api.services;

import com.constants.Roles;
import com.utils.SpecUtil;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Epic("User Management")
@Feature("Authentication")
public class AuthService {

	private static Logger logger = LogManager.getLogger(AuthService.class);
	private static final String LOGIN_ENDPOINT = "login";

	public Response login(Object cred) {
		logger.info("Calling Login method from Auth Service");
		Response res = given().spec(SpecUtil.requestspec(cred)).when().post(LOGIN_ENDPOINT);
		return res;
	}

}
