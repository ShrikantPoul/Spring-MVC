package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Student;

public interface StudentRepo {
	
	public void registerStudent(Student s);
	
	public List<Student> getAllStudent();
	
	public void deleteStudent(int sid);
	
	public Student getStudent(int sid);
	
	public void updateStudent(Student s);

}
