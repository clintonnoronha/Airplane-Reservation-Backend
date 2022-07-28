package com.example.demo.model;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="aircraft_model")
public class AircraftModel {

	@Id
	@Column(length=4)
	Long aircraftTypeId;
	
	@Column(length=2)
	Long totalCapacity;
	
	@Column(length=2)
	Long countOfEconomicSeats;
	
	@Column(length=1)
	Long countOfBusinessSeats;
	
	@OneToMany(mappedBy = "aircraftModel")
	List<Aircraft> aircraftList;
	
	public AircraftModel() {
		super();
		System.out.println("Aircraft  model created");
		// TODO Auto-generated constructor stub
	}
	
	public AircraftModel(AircraftModelResponse aircraftModelResponse) {
		this.aircraftTypeId=aircraftModelResponse.getAircraftTypeId();
		this.totalCapacity=aircraftModelResponse.getTotalCapacity();
		this.countOfEconomicSeats=aircraftModelResponse.getCountOfEconomicSeats();
		this.countOfBusinessSeats=aircraftModelResponse.getCountOfBusinessSeats();
	}

	
	public AircraftModel(Long aircraftTypeId, Long totalCapacity, Long countOfEconomicSeats,
			Long countOfBusinessSeats) {
		super();
		this.aircraftTypeId = aircraftTypeId;
		this.totalCapacity = totalCapacity;
		this.countOfEconomicSeats = countOfEconomicSeats;
		this.countOfBusinessSeats = countOfBusinessSeats;
	}

	public Long getAircraftTypeId() {
		return aircraftTypeId;
	}

	public void setAircraftTypeId(Long aircraftTypeId) {
		this.aircraftTypeId = aircraftTypeId;
	}

	public Long getTotalCapacity() {
		return totalCapacity;
	}

	public void setTotalCapacity(Long totalCapacity) {
		this.totalCapacity = totalCapacity;
	}

	public Long getCountOfEconomicSeats() {
		return countOfEconomicSeats;
	}

	public void setCountOfEconomicSeats(Long countOfEconomicSeats) {
		this.countOfEconomicSeats = countOfEconomicSeats;
	}

	public Long getCountOfBusinessSeats() {
		return countOfBusinessSeats;
	}

	public void setCountOfBusinessSeats(Long countOfBusinessSeats) {
		this.countOfBusinessSeats = countOfBusinessSeats;
	}
	
	public List<Aircraft> getAircraftList() {
		return aircraftList;
	}

	public void setAircraftList(List<Aircraft> aircraftList) {
		this.aircraftList = aircraftList;
	}
}
