package com.example.demo.model;

public class TripResponse {

	private Long trip_id;
	
	private Long flight_id;
	
	private Long aircraft_id;

	public Long getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(Long trip_id) {
		this.trip_id = trip_id;
	}

	public Long getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(Long flight_id) {
		this.flight_id = flight_id;
	}

	public Long getAircraft_id() {
		return aircraft_id;
	}

	public void setAircraft_id(Long aircraft_id) {
		this.aircraft_id = aircraft_id;
	}
	
	
}
