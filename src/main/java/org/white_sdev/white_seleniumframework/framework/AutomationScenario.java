package org.white_sdev.white_seleniumframework.framework;

import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.white_sdev.propertiesmanager.model.service.PropertyProvider.*;

import org.white_sdev.white_seleniumframework.exceptions.White_SeleniumFrameworkException;

import static org.white_sdev.white_validations.parameters.ParameterValidator.notNullValidation;

/**
 * This represents every Automation Case from which the user can inherit and will be provided with the framework resources and functionality.
 *
 * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
 */

public interface AutomationScenario {
	/**
	 * Local variable to hold on the System property.
	 */
	PrintStream SYSTEM_OUT = System.out;
	/**
	 * Local variable to hold on the System property.
	 */
	PrintStream SYSTEM_ERR = System.err;
	
	/**
	 * Will execute the scenario with all {@link WebDriver}s provided.
	 * @param webDriverElements {@link WebDriverElements} instance with the configuration of the {@link WebDriver}s loaded in it.
	 */
	default void executeScenario(WebDriverElements webDriverElements) {
		WebDriver driver;
		try {
			driver = initialize(webDriverElements);
		} catch (Exception ex) {throw new White_SeleniumFrameworkException("An Error has occurred while initializing the automation scenario execution", ex);}
		
		try {
			WebDriverUtils utils = new WebDriverUtils(driver);
			run(utils);
			if (getQuitOnFinish()) utils.quit();
		} catch (Exception ex) {
			if (getQuitOnFinish()) driver.quit();
			throw new White_SeleniumFrameworkException("An Error has occurred while executing the automation scenario", ex);
		}
	}
	
	/**
	 * It will initialize the Scenario with the provided properties from the user.
	 * @param webDriverElements	Configurations of the {@link WebDriver}s
	 * @return
	 */
	default WebDriver initialize(WebDriverElements webDriverElements) {
		notNullValidation(webDriverElements);
		disableLogs();
		try {
			WebDriver driver;
			if (this instanceof SilentAutomationScenario) {
				if (ChromeOptions.class.equals(webDriverElements.silentOptionsClazz)) {
					driver =
							webDriverElements.driverClazz.getConstructor(new Class[]{webDriverElements.silentOptionsClazz}).newInstance(webDriverElements.silentOptions);
				} else {
					throw new UnsupportedOperationException("WebExplorer not supported yet for Silent execution.");
				}
			} else {
				try {
					driver = webDriverElements.driverClazz.getDeclaredConstructor().newInstance();
				} catch (java.lang.reflect.InvocationTargetException ex) {
					throw new White_SeleniumFrameworkException("Impossible to Instantiate WebDriver", ex);
				} catch (java.lang.NoSuchMethodError ex) {
					throw new White_SeleniumFrameworkException("Impossible to Instantiate WebDriver, thrown often due to dependency versions compatibility issues. "
																	   +
																	   "Check if one of your dependencies is using guava or other selenium/web-driver dependencies " +
																	   "different version. \n" +
																	   ex.getMessage());
				}
			}
			String wait = getProperty("implicit-wait");
			if (wait != null) driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(wait)));
			if (Boolean.parseBoolean(getProperty("maximize-on-open"))) driver.manage().window().maximize();
			enableLogs();
			return driver;
		} catch (Exception ex) {
			enableLogs();
			throw new White_SeleniumFrameworkException("Error initializing the Driver", ex);
		}
	}
	
	void run(WebDriverUtils utils) throws Exception;
	
	/**
	 * Will obtain the Scenario descriptive name.
	 * This could be a detailed definition of the scenario or just a {@code getClass().getCanonicalName()}.
	 * @return a {@link String} representation the name of the {@link AutomationScenario}
	 */
	String getScenarioFullName();
	
	/**
	 * Will <i>temporarily</i> disable any logs to the {@link System#out}.
	 */
	default void disableLogs() {
		System.setOut(
				new PrintStream(new OutputStream() {
					@Override
					public void close() {}
					
					@Override
					public void flush() {}
					
					@Override
					public void write(byte[] b) {}
					
					@Override
					public void write(byte[] b, int off, int len) {}
					
					@Override
					public void write(int b) {}
					
				}));
		System.setErr(
				new PrintStream(new OutputStream() {
					@Override
					public void close() {}
					
					@Override
					public void flush() {}
					
					@Override
					public void write(byte[] b) {}
					
					@Override
					public void write(byte[] b, int off, int len) {}
					
					@Override
					public void write(int b) {}
					
				}));
	}
	
	/**
	 * Will re-enable logs if they have been disabled by this instance.
	 */
	default void enableLogs() {
		System.setOut(SYSTEM_OUT);
		System.setErr(SYSTEM_ERR);
	}
	
	/**
	 * Retrieves if the framework should automatically close the Web Explorer after each scenario is executed.
	 * @return if the Web Browser was closed successfully
	 */
	default Boolean getQuitOnFinish() {
		try {
			return Boolean.parseBoolean(getProperty("close-on-error"));
		} catch (Exception e) {
			SYSTEM_ERR.println("Exception occurred when retrieving property close-on-error from properties files");
			return true;
		}
	}
}
