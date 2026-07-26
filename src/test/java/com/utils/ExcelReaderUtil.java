package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.poiji.bind.Poiji;

import Pojo_classes_automation_framework.CreateJobBean;
import Pojo_classes_automation_framework.LoginBean;
import Pojo_classes_automation_framework.createJobPayload;
import Pojo_classes_automation_framework.logincred;

public class ExcelReaderUtil {

	
	
	
	public static Iterator<logincred> readexcelintoIterator() {
		
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream("testdata/test_data_excel_login.xlsx");
		XSSFWorkbook wb = null;
		try {
			wb = new XSSFWorkbook(is);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		   XSSFSheet sheet= wb.getSheet("Login");
		   
		   
		    List<logincred> list= Poiji.fromExcel(sheet, logincred.class);
		
		    return list.iterator();
	}}
