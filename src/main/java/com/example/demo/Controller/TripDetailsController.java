package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TripDetails;
import com.example.demo.model.TripDetailsResponse;
import com.example.demo.repo.TripDetailsRepository;
import com.example.demo.repo.TripRepository;

@RestController
public class TripDetailsController {

	@Autowired
	private TripDetailsRepository tripDetailsRepository;
	
	@Autowired
	private TripRepository tripRepository;
	
	@PostMapping("/tripDetails/economic")
	public TripDetails createTripDetailsEconomy(@RequestBody TripDetailsResponse tdr) {
		TripDetails td = new TripDetails(tdr);
		td.setCount_of_seats(tripRepository.findByTripId(tdr.getTrip_id()).getAircraft().getAircraftModel().getCountOfEconomicSeats());
		td.setSeat_type("Economy");
		td.setTrip(tripRepository.findByTripId(tdr.getTrip_id()));
		return tripDetailsRepository.save(td);
	}
	
	@PostMapping("/tripDetails/business")
	public TripDetails createTripDetailsBusiness(@RequestBody TripDetailsResponse tdr) {
		TripDetails td = new TripDetails(tdr);
		td.setCount_of_seats(tripRepository.findByTripId(tdr.getTrip_id()).getAircraft().getAircraftModel().getCountOfBusinessSeats());
		td.setSeat_type("Business");
		td.setTrip(tripRepository.findByTripId(tdr.getTrip_id()));
		return tripDetailsRepository.save(td);
	}
	
	@GetMapping("/tripDetails/{trip_id}")
	public List<TripDetailsResponse> getTripDetailsByTripId(@PathVariable Long trip_id) {
		List<TripDetails> tdl = tripDetailsRepository.findByTripDetailsId(trip_id);
		List<TripDetailsResponse> tdrList = new ArrayList<>();
		tdl.forEach(td -> {
			TripDetailsResponse tdr = new TripDetailsResponse();
			tdr.setDetails_id(td.getDetail_id());
			tdr.setPrice(td.getPrice());
			tdr.setTrip_id(td.getTrip().getTrip_id());
			tdr.setSeat_type(td.getSeat_type());
			tdr.setCount_of_seats(td.getCount_of_seats());
			tdrList.add(tdr);
		});
		
		return tdrList;
	}
}


