package com.spring.annotations.practice;

import org.springframework.stereotype.Component;

@Component
public class BadmintonCoach implements Coach{
	
	FortuneService service;
	
	public BadmintonCoach(FortuneService service) {
		this.service = service;
	}
	
	@Override
	public String getFortune() {
		return service.getFortuneService();
	}

	@Override
	public String getDaliyWorkout() {
		return "two v two practice for 1 hour";
	}

}
