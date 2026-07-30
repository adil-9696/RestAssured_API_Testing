package com.api.database;

import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class demo {

	
	private static Logger logger=LogManager.getLogger(demo.class);
	
	public static void main(String[] args) throws SQLException {

			
	    int a=10;
	    	logger.info("value of a is {} ",a);
	       int b=0;
	       
	       if(b==0)
	       {
	    	   logger.warn("value of b is {} ",b);
	       }
	       
	       else {	
	    	   logger.info("value of b is {} ",b);
	       }
	       
	       
	       try {
	    	   int result =a/b;
	    	   
	    	  logger.info("result is= {}",result); 
	       }
	       
	       catch(ArithmeticException e)
	       {
	    	    logger.error("Operation cannot be done {}",e);
	       }
	       
	
		System.out.println("end!!!!");	
	 	
	}

}
