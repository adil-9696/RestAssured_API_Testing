package com.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;
import com.utils.EnvUtil;

import io.github.cdimascio.dotenv.Dotenv;

public class demo {

	public static void main(String[] args) throws SQLException {

			
	
		System.out.println(EnvUtil.getValue("DB_Username"));
			
			
	}

}
