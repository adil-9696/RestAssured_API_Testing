package com.practice.revision;

import static io.restassured.RestAssured.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Properties;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.hamcrest.Matchers;

import com.api.database.DataManagerHCP;
import com.api.db.dao.Customer_AddressDao;
import com.constants.Roles;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.utils.Authtoken_generator;
import com.utils.ConfigManager;
import com.utils.FakerDataGenerator;

import Pojo_classes_automation_framework.createJobPayload;
import Pojo_classes_automation_framework.logincred;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class PracticeTest {

	public static void main(String[] args) throws StreamReadException, DatabindException, IOException {
		
		
		  Connection conn=DataManagerHCP.getConnection();
		 

          
	
    
   
    
 
    
  
    
   
  
    

	}

}
