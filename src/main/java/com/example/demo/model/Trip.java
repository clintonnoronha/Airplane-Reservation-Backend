package com.example.demo.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "trip")
public class Trip {

	
	@Id
	private Long trip_id;

	@JsonManagedReference
	@OneToOne(mappedBy="trip", cascade=CascadeType.ALL)
	private Flight_schedule flight_schedule;

	@ManyToOne
	@JoinColumn(name="aircraft_id")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Aircraft aircraft;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "trip", cascade=CascadeType.ALL)
	private List<BookingDetails> bkDetails;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "trip", cascade=CascadeType.ALL)
	private List<TripDetails> tripDetail;
	
	@JsonManagedReference
	@OneToMany(mappedBy="trip", cascade=CascadeType.ALL)
	private List <Passenger> passenger;
	
	public Trip() {}

	public Trip(Long trip_id) {
		super();
		this.trip_id = trip_id;
	}



	public Long getTrip_id() {
		return trip_id;
	}

	public void setTrip_id(Long trip_id) {
		this.trip_id = trip_id;
	}

	public Flight_schedule getFlight_schedule() {
		return flight_schedule;
	}

	public void setFlight_schedule(Flight_schedule flight_schedule) {
		this.flight_schedule = flight_schedule;
	}

	public Aircraft getAircraft() {
		return aircraft;
	}

	public void setAircraft(Aircraft aircraft) {
		this.aircraft = aircraft;
	}

	public List<BookingDetails> getBkDetails() {
		return bkDetails;
	}

	public void setBkDetails(List<BookingDetails> bkDetails) {
		this.bkDetails = bkDetails;
	}

	public List<TripDetails> getTripDetail() {
		return tripDetail;
	}

	public void setTripDetail(List<TripDetails> tripDetail) {
		this.tripDetail = tripDetail;
	}

	
	public List<Passenger> getPassenger() {
		return passenger;
	}

	public void setPassenger(List<Passenger> passenger) {
		this.passenger = passenger;
	}

	public Trip(TripResponse tr) {
		this.trip_id = tr.getTrip_id();
	}
	
}
