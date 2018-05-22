package com.nagarro.training.posapp.services;

import org.hibernate.HibernateException;

import com.nagarro.training.posapp.models.Order;
import com.nagarrro.training.posapp.exceptions.NoResourceFoundException;
import com.nagarrro.training.posapp.exceptions.OperationalException;

public interface IOrderService {
	void addOrder(Order order, int customerId, int employeeId)
			throws HibernateException, NoResourceFoundException, OperationalException;
}
