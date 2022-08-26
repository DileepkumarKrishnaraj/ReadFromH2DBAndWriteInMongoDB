package com.samco.model;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class MongoDBLocal {

	public static void main(String args[]) {
		try {
			MongoClientURI uri = new MongoClientURI("mongodb+srv://Dileepkumar:MongoDB%40DK76@cluster0.hchuo6v.mongodb.net/?retryWrites=true&w=majority");
			MongoClient client = new MongoClient(uri);
			DB db = client.getDB("Student");
			DBCollection dbColl = db.getCollection("Student");
			Student stu = new Student();
			stu.setId(1);
			stu.setDepartment("ECE");
			stu.setName("Karthick");
			stu.setCollegeyear(4);

			Gson gson = new Gson();
			String json = gson.toJson(stu);
			BasicDBObject basicDbObject = new BasicDBObject("student", json);
			dbColl.save(basicDbObject);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
