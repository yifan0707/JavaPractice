package com.spring.annotations;

import org.springframework.beans.factory.annotation.Value;

public class CodingCoach implements Coach {

	FortuneService service;

	@Value("${foo.email}")
	private String email;
	
	@Value("${foo.team}")
	private String team;
	
	public CodingCoach(FortuneService service) {
		this.service = service;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Practice Spring and React.js together!";
	}

	@Override
	public String getDailyFortune() {
		return service.getFortune();
	}

	public String getEmail() {
		return email;
	}

	public String getTeam() {
		return team;
	}
	
	
	
}
