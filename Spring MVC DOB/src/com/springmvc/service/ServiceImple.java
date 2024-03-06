package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.Repo;
import com.springmvc.model.Student;
@org.springframework.stereotype.Service
public class ServiceImple implements Service{
	
	@Autowired
	private Repo sr;

	@Override
	public void saveStudent(Student s) {
		System.out.println("Save Student Service Layer:"+s);
		sr.saveStudent(s);
		
	}

	@Override
	public List<Student> getAllStudent() {
		System.out.println("Get All Student Service Layer");
		return sr.getAllStudent();
	}

	@Override
	public Student getStudent(int sid) {
		System.out.println("Get Student Service Layer:"+sid);
		return sr.getStudent(sid);
	}

	@Override
	public void updateStudent(Student s) {
		System.out.println("Update Student Service Layer:"+s);
		sr.updateStudent(s);
		
	}

	@Override
	public void deleteStudent(int sid) {
		System.out.println("Delete Student Service Layer:"+sid);
		sr.deleteStudent(sid);
		
	}

}
