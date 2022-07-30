package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	private String payment_id;
	
	private Long amount;
	
	@Column(length=8)
	private String status;
	
	@OneToOne(mappedBy = "pay")
	private BookingDetails bkDetails;
	
	public Payment() {}

	public Payment(String payment_id, Long amount, String status) {
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

	public Long getAmount() {
		return amount;
	}

	public void setAmount(Long amount) {
		this.amount = amount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public BookingDetails getBkDetails() {
		return bkDetails;
	}

	public void setBkDetails(BookingDetails bkDetails) {
		this.bkDetails = bkDetails;
	}
}