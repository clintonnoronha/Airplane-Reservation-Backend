package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Aircraft;
import com.example.demo.model.AircraftResponse;
import com.example.demo.model.Trip;
import com.example.demo.repo.AircraftModelRepository;
import com.example.demo.repo.AircraftRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AircraftController {

	@Autowired
	AircraftRepository aircraftRepo;
	@Autowired
	AircraftModelRepository aircraftRepoModel;
	
	@PostMapping("/aircraft")
	public AircraftResponse createAircraftModel(@RequestBody AircraftResponse ar) {
		Aircraft aircraft=new Aircraft(ar);
		aircraft.setAircraftModel(this.aircraftRepoModel.findById(ar.getAircraftTypeId()).get());
		aircraft.setTrip(new ArrayList<Trip>());
		aircraftRepo.save(aircraft);
		return ar;
	}
	
	@GetMapping("/aircraft")
	public List<AircraftResponse> getAllAircrafts(){
		List<Aircraft> al=aircraftRepo.findAll();
		List<AircraftResponse> arl=new ArrayList<>();
		al.forEach(a->{
			AircraftResponse ar=new AircraftResponse();
			ar.setAircraftId(a.getAircraftId());
			ar.setAircraftTypeId(a.getAircraftModel().getAircraftTypeId());
			arl.add(ar);
		});
		return arl;
	}
	
	@GetMapping("/aircraft/{id}")
	public List<AircraftResponse> getById(@PathVariable Long id) {
		Aircraft a= aircraftRepo.findByAircraftId(id);
		List<AircraftResponse> arl=new ArrayList<>();
		if(a!=null) {
			AircraftResponse ar=new AircraftResponse();
			ar.setAircraftId(a.getAircraftId());
			ar.setAircraftTypeId(a.getAircraftModel().getAircraftTypeId());
			arl.add(ar);
		}
		return arl;
	}
	
	@DeleteMapping("/aircraft/{id}")
	public void deleteById(@PathVariable Long id) {
		 aircraftRepo.deleteById(id);
	}
}
