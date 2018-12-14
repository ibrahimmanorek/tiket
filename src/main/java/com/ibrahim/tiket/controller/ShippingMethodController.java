package com.ibrahim.tiket.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ibrahim.tiket.controller.repository.ShippingMethodeRepository;
import com.ibrahim.tiket.model.ShippingMethod;
import com.ibrahim.tiket.utils.Helper;

@Component
public class ShippingMethodController {
	
	@Autowired
	private ShippingMethodeRepository shippingMethodeRepository;
	
	public void transferShippingMethod() {
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ";";
	
	        try {
	
	            br = new BufferedReader(new FileReader(Helper.pathUrl + Helper.shippingMethodsCsv));
	            int i = 1;
	            while ((line = br.readLine()) != null) {
	            	if(i == 1) {
	            		i++;
	            		continue;
	            	}
	            	ShippingMethod sm = new ShippingMethod();
	                String[] data = line.split(cvsSplitBy);
	                sm.setShippingMethode(data[1]);
	                shippingMethodeRepository.save(sm);
	                i++;
	            }
	
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
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
