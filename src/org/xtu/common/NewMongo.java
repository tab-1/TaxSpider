package org.xtu.common;

import com.qdcz.spider.utils.SupperMongoCRUD;

public class NewMongo extends SupperMongoCRUD{
	private static String host="localhost";
	private static int port=27017;
	public NewMongo(String databaseName, String collectionName) {
		super(SpiderProperties.getProperty("MongoDB.host"),
				databaseName,
				Integer.parseInt(SpiderProperties.getProperty("MongoDB.port")),
				collectionName,
				SpiderProperties.getProperty("MongoDB.user"),
				SpiderProperties.getProperty("MongoDB.password"));
	}
}
