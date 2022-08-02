package com.example.demo.test;

import static org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.Passenger;
import com.example.demo.model.Seat;
import com.example.demo.model.User;
import com.example.demo.repo.PassengerRepository;
import com.example.demo.repo.SeatRepository;
import com.example.demo.repo.UserRepository;


import org.springframework.beans.factory.annotation.Autowired;


@SpringBootTest
class Test {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private SeatRepository seatRepository;
	
	@Autowired
	private PassengerRepository passengerRepository;
	
	@org.junit.jupiter.api.Test
	void testUserByEmail() {
		User user= this.userRepository.findByEmail("admin@gmail.com");
		assertNotNull(user, "Test case Successful");
	}
	
	@org.junit.jupiter.api.Test
	void testUserByEmailAndPassword() {
		User user= this.userRepository.findByEmailAndPswd("admin@gmail.com", "admin123");
		assertNull(user, "Test case Unsuccessful");
	}
	
	@org.junit.jupiter.api.Test
	void testSeatTypeBySeatId() {
		Seat seat= this.seatRepository.findSeatById("A1");
		assertEquals("Business", seat.getSeat_type(), "Test case Successful");
		seat= this.seatRepository.findSeatById("C3");
		assertNotEquals("Economy", seat.getSeat_type(), "Test case Unsuccessful");
	}
	
	@org.junit.jupiter.api.Test
	void testPassengerBookedSeatByTripIdAndSeatId() {
		Passenger passenger = this.passengerRepository.findPassengerByTripIdAndSeatId(1L, "D3");
		assertTrue(passenger.getName().equals("C"), "Test case Successful");
		assertFalse(passenger.getName().equals("C"), "Test case Unsuccessful");
	}
}
