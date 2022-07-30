package com.example.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="seats")
public class Seat {
	
		
		@Id
		@Column(length=2)
		private String seat_id;
		@Column(length=8)
		private String seat_type;

		@OneToMany(mappedBy="seat", cascade = CascadeType.ALL)
		private List<Passenger> passenger;
		
		public String getSeat_id() {
			return seat_id;
		}

		public void setSeat_id(String seat_id) {
			this.seat_id = seat_id;
		}

		public String getSeat_type() {
			return seat_type;
		}

		public void setSeat_type(String seat_type) {
			this.seat_type = seat_type;
		} 

		public List<Passenger> getPassenger() {
			return passenger;
		}

		public void setPassenger(List<Passenger> passenger) {
			this.passenger = passenger;
		}

		public Seat() {
			
		}
		
		public Seat(SeatResponse sr) {
			this.seat_id=sr.getSeat_id();
			this.seat_type=sr.getSeat_type();
		}

		public Seat(String seat_id, String seat_type) {
			super();
			this.seat_id = seat_id;
			this.seat_type = seat_type;
		}
		

}
