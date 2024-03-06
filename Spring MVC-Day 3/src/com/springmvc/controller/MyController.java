package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.Student;

@Controller
public class MyController {
	
	@RequestMapping(value="log")
	public String login(@RequestParam String user,@RequestParam String pass) {
		System.out.println("Login Method");
		System.out.println("Username : "+user+" Password : "+pass);
		return "success";
	}
	
	@RequestMapping(value="reg")
	public String register(@ModelAttribute Student s) {
		System.out.println("Register Method");
		System.out.println(s);
		return "success";
	}

}
