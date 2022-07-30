package com.example.demo.model;

public class UserResponse {

	private Long id;
	private String fname;
	private String lname;
	private String email;
	private String pswd;
	private String dob;
	private Long phone_number;
	private int role;
	private String title;
	
	
	public UserResponse()
	{
		
	}
	public UserResponse(User user) {
		this.id= user.getId();
		this.fname= user.getFname();
		this.lname= user.getLname();
		this.dob= user.getDob();
		this.email= user.getEmail();
		this.pswd= user.getPswd();
		this.phone_number= user.getPhone_number();
		this.role= user.getRole();
		this.title= user.getTitle();
		
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
	
	
}
