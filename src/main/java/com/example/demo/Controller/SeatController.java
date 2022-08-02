package com.example.demo.Controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Passenger;
import com.example.demo.model.Seat;
import com.example.demo.model.SeatResponse;
import com.example.demo.repo.PassengerRepository;
import com.example.demo.repo.SeatRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class SeatController {
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@PostMapping("/seat")
	public SeatResponse createSeats(@Valid @RequestBody SeatResponse sr){
		Seat s=new Seat(sr);
		s.setPassenger(new ArrayList<Passenger>());
		this.seatRepository.save(s);
		return sr;
	}
	
	@GetMapping("/seat/business/{trip_id}")
	public List<String> businessSeats(@PathVariable("trip_id") Long id) {
		List<Seat> sl = this.seatRepository.findAll();
		List<String> rl = new ArrayList<>();
		sl.forEach(s -> {
			if (s.getSeat_type().equals("Business")) {
				rl.add(s.getSeat_id());
			}
		});
		List <Passenger> pl=this.passengerRepository.findAll();
		pl.stream().filter(p -> id == p.getTrip().getTrip_id()).forEach(p ->{
			Seat  pr=p.getSeat();
			if (pr != null) {
				if (!rl.contains(pr.getSeat_id())) {
					rl.add(pr.getSeat_id());
				}
			}
		});
		return rl;
	}
	
	@GetMapping("/seat/economy/{trip_id}")
	public List<String> economySeats(@PathVariable("trip_id") Long id) {
		List<Seat> sl = this.seatRepository.findAll();
		List<String> rl = new ArrayList<>();
		sl.forEach(s -> {
			if (s.getSeat_type().equals("Economy")) {
				rl.add(s.getSeat_id());
			}
		});
		List <Passenger> pl=this.passengerRepository.findAll();
		pl.stream().filter(p -> id == p.getTrip().getTrip_id()).forEach(p ->{
			Seat  pr=p.getSeat();
			if (pr != null) {
				if (!rl.contains(pr.getSeat_id())) {
					rl.add(pr.getSeat_id());
				}
			}
		});
		return rl;
	}
}
