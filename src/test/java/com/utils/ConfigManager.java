package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigManager {

	private static Properties prop=new Properties();
	private static String path=null;
	
	private static String env=null;
			
	static
	{   env=System.getProperty("env","qa");
		env=env.toLowerCase().trim();
		
		switch(env) {
		case "dev" ->path="Config/config.dev.properties";
		case "qa" ->path="Config/config.qa.properties";
		case "uat" -> path="Config/config.UAT.properties";
		
		}
		
InputStream input=Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		
		  try {
			  
			prop.load(input);
			
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key)
	{
		return prop.getProperty(key);
	}
	
	
}
