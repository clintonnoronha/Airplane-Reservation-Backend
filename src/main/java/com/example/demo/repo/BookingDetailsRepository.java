package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.BookingDetails;

public interface BookingDetailsRepository extends JpaRepository<BookingDetails, Long> {

}