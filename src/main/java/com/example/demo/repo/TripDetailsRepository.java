package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.TripDetails;

public interface TripDetailsRepository extends JpaRepository<TripDetails, Long>{

	@Query("from TripDetails WHERE trip_id = ?1")
	public List<TripDetails> findByTripDetailsId(Long trip_id);
	
	
}
