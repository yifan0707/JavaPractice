package com.spring.annotations.practice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	
	@Bean
	public FortuneService goodFortuneService() {
		return new GoodFortuneService();
	}
	
	@Bean
	public Coach badmintonCoach() {
		return new BadmintonCoach(goodFortuneService());
	}
}
