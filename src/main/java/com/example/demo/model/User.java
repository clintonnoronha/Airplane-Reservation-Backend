package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="users")
public class User {
	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1, initialValue=1)
	private Long id;
	@Column(length=15)
	private String fname;
	@Column(length=15)
	private String lname;
	@Column(nullable = false, unique = true,length=50)
	private String email;
	@Column(length=16)
	private String pswd;
	@Column(length=10)
	private String dob;

	private Long phone_number;
	private int role;
	@Column(length=4)
	private String title;
	
	@JsonManagedReference
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private List<BookingDetails> bookingList;

	
	public User(UserResponse userResponse) {
		
		this.fname = userResponse.getFname();
		this.lname = userResponse.getLname();
		this.email = userResponse.getEmail();
		this.pswd = userResponse.getPswd();
		this.dob = userResponse.getDob();
		this.phone_number = userResponse.getPhone_number();
		this.role = userResponse.getRole();
		this.title = userResponse.getTitle();
	}
	public User(String fname, String lname, String email, String pswd, String dob, Long phone_number, int role,
			String title) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.pswd = pswd;
		this.dob = dob;
		this.phone_number = phone_number;
		this.role = role;
		this.title = title;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public Long getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(Long phone_number) {
		this.phone_number = phone_number;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<BookingDetails> getBookingList() {
		return bookingList;
	}

	public void setBookingList(List<BookingDetails> bookingList) {
		this.bookingList = bookingList;
	}
}
