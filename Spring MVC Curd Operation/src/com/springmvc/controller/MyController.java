package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.Service.StudentService;
import com.springmvc.model.Student;

@Controller
public class MyController {

	@Autowired
	private StudentService ss;

	@RequestMapping(value = "log")
	public String login(@RequestParam String user, @RequestParam("pass") String password, Model model) {
		System.out.println("Login Method Controller");
		System.out.println("Username:" + user);
		System.out.println("Password:" + password);

		String username = "admin";
		String pass = "admin";

		if (username.equals(user) && pass.equals(password)) {
			System.out.println("Login Successfull!!");
			List<Student> slist = ss.getAllStudent();
			model.addAttribute("list", slist);
			return "details";

		} else {
			return "warning";
		}
	}

	@RequestMapping(value = "reg")
	public String login(@ModelAttribute Student s, Model model) {
		System.out.println("Register Method Controller");
		System.out.println(s);
		model.addAttribute("stu", s);
		ss.addStudent(s);
		return "success";

	}
	
	@RequestMapping(value = "del")
	public String deleteStudent(@RequestParam int sid,Model model) {
		System.out.println("Delete Student Controller:"+sid);
		ss.deleteStudent(sid);
		model.addAttribute("del","Student Details Deleted Successfully");
		return "success";
	}
}
