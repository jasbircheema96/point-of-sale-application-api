package com.nagarro.training.posapp.services;

import java.util.List;

import org.hibernate.HibernateException;

import com.nagarro.training.posapp.models.Customer;
import com.nagarrro.training.posapp.exceptions.NoDataFoundException;

public interface ICustomerService {
	List<Customer> getAllCustomers() throws HibernateException, NoDataFoundException;

	void addCustomer(Customer customer) throws Exception;

}
