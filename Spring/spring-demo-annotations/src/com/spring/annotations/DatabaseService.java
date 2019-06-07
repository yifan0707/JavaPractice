package com.spring.annotations;

import org.springframework.stereotype.Component;

@Component
public class DatabaseService implements FortuneService {
	
	@Override
	public String getFortune() {
		return "FortuneService from DatabaseService";
	}

}
