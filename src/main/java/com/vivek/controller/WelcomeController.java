package com.vivek.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/myApp")
public class WelcomeController {
	
	@RequestMapping(value="/welcome")
	public String displayGreetMessage() {
		return "Welcome to Spring boot App";
	}
}
