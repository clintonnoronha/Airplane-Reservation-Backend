package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Flight_schedule;

public interface Flight_scheduleRepository extends JpaRepository<Flight_schedule, Long> {
	

}
