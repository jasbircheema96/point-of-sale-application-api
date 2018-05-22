package com.nagarro.training.posapp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nagarro.training.posapp.dao.IEmployeeDAO;
import com.nagarro.training.posapp.models.Employee;
import com.nagarro.training.posapp.utilities.HibernateUtil;

@Repository
public class EmployeeDAO implements IEmployeeDAO {

	@SuppressWarnings("deprecation")
	@Override
	public Employee getEmployee(Employee employee) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.eq("email", employee.getEmail()));
		criteria.add(Restrictions.eq("password", employee.getPassword()));
		Employee loggedInEmployee = (Employee) criteria.uniqueResult();
		txn.commit();
		session.close();
		return loggedInEmployee;
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Employee> getAllEmployees() throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		List<Employee> employees = session.createCriteria(Employee.class).list();
		txn.commit();
		session.close();
		return employees;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Employee getEmployeeById(int employeeId) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		Criteria criteria = session.createCriteria(Employee.class);
		criteria.add(Restrictions.idEq(employeeId));
		Employee employee = (Employee) criteria.uniqueResult();
		txn.commit();
		session.close();
		return employee;
	}

}
