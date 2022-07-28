package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "booking_details")
public class BookingDetails {
	
	@Id
	private int booking_id;
	
	@Column(name="booking_date", length=10)
	private String bookingDate;
	
	private String status;
	
}