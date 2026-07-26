package com.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.utils.ConfigManager;

public class DatabaseManager {

	private static String dbURL = ConfigManager.getProperty("DATABASE_URL");
	private static String Username = ConfigManager.getProperty("Username");
	private static String Password = ConfigManager.getProperty("Password");

	private static volatile Connection conn = null;

	public static Connection createConnection() {

		try {

			if (conn == null) {
				synchronized (DatabaseManager.class) {
					conn = DriverManager.getConnection(dbURL, Username, Password);
				}
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		System.out.println(conn);
		return conn;
	}

}
