package com.springmvc.Dao;

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
	public void registerStudent(Student s) {
		Session session = sf.openSession();
		System.out.println("Student In Dao Layer");
		System.out.println(s);
		session.save(s);
		session.beginTransaction().commit();
		System.out.println("Successfull!!!");

	}

	@Override
	public List<Student> getAllStudent() {
		Session session = sf.openSession();
		Query<Student> query = session.createQuery("from Student");
		List<Student> slist = query.getResultList();

		return slist;
	}

	@Override
	public void deleteStudent(int sid) {
		Session session = sf.openSession();
		System.out.println("Delete Method Dao Layer");
		Student s = session.get(Student.class, sid);
		session.delete(s);
		session.beginTransaction().commit();
		System.out.println("Student Deleted!!");

	}

}
