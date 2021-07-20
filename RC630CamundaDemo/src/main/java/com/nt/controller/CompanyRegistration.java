package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CompanyRegistration {
	
	@RequestMapping("/registration")
	public String showHome() {
		System.out.println("CompanyRegistration.showHome()");
		return "test";
	}

	
}
	