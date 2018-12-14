package com.ibrahim.tiket.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ibrahim.tiket.controller.repository.EmployeeRepository;
import com.ibrahim.tiket.model.Employee;
import com.ibrahim.tiket.utils.Helper;

@Component
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public void transferEmployees() {
	        BufferedReader br = null;
	        String line = "";
	        String cvsSplitBy = ";";
	
	        try {
	
	            br = new BufferedReader(new FileReader(Helper.pathUrl + Helper.employeesCsv));
	            int i = 1;
	            while ((line = br.readLine()) != null) {
	            	if(i == 1) {
	            		i++;
	            		continue;
	            	}
	            	Employee emp = new Employee();
	                String[] data = line.split(cvsSplitBy);
	                emp.setFirstName(data[1]);
	                emp.setLastName(data[2]);
	                emp.setTitle(data[3]);
	                emp.setWorkPhone(data[4]);
	                employeeRepository.save(emp);
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
