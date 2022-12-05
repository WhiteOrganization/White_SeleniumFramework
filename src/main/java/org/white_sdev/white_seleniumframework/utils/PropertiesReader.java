package org.white_sdev.white_seleniumframework.utils;

import lombok.extern.slf4j.Slf4j;
import org.white_sdev.white_seleniumframework.exceptions.White_SeleniumFrameworkException;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Slf4j
public class PropertiesReader {
	
	public static Properties prop = new Properties();
	static {
		try (InputStream input = new FileInputStream("application.properties")) {
			prop.load(input);
		} catch (IOException ex) {
			throw new White_SeleniumFrameworkException("Impossible to read application.properties file to pull properties from it. " +
															   "Please create an application.properties file on the project resources path.");
		}
	}
	
	public static String getProperty(String key){
		return prop.getProperty(key);
	}
}