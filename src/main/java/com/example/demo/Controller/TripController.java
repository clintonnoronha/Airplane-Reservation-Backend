package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookingDetails;
import com.example.demo.model.Passenger;
import com.example.demo.model.Trip;
import com.example.demo.model.TripDetails;
import com.example.demo.model.TripResponse;
import com.example.demo.repo.AircraftRepository;
import com.example.demo.repo.Flight_scheduleRepository;
import com.example.demo.repo.TripRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class TripController {
	
	@Autowired
	private TripRepository tripRepository;
	
	@Autowired
	private AircraftRepository aircraftRepository;
	
	@Autowired
	private Flight_scheduleRepository flight_scheduleRepository;
	

	@PostMapping("/trip")
	public Trip createTrip(@RequestBody TripResponse tr) {
		Trip t = new Trip(tr);
		t.setAircraft(aircraftRepository.findByAircraftId(tr.getAircraft_id()));
		t.setFlight_schedule(flight_scheduleRepository.findById(tr.getFlight_id()).get());
		t.setBkDetails(new BookingDetails());
		t.setPassenger(new ArrayList <Passenger>());
		t.setTripDetail(new ArrayList<TripDetails>());
		return tripRepository.save(t);
	}
	
	@GetMapping("/trip")
	public List<TripResponse> getTrip(){
		List<Trip> tl = tripRepository.findAll();
		List<TripResponse> trl = new ArrayList<>();
		tl.forEach(t -> {
			TripResponse tr = new TripResponse();
			tr.setTrip_id(t.getTrip_id());
			tr.setFlight_id(t.getFlight_schedule().getFlight_id());
			tr.setAircraft_id(t.getAircraft().getAircraftId());
			trl.add(tr);
		});
		return trl;
	}

}
