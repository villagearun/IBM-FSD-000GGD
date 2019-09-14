package com.example.demo.Bootstrap_Flight;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.example.demo.repository_Flights.PassengerRepository;
import com.example.demo.repository_Flights.ReservationRepository;
import com.example.demo.Model_Flights.Flight;
import com.example.demo.Model_Flights.Passenger;
import com.example.demo.Model_Flights.Reservation;
import com.example.demo.repository_Flights.FlightRepository;

@Component
public class DevJpaBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	private PassengerRepository passengerRepository;
	private FlightRepository flightRepository;
	private ReservationRepository reservationRepository;

	public DevJpaBootStrap(PassengerRepository passengerRepository, FlightRepository flightRepository,
			ReservationRepository reservationRepository) {
		super();
		this.passengerRepository = passengerRepository;
		this.flightRepository = flightRepository;
		this.reservationRepository = reservationRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		init();
	}

	private void init() {
		// TODO Auto-generated method stub
		Passenger passenger=new Passenger("Arun","Kumar","Sengal,Karur");
		Flight flight=new Flight("Trichy", "Bangalore");

		passengerRepository.save(passenger);
		flightRepository.save(flight);
	}

}