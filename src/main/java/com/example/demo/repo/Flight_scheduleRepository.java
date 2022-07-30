package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Flight_schedule;

public interface Flight_scheduleRepository extends JpaRepository<Flight_schedule, Long> {
	
	@Query("from Flight_schedule where flight_id= ?1")
	public Flight_schedule findByFlightId(Long id);

}
