package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.springmvc.dao.Repo;
import com.springmvc.model.Student;

@org.springframework.stereotype.Service
public class ServiceImple implements Service {
	
	@Autowired
	private Repo rr;

	@Override
	public void addStudent(Student s) {
		System.out.println("Student In Service Layer");
		System.out.println(s);
		rr.registerStudent(s);

	}

}
