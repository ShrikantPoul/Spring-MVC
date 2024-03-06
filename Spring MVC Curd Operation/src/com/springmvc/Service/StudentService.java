package com.springmvc.Service;

import java.util.List;

import com.springmvc.model.Student;

public interface StudentService {

	public void addStudent(Student s);
	
	public List<Student> getAllStudent();
	
	public void deleteStudent(int sid);

}
