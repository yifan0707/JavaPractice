package com.springdemo;

public class BaseballCoach implements Coach{
	//define a private field for dependency
	private FortuneService fortuneService;
	
	public BaseballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	public String getDailyWorkOut() {
		return "Spend 30 minutes on running practice.";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getService();
	}
}
