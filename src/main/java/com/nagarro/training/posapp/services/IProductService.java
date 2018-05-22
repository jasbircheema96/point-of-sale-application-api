package com.nagarro.training.posapp.services;

import java.util.List;

import org.hibernate.HibernateException;

import com.nagarro.training.posapp.models.Product;
import com.nagarrro.training.posapp.exceptions.NoDataFoundException;

public interface IProductService {
	List<Product> getAllProducts() throws HibernateException, NoDataFoundException;

	void addProduct(Product product) throws Exception;
}