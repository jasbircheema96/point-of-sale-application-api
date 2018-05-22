package com.nagarro.training.posapp.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.nagarro.training.posapp.constants.POSAppConstants;

@Entity(name = POSAppConstants.ORDER_DETAIL_TABLE_NAME)
public class OrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private long quantity;
	private double price;

	@ManyToOne
	private Order order;

	@ManyToOne
	private Product product;

	@Transient
	private int productId;

	public OrderDetail() {
		super();
	}

	public OrderDetail(int id, long quantity, double price, Order order, Product product) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.order = order;
		this.product = product;
	}

	public int getId() {
		return id;
	}

	public Order getOrder() {
		return order;
	}

	public double getPrice() {
		return price;
	}

	public Product getProduct() {
		return product;
	}

	public int getProductId() {
		return productId;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
