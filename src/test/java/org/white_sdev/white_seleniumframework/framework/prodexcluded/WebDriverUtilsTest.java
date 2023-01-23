package org.white_sdev.white_seleniumframework.framework.prodexcluded;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.white_sdev.white_seleniumframework.framework.AutomationScenario;
import org.white_sdev.white_seleniumframework.framework.AutomationSuite;
import org.white_sdev.white_seleniumframework.framework.WebDriverUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.white_sdev.white_seleniumframework.utils.PropertiesReader.setProperty;

public class WebDriverUtilsTest {
	
	@BeforeAll
	public static void setUp() {
		setProperty("white-selenium-framework.execute.web-driver.chrome", "false");
		setProperty("white-selenium-framework.execute.web-driver.ie", "false");
		setProperty("white-selenium-framework.execute.web-driver.edge", "false");
		setProperty("white-selenium-framework.execute.web-driver.firefox", "false");
		setProperty("white-selenium-framework.execute.web-driver.browserless", "true");
		setProperty("white-selenium-framework.close-on-error", "true");
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
	public void tripleQuittingTest() {
		AutomationSuite.registerAutomationScenario(new DoubleQuitting());
		AutomationSuite.launchExecutions();
	}
	
	@Test
	@Disabled
	public void simpleTableExtractionTest() {
		AutomationSuite.registerAutomationScenario(new TableExtraction());
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
		public String getDisplayName() {
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
		public String getDisplayName() {
			return getClass().getCanonicalName();
		}
	}
	
	public static class DoubleQuitting implements AutomationScenario {
		
		@Override
		public void run(final WebDriverUtils utils) {
			utils.closeWebBrowserWindow();
			utils.closeWebBrowserWindow();
		}
		
		@Override
		public String getDisplayName() {
			return getClass().getCanonicalName();
		}
	}
	
	@Slf4j
	public static class TableExtraction implements AutomationScenario {
		
		@Override
		public void run(final WebDriverUtils utils) {
			String logID = "::run([utils]): ";
			log.trace("{}Start ", logID);
			utils.openURL("https://www.techlistic.com/p/demo-selenium-practice.html");
			Optional<List<LinkedHashMap<String, String>>> table = utils.getTableDataWithId("customers");
			assertThat(table).isNotEmpty();
			
			log.info("{}{}", logID, table.get());
			List<LinkedHashMap<String, String>> filtered = new ArrayList<>();
			for (LinkedHashMap<String, String> row : table.get())
				if (row.containsKey("Company") && row.get("Company").equals("Google"))
					filtered.add(row);

//			List<LinkedHashMap<String, String>> filtered = table.get()
//					.stream()
//					.filter((LinkedHashMap<String,String> map)-> map.get("Company").equals("Google"))
//						.collect(Collectors.toList());
			assertThat(filtered).isNotEmpty();
//			utils.closeWebBrowserWindow();
			
		}
		
		@Override
		public String getDisplayName() {
			return getClass().getCanonicalName();
		}
	}
}