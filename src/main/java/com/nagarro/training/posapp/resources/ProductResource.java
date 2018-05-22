package com.nagarro.training.posapp.resources;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.posapp.models.Product;
import com.nagarro.training.posapp.services.IProductService;
import com.nagarrro.training.posapp.exceptions.NoDataFoundException;

@RestController
public class ProductResource {

	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<?> getAllProducts() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(productService.getAllProducts());
		} catch (NoDataFoundException noDataException) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(noDataException);
		} catch (HibernateException hibernateException) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(hibernateException);
		}
	}

	@RequestMapping(value = "/products", method = RequestMethod.POST)
	public ResponseEntity<?> addProduct(@RequestBody Product product) {
		try {
			productService.addProduct(product);
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception exception) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
		}

	}
}
