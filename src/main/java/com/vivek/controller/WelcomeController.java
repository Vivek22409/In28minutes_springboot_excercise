package com.vivek.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/myApp")
public class WelcomeController {
	
	@RequestMapping(value="/welcome")
	public String displayGreetMessage() {
		return "Welcome to Spring boot App";
	}

}
