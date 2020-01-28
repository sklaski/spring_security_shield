package com.wildcodeschool.shield.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ShieldController {

	@GetMapping("/")
	public String everyone() {
		return "<p>Welcome to the Shield</p>" + "<br>" + "<a href=\"/avengers/assemble\">Avengers</a>" + "<br>"
				+ "<a href=\"/secret-bases\">Secret Bases</a>";
	}
	
	@GetMapping("/avengers/assemble")
	public String avenger() {
		return "Avengers..... Assemble" + "<br>"
				+ "<a href=\"/\">Return home</a>" + "<br>" 
				+ "<a href=\"/logout\">Logout</a>";
	}

	@GetMapping("/secret-bases")
	public String base() {
		return "<a href=\"https://www.wildcodeschool.com/fr-FR\">Secret Bases</a>" + "<br>"
				+ "<a href=\"/\">Return home</a>"+ "<br>"
				+ "<a href=\"/logout\">Logout</a>";
	}
	
}