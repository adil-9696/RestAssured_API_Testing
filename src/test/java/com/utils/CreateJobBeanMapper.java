package com.utils;

import java.util.ArrayList;
import java.util.List;

import Pojo_classes_automation_framework.CreateJobBean;
import Pojo_classes_automation_framework.Customer;
import Pojo_classes_automation_framework.Customer_Address;
import Pojo_classes_automation_framework.Customer_Product;
import Pojo_classes_automation_framework.Problem;
import Pojo_classes_automation_framework.createJobPayload;

public class CreateJobBeanMapper {

	public static createJobPayload createJobBeanmappingtoPayload(CreateJobBean bean) {

		int mst_servicelocation_id = Integer.parseInt(bean.getMst_service_location_id());
		int mst_platform_id = Integer.parseInt(bean.getMst_platform_id());
		int mst_warranty_status = Integer.parseInt(bean.getMst_warrenty_status_id());
		int mst_oem_id = Integer.parseInt(bean.getMst_oem_id());

		Customer customer = new Customer(bean.getCustomer__first_name(), bean.getCustomer__last_name(),
				bean.getCustomer__mobile_number(), bean.getCustomer__mobile_number_alt(), bean.getCustomer__email_id(),
				bean.getCustomer__email_id_alt());
		;

		Customer_Address customer_address = new Customer_Address(bean.getCustomer_address__flat_number(),
				bean.getCustomer_address__apartment_name(), bean.getCustomer_address__street_name(),
				bean.getCustomer_address__landmark(), bean.getCustomer_address__area(),
				bean.getCustomer_address__pincode(), bean.getCustomer_address__country(),
				bean.getCustomer_address__state());

		Customer_Product customerproduct = new Customer_Product(bean.getCustomer_product__dop(),
				bean.getCustomer_product__serial_number(), bean.getCustomer_product__imei1(),
				bean.getCustomer_product__imei2(), bean.getCustomer_product__popurl(),
				Integer.parseInt(bean.getCustomer_product__product_id()),
				Integer.parseInt(bean.getCustomer_product__mst_model_id()));

		Problem problem = new Problem(Integer.parseInt(bean.getProblems__id()), bean.getProblems__remark());

		List<Problem> problems = new ArrayList<Problem>();

		problems.add(problem);

		createJobPayload payload = new createJobPayload(mst_servicelocation_id, mst_platform_id, mst_warranty_status,
				mst_oem_id, customer, customer_address, customerproduct, problems);

		return payload;
	}

}
