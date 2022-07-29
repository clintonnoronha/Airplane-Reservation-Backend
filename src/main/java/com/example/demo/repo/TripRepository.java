package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Long>{

	@Query("from Trip WHERE trip_id = ?1")
	public Trip findByTripId(Long trip_id);
	
}
