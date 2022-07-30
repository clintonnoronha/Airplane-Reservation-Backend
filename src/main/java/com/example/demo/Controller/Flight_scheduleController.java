package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookingDetails;
import com.example.demo.model.Flight_schedule;
import com.example.demo.model.Flight_scheduleResponse;
import com.example.demo.model.Passenger;
import com.example.demo.model.Trip;
import com.example.demo.model.TripDetails;
import com.example.demo.repo.AircraftRepository;
import com.example.demo.repo.Flight_scheduleRepository;
import com.example.demo.repo.TripRepository;

@RestController
public class Flight_scheduleController {
	
	@Autowired
	private Flight_scheduleRepository flightscheduleRepository ;
	
	@Autowired
	private TripRepository tripRepository;
	
	@Autowired
	private AircraftRepository aircraftRepository;

	@GetMapping("/flights")
	public List<Flight_scheduleResponse> viewAllFlights() {
		List<Flight_schedule> list=flightscheduleRepository.findAll();
		List<Flight_scheduleResponse> responselist=new ArrayList<>();
		list.forEach(l -> {
			Flight_scheduleResponse fs=new Flight_scheduleResponse();
			fs.setFlight_id(l.getFlight_id());
			fs.setArrival_time(l.getArrival_time());
			fs.setDeparture_time(l.getDeparture_time());
			fs.setDeparture_date(l.getDeparture_date());
			fs.setDuration(l.getDuration());
			fs.setSource(l.getSource());
			fs.setDestination(l.getDestination());
			fs.setTrip_id(l.getFlight_id());
			fs.setAircraft_id(tripRepository.findByTripId(l.getFlight_id()).getAircraft().getAircraftId());
			responselist.add(fs);
			
		});
		return responselist;
	}
	
	@PostMapping("/add")
	public ResponseEntity<Flight_schedule> createFlight(@Valid @RequestBody Flight_scheduleResponse fsr) {
		
		Flight_schedule fs=new Flight_schedule(fsr);
		
		Trip tr=new Trip();
		tr.setTrip_id(fsr.getTrip_id());
		tr.setBkDetails(new BookingDetails());
		tr.setAircraft(aircraftRepository.findByAircraftId(fsr.getAircraft_id()));
		tr.setFlight_schedule(fs);
		tr.setTripDetail(new ArrayList<TripDetails>());
		tr.setPassenger(new ArrayList<Passenger>());
		tripRepository.save(tr);
		
		fs.setTrip(tripRepository.findByTripId(fsr.getTrip_id()));
		flightscheduleRepository.save(fs);
		
		return new ResponseEntity<>(fs, HttpStatus.CREATED);
	}
	
	@DeleteMapping(value = "/delete/{trip_id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long trip_id) {
        tripRepository.deleteById(trip_id);
        return new ResponseEntity<>(trip_id, HttpStatus.OK);
    }
	
	@GetMapping(value="/search")
	public List<Flight_scheduleResponse> searchFlight(@RequestParam(name="departure_date") String dep_date,
			@RequestParam(name="source") String src,
			@RequestParam(name="destination") String dest){
		List<Flight_schedule> list=flightscheduleRepository.findAll();
		List<Flight_scheduleResponse> responselist=new ArrayList<>();
		list.forEach(l -> {
			Flight_scheduleResponse fs=new Flight_scheduleResponse();
			if(dep_date.equals(l.getDeparture_date()) && src.equals(l.getSource()) && dest.equals(l.getDestination())) {
				fs.setFlight_id(l.getFlight_id());
				fs.setArrival_time(l.getArrival_time());
				fs.setDeparture_time(l.getDeparture_time());
				fs.setDeparture_date(l.getDeparture_date());
				fs.setDuration(l.getDuration());
				fs.setSource(l.getSource());
				fs.setDestination(l.getDestination());
				fs.setTrip_id(l.getFlight_id());
				fs.setAircraft_id(tripRepository.findByTripId(l.getFlight_id()).getAircraft().getAircraftId());
				responselist.add(fs);
			}
			
		});
		return responselist;
	}
}
	
