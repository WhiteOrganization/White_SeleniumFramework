package org.white_sdev.white_seleniumframework.framework;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.seljup.Watch;
import lombok.SneakyThrows;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;
import org.openqa.selenium.WebDriver;
import org.white_sdev.white_seleniumframework.framework.utils.GeneralUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * As part of the selenium-jupiter integration this Base class will save some configurations from the tests implementing it.
 *
 * @author <a href="mailto:obed.vazquez@gmail.com>Obed Vazquez</a>
 */
@lombok.extern.slf4j.Slf4j
public abstract class SeleniumJupiterScenario {
	
	public static WebDriver driver;
	
	
	//region Before&After
	@SneakyThrows
	@BeforeEach
	public void beforeEach(TestInfo testInfo, @Watch(display = true) WebDriver driver) {
		SeleniumJupiterScenario.driver = driver;
		ScenarioUtils.launchEvidencesRecords(testInfo, driver, getSeleniumJupiterRegisteredExtension());
	}
	
	public abstract SeleniumJupiter getSeleniumJupiterRegisteredExtension();
	
	@AfterEach
	public void afterEach(TestInfo testInfo) {
		String logID = "::afterEach([testInfo, driver]): ";
		log.info("{}Start ", logID);
		ScenarioUtils.stopEvidencesRecords(testInfo, getSeleniumJupiterRegisteredExtension(), driver);
	}
	//endregion Before&After
	
	public static class ScenarioUtils {
		static Map<String, WebDriverUtils> utilsMap = new HashMap<>();
		
		static WebDriverUtils getUtils(String displayName, WebDriver driver) {
			String logID = "::getUtils([driver]): ";
			log.trace("{}Start ", logID);
			WebDriverUtils utils = utilsMap.get(displayName);
			if (utils == null) utils = getNewUtils(displayName, driver);
			return utils;
		}
		
		static WebDriverUtils getNewUtils(String displayName, WebDriver driver) {
			String logID = "::getUtils([driver]): ";
			log.trace("{}Start ", logID);
			WebDriverUtils utils = new WebDriverUtils(driver);
			utilsMap.put(displayName, utils);
			return utils;
		}
		
		
		public static void launchEvidencesRecords(TestInfo testInfo, WebDriver driver, SeleniumJupiter seleniumJupiter) {
			String logID = "::startRecordings([testInfo, driver]): ";
			String displayName = testInfo.getDisplayName();
			log.trace("{}Start ", logID);
			try{
				GeneralUtils.startRecording(seleniumJupiter, driver, displayName);
			}catch (IllegalStateException ex){
				log.error("{}There is a problem while trying to start the recording, the execution will continue.", logID, ex);
			}
			createTestLogFile(displayName);
			log.info("{}Test Name: {} {}", getLogBreak(), displayName, getLogBreak());
		}
		
		public static void stopEvidencesRecords(TestInfo testInfo, SeleniumJupiter seleniumJupiter, WebDriver driver) {
			String logID = "::stopEvidencesRecords([testInfo, driver]): ";
			String displayName = testInfo.getDisplayName();
			log.trace("{}Start ", logID);
			takeScreenshot(driver, displayName);
			stopRecording(seleniumJupiter, displayName);
			driver.quit();
			log.info("{}{}", logID, getLogBreak());
			closeTestLogFile();
		}
		
		static void takeScreenshot(WebDriver driver, String displayName) {
			String logID = "::takeScreenshot([driver, displayName]): ";
			log.trace("{}Start ", logID);
			try {
				getUtils(displayName, driver).screenshot.
						setScenarioDisplayName(displayName).
						take();
			} catch (org.white_sdev.white_seleniumframework.exceptions.White_SeleniumFrameworkException ex) {
				log.error(logID + "The application was not able to save screenshots due to execution environment. Are you running as administrator?", ex);
			}
		}
		
		static void stopRecording(SeleniumJupiter seleniumJupiter, String displayName) {
			String logID = "::stopRecording([displayName]): ";
			log.trace("{}Start ", logID);
			try {
				GeneralUtils.saveRecording(seleniumJupiter, displayName).ifPresentOrElse(
						(fileName) -> log.debug("{}Saved recorded session at: {}", logID, fileName),
						() -> log.error(logID + "Impossible to save the recording"));
			} catch (org.white_sdev.white_seleniumframework.exceptions.White_SeleniumFrameworkException ex) {
				log.error(logID + "The application was not able to save a video recording due to execution environment. Are you running as administrator?", ex);
			}
		}
		
		/**
		 * This will use logback Spring configuration in file {@code logback-spring.xml} instantiating the SiftingAppender discriminator
		 * to create a log file with the displayed Name of the test.
		 *
		 * @param displayName This will be used as the name of the log file.
		 *                    Although you can use any name it is recommended to use the Test displayed Name that you can obtain with an instance of {@link TestInfo}
		 */
		public static void createTestLogFile(String displayName) {
			String logID = "::createTestLogFile([displayName]): ";
			log.trace("{}Start ", logID);
			org.slf4j.MDC.put("testId", displayName);
			log.trace("{}Finish", logID);
		}
		
		/**
		 * This will force the closure of the log file used for a specific test.
		 *
		 * @see #createTestLogFile(String)
		 */
		public static void closeTestLogFile() {
			String logID = "::closeTestLogFile([]): ";
			log.trace("{}Start ", logID);
			org.slf4j.MDC.remove("testId");
		}
		
		/**
		 * Override to customize log breaks.
		 * @return LogBreak {@link String}
		 */
		public static String getLogBreak(){
			return "\n\n##################################################################\n";
		}
	}
}