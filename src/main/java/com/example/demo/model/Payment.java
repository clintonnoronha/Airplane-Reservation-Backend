package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	private String payment_id;
	
	private double amount;
	
	private String status;
	
	public Payment() {}

	public Payment(String payment_id, double amount, String status) {
		super();
		this.payment_id = payment_id;
		this.amount = amount;
		this.status = status;
	}

	public String getPayment_id() {
		return payment_id;
	}

	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}