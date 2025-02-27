package com.example.demo.Model_Flights;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String flightName;
    private String passengerName;
    private String address;
	public Reservation() {
		super();
	}
	
//	public Reservation(String flightName, String passengerName, String address) {
//		super();
//		this.flightName = flightName;
//		this.passengerName = passengerName;
//		this.address = address;
//	}

	public String getFlightName() {
		return flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public void setPassengerName(String passengerName) {
		this.passengerName = passengerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	


}