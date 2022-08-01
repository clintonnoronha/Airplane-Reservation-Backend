package com.example.demo.model;

public class DetailsResponse {

	private Long flight_id;
	private String source;
	private String destination;
	private String departure_time;
	private String arrival_time;
	private String departure_date;
	private String duration;
	private Long aircraft_id;
	private Long trip_id;
	
	private Long price;
	private String seat_type;	
	private Long count_of_seats;
	
	
	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDeparture_time() {
		return departure_time;
	}

	public void setDeparture_time(String departure_time) {
		this.departure_time = departure_time;
	}

	public String getArrival_time() {
		return arrival_time;
	}

	public void setArrival_time(String arrival_time) {
		this.arrival_time = arrival_time;
	}

	public String getDeparture_date() {
		return departure_date;
	}

	public void setDeparture_date(String departure_date) {
		this.departure_date = departure_date;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public Long getAircraft_id() {
		return aircraft_id;
	}

	public void setAircraft_id(Long aircraft_id) {
		this.aircraft_id = aircraft_id;
	}
	
	public Long getFlight_id() {
		return flight_id;
	}

	public void setFlight_id(Long i) {
		this.flight_id = i;
	}
	
	
	public Long getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(Long trip_id) {
		this.trip_id = trip_id;
	}
	
	
	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getSeat_type() {
		return seat_type;
	}

	public void setSeat_type(String seat_type) {
		this.seat_type = seat_type;
	}

	public Long getCount_of_seats() {
		return count_of_seats;
	}

	public void setCount_of_seats(Long count_of_seats) {
		this.count_of_seats = count_of_seats;
	}

	public DetailsResponse() {
		
	}
	
	public DetailsResponse(Flight_scheduleResponse fsr) {
		this.aircraft_id=fsr.getAircraft_id();
		this.arrival_time=fsr.getArrival_time();
		this.departure_date=fsr.getDeparture_date();
		this.departure_time=fsr.getDeparture_time();
		this.source=fsr.getSource();
		this.destination=fsr.getDestination();
		this.trip_id=fsr.getTrip_id();
		this.flight_id=fsr.getFlight_id();
		this.duration=fsr.getDuration();
	}
	
}
