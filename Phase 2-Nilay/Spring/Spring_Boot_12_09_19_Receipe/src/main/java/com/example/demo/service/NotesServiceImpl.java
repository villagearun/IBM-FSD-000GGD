package com.example.demo.service;

import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Notes;
import com.example.demo.repository.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService{

	@Autowired
	private NotesRepository notesRepository;

	@Override
	public List<Notes> findAll() {
		
		
		return notesRepository.findAll();
	}
    @Override
	public Notes findById(Long theId) {
		Optional<Notes> result=notesRepository.findById(theId);
		Notes theNotes=null;
		
		if(result.isPresent())
		{
			theNotes=result.get();
		}
		else
			throw new RuntimeException("The Id is Invalid"+theId);
		 
		return theNotes;
	}

	@Override
	public void save(Notes theNotes) {
		notesRepository.save(theNotes);
		
		
	}
	@Override
	public void deleteById(Long theId) {
		notesRepository.deleteById(theId);
		
	}


	
	
}
