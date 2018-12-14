package com.ibrahim.tiket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ibrahim.tiket.controller.CustomerContoller;
import com.ibrahim.tiket.controller.EmployeeController;
import com.ibrahim.tiket.controller.OrderController;
import com.ibrahim.tiket.controller.OrderDetailController;
import com.ibrahim.tiket.controller.ProductController;
import com.ibrahim.tiket.controller.ShippingMethodController;

@SpringBootApplication
public class TiketApplication implements CommandLineRunner {
	
	@Autowired
	private EmployeeController employeeController;
	
	@Autowired
	private CustomerContoller customerContoller;
	
	@Autowired
	private ProductController productController;
	
	@Autowired
	private ShippingMethodController shippingMethodController;
	
	@Autowired
	private OrderDetailController orderDetailController;
	
	@Autowired
	private OrderController orderController;

	public static void main(String[] args) {
		SpringApplication.run(TiketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		employeeController.transferEmployees();
		customerContoller.transferCustomers();
//		productController.transferProducts();
//		shippingMethodController.transferShippingMethod();
//		orderDetailController.transferOrderDetail();
//		orderController.transferOrder();
	}
}
