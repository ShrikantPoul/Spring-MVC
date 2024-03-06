package com.springmvc.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Student;

@Repository
public class StudentRepoImple implements StudentRepo {

	@Autowired
	private SessionFactory sf;

	@Override
	public void addStudent(Student s) {
		Session session = sf.openSession();
		System.out.println("Add Student Dao Layer");
		session.save(s);
		session.beginTransaction().commit();
		System.out.println("Student Added Successfully");

	}

	@Override
	public List<Student> getAllStudent() {
		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student");
		List<Student> slist = query.getResultList();

		return slist;
	}

	@Override
	public Student getStudent(int sid) {
		Session session = sf.openSession();
		System.out.println("Get Student Dao Layer");
		Student s = session.get(Student.class, sid);
		return s;
	}

	@Override
	public void updateStudent(Student s) {
		System.out.println("Update Student Dao Layer");
		Session session=sf.openSession();
		session.update(s);
		session.beginTransaction().commit();
		System.out.println("Student details updated!!!!");
		
	}

	@Override
	public void deleteStudent(int sid) {
		System.out.println("Delete Student Dao Layer");
		Session session=sf.openSession();
		Student s=session.get(Student.class, sid);
		session.delete(s);
		session.beginTransaction().commit();
		System.out.println("Student Deleted Successfully");
		
		
	}
	
	

}
