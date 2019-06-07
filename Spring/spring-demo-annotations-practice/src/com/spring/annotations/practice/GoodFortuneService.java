package com.spring.annotations.practice;

import org.springframework.stereotype.Component;

@Component
public class GoodFortuneService implements FortuneService{

	@Override
	public String getFortuneService() {
		return "Wish you good fortune in game";
	}
	
}
