package com.utils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import org.testng.annotations.Test;

import com.constants.OEM;
import com.constants.Platform;
import com.constants.ServiceLocation;
import com.constants.Warranty;
import com.github.javafaker.Faker;

import Pojo_classes_automation_framework.Customer;
import Pojo_classes_automation_framework.Customer_Address;
import Pojo_classes_automation_framework.Customer_Product;
import Pojo_classes_automation_framework.Problem;
import Pojo_classes_automation_framework.createJobPayload;

public class FakerDataGenerator {

	private static Faker faker = new Faker(new Locale("en-ind"));

	private static final int PRODUCT_ID = 1;
	private static final int mst_model_id = 1;
	private static int validproblemID[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 15, 16, 17, 19, 20, 22, 24, 26 };

	private static Customer generateCustomer_Fakedata() {

		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String mobileNumber = faker.numerify("8#########");
		String alt_mobileNumber = faker.numerify("8#########");
		String email = faker.internet().emailAddress();
		String alt_email = faker.internet().emailAddress();

		Customer cutomer = new Customer(firstName, lastName, mobileNumber, alt_mobileNumber, email, alt_email);

		return cutomer;
	}

	private static Customer_Address generateCustomerAddress_Fakedata() {
		String flat_number = faker.address().buildingNumber();
		String apartmentname = faker.address().firstName();
		String streetAddress = faker.address().streetAddress();
		String landmark = faker.address().streetName();
		String area = faker.address().city();
		String pincode = faker.numerify("#####");
		String country = "India";
		String state = faker.address().state();

		Customer_Address cust_add = new Customer_Address(flat_number, apartmentname, streetAddress, landmark, area,
				pincode, country, state);

		return cust_add;
	}

	private static Customer_Product generateCustomerProduct_Fakedata() {

		String dop = DateTimeUtil.getTimewithDaysAgo(10);
		String imei_serial_number = faker.number().digits(14);
		String pop_URL = faker.internet().url();

		Customer_Product cust_prod = new Customer_Product(dop, imei_serial_number, imei_serial_number,
				imei_serial_number, pop_URL, PRODUCT_ID, mst_model_id);

		return cust_prod;
	}

	private static List<Problem> ProblemList() {

		Random rand = new Random();

		int index = rand.nextInt(1);

		String remark = faker.lorem().sentence(5);
		Problem problem = new Problem(validproblemID[index], remark);

		List<Problem> problemList = new ArrayList<Problem>();

		problemList.add(problem);

		return problemList;
	}
	
	
	public static createJobPayload generatecreateJob_Fakedata() {

		createJobPayload payload = new createJobPayload(ServiceLocation.SERVICELOCATION_A.getCode(),
				Platform.FRONT_DESK.getCode(), Warranty.INWARRANTY.getCode(), OEM.GOOGLE.getCode(),
				generateCustomer_Fakedata(), generateCustomerAddress_Fakedata(), generateCustomerProduct_Fakedata(),
				ProblemList());

		return payload;
	}
	
	
	public static List<createJobPayload> generatecreateJob_Fakedata(int count) {
		createJobPayload payload;
		List<createJobPayload> list=new ArrayList<createJobPayload>();
		
		
		for(int i=0;i<count;i++)
		{
		
		payload=new createJobPayload(ServiceLocation.SERVICELOCATION_A.getCode(),Platform.FRONT_DESK.getCode(),Warranty.INWARRANTY.getCode(),OEM.GOOGLE.getCode(),generateCustomer_Fakedata()
				,generateCustomerAddress_Fakedata(),generateCustomerProduct_Fakedata(),ProblemList());
	
		list.add(payload);
		}
	
	return list;
	}

	
}
