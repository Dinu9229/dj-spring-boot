package com.Springboot.tutorial.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@GetMapping("/")
	public String HelloController() {
		
		return "welcome to Dj API service updated again merge1 2";
	}
}
