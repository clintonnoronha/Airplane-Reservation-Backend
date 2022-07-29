package com.example.demo.Controller;

import java.util.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Passenger;
import com.example.demo.model.PassengerResponse;
import com.example.demo.repo.PassengerRepository;
import com.example.demo.repo.SeatRepository;
import com.example.demo.repo.TripRepository;

@RestController
public class PassengerController {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private TripRepository tripRepository; 
	
	@PostMapping("/passengers")
	public List <PassengerResponse> createPassengers(@Valid @RequestBody List<PassengerResponse> prList){
		List<PassengerResponse> prl=new ArrayList<>();
		prList.forEach(pr ->{
			Passenger pe=new Passenger(pr);
			pe.setTrip(this.tripRepository.findById(pr.getTrip_id()).get());
			pe.setSeat(this.seatRepository.findSeatById(pr.getSeat_id()));
			this.passengerRepository.save(pe);
			prl.add(pr);
		});
		return prl;
	} 
	
	@GetMapping("/passengers")
	public List <String> getPassengersByTripId(@RequestParam(name="trip_id") Long id){
		List <Passenger> pl=this.passengerRepository.findAll();
		List <String> prl=new ArrayList<>();
		pl.stream().filter(p -> id == p.getTrip().getId()).forEach(p ->{
			String  pr=p.getSeat().getSeat_id();
			prl.add(pr);
		});
		return prl;
		
	}
	

}
