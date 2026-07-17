package com.utils;

import static io.restassured.RestAssured.*;

import org.hamcrest.Matchers;

import com.constants.Roles;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class SpecUtil {

	
	
public static RequestSpecification requestspec(Object payload) {
		
		RequestSpecification req=new RequestSpecBuilder().setContentType(ContentType.JSON)
		.setBaseUri(ConfigManager.getProperty("BASEURI"))
		.setAccept(ContentType.JSON)
		.setBody(payload)
		.log(LogDetail.URI).log(LogDetail.METHOD).log(LogDetail.BODY)
		.build();
		
		return req;
	}
	
	
public static RequestSpecification requestspecwithAuth(Roles role) {
		
		RequestSpecification req=new RequestSpecBuilder().setContentType(ContentType.JSON)
		.setBaseUri(ConfigManager.getProperty("BASEURI"))
		.setAccept(ContentType.JSON)
		.addHeader("Authorization", Authtoken_generator.getToken(role))
		.log(LogDetail.URI).log(LogDetail.METHOD)
		.build();
		
		return req;
	}

public static RequestSpecification requestspecwithMissingAuth() {
	
	RequestSpecification req=new RequestSpecBuilder().setContentType(ContentType.JSON)
	.setBaseUri(ConfigManager.getProperty("BASEURI"))
	.setAccept(ContentType.JSON)
	.log(LogDetail.URI).log(LogDetail.METHOD)
	.build();
	
	return req;
}

public static RequestSpecification requestspecwithAuth(Roles role, Object Payload) {
	
	RequestSpecification req=new RequestSpecBuilder().setContentType(ContentType.JSON)
	.setBaseUri(ConfigManager.getProperty("BASEURI"))
	.setAccept(ContentType.JSON)
	.addHeader("Authorization", Authtoken_generator.getToken(role))
	.setBody(Payload)
	.log(LogDetail.URI).log(LogDetail.METHOD).log(LogDetail.BODY)
	.build();
	
	return req;
}
	
	

public static ResponseSpecification responsespec() {
	
	  ResponseSpecification res=new ResponseSpecBuilder().expectContentType(ContentType.JSON)
	  .expectStatusCode(200).
	 expectResponseTime(Matchers.lessThan(1500L))
	 .log(LogDetail.METHOD)
	 .log(LogDetail.BODY)
	  .build();
	 
	  return res;
	  
}


public static ResponseSpecification responsespec(int Statuscode) {
	
	  ResponseSpecification res=new ResponseSpecBuilder()
	  .expectStatusCode(Statuscode).
	 expectResponseTime(Matchers.lessThan(1500L))
	 .log(LogDetail.BODY)
	  .build();
	 
	  return res;
	  
}
	
}
