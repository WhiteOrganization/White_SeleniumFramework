package org.white_sdev.white_seleniumframework.framework;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.fail;

import org.white_sdev.propertiesmanager.model.service.PropertiesManager;

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
		PropertiesManager.loadCustomProperty("run.tests.chrome", "true");
		PropertiesManager.loadCustomProperty("run.tests.ie", "false");
		PropertiesManager.loadCustomProperty("run.tests.edge", "false");
		PropertiesManager.loadCustomProperty("run.tests.firefox", "false");
		PropertiesManager.loadCustomProperty("run.tests.opera", "false");
		PropertiesManager.loadCustomProperty("close-on-error", "true");
		
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
