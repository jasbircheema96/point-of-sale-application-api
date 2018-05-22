package com.nagarro.training.posapp.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.nagarro.training.posapp.constants.POSAppConstants;

@Entity(name = POSAppConstants.ORDER_TABLE_NAME)
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@ManyToOne
	private Customer customer;

	@ManyToOne
	private Employee employee;

	private String status;
	private String paymentMode;
	private Date date;
	private double amount;
	private double payableAmount;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "order")
	private List<OrderDetail> orderDetails;

	@Transient
	private String timeString;

	@Transient
	private String dateString;

	public Order() {
		super();
	}

	public Order(int id, Customer customer, Employee employee, String status, String paymentMode, Date date,
			double amount, double payableAmount, List<OrderDetail> orderDetails, String timeString, String dateString) {
		super();
		this.id = id;
		this.customer = customer;
		this.employee = employee;
		this.status = status;
		this.paymentMode = paymentMode;
		this.date = date;
		this.amount = amount;
		this.payableAmount = payableAmount;
		this.orderDetails = orderDetails;
		this.timeString = timeString;
		this.dateString = dateString;
	}

	public double getAmount() {
		return amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public Date getDate() {
		return date;
	}

	public String getDateString() {
		return dateString;
	}

	public Employee getEmployee() {
		return employee;
	}

	public int getId() {
		return id;
	}

	public List<OrderDetail> getOrderDetails() {
		return orderDetails;
	}

	public double getPayableAmount() {
		return payableAmount;
	}

	public String getPaymentMode() {
		return paymentMode;
	}

	public String getStatus() {
		return status;
	}

	public String getTimeString() {
		return timeString;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public void setDateString(String dateString) {
		this.dateString = dateString;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setOrderDetails(List<OrderDetail> orderDetails) {
		this.orderDetails = orderDetails;
	}

	public void setPayableAmount(double payableAmount) {
		this.payableAmount = payableAmount;
	}

	public void setPaymentMode(String paymentMode) {
		this.paymentMode = paymentMode;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTimeString(String timeString) {
		this.timeString = timeString;
	}

}
