package org.xtu.common;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.qdcz.spider.utils.SupperMongoCRUD;
import com.qdcz.spider.utils.Tools;

public class testLog {
	public static void main(String[] args) {
		testKafkaLog();
	}
	
	
	public static void moveTaxDate() {
		SupperMongoCRUD supMongo = new SupperMongoCRUD("218.77.58.180",
				"Trade",27017,"tax_related");
		NewMongo mongo = new NewMongo("Taxation", "TaxWeb");
		for (int j = 0; j < 2225; j++) {
			JSONArray array = supMongo.getOnePage(j, 1000);
			for (int i = 0; i < array.length(); i++) {
				try {
					JSONObject object = array.getJSONObject(i);
					String _id = object.getString("_id");
					object.remove("_id");
					mongo.saveOrReplaceOneDocument(_id, object);
				} catch (JSONException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void testKafkaLog() {
		try {
			SQLOperate sqlOperate = new SQLOperate();
//			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd ");  
//			String log = "[2017-05-07 13:31:42] [qdcz-PC/192.168.2.124] [INFO] - org.xtu.common.MyLog:153 - 0";
//			String time = Tools.get_one_match(log, "(\\d{1,4}[-|\\/|年|\\.]\\d{1,2}[-|\\/|月|\\.]\\d{1,2}([日|号])?(\\s)*(\\d{1,2}([点|时])?((:)?\\d{1,2}(分)?((:)?\\d{1,2}(秒)?)?)?)?(\\s)*(PM|AM)?)");
//			Date date = sdf.parse(time);
//			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			Timestamp ts = new Timestamp(System.currentTimeMillis());
			
			sqlOperate.saveLog(ts, "[2017-05-07 13:31:42] [qdcz-PC/192.168.2.124] [INFO] - org.xtu.common.MyLog:153 - 0");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
