package com.example.demo.controller;

	import java.util.List;

import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.Model_Flights.Flight;
import com.example.demo.repository_Flights.FlightRepository;

	@Controller
	@RequestMapping("/api")
	public class FlightController {
		
		private FlightRepository flightRepository;
		
		
		public FlightController(FlightRepository flightRepository) {
			super();
			this.flightRepository = flightRepository;
		}


		@RequestMapping("/flights")
		public String getAllBooks(Model theModel)
		{
			List<Flight> list = (List<Flight>)flightRepository.findAll();
			theModel.addAttribute("flights",list);
			return "flights";
		}

	}

