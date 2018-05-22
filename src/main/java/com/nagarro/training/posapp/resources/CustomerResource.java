package com.nagarro.training.posapp.resources;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.posapp.models.Customer;
import com.nagarro.training.posapp.services.ICustomerService;
import com.nagarrro.training.posapp.exceptions.NoDataFoundException;

@RestController
public class CustomerResource {

	@Autowired
	private ICustomerService customerService;

	@RequestMapping(value = "/customers", method = RequestMethod.GET)
	public ResponseEntity<?> getAllCustomers() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(customerService.getAllCustomers());
		} catch (NoDataFoundException noDataException) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(noDataException);
		} catch (HibernateException hibernateException) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hibernateException);
		}
	}

	@RequestMapping(value = "/customers", method = RequestMethod.POST)
	public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
		try {
			customerService.addCustomer(customer);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
		}
	}
}
