package com.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;
import com.utils.ConfigManager;

public class AllureEnvUtil {

	///Properties prop=new Properties();
	
	private static String path="target/allure-results/";
			

	public static void setupEnvthings()
	{
		Properties prop=new Properties();
		prop.setProperty("Project Name:", "Phonenix Automation rest assured suite");
		prop.setProperty("Operating System: ", System.getProperty("os.name"));
		prop.setProperty("Java Version: ", System.getProperty("java.version"));
		prop.setProperty("Environment: ", ConfigManager.env);
		prop.setProperty("BASE URI: ", ConfigManager.getProperty("BASEURI"));
		
		
		File file=new File(path);
		file.mkdirs();
		
		try {
			
			
			FileWriter fw=new FileWriter(path+"environment.properties");
			  prop.store(fw, path);
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		
	}
	
}
