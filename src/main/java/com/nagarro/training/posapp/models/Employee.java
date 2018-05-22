package com.nagarro.training.posapp.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.nagarro.training.posapp.constants.POSAppConstants;

@Entity(name = POSAppConstants.EMPLOYEE_TABLE_NAME)
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(unique = true)
	private String code;
	private String name;

	@Column(unique = true)
	private String email;
	private String password;

	@Column(unique = true)
	private long phoneNumber;
	private boolean active;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "employee")
	@Fetch(FetchMode.SUBSELECT)
	private List<Order> orders;

	@OneToOne(fetch = FetchType.EAGER)
	private CashDrawer drawer;

	public Employee() {
		super();
	}

	public Employee(int id, String code, String name, String email, String password, long phoneNumber, boolean active,
			List<Order> orders, CashDrawer drawer) {
		super();
		this.id = id;
		this.code = code;
		this.name = name;
		this.email = email;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.active = active;
		this.orders = orders;
		this.drawer = drawer;
	}

	public String getCode() {
		return code;
	}

	public CashDrawer getDrawer() {
		return drawer;
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

	public String getPassword() {
		return password;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public void setDrawer(CashDrawer drawer) {
		this.drawer = drawer;
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

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
