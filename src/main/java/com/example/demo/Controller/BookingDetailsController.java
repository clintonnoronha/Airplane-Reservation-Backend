package com.example.demo.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.BookingDetails;
import com.example.demo.model.BookingDetailsResponse;
import com.example.demo.model.Payment;
import com.example.demo.repo.BookingDetailsRepository;
import com.example.demo.repo.PaymentRepository;
import com.example.demo.repo.TripRepository;
import com.example.demo.repo.UserRepository;

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
    public List<BookingDetailsResponse> getAllBookingByUserId(@RequestParam(name="id") Long id) {
		List<BookingDetails> ls= bookingDetailsRepository.findAll();
		List<BookingDetailsResponse> list=new ArrayList<>();
		ls.stream().filter(uid -> id == uid.getUser().getId()).forEach(l -> {
			BookingDetailsResponse bdr=new BookingDetailsResponse();
			bdr.setBookingId(l.getBooking_id());
			bdr.setUserId(l.getUser().getId());
			bdr.setPaymentId(l.getPay().getPayment_id());
			bdr.setTrip(l.getTrip().getTrip_id());
			bdr.setBookingDate(l.getBookingDate());
			bdr.setStatus(l.getStatus());
			
			list.add(bdr);
		});
		return list;
    }
	
	@PostMapping("/bookings")
	public BookingDetailsResponse createBooking(@RequestParam(name="uid") Long user_id,
			@RequestParam(name="pid") String payment_id,
			@RequestParam(name="tid") Long trip_id,
			@RequestParam(name="date") String booking_date,
			@RequestParam(name="status") String status,
			@RequestParam(name="amount") Long amount)
		{
		
		BookingDetailsResponse bdr = new BookingDetailsResponse();
		bdr.setUserId(user_id);
		bdr.setPaymentId(payment_id);
		bdr.setTrip(trip_id);
		bdr.setBookingDate(booking_date);
		bdr.setStatus(status);
		
		Payment p=new Payment();
		p.setPayment_id(payment_id);
		p.setAmount(amount);
		p.setStatus(status);
		paymentRepository.save(p);
		
		BookingDetails bd = new BookingDetails();
		bd.setUser(userRepository.findById(user_id).get());
		bd.setPay(paymentRepository.findByPaymentId(payment_id));
		bd.setTrip(tripRepository.findById(trip_id).get());
		bd.setBookingDate(booking_date);
		bd.setStatus(status);
		bookingDetailsRepository.save(bd);
        return bdr;
		}
}