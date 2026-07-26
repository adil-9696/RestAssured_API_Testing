package com.utils;

public class Generate14digit_random {

	public static String getNumber(){
	
		
		double d=Math.random();
		
                    //3 digit 999
		
//		Math.random()*1000-Math.random()*100
		
		long number=(long)(Math.floor( (Math.random()*(100000000000000L-10000000000000L))+10000000000000L));
		
		System.out.println(number+"");
		
		return number+"";
	            
		     
	}

}
