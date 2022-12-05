package org.white_sdev.white_seleniumframework.framework.prodexcluded;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.white_sdev.white_seleniumframework.framework.AutomationScenario;
import org.white_sdev.white_seleniumframework.framework.AutomationSuite;
import org.white_sdev.white_seleniumframework.framework.WebDriverUtils;
import org.white_sdev.white_seleniumframework.utils.PropertiesReader;

import static org.white_sdev.white_seleniumframework.utils.PropertiesReader.setProperty;

/**
 * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
 */
public class AutomationSuiteTest {
	
	public static Boolean flag = false;
	
	public static class DummyTest implements AutomationScenario {
		
		@Override
		public void run(WebDriverUtils utils) {
			flag = !flag;
		}
		
		@Override
		public String getScenarioFullName() {
			return "Dummy Test";
		}
		
	}
	
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
	public void singleAutomationScenarioRegistrationTest() {
		flag = false;
		AutomationSuite.registerAutomationScenario(new DummyTest());
		AutomationSuite.launchExecutions();
		assert (flag);
	}
	
	/**
	 * Test of registerAutomationScenario method, of class AutomationSuite.
	 */
	@Test
	public void automationScenarioRegistrationTest() {
		try {
			flag = false;
			AutomationSuite.registerAutomationScenario(new DummyTest());
			AutomationSuite.launchExecutions();
			assert (flag);
			AutomationSuite.registerAutomationScenario(new DummyTest(), new DummyTest());
			AutomationSuite.launchExecutions();
			assert (flag);
		} catch (Exception ex) {
			fail("Execution threw an Exception :" + ex);
		}
	}
	
}
