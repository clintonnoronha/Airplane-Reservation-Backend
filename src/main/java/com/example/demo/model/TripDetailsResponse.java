package com.example.demo.model;

public class TripDetailsResponse {

	private Long details_id;
	
	private Long count_of_seats;
	
	private String seat_type;
	
	private Long price;
	
	private Long trip_id;

	public Long getDetails_id() {
		return details_id;
	}

	public void setDetails_id(Long details_id) {
		this.details_id = details_id;
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

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public Long getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(Long trip_id) {
		this.trip_id = trip_id;
	}
	
	
		
	
}
