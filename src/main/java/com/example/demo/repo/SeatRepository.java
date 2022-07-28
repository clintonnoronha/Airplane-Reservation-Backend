package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long> {

}
