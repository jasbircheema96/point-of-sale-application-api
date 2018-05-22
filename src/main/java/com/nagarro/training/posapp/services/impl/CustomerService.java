package com.nagarro.training.posapp.services.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.posapp.constants.POSAppErrorMessages;
import com.nagarro.training.posapp.dao.ICustomerDAO;
import com.nagarro.training.posapp.models.Customer;
import com.nagarro.training.posapp.services.ICustomerService;
import com.nagarrro.training.posapp.exceptions.NoDataFoundException;

@Service
public class CustomerService implements ICustomerService {

	@Autowired
	private ICustomerDAO customerDAO;

	@Override
	public List<Customer> getAllCustomers() throws NoDataFoundException, HibernateException {
		List<Customer> customers = customerDAO.getAllCustomers();

		if (customers.isEmpty()) {
			throw new NoDataFoundException(POSAppErrorMessages.ERROR_MESSAGE_CUSTOMERS_EMPTY);
		}
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) throws Exception {
		customerDAO.addCustomer(customer);
	}

}
