package com.example.demo.model;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "booking_details")
public class BookingDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1, initialValue=1)
	@Column(length = 3)
	private Long booking_id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private User user;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "payment_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Payment pay;
	
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "trip_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Trip trip;
	
	@Column(name="booking_date", length=10)
	private String bookingDate;
	
	@Column(length=10)
	private String status;
	
	public BookingDetails() {}

	public BookingDetails(Long booking_id, String bookingDate, String status) {
		super();
		this.booking_id = booking_id;
		this.bookingDate = bookingDate;
		this.status = status;
	}

	public Long getBooking_id() {
		return booking_id;
	}

	public void setBooking_id(Long booking_id) {
		this.booking_id = booking_id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Payment getPay() {
		return pay;
	}

	public void setPay(Payment pay) {
		this.pay = pay;
	}

	public Trip getTrip() {
		return trip;
	}

	public void setTrip(Trip trip) {
		this.trip = trip;
	}
}