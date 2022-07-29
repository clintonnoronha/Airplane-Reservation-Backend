package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {
	
	@Query("from Seat WHERE seat_id= ?1")
	public Seat findSeatById(String id);
	
}
