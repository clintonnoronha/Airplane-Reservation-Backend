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
import com.example.demo.model.PassengerResponse;
import com.example.demo.model.TripDetails;
import com.example.demo.model.TripDetailsResponse;
import com.example.demo.repo.PassengerRepository;
import com.example.demo.repo.SeatRepository;
import com.example.demo.repo.TripDetailsRepository;
import com.example.demo.repo.TripRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class PassengerController {
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private TripRepository tripRepository; 
	
	@Autowired
	private TripDetailsRepository tripDetailsRepository;
	
	@PostMapping("/passengers")
	public Passenger createPassengers(@Valid @RequestBody PassengerResponse pr){
		Passenger pe=new Passenger(pr);
		pe.setTrip(this.tripRepository.findByTripId(pr.getTrip_id()));
		pe.setSeat(this.seatRepository.findSeatById(pr.getSeat_id()));
		this.passengerRepository.save(pe);
		List<TripDetails> tdl=this.tripDetailsRepository.findByTripDetailsId(pr.getTrip_id());
		tdl.forEach(t->{
			if(this.seatRepository.findSeatById(pr.getSeat_id()).getSeat_type().equals(t.getSeat_type())) {
				TripDetails td=t;
				td.setCount_of_seats(td.getCount_of_seats()-1);
				this.tripDetailsRepository.save(td);
			}
		});
		return pe;
	} 
	
	@GetMapping("/passengers/{trip_id}")
	public List <String> getPassengersByTripId(@PathVariable("trip_id") Long id){
		List <Passenger> pl=this.passengerRepository.findAll();
		List <String> seatList=new ArrayList<>();
		pl.stream().filter(p -> id == p.getTrip().getTrip_id()).forEach(p ->{
			String  pr=p.getSeat().getSeat_id();
			seatList.add(pr);
		});
		return seatList;
		
	}
	

}
