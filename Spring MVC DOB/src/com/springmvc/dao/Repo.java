package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Student;

public interface Repo {
	
	public void saveStudent(Student s);
	
	public List<Student> getAllStudent();
	
	public Student getStudent(int sid);
	
	public void updateStudent(Student s);
	
	public void deleteStudent(int sid);

}
