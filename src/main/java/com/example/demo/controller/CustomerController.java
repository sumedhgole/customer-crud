package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.Customer;
import com.example.demo.service.ICustomerService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private ICustomerService service;

	@GetMapping("/{name}")
	@ApiOperation("Greetings API")
	public String greetings(@PathVariable String name) {
		return "<h1>Welcome to Spring Boot "+name+"</h1>";
	}
	
	@GetMapping("/getById/{id}")
	@ApiOperation("Get Customer By ID")
	public Customer fetchById(@PathVariable String id) {
		return service.fetchById(Integer.valueOf(id));
	}
	
	@GetMapping("/getAll")
	@ApiOperation("Fetch all Customers details")
	public List<Customer> fetch() {
		return service.fetchAll();
	}
	
	@PostMapping("/save")
	public void save(@RequestBody Customer customer) {
		service.addCustomer(customer);
	}
	
	@PutMapping("/update")
	public void update(@RequestBody Customer customer) {
		service.updateCustomer(customer);
	}
	
	@DeleteMapping("/delete/{id}")
	@ApiOperation("Delete Customers details")
	public void delete(@PathVariable String id) {
		service.delCustomer(Integer.valueOf(id));
	}
}
