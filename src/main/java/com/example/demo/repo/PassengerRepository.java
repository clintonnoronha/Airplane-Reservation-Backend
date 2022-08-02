package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.*;

public interface PassengerRepository extends JpaRepository<Passenger, Long>{
	
	@Query("from Passenger where trip_id = ?1 and seat_id = ?2")
	public Passenger findPassengerByTripIdAndSeatId(Long trip_id, String seat_id);

}
