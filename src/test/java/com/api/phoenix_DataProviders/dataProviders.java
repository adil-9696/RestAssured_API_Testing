package com.api.phoenix_DataProviders;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.testng.annotations.DataProvider;

import com.api.db.dao.createJobDao;
import com.utils.CSVReadUtil;
import com.utils.CreateJobBeanMapper;
import com.utils.ExcelReaderUtil;
import com.utils.FakerDataGenerator;
import com.utils.JsonReaderUtil;

import Pojo_classes_automation_framework.CreateJobBean;
import Pojo_classes_automation_framework.LoginBean;
import Pojo_classes_automation_framework.createJobPayload;
import Pojo_classes_automation_framework.logincred;

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
	
	
	@DataProvider(name="fakedatacreatejob")
	public static Iterator<createJobPayload> createJobAPIdataProviderfakedata() {
		
		 List<createJobPayload> list=FakerDataGenerator.generatecreateJob_Fakedata(100);
		 
		 return list.iterator();
	}
	
	
	@DataProvider(name="loginAPIDataProviderJson")
	public static Iterator<logincred> loginAPIdataproviderJson() {

		Iterator<logincred> it=JsonReaderUtil.readJSONtoPojoArray("testdata/testdata_login.json", logincred[].class);
		
		return it;
		
	}
	
	
	@DataProvider(name="createJobJsonDataProvider")
	public static Iterator<createJobPayload> createJobJSONDataprovider() {
		
		Iterator<createJobPayload> it=JsonReaderUtil.readJSONtoPojoArray("testdata/testdataCreateJob.json", createJobPayload[].class);
	
		return it;
	}
	
	
	

	@DataProvider(name="loginAPIExcelDataProvider")
	public static Iterator<logincred> loginAPIdataproviderexcel() {

		Iterator<logincred> it=ExcelReaderUtil.readexcelintoIterator();		
		return it;
		
	}
	

	
	@DataProvider(name="createJobfrmdatabasedata")
	public static Iterator<createJobPayload> createJobPayloadDatabaseDataProvider()
	{
		List<CreateJobBean> bean=createJobDao.getCreateJobpayloadBean();
		   List<createJobPayload> list=new ArrayList<createJobPayload>();
		for(int i=0;i<bean.size();i++)
		{
			createJobPayload payload=CreateJobBeanMapper.createJobBeanmappingtoPayload(bean.get(i));
		     list.add(payload);
		}
		
		return list.iterator();
	}
	
	
}
