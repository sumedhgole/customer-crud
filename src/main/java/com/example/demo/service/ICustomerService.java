package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;

@Service
public interface ICustomerService {
	
	void addCustomer(Customer customer);
	
	List<Customer> fetchAll();
	
	void delCustomer(int id);
	
	void updateCustomer(Customer customer);
	
	Customer fetchById(int id);

}
