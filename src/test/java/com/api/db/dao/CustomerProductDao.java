package com.api.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.testng.annotations.Test;

import com.api.database.DataManagerHCP;
import com.database.models.CustomerProductDatabaseModel;

public class CustomerProductDao {

	private static final String SQL_QUERY="""
			select * from tr_customer_product where tr_customer_id=?;
			""";
	
	
	
	public  static CustomerProductDatabaseModel getcustomerProductdbinfo(int cust_id) {
		
		Connection conn=DataManagerHCP.getConnection();
		CustomerProductDatabaseModel cust_prod = null;
		
		try {
			PreparedStatement statement =conn.prepareStatement(SQL_QUERY);
			statement.setInt(1, cust_id);
			ResultSet result=statement.executeQuery();
			
			if(result.next())
			{
				   cust_prod=new CustomerProductDatabaseModel(Integer.parseInt(result.getString("id")),Integer.parseInt(result.getString("tr_customer_id")),Integer.parseInt(result.getString("mst_model_id"))
				    		,result.getString("dop"),result.getString("popurl"),result.getString("serial_number"),result.getString("imei1")
				    		,result.getString("imei2"));
		
			  
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	return cust_prod;
	}
	
	
	
	
}
