package com.springmvc.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.annotation.MultipartConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.springmvc.model.Student;
import com.springmvc.service.StudentService;

@Controller
public class MyController {

	@Autowired
	private StudentService ss;

	@RequestMapping(value = "/")
	public String onStart() {
		System.out.println("Hello");
		return "index";
	}

	@RequestMapping(value = "log")
	public String login(@RequestParam String user, @RequestParam String pass, Model model) {
		System.out.println("Login Method Controller");
		System.out.println("Username:" + user);
		System.out.println("Password:" + pass);

		String username = "admin";
		String password = "admin";

		if (username.equals(user) && password.equals(pass)) {
			model.addAttribute("login", "login Successfull");
			List<Student> slist = ss.getAllStudent();
			model.addAttribute("slist", slist);
			return "details";
		} else {
			return "warning";
		}

	}

	@RequestMapping(value = "reg", method = RequestMethod.POST)
	public String register(@ModelAttribute Student s, Model model, @RequestParam MultipartFile fileUp)
			throws IOException {
		System.out.println("Register Method Controller");

		byte[] file = fileUp.getBytes();
		s.setIdProof(file);
		s.setRegisterDate(new Date());

		model.addAttribute("stu", s);
		ss.addStudent(s);
		return "success";
	}

	@RequestMapping("edit")
	public String edit(@RequestParam int sid, Model model) {
		System.out.println("Edit Method Controller");
		Student s = ss.getStudent(sid);
		model.addAttribute("stu", s);
		return "edit";
	}

	@RequestMapping(value = "up", method = RequestMethod.POST)
	public String update(@ModelAttribute Student s, @RequestParam MultipartFile fileUp,Model model) throws IOException {
		System.out.println("Update Method Controller");
		
		byte[] file = fileUp.getBytes();
		s.setIdProof(file);
		
		model.addAttribute("update","Student Updated Successfully");

		ss.updateStudent(s);
		return "success";
	}
	
	@RequestMapping(value="delete")
	public String delete(@RequestParam int sid,Model model) {
		System.out.println("Delete Method Controller");
		ss.deleteStudent(sid);
		model.addAttribute("delete","Student Deleted Successfully");
		return "success";
	}

}
