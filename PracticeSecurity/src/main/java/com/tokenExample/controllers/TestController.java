package com.tokenExample.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/testToken")
	public String getTest() {
		return "Application accessed";
	}
}
