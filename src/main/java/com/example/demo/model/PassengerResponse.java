package com.example.demo.model;



public class PassengerResponse {
	
	
	private Long trip_id;
	private String seat_id;
	
	private Long passenger_id;
	private String name;
	private int age;
	
	public PassengerResponse() {}
	
	public PassengerResponse(Passenger p) {
		this.passenger_id = p.getPassenger_id();
		this.name = p.getName();
		this.age = p.getAge();
		this.seat_id = p.getSeat().getSeat_id();
		this.trip_id = p.getTrip().getTrip_id();
	}

	
	public Long getTrip_id() {
		return trip_id;
	}
	public void setTrip_id(Long trip_id) {
		this.trip_id = trip_id;
	}
	public String getSeat_id() {
		return seat_id;
	}
	public void setSeat_id(String seat_id) {
		this.seat_id = seat_id;
	}
	public Long getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(Long passenger_id) {
		this.passenger_id = passenger_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}
