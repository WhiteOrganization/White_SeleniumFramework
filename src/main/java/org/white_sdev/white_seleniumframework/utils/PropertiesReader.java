package org.white_sdev.white_seleniumframework.utils;

import lombok.extern.slf4j.Slf4j;
import org.white_sdev.white_seleniumframework.exceptions.White_SeleniumFrameworkException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class PropertiesReader {
	public static Properties properties = new Properties();
	
	static {
		try {
			String path = new File(".").getCanonicalPath();
			log.info("{}path: {}", "static block:", path);
			@SuppressWarnings("all")
			InputStream input = new FileInputStream(path + "\\src\\main\\resources\\" + "application.properties");
			properties.load(input);
		} catch (IOException ex) {
			throw new White_SeleniumFrameworkException("Impossible to read application.properties file to pull properties from it. " +
															   "Please create an application.properties file on the project resources path.");
		}
	}
	
	public static String getProperty(String key) {
		String logID = "::getProperty(key): ";
		log.trace("{}Start ", logID);
		String value = properties.getProperty(key);
		log.debug("{}Start - reading property: [{}:{}]", logID, key, value);
		return value;
	}
	
	public static void setProperty(String key, String value) {
		String logID = "::setProperty([key, value]): ";
		log.trace("{}Start ", logID);
		properties.setProperty(key, value);
		log.trace("{}Finish", logID);
	}
}