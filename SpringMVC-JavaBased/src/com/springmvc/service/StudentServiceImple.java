package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.dao.StudentRepo;
import com.springmvc.model.Student;

@Service
public class StudentServiceImple implements StudentService {

	@Autowired
	private StudentRepo sr;

	@Override
	public void addStudent(Student s) {
		System.out.println("Add Student Service Layer");
		sr.addStudent(s);

	}

	@Override
	public List<Student> getAllStudent() {
		System.out.println("Get All Student Service Layer");
		return sr.getAllStudent();
	}

	@Override
	public Student getStudent(int sid) {
		System.out.println("Get Student Service Layer");
		return sr.getStudent(sid);
	}

	@Override
	public void updateStudent(Student s) {
		System.out.println("Update Student Service Layer");
		sr.updateStudent(s);
		
	}

	@Override
	public void deleteStudent(int sid) {
		System.out.println("Delete Student Service Layer");
		sr.deleteStudent(sid);
	}

}
