package com.example.demo.Controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Passenger;
import com.example.demo.model.Seat;
import com.example.demo.model.SeatResponse;
import com.example.demo.repo.SeatRepository;

@CrossOrigin(origins = "http://localhost:4200")
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
	
	@GetMapping("/seat/business")
	public List<String> businessSeats() {
		List<Seat> sl = this.seatRepository.findAll();
		List<String> rl = new ArrayList<>();
		sl.forEach(s -> {
			if (s.getSeat_type().equals("Business")) {
				rl.add(s.getSeat_id());
			}
		});
		return rl;
	}
	
	@GetMapping("/seat/economy")
	public List<String> economySeats() {
		List<Seat> sl = this.seatRepository.findAll();
		List<String> rl = new ArrayList<>();
		sl.forEach(s -> {
			if (s.getSeat_type().equals("Economy")) {
				rl.add(s.getSeat_id());
			}
		});
		return rl;
	}
}
