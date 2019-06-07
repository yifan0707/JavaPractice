package com.springdemo;

public class TrackCoach implements Coach {
	//define a private field for dependency
	private FortuneService fortuneService;
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkOut() {
		// TODO Auto-generated method stub
		return "Tracking exercise";
	}
	
	@Override
	public String getDailyFortune() {
		return fortuneService.getService();
	}
	
}
