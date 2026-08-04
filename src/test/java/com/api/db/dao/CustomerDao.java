package com.api.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.Test;

import com.api.database.DataManagerHCP;
import com.database.models.CustomerDataBaseModel;

public class CustomerDao {

	private static final String SQL_QUERY = """
			Select * from tr_customer where id=?;
			""";

	
	

	public  static  CustomerDataBaseModel getCustominfo(int custid) {

		
		Connection conn = DataManagerHCP.getConnection();
		
		CustomerDataBaseModel customer = null;
		
		try {
			PreparedStatement statement = conn.prepareStatement(SQL_QUERY);
			statement.setInt(1, custid);
			ResultSet result = statement.executeQuery();
          
			if(result.next()) {
			 customer = new CustomerDataBaseModel(Integer.parseInt(result.getString("id")), result.getString("first_name"),
					result.getString("last_name"), result.getString("mobile_number"),
					result.getString("mobile_number_alt"), result.getString("email_id"),
					result.getString("email_id_alt"), Integer.parseInt(result.getString("tr_customer_address_id")));
			}	
			
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return customer;		
	}
	
	

}
