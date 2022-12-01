package org.white_sdev.white_seleniumframework.framework;

//import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;

import static org.white_sdev.propertiesmanager.model.service.PropertyProvider.getProperty;

//import static org.white_sdev.white_validations.parameters.ParameterValidator.notNullValidation;

/**
 * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
 * @since Feb 9, 2021
 */
//@Slf4j
//@AllArgsConstructor
public class WebDriverElements {
	public static final String RUN_CHROME = getProperty("run.tests.chrome");
	public static final String RUN_IE = getProperty("run.tests.ie");
	public static final String RUN_EDGE = getProperty("run.tests.edge");
	public static final String RUN_FIREFOX = getProperty("run.tests.firefox");
	public static final String RUN_OPERA = getProperty("run.tests.opera");
	
	public static WebDriverElements CHROME = new WebDriverElements(
			ChromeDriver.class,
			RUN_CHROME == null || Boolean.parseBoolean(RUN_CHROME),
			ChromeOptions.class);
	
	public static WebDriverElements INTERNET_EXPLORER = new WebDriverElements(
			InternetExplorerDriver.class,
			RUN_IE == null || Boolean.parseBoolean(RUN_IE),
			null);
	
	public static WebDriverElements EDGE = new WebDriverElements(
			EdgeDriver.class,
			RUN_EDGE == null || Boolean.parseBoolean(RUN_EDGE),
			null);
	
	public static WebDriverElements FIRE_FOX = new WebDriverElements(
			FirefoxDriver.class,
			RUN_FIREFOX == null || Boolean.parseBoolean(RUN_FIREFOX),
			null);
	
	public static WebDriverElements OPERA = new WebDriverElements(
			OperaDriver.class,
			RUN_OPERA == null || Boolean.parseBoolean(RUN_OPERA),
			null);
	public static ArrayList<WebDriverElements> allWebDriversElements = new ArrayList<WebDriverElements>() {{
		add(CHROME);
		add(INTERNET_EXPLORER);
		add(EDGE);
		add(FIRE_FOX);
		add(OPERA);
	}};
	
	Class<? extends WebDriver> driverClazz;
	Boolean activated;
	Class<? extends MutableCapabilities> silentOptionsClazz;
	MutableCapabilities silentOptions;
	
	private WebDriverElements(Class<? extends WebDriver> driverClazz,
							  boolean activated,
							  Class<? extends MutableCapabilities> silentOptionsClazz) {
		this.driverClazz = driverClazz;
		this.activated = activated;
		this.silentOptionsClazz = silentOptionsClazz;
		ChromeOptions headless = null;
		if (silentOptionsClazz != null && silentOptionsClazz.isAssignableFrom(ChromeOptions.class)) {
			headless = new ChromeOptions();
			//disabled due to
			//java.lang.NoSuchMethodError: org.openqa.selenium.chrome.ChromeOptions.addArguments([Ljava/lang/String;)Lorg/openqa/selenium/chromium/ChromiumOptions;

//	    headless.addArguments("--headless");
		}
		this.silentOptions = headless;
	}
	
}
