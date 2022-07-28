package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AircraftModel;

public interface AircraftModelRepository extends JpaRepository<AircraftModel, Long>{

}
