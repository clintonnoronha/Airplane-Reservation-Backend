package com.example.demo.model;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Table(name = "trip_details")
public class TripDetails {

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1, initialValue=1)
	private Long detail_id;
	
	private Long price;

	private Long count_of_seats;

	@Column(length=8)
	private String seat_type;
	
	@OneToOne
	@JoinColumn(name="trip_id")
	@OnDelete(action=OnDeleteAction.CASCADE)
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
