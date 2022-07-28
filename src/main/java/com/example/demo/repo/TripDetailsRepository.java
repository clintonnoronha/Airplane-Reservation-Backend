package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.TripDetails;

public interface TripDetailsRepository extends JpaRepository<TripDetails, Long>{

	
}
