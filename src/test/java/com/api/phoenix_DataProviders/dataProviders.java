package com.api.phoenix_DataProviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.utils.CSVReadUtil;

import Pojo_classes_automation_framework.CreateJobBean;
import Pojo_classes_automation_framework.LoginBean;
import Pojo_classes_automation_framework.createJobPayload;

public class dataProviders {

	
	@DataProvider(name="loginAPIDataProvider")
	public static Iterator<LoginBean> loginAPIdataprovider() {

		Iterator<LoginBean> it=CSVReadUtil.readCSVtoBean("testdata/testdata_login.csv", LoginBean.class);
		
		return it;
		
	}
	
	
	
	@DataProvider(name="createjobAPIdataprovider")
	public static Iterator<createJobPayload> createJobAPIdataProvider() {
		
		  Iterator<CreateJobBean> it=CSVReadUtil.readCSVtoBean("testdata/testdataCreateJob.csv", CreateJobBean.class);
		  
		  List<createJobPayload> list=new ArrayList<createJobPayload>();
		  createJobPayload payloadtemp;
		  
		 while(it.hasNext())
		 {
			payloadtemp=com.utils.CreateJobBeanMapper.createJobBeanmappingtoPayload(it.next());
			 
			 list.add(payloadtemp);
		 }
		 
		 return list.iterator();
		 
	}
	
	

}
