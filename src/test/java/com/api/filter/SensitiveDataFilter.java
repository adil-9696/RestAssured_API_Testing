package com.api.filter;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import io.restassured.filter.Filter;
import io.restassured.filter.FilterContext;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.FilterableRequestSpecification;
import io.restassured.specification.FilterableResponseSpecification;

public class SensitiveDataFilter implements Filter {

	private static Logger logger=LogManager.getLogger(SensitiveDataFilter.class);
	
	@Override
	public Response filter(FilterableRequestSpecification requestSpec, FilterableResponseSpecification responseSpec,
			FilterContext ctx) {

		logger.info("BaseURI: {}",requestSpec.getURI());
		logger.info("HTTP Method: {}",requestSpec.getMethod());
		//logger.info("Headers: {}",requestSpec.getHeaders());
		readactHeader(requestSpec);
		if(requestSpec.getBody()!=null) {
		String payload=redactPayload(requestSpec);
		logger.info("Request Body: {}",payload);}
		Response res=ctx.next(requestSpec, responseSpec);
		
		String responsepayload=redactResponsePayload(res);
		logger.info("Response Body: {}",responsepayload);
		
		
		return res;
	}
	
	
	public String redactPayload(FilterableRequestSpecification requestSpec) {
		
		
		String payload=requestSpec.getBody().toString();
		
	//	"password"\s*:\s*"[^"]+", "password":"REDACTED"
		
		payload=payload.replaceAll("\"password\"\\s*:\\s*\"[^\"]+\"","\"Password\":\"[REDACTED]\"" );
		
		return payload;
		
	}

	
public String redactResponsePayload(Response response) {
		
		String payload=response.asPrettyString();
		
	//	"password"\s*:\s*"[^"]+", "password":"REDACTED"
		
		payload=payload.replaceAll("\"token\"\\s*:\\s*\"[^\"]+\"","\"token\":\"[REDACTED]\"" );
		
		return payload;
		
	}


public void readactHeader(FilterableRequestSpecification requestSpec)

{
	   List<Header> headerlist=requestSpec.getHeaders().asList();
	   
	   for(int i=0;i<headerlist.size();i++)
	   { 
		   Header header=headerlist.get(i);
		  String value=header.getName();
		   if(value.equals("Authorization"))
		   {
			   logger.info(header.getName()+": REDACTED");
			   
		   }
		   
		   else {
			   logger.info(header.getName()+": "+header.getValue());
		   }
		         
	   }
}


}
