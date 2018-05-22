package com.nagarro.training.posapp.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.nagarro.training.posapp.dao.IProductDAO;
import com.nagarro.training.posapp.models.Product;
import com.nagarro.training.posapp.utilities.HibernateUtil;

@Repository
public class ProductDAO implements IProductDAO {

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<Product> getAllProducts() throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		List<Product> products = session.createCriteria(Product.class).list();
		txn.commit();
		session.close();
		return products;
	}

	@Override
	public void addProduct(Product product) throws Exception {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		session.save(product);
		txn.commit();
		session.close();
	}

	@SuppressWarnings("deprecation")
	@Override
	public Product getProductById(int productId) throws HibernateException {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction txn = session.beginTransaction();
		Criteria criteria = session.createCriteria(Product.class);
		criteria.add(Restrictions.idEq(productId));
		Product product = (Product) criteria.uniqueResult();
		txn.commit();
		session.close();
		return product;
	}
}
