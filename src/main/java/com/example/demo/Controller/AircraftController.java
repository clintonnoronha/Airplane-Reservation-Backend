package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Aircraft;
import com.example.demo.repo.AircraftModelRepository;
import com.example.demo.repo.AircraftRepository;

@RestController
public class AircraftController {

	@Autowired
	AircraftRepository aircraftRepo;
	@Autowired
	AircraftModelRepository aircraftRepoModel;
	
	@PostMapping("/aircraft")
	public Aircraft createAircraftModel(@RequestBody Aircraft aircraft) {
//		AircraftModel arpm=aircraftRepoModel.findById(id).get();
		
		return aircraftRepo.save(aircraft);
	}
	
	@GetMapping("/aircraft")
	public List<Aircraft> getAll(){
		return aircraftRepo.findAll();
	}
	
	@GetMapping("/aircraft/{id}")
	public Aircraft getById(@PathVariable Long id) {
		return aircraftRepo.findById(id).get();
	}
	
	@DeleteMapping("/aircraft/{id}")
	public void deleteById(@PathVariable Long id) {
		 aircraftRepo.deleteById(id);
	}
}
