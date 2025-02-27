package com.example.demo.Model_Flights;

import java.util.*;

import javax.persistence.*;


@Entity
public class Passenger {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)	
	private Long id;
	private String firstName;
	private String lastName;
	private String address;
	
	@ManyToMany(mappedBy="passenger")	
	public Set<Flight> flight=new HashSet<Flight>();

	public Passenger() {
		super();
	}

	public Passenger(String firstName, String lastName, String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Set<Flight> getflights() {
		return flight;
	}

	public void setflights(Set<Flight> flights) {
		this.flight = flights;
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
		return "Flight [id=" + id + ", firstname=" + firstName + ", lastname=" + lastName + ", address=" + address
				+ ", flights=" + flight + "]";
	}
	
	
	
}
