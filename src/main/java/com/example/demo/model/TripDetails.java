package com.example.demo.model;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name = "trip_details")
public class TripDetails {

	
	@Id
	private int trip_id;

	private int price;

	private int count_of_seats;

	private String seat_type;

	public int gettrip_id() {
		return trip_id;
	}

	public void settrip_id(int trip_id) {
		this.trip_id = trip_id;
	}

	public int getprice() {
		return price;
	}

	public void setprice(int price) {
		this.price = price;
	}

	public int getcount_of_seats() {
		return count_of_seats;
	}

	public void secount_of_seats(int count_of_seats) {
		this.count_of_seats = count_of_seats;
	}

	public String getseat_type() {
		return seat_type;
	}

	public void setseat_type(String seat_type) {
		this.seat_type = seat_type;
	}
	public TripDetails() {}
}
