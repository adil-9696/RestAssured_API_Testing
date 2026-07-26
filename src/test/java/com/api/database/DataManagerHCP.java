package com.api.database;

import java.sql.Connection;
import java.sql.SQLException;

import com.utils.ConfigManager;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import groovy.transform.Synchronized;

public class DataManagerHCP {

	private static String dbURL=ConfigManager.getProperty("DATABASE_URL");
	private static String Username=ConfigManager.getProperty("Username");
	private static String Password=ConfigManager.getProperty("Password");
	private static Connection conn=null;
	
	public static void createPool() {
		
		HikariConfig config=new HikariConfig();
		
		config.setJdbcUrl(dbURL);
		config.setUsername(Username);
		config.setPassword(Password);
		config.setMaximumPoolSize(10);
		
		HikariDataSource ds=new HikariDataSource(config);
		
		try {
		
			conn=ds.getConnection();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	public static Connection getConnection() {
		
		if(conn==null)
		{
			synchronized(DataManagerHCP.class){
				createPool();
			}
		}
		
		else {
			{
				System.out.println("Connetion is not null hence, using the already opened connection");
				
			}
		
		}
		
		return conn;
	}
	
}
