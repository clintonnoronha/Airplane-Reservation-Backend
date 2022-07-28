package com.example.demo.model;

import java.util.List;

public class AircraftModelResponse {
	
	Long aircraftTypeId;
    Long totalCapacity;
	Long countOfEconomicSeats;
	Long countOfBusinessSeats;
	
	List<Long> aircraftIdList;

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

	public List<Long> getAircraftIdList() {
		return aircraftIdList;
	}

	public void setAircraftIdList(List<Long> aircraftIdList) {
		this.aircraftIdList = aircraftIdList;
	}
	
}
