package com.api.db.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.api.database.DataManagerHCP;
import com.utils.ConfigManager;

import Pojo_classes_automation_framework.CreateJobBean;


public class createJobDao {

	
	private final static String SQL_Query=
			"""
Select mst_service_location_id,mst_platform_id,mst_warrenty_status_id,mst_oem_id,first_name,last_name,mobile_number,mobile_number_alt
,email_id,email_id_alt,flat_number,apartment_name,street_name,landmark,area,pincode
,country,state,dop,popurl,serial_number,imei1,imei2,mst_model_id,mst_problem_id,remark
from  tr_customer as cust inner join tr_customer_address as cust_add on cust.tr_customer_address_id=cust_add.id 
inner join tr_customer_product as custprod on cust.id=custprod.tr_customer_id
inner join tr_job_head on tr_job_head.tr_customer_id=cust.id
inner join map_job_problem on map_job_problem.tr_job_head_id=tr_job_head.id LIMIT 10;""";
	
	
	
	public static List<CreateJobBean>  getCreateJobpayloadBean() {
	Connection conn=DataManagerHCP.getConnection();
	List<CreateJobBean> listbean=new ArrayList<CreateJobBean>();
      try {
		Statement statement=conn.createStatement();
		
		ResultSet result=statement.executeQuery(SQL_Query);
		
		while(result.next())
		{     CreateJobBean bean=new CreateJobBean();
			  bean.setMst_service_location_id(result.getString("mst_service_location_id"));
			  bean.setMst_platform_id(result.getString("mst_platform_id"));
			  bean.setMst_warrenty_status_id(result.getString("mst_warrenty_status_id"));
			 
			  //bean.setMst_oem_id(result.getString("mst_oem_id"));
			  bean.setMst_oem_id("1");
			  
			  bean.setCustomer__first_name(result.getString("first_name"));
			  bean.setCustomer__last_name(result.getString("last_name"));
			  bean.setCustomer__mobile_number(result.getString("mobile_number"));
			  bean.setCustomer__mobile_number_alt(result.getString("mobile_number_alt"));
			  bean.setCustomer__email_id(result.getString("email_id"));
			  bean.setCustomer__email_id_alt(result.getString("email_id_alt"));
			
			  bean.setCustomer_address__flat_number(result.getString("flat_number"));
			  bean.setCustomer_address__apartment_name(result.getString("apartment_name"));
			  bean.setCustomer_address__street_name(result.getString("street_name"));
			  bean.setCustomer_address__landmark(result.getString("landmark"));
			  bean.setCustomer_address__area(result.getString("area"));
			  bean.setCustomer_address__pincode(result.getString("pincode"));
			  bean.setCustomer_address__country(result.getString("country"));
			  bean.setCustomer_address__state(result.getString("state"));
			
			  bean.setCustomer_product__dop(result.getString("dop"));
			  bean.setCustomer_product__popurl(result.getString("popurl"));
			  bean.setCustomer_product__serial_number(result.getString("serial_number"));
			  bean.setCustomer_product__imei1(result.getString("imei1"));
			  bean.setCustomer_product__imei2(result.getString("imei2"));
			  bean.setCustomer_product__product_id("1");
			
			  //bean.setCustomer_product__mst_model_id(result.getString("mst_model_id"));
			  bean.setCustomer_product__mst_model_id("1");
			  
			  bean.setProblems__id(result.getString("mst_problem_id"));
			  bean.setProblems__remark(result.getString("remark"));
			  
			listbean.add(bean);  
			
		}
		
		
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	  return listbean; 
      
      
       
}
	
}
