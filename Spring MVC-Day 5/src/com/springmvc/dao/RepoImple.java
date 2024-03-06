package com.springmvc.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Student;

@Repository
public class RepoImple implements Repo {

	@Autowired
	private SessionFactory sf;

	@Override
	public void registerStudent(Student s) {
		System.out.println("Student in dao layer");
		System.out.println(s);
		
		Session session=sf.openSession();
		session.save(s);
		session.beginTransaction().commit();
		System.out.println("Successfull!!!!!");

	}

}
