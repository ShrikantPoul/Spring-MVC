package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.model.Student;
import com.springmvc.service.StudentService;

@Controller
public class MyController {

	@Autowired
	private StudentService ss;

	@RequestMapping(value = "log")
	public String login(@RequestParam String user, @RequestParam String pass, Model model) {
		System.out.println("Login Method Controller");
		System.out.println("Username:" + user);
		System.out.println("Password:" + pass);
		String username = "admin";
		String password = "admin";
		if (username.equals(user) && password.equals(pass)) {
			System.out.println("Login Successfull");
			List<Student> slist = ss.getAllStudent();
			model.addAttribute("slist", slist);
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

	@RequestMapping(value = "delete")
	public String deleteStudent(@RequestParam int sid,Model model) {
		System.out.println("Delete Student Controller:"+sid);
		ss.deleteStudent(sid);
		model.addAttribute("del","Student Deleted Successfully");
		return "success";
	}
	
	@RequestMapping(value="edit")
	public String editData(@RequestParam int sid,Model model) {
		System.out.println("Edit Data Controller:"+sid);
		Student s=ss.getStudent(sid);
		System.out.println("Retrived Student Controller:"+s);
		model.addAttribute("edit",s);
		return "edit";
	}
	
	@RequestMapping(value="up")
	public String updateStudent(@ModelAttribute Student s,Model model) {
		System.out.println("Update Student Controller:"+s);
		ss.updateStudent(s);
		model.addAttribute("update","Student Details Updated Successfully!!");
		return "success";
	}

}
