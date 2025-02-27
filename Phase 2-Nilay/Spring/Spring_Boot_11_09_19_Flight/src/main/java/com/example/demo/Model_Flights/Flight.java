package com.example.demo.Model_Flights;
import java.util.*;

import javax.persistence.*;

import lombok.Data;


@Entity
@Data
public class Flight {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO) 
	public Long id;
	private String source;
	public String getSource() {
		return source;
	}


	public void setSource(String source) {
		this.source = source;
	}
	private String destination;
	
	
	@ManyToMany
	@JoinTable(name = "passenger_flight", joinColumns = @JoinColumn(name = "passenger_id"),
    inverseJoinColumns = @JoinColumn(name = "flight_id"))
	public Set<Passenger> passenger=new HashSet<Passenger>();
	
	public Flight() {
		super();
	}


	public Flight(String fromCity, String toCity) {
		super();
		this.source = fromCity;
		this.destination = toCity;
	}

public Flight(String fromCity, String toCity, Set<Passenger> passenger) {
		super();
		this.source = fromCity;
		this.destination = toCity;
		this.passenger = passenger;
	}


//	public Flight(String from, String to, Reservation reservation, Set<Passenger> passengers) {
//		super();
//		this.from = from;
//		this.to = to;
//		this.reservation = reservation;
//		this.passengers = passengers;
//	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String to) {
		this.destination = to;
	}
	public Set<Passenger> getpassengers() {
		return passenger;
	}
	public void setpassengers(Set<Passenger> passengers) {
		this.passenger = passengers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Flight [id=" + id + ", from=" + source + ", to=" + destination + ", passengers="
				+ passenger + "]";
	}
	
	
	
	
}
