package com.pkd.helper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;

public class MakeQuestionPatternHelper {

	private final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);

	// get MongoDb connection
	// public static void main(String args[]) {
	public Map<String, String> saveQpatteren(StringBuilder qPatterenInput) {
		Map<String, String> returnVal = new HashMap<>();
		try {

			MongoClientURI uri = new MongoClientURI(System.getProperty("DBCONNECTSTRING"));
			MongoClient mongoClient = new MongoClient(uri);
			MongoDatabase database = mongoClient.getDatabase(System.getProperty("DATABASENAME"));

			MongoCollection<Document> table = database.getCollection("QuestionPatteren");
			LOGGER.info("Collection Received from DB");
			/*
			 * String jsoon = "{'Name':'Kolkata'}"; JsonElement element=new
			 * JsonPrimitive(qPatterenInput+""); JsonObject jsonObj =
			 * element.getAsJsonObject(); // jsonObj.addProperty("Hey",
			 * "Ohhhh");
			 */
			LOGGER.info("Converted :");
			Document doc = Document.parse(qPatterenInput + "");// (Document)
			table.insertOne(doc);
			
			ObjectId id = (ObjectId) doc.get("_id");
			LOGGER.info("Value Inserted");
			returnVal.put("_id", id+"");
			returnVal.put("ErrCode", "1");
			returnVal.put("ErrMsg", "Success");
			FindIterable<Document> iterDoc = table.find();
			int i = 1;
			LOGGER.info("Count " + table.count());
			// Getting the iterator
			Iterator<Document> it = iterDoc.iterator();

			while (it.hasNext()) {
				System.out.println(it.next());
				i++;
			}

			// List<Document> list = table.find().into(new
			// ArrayList<Document>());
			/*
			 * MongoClientURI uri = new MongoClientURI(
			 * "mongodb://Mohanty:Allthatjazz1!@dedsec09-npcsy.mongodb.net/test?retryWrites=true&w=majority"
			 * ); System.out.println("Hey"); MongoClient mongoClient = new
			 * MongoClient(uri); System.out.println("Hey1"); MongoDatabase
			 * database = mongoClient.getDatabase("bararuchi");
			 * MongoCollection<Document> table =
			 * database.getCollection("bararuchiTest");
			 * System.out.println("Hey2"); Document doc = new Document("Key1",
			 * "SomeValue like 123"); table.insertOne(doc);
			 * System.out.println("Hey3"); List<Document>
			 * list=table.find().into(new ArrayList<Document>());
			 * 
			 * 
			 * DB db=mongoClient.getDB("sample_airbnb"); DBCollection
			 * table=db.getCollection("listingsAndReviews");
			 * 
			 * System.out.println("Success :" + list);
			 */
		} catch (Exception e) {

			returnVal.put("id", "Not Available");
			returnVal.put("ErrCode", "0");
			returnVal.put("ErrMsg", e.getMessage());

			e.printStackTrace();
		}
		return returnVal;
	}
}
