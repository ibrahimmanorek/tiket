package com.ibrahim.tiket.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ibrahim.tiket.controller.repository.OrderRepository;
import com.ibrahim.tiket.model.Order;
import com.ibrahim.tiket.utils.Helper;

@Component
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	public void transferOrder() {
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ";";
	
	        try {
	
	            br = new BufferedReader(new FileReader(Helper.pathUrl + Helper.orderCsv));
	            int i = 1;
	            while ((line = br.readLine()) != null) {
	            	if(i == 1) {
	            		i++;
	            		continue;
	            	}
	            	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	            	Order o = new Order();
	                String[] data = line.split(cvsSplitBy);
	                o.setCustomerId(Integer.parseInt(data[1]));
	                o.setEmployeeId(Integer.parseInt(data[2]));
	                o.setOrderDate(sdf.parse(data[3]));
	                o.setPurchaseOrderNumber(data[4]);
	                try {
		                o.setShipDate(sdf.parse(data[5]));
					} catch (Exception e) {
						// TODO: handle exception
					}
	                o.setShippingMethodId(Integer.parseInt(data[6]));
	                try {
	                	o.setFreightCharge(Integer.parseInt(data[7]));
					} catch (Exception e) {
					}

	                o.setTaxes(Integer.parseInt(data[8]));
	                o.setPaymentReceived(data[9]);
	                try {
	                	o.setComment(data[10]);
					} catch (Exception e) {
						o.setComment("");
					}
	                
	                orderRepository.save(o);
	                i++;
	            }
	
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        } catch (ParseException e) {
				e.printStackTrace();
			} finally {
	            if (br != null) {
	                try {
	                    br.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	}

}
