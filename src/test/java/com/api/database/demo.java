package com.api.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import io.github.cdimascio.dotenv.Dotenv;

public class demo {

	public static void main(String[] args) throws SQLException {

			
	Dotenv dot=Dotenv.load();
		System.out.println(dot.get("DB_URL"));
			
			
	}

}
