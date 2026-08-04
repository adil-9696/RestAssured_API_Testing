package com.api.retry;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	private static int MAX_Attempt=2;
	private static int count=0;
	
	
	@Override
	public boolean retry(ITestResult result) {
		
		if(count<MAX_Attempt)
		{
			count++;
			return true;
		}
		
		
		
		return false;
	}

	
}
