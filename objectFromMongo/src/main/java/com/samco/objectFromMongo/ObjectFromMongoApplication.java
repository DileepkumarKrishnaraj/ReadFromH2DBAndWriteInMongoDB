package com.samco.objectFromMongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.samco.objectFromMongo.model.Customer;

@SpringBootApplication
public class ObjectFromMongoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ObjectFromMongoApplication.class, args);
		
		MongoClientURI uri = new MongoClientURI(
				"mongodb+srv://Dileepkumar:MongoDB%40DK76@cluster0.hchuo6v.mongodb.net/?retryWrites=true&w=majority&connectTimeoutMS=30000&socketTimeoutMS=30000");

		MongoClient mongoClient = new MongoClient(uri);

		
		DB db = mongoClient.getDB("CUSTOMERDETAILS");
		DBCollection col = db.getCollection("CustomerDetails");

		

		Customer customer = new Customer();
		Gson gson = new Gson();
		String json = gson.toJson(customer);
		BasicDBObject basicDBObject = new BasicDBObject("customer", json);
		col.save(basicDBObject);

		DBCollection dbCollection = db.getCollection("CustomerDetails");

		
	}

}
