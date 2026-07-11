package com.utils;

import static io.restassured.RestAssured.*;

import com.constants.Roles;

import Pojo_classes_automation_framework.logincred;
import io.restassured.http.ContentType;

public class Authtoken_generator {
 
	private static logincred usercred;
	
	public static String getToken(Roles role)
	{
		
		if(role==Roles.FD)
		usercred=new logincred("iamfd","password");
		else if(role==Roles.SUP)
			usercred=new logincred("iamsup","password");
		else if(role==Roles.ENG)
			usercred=new logincred("iameng","password");
		else if(role==Roles.QC)
			usercred=new logincred("iamqc","password");
	
		String token=given().baseUri(ConfigManager.getProperty("BASEURI"))
		.contentType(ContentType.JSON).body(usercred)
		.when().post("login")
		.then().extract().jsonPath().getString("data.token");
		
		return token;
	}
	

	
	
}
