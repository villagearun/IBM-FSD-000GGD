package com.example.demo.controller;


import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.model.Receipe;
import com.example.demo.service.ReceipeService;
import com.example.demo.model.Incredient;
import com.example.demo.service.IncredientService;
import com.example.demo.model.Notes;
import com.example.demo.service.NotesService;


@Controller
@RequestMapping("/receipes")
public class ReceipeController {

	private ReceipeService receipeService;
	private IncredientService incredientService;
	private NotesService notesService;
	
	
	public ReceipeController(ReceipeService theReceipeService,IncredientService theIncredientService,
			NotesService theNotesService) 
	{
		this.receipeService = theReceipeService;
		this.incredientService=theIncredientService;
		this.notesService=theNotesService;
	}
	
	// add mapping for "/list"

	@GetMapping("/list")
	public String listReceipeModel(Model theModel) {
		
		// get Receipes from db
		List<Receipe> theReceipe = receipeService.findAll();
		
		// add to the spring model
		theModel.addAttribute("receipes", theReceipe);
		
		return "list-receipe";
	}	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		// create model attribute to bind form data
         Receipe theReceipe = new Receipe();
		
		theModel.addAttribute("receipe", theReceipe);
		
		return "receipe-add-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("receipeId") Long theId,
									Model theModel) {
		
		// get the employee from the service
		Receipe theReceipe  = receipeService.findById(theId);
		
		// set employee as a model attribute to pre-populate the form
		theModel.addAttribute("receipe", theReceipe);
		
		// send over to our form
		return "receipes/receipe-add-form";			
	}
	
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute("receipe") Receipe theReceipe) {
		
		// save the employee
		receipeService.save(theReceipe);
		
		// use a redirect to prevent duplicate submissions
		return "redirect:/receipes/list";
	}
	
	
	@PostMapping("/delete")
	public String delete(@RequestParam("receipeId") Long theId) {
		
		// delete the employee
		receipeService.deleteById(theId);
		
		// redirect to /employees/list
		return "redirect:/receipes/list";
		
	}
}
 