package com.listeners;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

public class APITestListeners implements ITestListener {
	
	private static Logger logger=LogManager.getLogger(APITestListeners.class);
	
	public void onTestStart(ITestResult result) {
	    
		logger.info("Testing Class-Method : {} ",result.getMethod().getTestClass());
		logger.info("Starting the Test Method: {} ",result.getName());
		logger.info("Description: {} ",result.getMethod().getDescription());
		logger.info("Groups {} ",Arrays.toString(result.getMethod().getGroups()));
	  }
	
	
	public void onTestSuccess(ITestResult result) {
	   long start=result.getStartMillis();
		logger.info("Test is Passed: {} ",result.getName());
		
	   long end=result.getEndMillis();
	   
	   long Duration=end-start;
	   
	   logger.info("Duration {}ms ",Duration);
	}

	public void onTestFailure(ITestResult result) {
		logger.info("Test is Failed!!! : {}  ):",result.getName());
		logger.info("Error Message is : {}",result.getThrowable().getMessage());
		logger.info("Exception is: ",result.getThrowable());
	  }

	public void onTestSkipped(ITestResult result) {
		logger.info("Test is Skipped!!! : {}",result.getName());
	  }

	
	 public void onStart(ITestContext context) {
		 logger.info("Phoenix Framework is starting!!!");
		  }

}
