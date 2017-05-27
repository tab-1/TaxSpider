package org.xtu.common;

import org.apache.log4j.Logger;

public class testLogger {
	public static Logger logger = Logger.getLogger(testLogger.class); 
	public static void main(String[] args) {
		for(int i = 0;i <= 10; i++) {
			 logger.info("This is Message [" + i + "] from log4j producer .. ");
		}
	}

}
