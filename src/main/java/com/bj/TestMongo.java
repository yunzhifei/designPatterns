package com.bj;

import com.mongodb.*;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.HashMap;

public class TestMongo {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("127.0.0.1", 27017);
        MongoDatabase test = mongoClient.getDatabase("test");
        MongoCollection<Document> col = test.getCollection("col");

        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("class", 1);

        FindIterable<Document> documents = col.find(new Document(hashMap)).skip(1).limit(1);

        for (Document document : documents) {
            System.out.println("document = " + document);
        }


//
//        DBObject keys = new BasicDBObject("class", 1);
//        DBObject condition = new BasicDBObject();
//        DBObject init = new BasicDBObject("count", 0);
//        init.put("running_average", 0);
//        String reduce = "function(doc,out){out.count++;out.running_average+=doc.score;}";
//        String finlize = "function(out) { out.average = out.running_average / out.count;}";
//        BasicDBList group = (BasicDBList) col.group(keys, condition, init, reduce, finlize);
//        for (Object o : group) {
//            DBObject dbObject = (DBObject) o;
//            Object age = dbObject.get("class");
//            Object count = dbObject.get("count");
//            System.out.println("count = " + count);
//            System.out.println("class = " + age);
//            System.out.println("running_average = " + dbObject.get("average"));
//
//        }

    }
}
