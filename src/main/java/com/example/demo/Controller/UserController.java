package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.BookingDetails;
import com.example.demo.model.User;
import com.example.demo.model.UserResponse;
import com.example.demo.repo.BookingDetailsRepository;
import com.example.demo.repo.UserRepository;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;

	@Autowired
	private BookingDetailsRepository bookDetailsRepository;
	
	@GetMapping(value="/users/login")
	public List<UserResponse> userLogin(@RequestParam("email") String email_id, @RequestParam("password") String pwd) {
		System.out.println(email_id+" "+pwd);
		User u= this.userRepository.findByEmailAndPswd(email_id, pwd);
		System.out.println(email_id+" "+pwd);
		List<UserResponse> al = new ArrayList<>(); 
		if(u!=null) {
			UserResponse ur= new UserResponse(u);
			al.add(ur);
			return al;
		}
		return al;
	}
//	@GetMapping("/users/forgotPassword/{email}")
//	public List<UserResponse> forgetPassword(@PathVariable("email") String email) {
//		User u = this.userRepository.findByEmail(email);
//		List<UserResponse> al = new ArrayList<>(); 
//		if(u!=null) {
//			UserResponse ur= new UserResponse(u);
//			al.add(ur);
//			return al;
//		}
//		return al;
//	}
	
	
	@PutMapping("/users/forgotPassword/{email}")
	public ResponseEntity<User> updateUserPassword(@PathVariable("email") String email_id, 
			@RequestParam("password") String pwd) throws ResourceNotFoundException {
		User u=this.userRepository.findByEmail(email_id);
		if(u!=null) {
			u.setPswd(pwd);
			this.userRepository.save(u);
		}
		else {
			new ResourceNotFoundException("User not found");
		}

		return ResponseEntity.ok(u);
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody UserResponse ur) {
		User user= new User(ur);
		user.setRole(0);
		user.setBookingList(new ArrayList<BookingDetails>());
		this.userRepository.save(user);
		return new ResponseEntity<>(user, HttpStatus.CREATED);
	}
	@GetMapping("/users")
    public List<UserResponse> getAllUsers() {
		
        List<User> userList = userRepository.findAll();
        List<UserResponse> responseList = new ArrayList<>();
        userList.forEach(l -> {
        	UserResponse userResponse = new UserResponse();
        	userResponse.setId(l.getId());
        	userResponse.setFname(l.getFname());
        	userResponse.setLname(l.getLname());
        	userResponse.setDob(l.getDob());
        	userResponse.setEmail(l.getEmail());
        	userResponse.setPhone_number(l.getPhone_number());
        	userResponse.setPswd(l.getPswd());
        	userResponse.setRole(l.getRole());
        	userResponse.setTitle(l.getTitle());
        	responseList.add(userResponse);
        });
        
        return responseList;
    }
	
	
}
