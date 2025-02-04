package com.example.demo.model;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
@Table(name = "trip_details")
public class TripDetails {

	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long detail_id;
	
	private Long price;

	private Long count_of_seats;

	@Column(length=8)
	private String seat_type;
	
	@ManyToOne
	@JoinColumn(name="trip_id")
	@OnDelete(action=OnDeleteAction.CASCADE)
	@JsonBackReference
	private Trip trip;
	
	public TripDetails(TripDetailsResponse tdr) {
		this.detail_id = tdr.getDetails_id();
		this.price = tdr.getPrice();
		this.count_of_seats = tdr.getCount_of_seats();
		this.seat_type = tdr.getSeat_type();
		
	}

	
	public Long getDetail_id() {
		return detail_id;
	}




	public void setDetail_id(Long detail_id) {
		this.detail_id = detail_id;
	}



	public Long getPrice() {
		return price;
	}




	public void setPrice(Long price) {
		this.price = price;
	}




	public Long getCount_of_seats() {
		return count_of_seats;
	}




	public void setCount_of_seats(Long count_of_seats) {
		this.count_of_seats = count_of_seats;
	}




	public String getSeat_type() {
		return seat_type;
	}




	public void setSeat_type(String seat_type) {
		this.seat_type = seat_type;
	}




	public Trip getTrip() {
		return trip;
	}




	public void setTrip(Trip trip) {
		this.trip = trip;
	}




	public TripDetails(Long detail_id, Long price, Long count_of_seats, String seat_type) {
		super();
		this.detail_id = detail_id;
		this.price = price;
		this.count_of_seats = count_of_seats;
		this.seat_type = seat_type;
	}




	public TripDetails() {}
}
