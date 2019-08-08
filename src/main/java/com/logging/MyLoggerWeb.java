package com.logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MyLoggerWeb {
	private static final Logger LOG = LogManager.getLogger(MyLoggerWeb.class);
	
	public MyLoggerWeb() {
		LOG.error("");
	}
}
