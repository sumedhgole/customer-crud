package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Customer;
import com.example.demo.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private CustomerRepository repo;

	@Override
	public void addCustomer(Customer customer) {
		repo.save(customer);

	}

	@Override
	public List<Customer> fetchAll() {
		return repo.findAll();
	}

	@Override
	public void delCustomer(int id) {
		repo.deleteById(id);
	}

	@Override
	public void updateCustomer(Customer customer) {
		repo.save(customer);
	}

	@Override
	public Customer fetchById(int id) {
		Customer cust = null;
		Optional<Customer> optional = repo.findById(id);
		if(optional.isPresent())
			cust = optional.get();
		
		return cust;
	}

}
