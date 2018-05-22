package com.nagarro.training.posapp.dao.impl;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.nagarro.training.posapp.dao.IOrderDAO;
import com.nagarro.training.posapp.models.Order;
import com.nagarro.training.posapp.utilities.HibernateUtil;

public class OrderDAO implements IOrderDAO {

	@Override
	public void addOrder(Order order) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		session.save(order);
		txn.commit();
		session.close();
	}

}
