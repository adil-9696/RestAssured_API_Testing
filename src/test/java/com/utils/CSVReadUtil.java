package com.utils;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.List;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class CSVReadUtil {

	

	public static <T> Iterator<T> readCSVtoBean(String path,Class<T> bean)
	{
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream(path);
		  InputStreamReader ir=new InputStreamReader(is);
		    CSVReader readCSV=new CSVReader(ir);
		    
		    
		  CsvToBean<T> beantemp=new CsvToBeanBuilder<T>(readCSV) 
				  .withType(bean)
		   .withIgnoreEmptyLine(true)
		   .build();
		  
		  List<T> list=beantemp.parse();
		  
		  return list.iterator();
		  
	}
}
