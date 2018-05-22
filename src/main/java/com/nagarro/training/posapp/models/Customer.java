package com.nagarro.training.posapp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.nagarro.training.posapp.constants.POSAppConstants;

@Entity(name = POSAppConstants.CUSTOMER_TABLE_NAME)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;

	@Column(unique = true)
	private String email;

	@Column(unique = true)
	private long phoneNumber;
	private boolean isActive;

	@Column(unique = true)
	private String code;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "customer")
	@Fetch(FetchMode.SUBSELECT)
	private List<Order> orders;

	public Customer() {
		super();
	}

	public Customer(int id, String name, String email, long phoneNumber, boolean isActive, String code,
			List<Order> orders) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.isActive = isActive;
		this.code = code;
		this.orders = orders;
	}

	public String getCode() {
		return code;
	}

	public String getEmail() {
		return email;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
