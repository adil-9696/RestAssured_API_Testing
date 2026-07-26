package com.api.db.dao;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.api.database.DataManagerHCP;
import com.database.models.CustomerAddressDatabaseModel;

public class Customer_AddressDao {

	
	private static final String SQL_QUERY="""
			select * from tr_customer_address where id=?;
			""";
	
	
	public static CustomerAddressDatabaseModel getCustomerAddress(int customer_address_id) {
		
		
		
		Connection conn=DataManagerHCP.getConnection();
		CustomerAddressDatabaseModel cust_add=null;
		
		try {
			PreparedStatement statement=conn.prepareStatement(SQL_QUERY);
			statement.setInt(1, customer_address_id);
			ResultSet result=statement.executeQuery();
			
			if(result.next()) {
				
				cust_add=new CustomerAddressDatabaseModel(Integer.parseInt(result.getString("id"))
						,result.getString("flat_number"),result.getString("apartment_name"),result.getString("street_name")
						,result.getString("landmark"),result.getString("area"),result.getString("pincode")
						,result.getString("country"),result.getString("state"));
				
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cust_add;	     
	
	}
	
	
}
