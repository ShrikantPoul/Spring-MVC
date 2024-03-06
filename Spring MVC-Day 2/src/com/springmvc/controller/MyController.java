package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {
	
	@RequestMapping(value = "log")
	public String login() {
		
		System.out.println("Login method!!!!");
		return "success";
	}

}