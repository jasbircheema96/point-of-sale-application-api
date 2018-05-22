package com.nagarro.training.posapp.services;

import java.util.List;

import org.hibernate.HibernateException;

import com.nagarro.training.posapp.models.Employee;
import com.nagarrro.training.posapp.exceptions.LoginException;
import com.nagarrro.training.posapp.exceptions.NoDataFoundException;

public interface IEmployeeService {
	Employee login(Employee employee) throws HibernateException, LoginException;

	List<Employee> getAllEmployees() throws NoDataFoundException, HibernateException;
}
