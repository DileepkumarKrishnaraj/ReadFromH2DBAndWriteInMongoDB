package com.samco.model;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class StudentDao {

	public static void main(String[] args) {
		try {
			MongoClientURI mongoClientURI = new MongoClientURI(
					"mongodb+srv://Dileepkumar:MongoDB%40DK76@cluster0.hchuo6v.mongodb.net/?retryWrites=true&w=majority");
			MongoClient mongoClient = new MongoClient(mongoClientURI);

			DB db = mongoClient.getDB("InsertStudent");
			DBCollection dbColl = db.getCollection("StudentDetails");

			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the id : ");
			int id = sc.nextInt();

			Configuration cfg = new Configuration();
			cfg.configure("Config.xml");
			SessionFactory sessionFactory = cfg.buildSessionFactory();
			Session session = sessionFactory.openSession();

			List list = session.createQuery("from Student where id=" + id).list();
			Iterator iterator = list.iterator();

			while (iterator.hasNext()) {
				Object obj = (Object) iterator.next();
				Student student = (Student) obj;
				System.out.println(student.getId());
				System.out.println(student.getDepartment());
				System.out.println(student.getName());
				System.out.println(student.getCollegeyear());

				Gson gson = new Gson();
				String json = gson.toJson(obj);
				BasicDBObject basicDBObject = new BasicDBObject("StudentDetails", json);
				dbColl.save(basicDBObject);
			}
			session.close();
			sessionFactory.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
