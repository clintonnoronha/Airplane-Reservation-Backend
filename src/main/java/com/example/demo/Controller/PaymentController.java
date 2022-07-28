package com.example.demo.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Payment;
import com.example.demo.repo.PaymentRepository;

@RestController
public class PaymentController {
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@PostMapping("/payments")
	public ResponseEntity<Payment> createDepartment(@Valid @RequestBody Payment pay) {
		
		paymentRepository.save(pay);
		
		return new ResponseEntity<>(pay, HttpStatus.CREATED);
	}
	
	@GetMapping("/payments")
    public List<Payment> getAllDepartments() {
		
        List<Payment> paymentList = paymentRepository.findAll();
        
        return paymentList;
    }
}