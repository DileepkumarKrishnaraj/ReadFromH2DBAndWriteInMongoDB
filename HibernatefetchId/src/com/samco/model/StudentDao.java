package com.samco.model;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StudentDao {
	public static void main(String args[]) {
		try {

			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter id: ");
			int id = scanner.nextInt();
			
			Configuration configuration = new Configuration();
			configuration.configure("Config.xml");
			SessionFactory sessionFactory = configuration.buildSessionFactory();
			Session session = sessionFactory.openSession();
			
			List list = session.createQuery("from Student where id=" + id).list();
			Iterator iterator = list.iterator();
			
			while(iterator.hasNext()) {
				Object object = (Object)iterator.next();
				Student student = (Student) object;
				System.out.println(student.getId());
				System.out.println(student.getDepartment());
				System.out.println(student.getName());
				System.out.println(student.getCollegeyear());
				
				session.close();
				sessionFactory.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
			
	}
}
