package org.white_sdev.white_seleniumframework.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
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
			log.error(
					"Impossible to read application.properties file to pull properties from it. Please create an application.properties file on the project resources " +
							"path. White_SeleniumFramework will try to use the default properties but this might produce errors.", ex);
			loadDefaultProperties();
		}
	}
	
	public static void loadDefaultProperties() {
		setProperty("white-selenium-framework.execute.web-driver.chrome", "false");
		setProperty("white-selenium-framework.execute.web-driver.ie", "false");
		setProperty("white-selenium-framework.execute.web-driver.edge", "false");
		setProperty("white-selenium-framework.execute.web-driver.firefox", "false");
		setProperty("white-selenium-framework.execute.web-driver.browserless", "true");
		setProperty("white-selenium-framework.close-on-error", "true");
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
	
	/**
	 *
	 */
	/**
	 * types of Operating Systems
	 */
	public enum OSType {
		Windows, MacOS, Linux, Other
	}
	
	protected static OSType detectedOS;
	
	/**
	 * Detects the operating system from the os.name System property and cache the result.
	 * Helper class to check the operating system this Java VM runs in.
	 *
	 * http://stackoverflow.com/questions/228477/how-do-i-programmatically-determine-operating-system-in-java
	 * compare to http://svn.terracotta.org/svn/tc/dso/tags/2.6.4/code/base/common/src/com/tc/util/runtime/Os.java
	 * http://www.docjar.com/html/api/org/apache/commons/lang/SystemUtils.java.html
	 *
	 * @returns - the operating system detected
	 */
	public static OSType getOperatingSystemType() {
		if (detectedOS == null) {
			String OS = System.getProperty("os.name", "generic").toLowerCase(Locale.ENGLISH);
			if ((OS.indexOf("mac") >= 0) || (OS.indexOf("darwin") >= 0)) {
				detectedOS = OSType.MacOS;
			} else if (OS.indexOf("win") >= 0) {
				detectedOS = OSType.Windows;
			} else if (OS.indexOf("nux") >= 0) {
				detectedOS = OSType.Linux;
			} else {
				detectedOS = OSType.Other;
			}
		}
		return detectedOS;
	}
}
