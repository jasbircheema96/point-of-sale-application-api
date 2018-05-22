package com.nagarro.training.posapp.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.nagarro.training.posapp.constants.POSAppConstants;

@Entity(name = POSAppConstants.PRODUCT_TABLE_NAME)
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Column(unique = true)
	private String code;
	private double price;
	private long quantity;
	private String description;

	public Product() {
		super();
	}

	public Product(int id, String name, String code, double price, long quantity, String description) {
		super();
		this.id = id;
		this.name = name;
		this.code = code;
		this.price = price;
		this.quantity = quantity;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public String getDescription() {
		return description;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getPrice() {
		return price;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}