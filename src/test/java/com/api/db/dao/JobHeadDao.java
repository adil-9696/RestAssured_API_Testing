package com.api.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.api.database.DataManagerHCP;
import com.database.models.JobHeadModel;

public class JobHeadDao {

	private static final String SQL_QUERY="""
			select * from tr_job_head  where id=?;
			""";
	
	
	public static JobHeadModel getJobHeadinfo(int job_head_id) {
		
		
		Connection conn=DataManagerHCP.getConnection();
		ResultSet result=null;
		 JobHeadModel model=null;
		
	try {
		PreparedStatement statement=conn.prepareStatement(SQL_QUERY);
		 statement.setInt(1,job_head_id);
		 result=statement.executeQuery();
		 
		 if(result.next())
			{
				   model=new JobHeadModel(result.getInt("id"),result.getString("job_number"),
						   result.getInt("tr_customer_id"),result.getInt("tr_customer_product_id")
						   ,result.getInt("mst_service_location_id"),result.getInt("mst_platform_id"),
						   result.getInt("mst_warrenty_status_id"),result.getInt("mst_oem_id"));
				   
			}
		 
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	
	
	return model;
	}
	
	
}
