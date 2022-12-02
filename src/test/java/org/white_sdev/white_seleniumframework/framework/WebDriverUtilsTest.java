package org.white_sdev.white_seleniumframework.framework;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;
import org.white_sdev.propertiesmanager.model.service.PropertiesManager;

public class WebDriverUtilsTest {
	
	@BeforeAll
	public static void setUp() {
		PropertiesManager.loadCustomProperty("run.tests.chrome", "false");
		PropertiesManager.loadCustomProperty("run.tests.ie", "false");
		PropertiesManager.loadCustomProperty("run.tests.edge", "false");
		PropertiesManager.loadCustomProperty("run.tests.firefox", "false");
		PropertiesManager.loadCustomProperty("run.tests.opera", "false");
		PropertiesManager.loadCustomProperty("run.tests.browserless", "true");
		PropertiesManager.loadCustomProperty("close-on-error", "true");
	}
	
	@Test
	@SneakyThrows
	public void testRestartWebExplorerTest() {
		AutomationSuite.registerAutomationScenario(new DummyTest());
		AutomationSuite.launchExecutions();
	}
	
	@Test
	public void titleExtractionTest() {
		AutomationSuite.registerAutomationScenario(new TitleExtractor());
		AutomationSuite.launchExecutions();
		assertThat(WebDriverUtilsTest.title).contains("Selenium WebDriver");
	}
	
	@Test
	@Disabled
	public void tripleQuittingTest() {
		AutomationSuite.registerAutomationScenario(new DoubleQuitting());
		AutomationSuite.launchExecutions();
	}
	
	private static String title;
	
	@Slf4j
	public static class TitleExtractor implements AutomationScenario {
		
		@Override
		public void run(final WebDriverUtils utils) {
			String sutUrl = "https://bonigarcia.dev/selenium-webdriver-java/";
			utils.openURL(sutUrl);
			WebDriverUtilsTest.title = utils.driver.getTitle();
			log.debug("The title of {} is {}", sutUrl, title);
		}
		
		@Override
		public String getScenarioFullName() {
			return getClass().getCanonicalName();
		}
	}
	
	public static class DummyTest implements AutomationScenario {
		
		@Override
		public void run(final WebDriverUtils utils) {
			utils.openURL("https://www.google.com/");
			Class<? extends WebDriver> webDriverClass = utils.driver.getClass();
			utils.restartWebExplorer();
			utils.openURL("https://duckduckgo.com/");
			assertEquals(utils.driver.getClass(), webDriverClass);
		}
		
		@Override
		public String getScenarioFullName() {
			return getClass().getCanonicalName();
		}
	}
	
	public static class DoubleQuitting implements AutomationScenario {
		
		@Override
		public void run(final WebDriverUtils utils){
			utils.quit();
			utils.quit();
		}
		
		@Override
		public String getScenarioFullName() {
			return getClass().getCanonicalName();
		}
	}
}