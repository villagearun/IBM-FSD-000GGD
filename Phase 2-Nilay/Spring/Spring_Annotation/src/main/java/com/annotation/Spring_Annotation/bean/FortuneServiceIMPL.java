package com.annotation.Spring_Annotation.bean;


import org.springframework.stereotype.Component;

@Component
public class FortuneServiceIMPL implements FortuneService {

	public String getFortune() {
		// TODO Auto-generated method stub
		return "today is not lucky day";
	}

}
