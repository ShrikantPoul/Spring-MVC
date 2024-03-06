package com.springmvc.controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Date;
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
import com.springmvc.service.Service;

@Controller
public class MyController {

	@Autowired
	private Service ss;

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
			model.addAttribute("list", slist);
			return "details";
		} else {
			model.addAttribute("warning", "Invalid Username Or Password");
			return "warning";
		}
	}

	@RequestMapping(value = "reg", method = RequestMethod.POST)
	public String register(@ModelAttribute Student student, @RequestParam MultipartFile fileUp, Model model)
			throws IOException {
		System.out.println("Register Method Controller");

		byte[] file = fileUp.getBytes();
		student.setIdProof(file);
		
		student.setRegister_date(new Date());
		student.setNew_register_date(LocalDateTime.now());

		System.out.println(student);
		ss.saveStudent(student);
		model.addAttribute("stu", student);
		return "success";
	}

	@RequestMapping(value = "edit")
	public String editData(@RequestParam int sid, Model model) {
		System.out.println("Edit Data Controller");
		Student s = ss.getStudent(sid);
		model.addAttribute("Student", s);
		return "edit";
	}

	@RequestMapping(value = "up")
	public String updateStudent(@ModelAttribute Student s, Model model) {
		System.out.println("Update Student Controller:" + s);
		ss.updateStudent(s);
		model.addAttribute("update", "Student Updated Successfully");
		return "success";
	}

	@RequestMapping("delete")
	public String deleteStudent(@RequestParam int sid, Model model) {
		System.out.println("Delete Student Controller:" + sid);
		ss.deleteStudent(sid);
		model.addAttribute("delete", "Student Deleted Successfully");
		return "success";
	}

}
