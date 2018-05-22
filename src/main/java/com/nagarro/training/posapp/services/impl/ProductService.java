package com.nagarro.training.posapp.services.impl;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.posapp.constants.POSAppErrorMessages;
import com.nagarro.training.posapp.dao.IProductDAO;
import com.nagarro.training.posapp.models.Product;
import com.nagarro.training.posapp.services.IProductService;
import com.nagarrro.training.posapp.exceptions.NoDataFoundException;

@Service
public class ProductService implements IProductService {

	@Autowired
	private IProductDAO productDAO;

	@Override
	public List<Product> getAllProducts() throws HibernateException, NoDataFoundException {
		List<Product> products = productDAO.getAllProducts();

		if (products.isEmpty()) {
			throw new NoDataFoundException(POSAppErrorMessages.ERROR_MESSAGE_PRODUCTS_EMPTY);
		}
		return products;
	}

	@Override
	public void addProduct(Product product) throws Exception {
		productDAO.addProduct(product);
	}

}
