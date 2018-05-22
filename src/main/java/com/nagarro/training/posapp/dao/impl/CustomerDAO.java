package com.nagarro.training.posapp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nagarro.training.posapp.dao.ICustomerDAO;
import com.nagarro.training.posapp.models.Customer;
import com.nagarro.training.posapp.utilities.HibernateUtil;

@Repository
public class CustomerDAO implements ICustomerDAO {

	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Customer> getAllCustomers() throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		List<Customer> customers = session.createCriteria(Customer.class).list();
		txn.commit();
		session.close();
		return customers;
	}

	@Override
	public void addCustomer(Customer customer) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		session.save(customer);
		txn.commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Customer getCustomerById(int customerId) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		Criteria criteria = session.createCriteria(Customer.class);
		criteria.add(Restrictions.idEq(customerId));
		Customer customer = (Customer) criteria.uniqueResult();
		txn.commit();
		session.close();
		return customer;
	}
}
