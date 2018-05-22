package com.nagarro.training.posapp.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.nagarro.training.posapp.models.Product;

public interface IProductDAO {
	List<Product> getAllProducts() throws HibernateException;

	void addProduct(Product product) throws Exception;

	Product getProductById(int productId) throws HibernateException;
}
