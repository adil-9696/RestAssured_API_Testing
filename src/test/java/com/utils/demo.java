package com.utils;

import java.util.Properties;

public class demo {

	public static void main(String[] args) {
		Properties prop=new Properties();
		prop.setProperty("Project Name:", "Phonenix Automation rest assured suite");
		prop.setProperty("Operating System: ", System.getProperty("os.name"));
		prop.setProperty("Java Version: ", System.getProperty("java.version"));
		prop.setProperty("Environment: ", ConfigManager.env);
		prop.setProperty("BASE URI: ", ConfigManager.getProperty("BASEURI"));
	
	}

}
