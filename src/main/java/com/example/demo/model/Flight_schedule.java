package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name="flights_schedules")
public class Flight_schedule {
	
	@Id
	private Long flight_id;
	
	private String source;
	private String destination;
	private String departure_time;
	private String arrival_time;
	private String departure_date;
	private String duration;
	
	@OneToOne(mappedBy="flight_schedule")
	private Trip trip;
	
	
	
	public Long getFlight_id() {
		return flight_id;
	}
	public void setFlight_id(Long flight_id) {
		this.flight_id = flight_id;
	}
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
	
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public Flight_schedule(Long flight_id, String source, String destination, String departure_time,
			String arrival_time, String departure_date, String duration) {
		super();
		this.flight_id = flight_id;
		this.source = source;
		this.destination = destination;
		this.departure_time = departure_time;
		this.arrival_time = arrival_time;
		this.departure_date = departure_date;
		this.duration = duration;
	}
	
	public Flight_schedule() {
		
	}
	
	public Flight_schedule(Flight_scheduleResponse fcr) {
		this.flight_id=fcr.getFlight_id();
		this.source=fcr.getSource();
		this.destination=fcr.getDestination();
		this.departure_time=fcr.getDeparture_time();
		this.arrival_time=fcr.getArrival_time();
		this.departure_date=fcr.getDeparture_date();
		this.duration=fcr.getDuration();
	}
	
	
}
