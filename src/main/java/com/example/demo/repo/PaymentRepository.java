package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
	
	@Query("from Payment where payment_id = ?1")
	public Payment findByPaymentId(String id);

}