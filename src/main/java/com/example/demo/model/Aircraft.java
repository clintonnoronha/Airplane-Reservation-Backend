package com.example.demo.model;

import java.util.List;

import javax.persistence.*;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="aircraft")
public class Aircraft {

	@Id
	Long aircraftId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="aircraftTypeId")
	@OnDelete(action=OnDeleteAction.CASCADE)
	AircraftModel aircraftModel;
	
	@OneToMany(mappedBy="aircraft")
	private List<Trip> trip;
	
	public Aircraft() {
		super();
		System.out.println("Aircraft created");
		// TODO Auto-generated constructor stub
	}
	
	public Aircraft(AircraftResponse ar) {
		this.aircraftId=ar.getAircraftId();
	}

	public Aircraft(Long aircraftId) {
		super();
		this.aircraftId = aircraftId;
	}

	public Long getAircraftId() {
		return aircraftId;
	}

	public void setAircraftId(Long aircraftId) {
		this.aircraftId = aircraftId;
	}

	public AircraftModel getAircraftModel() {
		return aircraftModel;
	}

	public void setAircraftModel(AircraftModel aircraftModel) {
		this.aircraftModel = aircraftModel;
	}
	
	public List<Trip> getTrip() {
		return trip;
	}

	public void setTrip(List<Trip> trip) {
		this.trip = trip;
	}

	
	
}
