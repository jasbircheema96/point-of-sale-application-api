package com.nagarro.training.posapp.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.nagarro.training.posapp.models.Customer;

public interface ICustomerDAO {
	List<Customer> getAllCustomers() throws HibernateException;

	void addCustomer(Customer customer) throws Exception;

	Customer getCustomerById(int customerId) throws HibernateException;
}
