package com.api.phoenix.datadriven_Tests;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.utils.ConfigManager;
import com.utils.SpecUtil;

import Pojo_classes_automation_framework.LoginBean;
import Pojo_classes_automation_framework.logincred;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class LoginAPITest {
	
	
	@Test(description="loginAPIdatadriven testing",groups= {"smoke","regression"},dataProviderClass =com.api.phoenix_DataProviders.dataProviders.class
			,dataProvider="loginAPIDataProviderCSV")
	public void LoginAPITestdataDriven(LoginBean b) {
		
		given()
		.spec(SpecUtil.requestspec(b))
		.when().post("login")
		.then().spec(SpecUtil.responsespec());
	}

}
