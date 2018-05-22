package com.nagarro.training.posapp.services.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.posapp.constants.POSAppErrorMessages;
import com.nagarro.training.posapp.dao.IEmployeeDAO;
import com.nagarro.training.posapp.models.Employee;
import com.nagarro.training.posapp.services.IEmployeeService;
import com.nagarrro.training.posapp.exceptions.LoginException;
import com.nagarrro.training.posapp.exceptions.NoDataFoundException;

@Service
public class EmployeeService implements IEmployeeService {

	@Autowired
	private IEmployeeDAO employeeDAO;

	@Override
	public Employee login(Employee employee) throws HibernateException, LoginException {
		Employee loggedInEmployee = employeeDAO.getEmployee(employee);
		if (loggedInEmployee == null) {
			throw new LoginException(POSAppErrorMessages.ERROR_MESSAGE_INVALID_LOGIN_CREDENTIAL);
		}
		return loggedInEmployee;
	}

	@Override
	public List<Employee> getAllEmployees() throws NoDataFoundException, HibernateException {
		List<Employee> employees = employeeDAO.getAllEmployees();
		if (employees.isEmpty()) {
			throw new NoDataFoundException(POSAppErrorMessages.ERROR_MESSAGE_EMPLOYEES_EMPTY);
		}
		return employees;
	}

}
