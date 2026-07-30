package com.utils;

import static io.restassured.RestAssured.*;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.constants.Roles;

import Pojo_classes_automation_framework.logincred;
import io.restassured.http.ContentType;

public class Authtoken_generator {
 
	private static logincred usercred;
	private static Map<Roles,String> map=new ConcurrentHashMap<>();
	
	
	public static String getToken(Roles role)
	{
		
		if(map.containsKey(role))
		{
			return map.get(role);
		}
		
		
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
		
		map.put(role, token);
		
		return token;
	}
	

	
	
}
