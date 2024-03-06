package com.springmvc.controller;

import java.io.IOException;
import java.util.List;

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

	@RequestMapping(value = "log")
	public String login(@RequestParam String user, @RequestParam String pass, Model model) {
		System.out.println("Login Method Controller");
		System.out.println("Username:" + user);
		System.out.println("Password:" + pass);

		String username = "admin";
		String password = "admin";

		if (username.equals(user) && password.equals(pass)) {
			System.out.println("Login Successfull!!");
			List<Student> slist = ss.getAllStudent();
			model.addAttribute("slist", slist);
			return "details";
		} else {
			return "warning";
		}
	}

	@RequestMapping(value = "reg",method = RequestMethod.POST)
	public String register(@ModelAttribute Student s, Model model,@RequestParam MultipartFile fileUp) throws IOException {

		byte[] file=fileUp.getBytes();
		s.setIdProof(file);
		
		System.out.println("Register Method Controller");
		System.out.println("Student In Controller:" + s);
		ss.addStudent(s);
		model.addAttribute("stu", s);
		
		
		return "success";
	}

	@RequestMapping(value = "edit")
	public String editStudent(@RequestParam int sid,Model model) {
		Student s = ss.getStudent(sid);
		model.addAttribute("student",s);
		return "edit";
	}
	
	@RequestMapping(value = "up")
	public String updateStudent(@ModelAttribute Student s,Model model) {
		System.out.println("Update Student Controller:"+s);
		ss.updateStudent(s);
		model.addAttribute("update","Student Updated Successfully");
		return "success";
	}
	
	@RequestMapping("delete")
	public String deleteStudent(@RequestParam int sid,Model model) {
		System.out.println("Delete Student Controller:"+sid);
		ss.deleteStudent(sid);
		model.addAttribute("delete","Student Deleted Successfully");
		return "success";
	}

}
