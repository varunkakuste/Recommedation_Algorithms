package com.sjsu.edu.recommendations;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;


public class MongoDBConnection {



		private static final String URI = "localhost";
		private static final Integer PORT = 27017;
		private static final String DATABASE_NAME = "career";

		public DBCollection getCollection(String collectionName) throws UnknownHostException, MongoException {
			MongoClient mongoClient = new MongoClient(URI, PORT);
			DB db = mongoClient.getDB(DATABASE_NAME);
			DBCollection dbobj = db.getCollection(collectionName);
			return dbobj;
		}
		
		
		


}
