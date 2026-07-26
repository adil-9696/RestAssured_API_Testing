package com.utils;

import io.github.cdimascio.dotenv.Dotenv;

public class EnvUtil {

	public static Dotenv dot;
	
	
	static {
		
		dot=Dotenv.load();
	}
	
	
	
	public static String getValue(String key)
	{
		return dot.get(key);
	}
}
