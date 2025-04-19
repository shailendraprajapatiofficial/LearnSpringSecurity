package com.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String sayHello() {
		return "Hello";
	}
	@GetMapping("/contact")
	public String saycontact() {
		return "Contact";
	}
	
	@GetMapping("/hi")
	public String sayHi() {
		return "Hello";
	}

}
