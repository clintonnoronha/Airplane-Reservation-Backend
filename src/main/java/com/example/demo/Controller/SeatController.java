package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.repo.SeatRepository;

@RestController
public class SeatController {
	
	@Autowired
	private SeatRepository seatRepository;

}
