package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Aircraft;

public interface AircraftRepository extends JpaRepository<Aircraft, Long>{
	
	@Query("from Aircraft where aircraftId=?1")
	public Aircraft findByAircraftId(Long id);
}
