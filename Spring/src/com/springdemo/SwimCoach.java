package com.springdemo;

public class SwimCoach implements Coach{
	//define a private field for dependency
	private FortuneService fortuneService;
	
	public SwimCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkOut() {
		return "Practice breathing for 10 min";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getService();
	}
	
	
}
