package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.AircraftModel;

public interface AircraftModelRepository extends JpaRepository<AircraftModel, Long>{
	
	@Query("from AircraftModel where aircraftTypeId=?1")
	public AircraftModel findByAircraftTypeId(Long id);
}
