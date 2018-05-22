package com.nagarro.training.posapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.nagarro.training.posapp.utilities.HibernateUtil;

@SpringBootApplication
public class PointOfSaleApp {

	public static void main(String[] args) {
		SpringApplication.run(PointOfSaleApp.class, args);
		HibernateUtil.getSessionFactory();
	}

}
