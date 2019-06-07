package com.spring.annotations;

import org.springframework.stereotype.Component;

@Component
public class RandomService implements FortuneService {

	@Override
	public String getFortune() {
		return "fortune service from RandomService";
	}
	
}
