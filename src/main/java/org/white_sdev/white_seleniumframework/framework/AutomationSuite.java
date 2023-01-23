package org.white_sdev.white_seleniumframework.framework;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.bonigarcia.wdm.config.DriverManagerType;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.white_sdev.white_seleniumframework.exceptions.White_SeleniumFrameworkException;

import java.util.*;

/**
 * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
 * @since Dec 6, 2020
 */
@Slf4j
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class AutomationSuite {
	
	//TODO OV: Generate documentation
	public static List<AutomationScenario> automationScenarios = new ArrayList<>();
	
	public static void registerAutomationScenario(AutomationScenario testCase) {
		AutomationSuite.registerAutomationScenario((Boolean) null, testCase);
	}
	
	public static void registerAutomationScenario(Set<AutomationScenario> testCases) {
		registerAutomationScenario(null, testCases);
	}
	
	public static void registerAutomationScenario(AutomationScenario... automationScenarios) {
		String logID = "::registerAutomationScenario(automationScenarios): ";
		log.trace("{}Finish: Bridging ", logID);
		AutomationSuite.registerAutomationScenario(null, automationScenarios);
	}
	
	public static void registerAutomationScenario(Boolean startFresh, AutomationScenario... automationScenarios) {
		String logID = "::registerAutomationScenario([startFresh, automationScenarios]): ";
		log.trace("{}Start ", logID);
		Set<AutomationScenario> newTC;
		try {
			newTC = new HashSet<>(Arrays.asList(automationScenarios));
			log.debug("{}Automation Scenarios transformed into a Set", logID);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Impossible to transform automationScenarios into a Set to add to the TestCase queue.");
		}
		log.trace("{}Finish: Bridging", logID);
		registerAutomationScenario(startFresh, newTC);
	}
	
	public static void registerAutomationScenario(Boolean startFresh, Set<AutomationScenario> automationScenarios) {
		String logID = "::registerAutomationScenario(startFresh, automationScenarios): ";
		log.trace("{}Start - Adding scenarios for further execution.", logID);
		if (startFresh == null) startFresh = true;
		try {
			if (AutomationSuite.automationScenarios == null || startFresh) cleanTests();
			if (automationScenarios == null) return;
			AutomationSuite.automationScenarios.addAll(automationScenarios);
			log.trace("{}Finish - Automation Scenarios added to the queue.", logID);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Impossible to add Automation Scenarios to the queue for further execution", ex);
		}
	}
	
	
	public static void cleanTests() {
		automationScenarios = new ArrayList<>();
	}
	
	public void executeSuite() {
		String logID = "::executeSuite([]): ";
		log.trace("{}Start ", logID);
		try {
			runSetUp();
			ArrayList<WebDriverElements> allWebDriversElements;
			allWebDriversElements = WebDriverElements.allWebDriversElements;
			for (WebDriverElements webDriverElements : allWebDriversElements)
				if (webDriverElements.activated) executeScenarios(webDriverElements);
			log.trace("{}Finish - All Automation Scenario where executed", logID);
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Error when executing Automation Suite", e);
		}
	}
	
	public static void launchExecutions() {
		String logID = "::launchExecutions([]): ";
		log.trace("{}Start - Launching AutomationScenarios", logID);
		new AutomationSuite().executeSuite();
		log.trace("{}Finish - All scenarios were executed successfully", logID);
	}
	
	private void runSetUp() {
		String logID = "::runSetUp([]): ";
		log.trace("{}Start - Executing All WebDriver initial configurations for the platform to be ready", logID);
		for (DriverManagerType type : DriverManagerType.class.getEnumConstants())
			WebDriverManager.getInstance(type).setup();
	}
	
	@SneakyThrows
	private void executeScenarios(WebDriverElements webDriverElements) {
		String logID = "::executeScenarios(webDriverElements): ";
		log.trace("{}Start ", logID);
		for (AutomationScenario automationScenario : automationScenarios) {
			log.info("{}Executing [{}] automation scenarios over [{}]", logID, automationScenario.getDisplayName(), webDriverElements.driverClazz.getSimpleName());
			automationScenario.executeScenario(webDriverElements);
			log.info("{}Automation Scenario [{}] Executed over [{}]", logID, automationScenario.getDisplayName(), webDriverElements.driverClazz.getSimpleName());
		}
	}
	
}
