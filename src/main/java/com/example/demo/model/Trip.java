package com.example.demo.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
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

@Entity
@Table(name = "trip")
public class Trip {

	
	@Id
	@SequenceGenerator(sequenceName = "trip_id", allocationSize = 1, name = "seq", initialValue=1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq")
	@Column(name="trip_id")
	private Long id;

	//@OneToOne
	//@JoinColumn
	/*(name = "flight_id")
	private flight_schedule flight_schedule;

	//@ManyToOne
	//@JoinColumn
	(name = "aircraft_id")
	private aircraft aircraft;*/
	
	@OneToOne(mappedBy = "trip")
	private BookingDetails bkDetails;
	
	/*public flight_schedule getflight_id() {
		return flight_schedule;
	}

	public void setflight_id(flight_schedule flight_schedule) {
		this.flight_schedule = flight_schedule;
	}

	public aircraft getaircraft() {
		return aircraft;
	}

	public void setaircraft_id(aircraft aircraft) {
		this.aircraft = aircraft;
	}*/
	public Trip() {}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public BookingDetails getBkDetails() {
		return bkDetails;
	}

	public void setBkDetails(BookingDetails bkDetails) {
		this.bkDetails = bkDetails;
	}
}
