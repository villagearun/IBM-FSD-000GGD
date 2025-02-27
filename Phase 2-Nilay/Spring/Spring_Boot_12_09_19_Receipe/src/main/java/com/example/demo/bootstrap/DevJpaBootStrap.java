package com.example.demo.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.example.demo.model.Incredient;
import com.example.demo.model.Notes;
import com.example.demo.model.Receipe;
import com.example.demo.repository.IncredientRepository;
import com.example.demo.repository.NotesRepository;

import com.example.demo.repository.ReceipeRepository;

@Controller
public class DevJpaBootStrap implements ApplicationListener<ContextRefreshedEvent> {

	private ReceipeRepository receipeRepository;
	private IncredientRepository incredientRepository;
	private NotesRepository notesRepository;

	public DevJpaBootStrap(ReceipeRepository receipeRepository, IncredientRepository incredientRepository,
			NotesRepository notesRepository) {
		super();
		this.receipeRepository = receipeRepository;
		this.incredientRepository = incredientRepository;
		this.notesRepository = notesRepository;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		init();
	}

	private void init() {
		Receipe receipe=new Receipe("45 mins", "Boil the rise for half an hour and add masala", "40%",
				"20mins", "xxxxx", "Thalappakatti",
				"www.aaa.com");
		Notes notes=new Notes("Boil the rise for half an hour and add masala");
		Incredient incredient=new Incredient(200, "Boil the rise for half an hour and add masala");
		
//		incredient.setReceipe(receipe);
//		receipe.getIng().add(incredient);
//		receipe.getNotes().add(notes);
//		notes.getReceipe().add(receipe);
		receipeRepository.save(receipe);
		incredientRepository.save(incredient);
		notesRepository.save(notes);
		


	}

}