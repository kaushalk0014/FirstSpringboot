package com.boot.first.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.boot.first.domain.Customer;
import com.boot.first.repositry.FlipkartRepositry;

@RestController
@RequestMapping("/api")
public class FirstAppController {

	
	@Autowired(required = true)
	private FlipkartRepositry repositry;

	@RequestMapping(value = "/helth", method = RequestMethod.GET)
	public String helth() {
		return "up";
	}

	@RequestMapping(value = "/getAll/customer", method = RequestMethod.GET)
	public ResponseEntity<List<Customer>> getCustomer() {
		List<Customer> list = repositry.findAll();

		return new ResponseEntity<List<Customer>>(list, HttpStatus.OK);
	}

	@RequestMapping(value = "/save/customer", method = RequestMethod.POST)
	public String saveCustomer(@RequestBody Customer customer) {
		customer = repositry.save(customer);
		if (customer.getId() != null) {
			return "Successfully saved Customer details";
		} else {
			return "Failed to save Customer details";
		}

	}
}
