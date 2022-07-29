package com.example.demo.model;

import javax.persistence.*;


import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="passenger")
public class Passenger {
	
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="trip_id")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Trip trip;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="seat_id")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Seat seat;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="my_seq")
	@SequenceGenerator(name="my_seq",sequenceName="MY_SEQ", allocationSize=1, initialValue=1)
	private Long passenger_id;
	@Column(length=40)
	private String name;
	private int age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	public Long getPassenger_id() {
		return passenger_id;
	}
	public void setPassenger_id(Long passenger_id) {
		this.passenger_id = passenger_id;
	}
	
	
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public Seat getSeat() {
		return seat;
	}
	public void setSeat(Seat seat) {
		this.seat = seat;
	}
	public Passenger(Long passenger_id, String name, int age) {
		super();
		this.passenger_id = passenger_id;
		this.name = name;
		this.age = age;
	}
	
	public Passenger(PassengerResponse pr) {
		this.passenger_id=pr.getPassenger_id();
		this.name=pr.getName();
		this.age=pr.getAge();
	}
	
	public Passenger() {}
	

}
