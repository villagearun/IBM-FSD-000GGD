package com.example.demo;

import java.util.Random;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

public class WordController {

private final Random random = new Random();
	
	@Value("${words}") String[] words;
	
	@GetMapping("/")
	public Word getWord() {
		return new Word(words[random.nextInt(words.length)]);
	}
}
