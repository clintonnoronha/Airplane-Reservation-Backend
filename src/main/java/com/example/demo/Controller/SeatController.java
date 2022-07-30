package com.example.demo.Controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Passenger;
import com.example.demo.model.Seat;
import com.example.demo.model.SeatResponse;
import com.example.demo.repo.SeatRepository;

@RestController
public class SeatController {
	
	@Autowired
	private SeatRepository seatRepository;
	
	@PostMapping("/seat")
	public SeatResponse createSeats(@Valid @RequestBody SeatResponse sr){
		Seat s=new Seat(sr);
		s.setPassenger(new ArrayList<Passenger>());
		this.seatRepository.save(s);
		return sr;
	}

}
