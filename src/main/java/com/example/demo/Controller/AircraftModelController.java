package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Aircraft;
import com.example.demo.model.AircraftModel;
import com.example.demo.model.AircraftModelResponse;
import com.example.demo.repo.AircraftModelRepository;
import com.example.demo.repo.AircraftRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AircraftModelController {

	@Autowired
	private AircraftModelRepository aircraftModelRepo;
	@Autowired
	private AircraftRepository aircraftRepo;
	
	@PostMapping("/aircraftModel")
	public AircraftModel createAircraftModel(@RequestBody AircraftModelResponse aircraftModel) {
		AircraftModel model=new AircraftModel(aircraftModel);
		model.setAircraftList(new ArrayList<Aircraft>());
		return aircraftModelRepo.save(model);
	}
	
	@GetMapping("/aircraftModel")
	public List<AircraftModelResponse> getAll(){
		List<AircraftModel> ls= aircraftModelRepo.findAll();
		List<AircraftModelResponse> list=new ArrayList<>();
		ls.forEach(l -> {
			AircraftModelResponse amr=new AircraftModelResponse();
			amr.setAircraftTypeId(l.getAircraftTypeId());
			amr.setCountOfBusinessSeats(l.getCountOfBusinessSeats());
			amr.setCountOfEconomicSeats(l.getCountOfEconomicSeats());
			amr.setTotalCapacity(l.getTotalCapacity());
			List<Long> lst=new ArrayList<>();
			for(Aircraft a:l.getAircraftList()) {
				lst.add(a.getAircraftId());
			}
			amr.setAircraftIdList(lst);
			list.add(amr);
		});
		return list;
	}
	
	@GetMapping("/aircraftModel/{id}")
	public List<AircraftModelResponse> getById(@PathVariable Long id) {
		AircraftModel am=aircraftModelRepo.findByAircraftTypeId(id);
		List<AircraftModelResponse> amrl=new ArrayList<>();
		if(am!=null) {
			AircraftModelResponse amr=new AircraftModelResponse();
			amr.setAircraftTypeId(am.getAircraftTypeId());
			amr.setCountOfBusinessSeats(am.getCountOfBusinessSeats());
			amr.setCountOfEconomicSeats(am.getCountOfEconomicSeats());
			amr.setTotalCapacity(am.getTotalCapacity());
			amrl.add(amr);
		}
		return amrl;
	}
	
	@DeleteMapping("/aircraftModel/{id}")
	public void deleteById(@PathVariable Long id) {
		 aircraftModelRepo.deleteById(id);
	}
}
