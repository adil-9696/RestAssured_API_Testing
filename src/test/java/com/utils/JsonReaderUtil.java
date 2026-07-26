package com.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import Pojo_classes_automation_framework.logincred;

public class JsonReaderUtil {

	
	
	public static <T> Iterator<T> readJSONtoPojoArray(String filepath,Class<T[]> clazz)
	{
		InputStream is=Thread.currentThread().getContextClassLoader().getResourceAsStream(filepath);
		List<T> list=new ArrayList<T>();
		ObjectMapper mapper=new ObjectMapper();
		
		try {
			
			T[] bodyarray=mapper.readValue(is, clazz);
		
			   list=Arrays.asList(bodyarray);  
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return list.iterator();
	}
}
