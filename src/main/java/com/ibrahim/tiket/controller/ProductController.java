package com.ibrahim.tiket.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibrahim.tiket.controller.repository.ProductRepository;
import com.ibrahim.tiket.model.Product;
import com.ibrahim.tiket.utils.Helper;

@Component
public class ProductController {
	
	@Autowired
	private ProductRepository productRepository;
	
	public void transferProducts() {
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ";";
        
        try {

            br = new BufferedReader(new FileReader(Helper.pathUrl + Helper.productsCsv));
            int i = 1;
            while ((line = br.readLine()) != null) {
            	if(i == 1) {
            		i++;
            		continue;
            	}
            	
            	Product prd = new Product();
                String[] data = line.split(cvsSplitBy);
                prd.setProductName(data[1]);
                String unit = data[2];
                String res = unit.replaceAll(",",".");
                prd.setUnitPrice(Float.parseFloat(res));
                prd.setInStock(data[3]);
                productRepository.save(prd);
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
