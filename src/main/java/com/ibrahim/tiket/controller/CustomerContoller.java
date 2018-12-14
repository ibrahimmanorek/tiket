package com.ibrahim.tiket.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ibrahim.tiket.controller.repository.CustomerRepository;
import com.ibrahim.tiket.model.Customer;
import com.ibrahim.tiket.utils.Helper;

@Component
public class CustomerContoller {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	public void transferCustomers() {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        try {
        	
            br = new BufferedReader(new FileReader(Helper.pathUrl + Helper.customersCsv));
            int i = 1;
            while ((line = br.readLine()) != null) {
            	if(i == 1) {
            		i++;
            		continue;
            	}
            	
            	Customer cst = new Customer();
                String[] data = line.split(cvsSplitBy);
                cst.setCompanyName(data[1]);
                cst.setFirstName(data[2]);
                cst.setLastName(data[3]);
                cst.setBillingAddress(data[4]);
                cst.setCity(data[5]);
                cst.setStateOrProvince(data[6]);
                cst.setZipCode(data[7]);
            	cst.setEmail(data[8]);
            	cst.setCompanyWebsite(data[9]);
            	cst.setPhoneNumber(data[10]);
            	cst.setFaxNumber(data[11]);
            	cst.setShipAddress(data[12]);
            	cst.setShipCity(data[13]);
            	cst.setShipStateOrProvince(data[14]);
            	cst.setShipZIPCode(data[15]);
            	cst.setShipPhoneNumber(data[16]);
                
                customerRepository.save(cst);
            	System.out.println(cst.getFirstName());
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
	
	public static void main(String args[]) {
		new CustomerContoller().transferCustomers();
	}

}
