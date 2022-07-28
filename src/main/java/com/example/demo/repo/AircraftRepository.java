package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Aircraft;

public interface AircraftRepository extends JpaRepository<Aircraft, Long>{
	
}
