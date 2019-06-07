package com.spring.annotations;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService {
	
	@Override
	public String getFortune() {
		return "Fortune Service from REST FortuneService";
	}

}
