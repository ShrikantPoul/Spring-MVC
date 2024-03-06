package com.springmvc.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.Dao.StudentRepo;
import com.springmvc.model.Student;

@Service
public class StudentServiceImple implements StudentService{
	
	@Autowired
	private StudentRepo sr;

	@Override
	public void addStudent(Student s) {
		System.out.println("Student In Service Layer");
		System.out.println(s);
		sr.registerStudent(s);
	}

	@Override
	public List<Student> getAllStudent() {
		System.out.println("Get All Student Service Layer");
		return sr.getAllStudent();
		
	}

	@Override
	public void deleteStudent(int sid) {
		System.out.println("Delete Method Service Layer");
		sr.deleteStudent(sid);
		
	}

}
