package org.com.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class HelloWorldController {

	@GetMapping("/hello")
	@CrossOrigin(origins = "http://localhost:4200")
	public String getString() {
		return "Hello World";
	}
}
