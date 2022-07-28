package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repo.UserRepository;

import java.util.List;

import javax.validation.Valid;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	@GetMapping(value="/users/login")
	public User userLogin(@RequestParam("email") String email_id, @RequestParam("password") String pwd) {
		System.out.println(email_id+" "+pwd);
		User u= this.userRepository.findByEmailAndPswd(email_id, pwd);
		System.out.println(email_id+" "+pwd);
		return u;
	}
	@GetMapping("/users/forgotPassword/{email}")
	public User forgetPassword(@PathVariable("email") String email) {
		User u = this.userRepository.findByEmail(email);
		return u;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User u) {
		u.setRole(0);
		userRepository.save(u);
		
		return new ResponseEntity<>(u, HttpStatus.CREATED);
	}
	@GetMapping("/users")
    public List<User> getAllUsers() {
		
        List<User> userList = userRepository.findAll();
        
        return userList;
    }
	
	
}
