package com.nagarro.training.posapp.models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.nagarro.training.posapp.constants.POSAppConstants;

@Entity(name = POSAppConstants.CASH_DRAWER_TABLE_NAME)
public class CashDrawer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private double startBalance;
	private double currentBalance;
	private Date lastUpdated;

	public CashDrawer() {
		super();
	}

	public CashDrawer(int id, double startBalance, double currentBalance, Date lastUpdated) {
		super();
		this.id = id;
		this.startBalance = startBalance;
		this.currentBalance = currentBalance;
		this.lastUpdated = lastUpdated;
	}

	public double getCurrentBalance() {
		return currentBalance;
	}

	public int getId() {
		return id;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public double getStartBalance() {
		return startBalance;
	}

	public void setCurrentBalance(double currentBalance) {
		this.currentBalance = currentBalance;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public void setStartBalance(double startBalance) {
		this.startBalance = startBalance;
	}
}
