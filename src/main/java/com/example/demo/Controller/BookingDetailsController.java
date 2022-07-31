package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookingDetails;
import com.example.demo.model.BookingDetailsResponse;
import com.example.demo.model.Payment;
import com.example.demo.repo.BookingDetailsRepository;
import com.example.demo.repo.PaymentRepository;
import com.example.demo.repo.TripRepository;
import com.example.demo.repo.UserRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookingDetailsController {
	
	@Autowired
	private BookingDetailsRepository bookingDetailsRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Autowired
	private TripRepository tripRepository;
	
	@GetMapping("/bookings/{id}")
    public List<BookingDetailsResponse> getAllBookingByUserId(@PathVariable("id") Long id) {
		List<BookingDetails> ls= bookingDetailsRepository.findAll();
		List<BookingDetailsResponse> list=new ArrayList<>();
		ls.stream().filter(uid -> id == uid.getUser().getId()).forEach(l -> {
			BookingDetailsResponse bdr=new BookingDetailsResponse();
			bdr.setBookingId(l.getBooking_id());
			bdr.setUserId(l.getUser().getId());
			bdr.setPaymentId(l.getPay().getPayment_id());
			bdr.setTripId(l.getTrip().getTrip_id());
			bdr.setBookingDate(l.getBookingDate());
			bdr.setStatus(l.getStatus());
			bdr.setAmount(l.getPay().getAmount());
			list.add(bdr);
		});
		return list;
    }
	
	@PostMapping("/bookings")
	public BookingDetailsResponse createBooking(@Valid @RequestBody BookingDetailsResponse bdr){
		
		Payment p=new Payment();
		p.setPayment_id(bdr.getPaymentId());
		p.setAmount(bdr.getAmount());
		p.setStatus(bdr.getStatus());
		paymentRepository.save(p);
		
		BookingDetails bd = new BookingDetails(bdr);
		bd.setUser(userRepository.findById(bdr.getUserId()).get());
		bd.setPay(paymentRepository.findByPaymentId(bdr.getPaymentId()));
		bd.setTrip(tripRepository.findById(bdr.getTripId()).get());
		bookingDetailsRepository.save(bd);
        return bdr;
	}
}