package com.api.database;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bettercloud.vault.Vault;
import com.utils.ConfigManager;
import com.utils.EnvUtil;
import com.utils.VaultUtil;
import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import groovy.transform.Synchronized;

public class DataManagerHCP {

	
	private static Logger logger=LogManager.getLogger(DataManagerHCP.class);
	
	private static boolean isVaultup = true;
	private static String dbURL = loadsecret("DB_URL");
	private static String Username = loadsecret("DB_Username");
	private static String Password = loadsecret("DB_Password");

	/*
	 * private static String dbURL=EnvUtil.getValue("DB_URL"); private static String
	 * Username=EnvUtil.getValue("DB_Username"); private static String
	 * Password=EnvUtil.getValue("DB_Password");
	 */

	/*
	 * private static String dbURL=ConfigManager.getProperty("DATABASE_URL");
	 * private static String Username=ConfigManager.getProperty("Username"); private
	 * static String Password=ConfigManager.getProperty("Password");
	 * 
	 */

	private static HikariConfig config;
	private static volatile HikariDataSource ds;

	public static void createPool() {

		if (ds == null) {

			synchronized (DataManagerHCP.class) {

			 {
				config = new HikariConfig();
				config.setJdbcUrl(dbURL);
				config.setUsername(Username);
				config.setPassword(Password);
				config.setMaximumPoolSize(10);

				ds = new HikariDataSource(config);
			
				}
				}

		}
	}

	public static Connection getConnection() {
		Connection conn = null;
		if (ds == null) {
			createPool();
		}

		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	public static String loadsecret(String key) {
		String value = null;

		if (isVaultup) {
			logger.info("Checking if Vault is up :)");
			
			
			value = VaultUtil.getValue(key);
			
			
			if (value == null) {

				logger.info("Vault is Down!!!! ):");
				isVaultup = false;
				logger.info("Reading from Dot env file");
				value = EnvUtil.getValue(key);
				return value;
			}

			else {
				
				logger.info("Vault is up!!! Reading from Vault");
				return value;
			}

		}

		
		return value = EnvUtil.getValue(key);
	}

}