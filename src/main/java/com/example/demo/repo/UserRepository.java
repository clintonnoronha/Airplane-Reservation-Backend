package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	@Query("from User where email= ?1 and pswd =?2")
	public User findByEmailAndPswd(String emailId, String pswd);
	
	@Query("from User where email = ?1")
	public User findByEmail(String emailId);
}
