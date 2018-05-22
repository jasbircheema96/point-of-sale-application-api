package com.nagarro.training.posapp.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.nagarro.training.posapp.models.Employee;

public interface IEmployeeDAO {

	Employee getEmployee(Employee employee) throws HibernateException;

	List<Employee> getAllEmployees() throws HibernateException;

	Employee getEmployeeById(int employeeId) throws HibernateException;

}
