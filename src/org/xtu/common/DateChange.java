package org.xtu.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateChange {
	 public static String  parseDate(String date) {
		 String resultdate="";
	        try {
	            if (date.matches("\\d+/\\d+/\\d+\\s+\\d+:\\d+:\\d+.\\d+")) {
	            	 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		                Date date1 = format.parse(date);
		                resultdate = format.format(date1);
	            }else
	            if (date.matches("\\d+-\\d+-\\d+\\s+\\d+:\\d+:\\d+")) {
	                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
	                Date date1 = format.parse(date);
	                resultdate = format.format(date1);
	            }  else {
	            	 SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		             Date date1 = format.parse(date);
		             resultdate = format.format(date1);
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return resultdate;
	    }
}
