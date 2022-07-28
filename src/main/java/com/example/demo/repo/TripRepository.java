package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Long>{

	
}
