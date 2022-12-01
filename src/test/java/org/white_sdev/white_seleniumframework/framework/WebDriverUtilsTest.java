package org.white_sdev.white_seleniumframework.framework;

import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.white_sdev.propertiesmanager.model.service.PropertiesManager;

public class WebDriverUtilsTest{
	
	@BeforeAll
	public static void setUp(){
		PropertiesManager.loadCustomProperty("run.tests.chrome", "true");
		PropertiesManager.loadCustomProperty("run.tests.ie", "false");
		PropertiesManager.loadCustomProperty("run.tests.edge", "false");
		PropertiesManager.loadCustomProperty("run.tests.firefox", "false");
		PropertiesManager.loadCustomProperty("run.tests.opera", "false");
		PropertiesManager.loadCustomProperty("close-on-error", "true");
	}
	
	@Test
	@SneakyThrows
	public void testRestartWebExplorerTest() {
			AutomationSuite.registerAutomationScenario(new DummyTest());
			AutomationSuite.launchExecutions();
	}
	
	public static class DummyTest implements AutomationScenario {
		
		@Override
		public void run(final WebDriverUtils utils) {
			utils.openURL("https://www.google.com/");
			Class<? extends WebDriver> webDriverClass = utils.driver.getClass();
			assertEquals(webDriverClass.getSimpleName(), ChromeDriver.class.getSimpleName());
//			utils.quit();
			utils.restartWebExplorer();
			utils.openURL("https://duckduckgo.com/");
			assertEquals(utils.driver.getClass(), webDriverClass);
		}
		
		@Override
		public String getScenarioFullName() {
			return getClass().getCanonicalName();
		}
	}
}