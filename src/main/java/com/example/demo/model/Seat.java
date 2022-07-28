package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="seats")
public class Seat {

		@Id
		private String seat_id;
		
		private String seat_type;

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
		
		public Seat() {
			
		}

		public Seat(String seat_id, String seat_type) {
			super();
			this.seat_id = seat_id;
			this.seat_type = seat_type;
		}
		

}
