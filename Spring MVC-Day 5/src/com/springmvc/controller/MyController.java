package com.springmvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.Student;
import com.springmvc.service.Service;

@Controller
public class MyController {
	
	
	
	@Autowired
	private Service ss;

	@RequestMapping(value = "log")
	public String login(@RequestParam String user, @RequestParam("pass") String password) {

		System.out.println("Login Method Controller");
		System.out.println("Username:" + user);
		System.out.println("Password:" + password);

		return "success";

	}

	@RequestMapping(value = "reg")
	public String register(@ModelAttribute Student s, Model model) {

		System.out.println("Register Method Controller");
		System.out.println(s);
		model.addAttribute("stu", s);
		ss.addStudent(s);

		return "success";
	}

}
