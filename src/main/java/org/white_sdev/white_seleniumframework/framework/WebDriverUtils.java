package org.white_sdev.white_seleniumframework.framework;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.white_sdev.white_seleniumframework.exceptions.White_SeleniumFrameworkException;

import java.io.File;
import java.nio.file.NoSuchFileException;
import java.time.Duration;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import io.github.bonigarcia.seljup.SeleniumJupiter;

import static org.white_sdev.white_seleniumframework.utils.PropertiesReader.getProperty;

/**
 * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
 * @since Dec 6, 2020
 */
@Slf4j
@SuppressWarnings({"unused", "UnusedReturnValue"})
public class WebDriverUtils {
	
	//<editor-fold defaultstate="collapsed" desc="Attributes">
	
	/**
	 * The default {@link WebDriver driver} of the calling class to manage all interactions.
	 *
	 * @since 2019-02-24
	 */
	public WebDriver driver;
	
	public Boolean defaultContentFocused = true;
	
	public static Integer screenShootCounter = 1;
	
	public Actions action = null;
	
	public Integer defaultSecsToWaitForElements = null;

//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="Methods">
	
	/**
	 * Default Constructor
	 *
	 * @param driver {@link WebDriver drier} of the Class is using this Util.
	 * @since Feb 24, 2019
	 */
	public WebDriverUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public Integer getDefaultSecondsToWaitForElements() {
		log.trace("::getDefaultSecondsToWaitForElements() - Start: ");
		try {
			
			if (defaultSecsToWaitForElements == null) {
				try {
					String propertiesSecs = getProperty("white-selenium-framework.execute.default-explicit-wait");
					defaultSecsToWaitForElements = propertiesSecs != null ? Integer.parseInt(propertiesSecs) : null;
				} catch (Exception ex) {
					log.error("::getDefaultSecondsToWaitForElements(): Impossible to obtain the default seconds to wait from the properties files. Defaulting to 0");
				}
			}
			log.trace("::getDefaultSecondsToWaitForElements() - Finish: ");
			return defaultSecsToWaitForElements != null ? defaultSecsToWaitForElements : 0;
			
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Impossible to Obtain the default seconds to wait when looking for elements.", e);
		}
	}
	
	//<editor-fold defaultstate="collapsed" desc="Actions">
	//<editor-fold defaultstate="collapsed" desc="No Wait Bridges|Overloaded">
	//TODO OV: Generate documentation for all methods.
	public void clickId(String id) {
		clickId(id, null, null);
	}
	
	public void clickId(String id, Collection<String> nestedFrameNamesStructure) {
		clickId(id, nestedFrameNamesStructure, null);
	}
	
	public void clickName(String name) {
		clickName(name, null, null);
	}
	
	public void clickName(String name, Collection<String> nestedFrameNamesStructure) {
		clickName(name, nestedFrameNamesStructure, null);
	}

//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="Click">
	
	public void clickId(String id, Integer secsToWait) {
		clickId(id, null, secsToWait);
	}
	
	public void clickId(String id, Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		String logID = "::clickId([id, nestedFrameNamesStructure, secsToWait]): ";
		log.trace("{}Start Clicking", logID);
		if (id == null) return;
		try {
			
			if (nestedFrameNamesStructure != null) focus(nestedFrameNamesStructure, secsToWait);
			click(By.id(id), secsToWait);
			
			log.trace("{}Finish - Clicked", logID);
		} catch (Exception ex) {
			if (!defaultContentFocused && (nestedFrameNamesStructure == null || nestedFrameNamesStructure.isEmpty())) { //is dirty and wasn't me who got it dirty?
				try {
					log.warn("{}Couldn't click the element, switching to the main frame and trying again.", logID);
					driver.switchTo().defaultContent();
					defaultContentFocused = true;
					clickId(id, secsToWait);
					return;
				} catch (Exception ex2) {
					log.error("{}Impossible to to click the element, throwing exception", logID);
				}
			}
			throw new White_SeleniumFrameworkException("Unable to click the Button or Link:" + id, ex);
		}
	}
	
	public void clickName(String name, Integer secsToWait) {
		clickName(name, null, secsToWait);
	}
	
	public void clickName(String name, Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		String logID = "::clickName(name, nestedFrameNamesStructure, secsToWait): ";
		log.trace("{}Start - Clicking", logID);
		if (name == null) return;
		try {
			if (nestedFrameNamesStructure != null) focus(nestedFrameNamesStructure, secsToWait);
			click(By.name(name), secsToWait);
			log.trace("{}Finish - Clicked", logID);
		} catch (Exception ex) {
			if (!defaultContentFocused && (nestedFrameNamesStructure == null || nestedFrameNamesStructure.isEmpty())) { //is dirty and wasn't me who got it dirty?
				try {
					log.warn("{}Couldn't click the element, switching to the main frame and trying again.", logID);
					driver.switchTo().defaultContent();
					defaultContentFocused = true;
					clickName(name, secsToWait);
					return;
				} catch (Exception ex2) {
					log.error("{}Impossible to to click the element, throwing exception", logID);
				}
			}
			throw new White_SeleniumFrameworkException("Unable to click the Button or Link with name:" + name, ex);
		}
	}
	
	
	public void clickClass(String cssClass) {
		clickClass(cssClass, null, null);
	}
	
	public void clickClass(String css, Collection<String> nestedFrameNamesStructure) {
		clickClass(css, nestedFrameNamesStructure, null);
	}
	
	public void clickClass(String cssClass, Integer secsToWait) {
		clickClass(cssClass, null, secsToWait);
	}
	
	public void clickClass(String cssClass, Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		String logID = "::clickClass(cssClass, nestedFrameNamesStructure, secsToWait): ";
		log.trace("{}Start - Clicking", logID);
		if (cssClass == null) return;
		try {
			
			if (nestedFrameNamesStructure != null) focus(nestedFrameNamesStructure, secsToWait);
			click(By.className(cssClass), secsToWait);
			
			log.trace("{}Finish - Clicked", logID);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to click the Button or Link with class name:" + cssClass, ex);
		}
	}
	
	public void clickClass(String cssClass, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
						   Boolean skipRetryWithoutWaiting) {
		log.trace("clickClass(cssClass, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Clicking.");
		try {
			
			WebElement element = getElementBy(By.className(cssClass), relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
			element.click();
			log.trace("::clickClass(cssClass, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Finish: Clicked.");
			
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to click the Button or Link with class name: " + cssClass, ex);
		}
	}
	
	public void clickXpath(String xpath) {
		clickXpath(xpath, null, null);
	}
	
	public void scrollAndClickXpath(String xpath) {
		clickXpath(xpath, null, null, null, null, null);
	}
	
	public void clickXpath(String xpath, Collection<String> nestedFrameNamesStructure) {
		clickXpath(xpath, nestedFrameNamesStructure, null);
	}
	
	/**
	 * Clicks the element once it founds it by waiting for it to show up and obtaining it from the page with the provided xpath.
	 * This is a bridge method to {@link #clickXpath(java.lang.String, java.util.Collection, java.lang.Integer) } it sets up the nestedFrameNamesStructure as null.
	 *
	 * @param xpath      the xpath to locate the element to write to.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @since 2019-03-02
	 */
	public void clickXpath(String xpath, Integer secsToWait) {
		clickXpath(xpath, null, secsToWait);
	}
	
	/**
	 * Clicks the element once it founds it by waiting for it to show up and obtaining it from the page with the provided xpath.
	 * This is a bridge method to {@link #click(org.openqa.selenium.By, java.lang.Integer) } in a way setting up the {@link By#tagName(java.lang.String)} element.
	 *
	 * @param xpath                     the xpath to locate the element to write to.
	 * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                  outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
	 * @param secsToWait                the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                                  default-explicit-waitFor property) if null.
	 * @since 2019-03-02
	 */
	public void clickXpath(String xpath, Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		log.trace("clickXpath(xpath,frameNamesStructure,secsToWait) - Start: Bridging.");
		click(By.xpath(xpath), nestedFrameNamesStructure, null, secsToWait, null, null);
	}
	
	public void clickXpath(String xpath, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
						   Boolean skipRetryWithoutWaiting, Boolean scrollToElement) {
		click(By.xpath(xpath), relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting, scrollToElement);
	}
	
	public void clickLinkText(String linkText) {
		clickLinkText(linkText, null, null, null, null);
	}
	
	public void clickLinkText(String linkText, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
							  Boolean skipRetryWithoutWaiting) {
		click(By.linkText(linkText), relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting, null);
	}
	
	public void clickText(String text) {
		clickText(text, null, null, null, null);
	}
	
	public void clickText(String text, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
						  Boolean skipRetryWithoutWaiting) {
		try {
			WebElement element = getElementByText(text, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
			element.click();
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to click the element", ex);
		}
	}
	
	public void click(By locator) {
		log.trace("click(locator) - Start: Bridging.");
		click(locator, null, null, null, null, null);
	}
	
	/**
	 * clicks the element once it founds it by waiting for it to show up and obtaining it from the page with the provided {@link By locator}.
	 * This method is used by several methods as the point where they all converge and in that sense the rest of the methods work as a bridge for this
	 * (For example {@link #clickId(java.lang.String, java.util.Collection, java.lang.Integer)} method will call this method by doing <code>click(By.id(id),secs)</code>
	 * ).
	 * But they add an extra layer of logic on top of the simple click method.
	 *
	 * @param locator    the {@link By} object to locate the element to click.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @since 2019-03-02
	 */
	public void click(By locator, Integer secsToWait) {
		log.trace("click(locator,secsToWait) - Start: Bridging.");
		click(locator, null, null, secsToWait, null, null);
	}
	
	public void click(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
					  Boolean skipRetryWithoutWaiting, Boolean scrollToElement) {
		log.trace("::click(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting,scrollToElement) - Start: ");
		if (scrollToElement == null) scrollToElement = false;
		try {
			WebElement element = getElementBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
			if (element != null) {
				if (scrollToElement) scrollToElement(element);
				element.click();
				log.trace(
						"::click(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting,scrollToElement) - Finish: " +
								"clicked");
			} else {
				throw new White_SeleniumFrameworkException("Element to click on not fond");
			}
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to click the element", ex);
		}
	}
	
	/**
	 * Scrolls to the given element.It is required for you to obtain the element on the page first.
	 *
	 * @param element {@link WebElement} to perform the operation with.
	 * @return The same {@link WebElement} provided by the caller to scroll to.
	 * @throws IllegalArgumentException - if the provided parameter is null.
	 * @author <a href='mailto:obed.vazquez@gmail.com'>Obed Vazquez</a>
	 * @since 2021-02-01
	 */
	public WebElement scrollToElement(WebElement element) {
		log.trace("::scrollToElement(element) - Start: ");
		Objects.requireNonNull(element);
		try {
			
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
			log.trace("::scrollToElement(element) - Finish: ");
			return element;
			
		} catch (Exception e) {
			throw new RuntimeException("Impossible to complete the operation due to an unknown internal error.", e);
		}
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="Write">
	
	public void writeTag(String keys) {
		writeTag("input", keys, null);
	}
	
	public void writeTag(String tagName, String keys) {
		writeTag(tagName, keys, null);
	}
	
	public void writeXPath(String xpath, String keys) {
		writeXPath(xpath, keys, null);
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided id.
	 * This is a Bridge method of {@link #writeId(java.lang.String, java.lang.String, java.util.Collection, java.lang.Integer)}
	 * that sets up {@code secsToWait} and {@code nestedFrameNamesStructure} as {@code null}.
	 *
	 * @param id   the id to locate the element to write to.
	 * @param keys The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void writeId(String id, String keys) {
		writeId(id, keys, null, null);
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided id.
	 * This is a Bridge method of {@link #writeId(java.lang.String, java.lang.String, java.util.Collection, java.lang.Integer)}
	 * that sets up {@code secsToWait} as {@code null}.
	 *
	 * @param id                        the id to locate the element to write to.
	 * @param keys                      The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                  outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void writeId(String id, String keys, Collection<String> nestedFrameNamesStructure) {
		writeId(id, keys, nestedFrameNamesStructure, null);
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided id.
	 * This is a Bridge method of {@link #writeId(java.lang.String, java.lang.String, java.util.Collection, java.lang.Integer)}
	 * that sets up {@code nestedFrameNamesStructure} as {@code null}.
	 *
	 * @param id         the id to locate the element to write to.
	 * @param keys       The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void writeId(String id, String keys, Integer secsToWait) {
		writeId(id, keys, null, secsToWait);
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided id.
	 * This is a bridge method to {@link #write(org.openqa.selenium.By, java.lang.String, java.lang.Integer) } in a way setting up the
	 * {@link By#tagName(java.lang.String)} element.
	 *
	 * @param id                        the id to locate the element to write to.
	 * @param keys                      The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                  outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
	 * @param secsToWait                the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                                  default-explicit-waitFor property) if null.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void writeId(String id, String keys, Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		String logID = "::writeId(id, keys, nestedFrameNamesStructure, secsToWait): ";
		log.trace("{}Start - writing", logID);
		try {
			if (id == null) return;
			if (keys == null) keys = "";
			
			if (nestedFrameNamesStructure != null) focus(nestedFrameNamesStructure, secsToWait);
			write(By.id(id), keys, secsToWait);
			
			log.trace("{}Finish - Wrote", logID);
		} catch (Exception ex) {
			if (!defaultContentFocused && (nestedFrameNamesStructure == null || nestedFrameNamesStructure.isEmpty())) { //is dirty and wasn't me who got it dirty?
				try {
					log.warn("{}Couldn't write on the element by name, switching to the main frame and trying again.", logID);
					driver.switchTo().defaultContent();
					defaultContentFocused = true;
					writeId(id, keys, secsToWait);
					return;
				} catch (Exception ex2) {
					log.error("{}Impossible to send keys to element, throwing exception", logID);
				}
			}
			throw new White_SeleniumFrameworkException("Unable to write in element (Input?) with Id: " + id, ex);
		}
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided name.
	 * This is a bridge method to {@link #writeName(java.lang.String, java.lang.String, java.util.Collection, java.lang.Integer)}
	 * with {@code nestedFrameNamesStructure} and {@code secsToWait} as {@code null}.
	 *
	 * @param name                      the name to locate the element to write to.
	 * @param keys                      The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                  outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void writeName(String name, String keys, Collection<String> nestedFrameNamesStructure) {
		log.trace("writeName(name,keys,nestedFrameNamesStructure) - Start: Bridging");
		writeName(name, keys, nestedFrameNamesStructure, null);
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided name.
	 * This is a bridge method to {@link #writeName(java.lang.String, java.lang.String, java.util.Collection, java.lang.Integer)}
	 * with {@code nestedFrameNamesStructure} and {@code secsToWait} as {@code null}.
	 *
	 * @param name the name to locate the element to write to.
	 * @param keys The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void writeName(String name, String keys) {
		log.trace("writeName(name,keys) - Start: Bridging");
		writeName(name, keys, null, null);
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided name.
	 * This is a bridge method to {@link #writeName(java.lang.String, java.lang.String, java.util.Collection, java.lang.Integer)} with {@code nestedFrameNamesStructure}
	 * as {@code null}.
	 *
	 * @param name       the name to locate the element to write to.
	 * @param keys       The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void writeName(String name, String keys, Integer secsToWait) {
		log.trace("writeName(name,keys,secsToWait) - Start: Bridging");
		writeName(name, keys, null, secsToWait);
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided name.
	 * This particular method does not use {@link #write(org.openqa.selenium.By, java.lang.String, java.lang.Integer) } like its siblings.
	 *
	 * @param name                      the name to locate the element to write to.
	 * @param keys                      The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                  outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
	 * @param secsToWait                the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                                  default-explicit-waitFor property) if null.
	 * @since 2019-03-02
	 */
	public void writeName(String name, String keys, Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		String logID = "::writeName(name, keys, nestedFrameNamesStructure, secsToWait): ";
		log.trace("{}Start - writing", logID);
		if (name == null) return;
		
		try {
			WebElement input;
			try {
				
				if (nestedFrameNamesStructure != null) focus(nestedFrameNamesStructure, secsToWait);
				input = getElementByName(name, secsToWait);
				
			} catch (Exception ex) {
				input = null;
			}
			
			if (input == null) {
				try {
					log.warn("{}Couldn't find the element by name looking for it wih XPath. Name: {}", logID, name);
					//driver.switchTo().frame("main"); //this should be done by the method getElementBy(locator,secsToWait)
					input = getElementByXPath("//input[@name='" + name + "']", secsToWait);
				} catch (Exception ex) {
					if (!defaultContentFocused && (nestedFrameNamesStructure == null || nestedFrameNamesStructure.isEmpty())) {//is dirty and wasn't me who got it dirty?
						log.warn("{}Couldn't find the element by XPath, switching to the main frame and trying again.", logID);
						driver.switchTo().defaultContent();
						defaultContentFocused = true;
						writeName(name, keys, secsToWait);
						return;
					} else {
						throw new White_SeleniumFrameworkException("Impossible to write text on the element with name: " + name, ex);
					}
				}
			}
			
			input.sendKeys(keys);
			log.trace("{}Finish - keys sent", logID);
			
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to write in element (Input?) with Name: " + name, ex);
		}
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided CSS class.
	 * This is a bridge method to {@link #writeCSS(java.lang.String, java.lang.String, java.lang.Integer) } with {@code secsToWait} as {@code null}.
	 *
	 * @param css  the CSS class to locate the element to write to.
	 * @param keys The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void writeCSS(String css, String keys) {
		log.trace("writeCSS(css,keys) - Start: Bridging");
		writeCSS(css, keys, null);
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided CSS class.
	 * This is a bridge method to {@link #write(org.openqa.selenium.By, java.lang.String, java.lang.Integer) } in a way setting up the
	 * {@link By#tagName(java.lang.String)} element.
	 *
	 * @param css        the CSS class to locate the element to write to.
	 * @param keys       The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void writeCSS(String css, String keys, Integer secsToWait) {
		String logID = "::writeCSS(css, keys, secsToWait): ";
		log.trace("{}Start - writing.", logID);
		if (css == null) return;
		try {
			write(By.cssSelector(css), keys, secsToWait);
			
			log.trace("{}Finish - keys sent.", logID);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to write in element (Input?) with CSS: " + css, ex);
		}
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the default tag <code>input</code>.
	 * This is a Bridge method of {@link #writeTag(java.lang.String, java.lang.String, java.lang.Integer)} that sets up the tagName as "input".
	 *
	 * @param keys       The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void writeTag(String keys, Integer secsToWait) {
		writeTag("input", keys, secsToWait);
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided tag.
	 * This is a bridge method to {@link #write(org.openqa.selenium.By, java.lang.String, java.lang.Integer) } in a way setting up the
	 * {@link By#tagName(java.lang.String)} element.
	 *
	 * @param tagName    the tag to locate the element to write to.
	 * @param keys       The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void writeTag(String tagName, String keys, Integer secsToWait) {
		String logID = "::writeTag(tagName, keys, secsToWait): ";
		log.trace("{}Start - writing", logID);
		if (tagName == null) return;
		try {
			write(By.tagName(tagName), keys, secsToWait);
			
			log.trace("{}Finish - keys sent.", logID);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to write in element (Input?) with Tag: " + tagName, ex);
		}
	}
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided {@code xPath}.
	 * This is a bridge method to {@link #write(org.openqa.selenium.By, java.lang.String, java.lang.Integer) } in a way setting up the
	 * {@link By#tagName(java.lang.String)} element.
	 *
	 * @param xpath      The {@code xPath} to locate the element to write to.
	 * @param keys       The keys or {@link String text} to send to the element (usually an input) on the page.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void writeXPath(String xpath, String keys, Integer secsToWait) {
		String logID = "::writeXPath([xpath, keys, secsToWait]): ";
		log.trace("{}Start writing", logID);
		if (xpath == null) return;
		try {
			write(By.xpath(xpath), keys, secsToWait);
			
			log.trace("{}Finish - keys sent.", logID);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to write in element (Input?) with Xpath: " + xpath, ex);
		}
		
	}
	
	
	/**
	 * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page
	 * with the provided {@link By locator}.
	 * This method is used by several methods as the point where they all converge and in that sense the rest of the methods work as a bridge for this
	 * (For example {@link #writeId(java.lang.String, java.lang.String)} method will call this method by doing <code>write(By.id(id))</code> ). But some of
	 * them add an extra layer of logic on top of the simple writing method. The method {@link #writeName(java.lang.String, java.lang.String) }
	 * for example does not use this method.
	 *
	 * @param locator    the {@link By} object to locate the element to obtain the text from.
	 * @param keys       The key or {@link String text} to send to the element (usually an input) on the page.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public void write(By locator, String keys, Integer secsToWait) {
		String logID = "::write(locator, keys, secsToWait): ";
		log.trace("{}Start - Clicking", logID);
		try {
			if (locator == null) return;
			if (keys == null) keys = "";
			
			WebElement input = getElementBy(locator, secsToWait);
			input.sendKeys(keys);
			
			log.trace("{}Finish - keys sent.", logID);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to write in element (Input?) with locator: " + locator, ex);
		}
		
	}
	
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="getText">
	public String textFromXpath(String xpath) {
		return getTextFromXpath(xpath, null, null, null, null);
	}
	
	public String textFromXpath(String xpath, Collection<String> nestedFrameNamesStructure) {
		return getTextFromXpath(xpath, nestedFrameNamesStructure, null, null, null);
	}
	
	/**
	 * It will obtain the containing (link) text inside the [tag]element with the xpath specified. This is a bridge method that sets up the nestedFrameNamesStructure
	 * as null
	 * while calling the method {@link #textFromXpath(java.lang.String, java.util.Collection)}
	 *
	 * @param xpath      the xpath to locate the element to obtain the text from.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return The text of the found element with the {@link By locator}
	 * @since 2019-03-02
	 */
	public String getTextFromXpath(String xpath, Integer secsToWait) {
		return getTextFromXpath(xpath, null, null, secsToWait, null);
	}
	
	/**
	 * It will obtain the containing (link) text inside the [tag]element with the {@code xPath} specified.
	 *
	 * @param xpath                     The {@code xPath} to locate the element to obtain the text from.
	 * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                  outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
	 * @param secsToWait                the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                                  default-explicit-waitFor property) if null.
	 * @return The text of the found element with the {@link By locator}
	 * @since 2019-03-02
	 */
	public String getTextFromXpath(String xpath, Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		log.trace("::textFromXpath(xpath,frameNamesStructure,secsToWait) - Start: Bridging.");
		return getTextFromXpath(xpath, nestedFrameNamesStructure, null, secsToWait, null);
	}
	
	public String getTextFromXpath(String xpath, Collection<String> nestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
								   Boolean skipRetryWithoutWaiting) {
		try {
			return getTextFrom(By.xpath(xpath), nestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to obtain text from element with xPath: " + xpath, ex);
		}
	}
	
	
	/**
	 * Will obtain the containing text inside the element with the {@link By locator} specified.
	 *
	 * @param locator    the {@link By} object to locate the element to obtain the text from.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return The text of the found element with the {@link By locator}
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public String getTextFrom(By locator, Integer secsToWait) {
		String logID = "::getTextFrom(locator, secsToWait): ";
		log.trace("{}Start - Getting text from element.", logID);
		try {
			if (locator == null) return null;
			
			WebElement label = getElementBy(locator, secsToWait);
			String text = label.getText();
			log.trace("{}Finish - Text Obtained.", logID);
			return text;
			
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to obtain text from element with locator: " + locator, ex);
		}
		
	}
	
	/**
	 * Will obtain the containing text inside the element with the {@link By locator} specified; If the {@code nestedFrameNamesStructure} parameter is provided
	 * this Method will try to focus on the last frame specified in the {@code structure} and then attempt to obtain the element's text. If the first attempt resulted in
	 * {@code null} or threw an exception it will attempt to get the element without the {@code nestedFrameNamesStructure} if the parameter {@code retryInCaseOfError} is
	 * true
	 *
	 * @param locator                   The {@link By} object to locate the element to obtain the text from.
	 * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                  outer frame and ending with the frame where the element is contained. Will not switch of focus if {@code null}.
	 * @param skipRetryWithNoFrames     Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the first
	 *                                  attempt.
	 *                                  Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
	 *                                  {code false} if {@code null}
	 * @param secsToWait                The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                                  default-explicit-waitFor property) if null.
	 * @param skipRetryWithoutWaiting   Should the method try again without the Nested Frames Structure on the second time in case of an error on the first attempt.
	 *                                  {code false} if {@code null}
	 * @return A {@link String} with the text inside the found element with the given {@link By locator} or {@code null} if the element with that locator was not
	 * 		found.
	 * @throws White_SeleniumFrameworkException When a generic error is found.
	 * @since 2019-03-02
	 */
	public String getTextFrom(By locator, Collection<String> nestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
							  Boolean skipRetryWithoutWaiting) {
		log.trace("::getTextFrom(locator, nestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Getting text from element.");
		
		try {
			
			WebElement label = getElementBy(locator, nestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
			return label.getText();
			
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to obtain text from element with locator: " + locator, ex);
		}
	}
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="Table Data">
	
	
	/**
	 * Extracts all the data from a {@code <table>} and it will transform the rows ({@code <td>}s) into {@link Map}s indicating their header and cell value into its
	 * pairs.
	 * For example, this table: <br/>
	 * 			<table>
	 *             <thead>
	 *                 <tr>
	 *                     <th>First Name</th>
	 *                     <th>Email</th>
	 *                 </tr>
	 *             </thead>
	 *             <tbody id="usersBody">
	 *                 <tr>
	 *                     <td>baz</td>
	 *                     <td>baz@zinga.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>bar</td>
	 *                     <td>bar@dummy.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>foo</td>
	 *                     <td>foo@dummy.com</td>
	 *                 </tr>
	 *             </tbody>
	 *         </table> <br/>
	 * will be transformed into {@link List} objects with this format:
	 * {@code [{First Name=baz, Email=baz@zinga.com}, {First Name=bar, Email=bar@dummy.com}, {First Name=foo, Email=foo@dummy.com}]}.
	 * <p>
	 *     This method will use the first table if any is found.
	 * </p>
	 *
	 * @return {@link List} of {@link Map} representing the rows and cells of the table.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 */
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithTag() {
		return getTableDataWithTag("table", null);
	}
	
	private Optional<List<LinkedHashMap<String, String>>> getTableDataWithTag(String tagName) {
		return getTableDataWithTag(tagName, null);
	}
	
	
	/**
	 * Extracts all the data from a {@code <table>} and it will transform the rows ({@code <td>}s) into {@link Map}s indicating their header and cell value into its
	 * pairs.
	 * For example, this table: <br/>
	 * 			<table>
	 *             <thead>
	 *                 <tr>
	 *                     <th>First Name</th>
	 *                     <th>Email</th>
	 *                 </tr>
	 *             </thead>
	 *             <tbody id="usersBody">
	 *                 <tr>
	 *                     <td>baz</td>
	 *                     <td>baz@zinga.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>bar</td>
	 *                     <td>bar@dummy.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>foo</td>
	 *                     <td>foo@dummy.com</td>
	 *                 </tr>
	 *             </tbody>
	 *         </table> <br/>
	 * will be transformed into {@link List} objects with this format:
	 * {@code [{First Name=baz, Email=baz@zinga.com}, {First Name=bar, Email=bar@dummy.com}, {First Name=foo, Email=foo@dummy.com}]}.
	 * <p>
	 *     This method will use the first table if any is found.
	 * </p>
	 *
	 * @param secsToWait the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return {@link List} of {@link Map} representing the rows and cells of the table.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 */
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithTag(Integer secsToWait) {
		return getTableDataWithTag("table", secsToWait);
	}
	
	/**
	 * Extracts all the data from a {@code <table>} and it will transform the rows ({@code <td>}s) into {@link Map}s indicating their header and cell value into its
	 * pairs.
	 * For example, this table: <br/>
	 * 			<table>
	 *             <thead>
	 *                 <tr>
	 *                     <th>First Name</th>
	 *                     <th>Email</th>
	 *                 </tr>
	 *             </thead>
	 *             <tbody id="usersBody">
	 *                 <tr>
	 *                     <td>baz</td>
	 *                     <td>baz@zinga.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>bar</td>
	 *                     <td>bar@dummy.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>foo</td>
	 *                     <td>foo@dummy.com</td>
	 *                 </tr>
	 *             </tbody>
	 *         </table> <br/>
	 * will be transformed into {@link List} objects with this format:
	 * {@code [{First Name=baz, Email=baz@zinga.com}, {First Name=bar, Email=bar@dummy.com}, {First Name=foo, Email=foo@dummy.com}]}.
	 * <p>
	 *     This method will use the first table if any is found.
	 * </p>
	 *
	 * @param tagName    the tag to locate the element to perform the operation with.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return {@link List} of {@link Map} representing the rows and cells of the table.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 */
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithTag(String tagName, Integer secsToWait) {
		String logID = "::getTableDataWithTag([tagName, keys, secsToWait]): ";
		log.trace("{}Start ", logID);
		if (tagName == null) return Optional.empty();
		try {
			return getTableData(By.tagName(tagName), secsToWait);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException(String.format("Unable to obtain the data from table with tag :%s ", tagName), ex);
		}
	}
	
	
	/**
	 * Extracts all the data from a {@code <table>} and it will transform the rows ({@code <td>}s) into {@link Map}s indicating their header and cell value into its
	 * pairs.
	 * For example, this table: <br/>
	 * 			<table>
	 *             <thead>
	 *                 <tr>
	 *                     <th>First Name</th>
	 *                     <th>Email</th>
	 *                 </tr>
	 *             </thead>
	 *             <tbody id="usersBody">
	 *                 <tr>
	 *                     <td>baz</td>
	 *                     <td>baz@zinga.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>bar</td>
	 *                     <td>bar@dummy.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>foo</td>
	 *                     <td>foo@dummy.com</td>
	 *                 </tr>
	 *             </tbody>
	 *         </table> <br/>
	 * will be transformed into {@link List} objects with this format:
	 * {@code [{First Name=baz, Email=baz@zinga.com}, {First Name=bar, Email=bar@dummy.com}, {First Name=foo, Email=foo@dummy.com}]}.
	 *
	 * @param id {@link String} with the id to locate the element to perform the operation with.
	 * @return {@link List} of {@link Map} representing the rows and cells of the table.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 */
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithId(String id) {
		return getTableDataWithId(id, null, null);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithId(String id, Integer secsToWait) {
		return getTableDataWithId(id, null, secsToWait);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithId(String id, Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		String logID = "::getTableDataWithId([id, nestedFrameNamesStructure, secsToWait]): ";
		log.trace("{}Start ", logID);
		if (id == null) return Optional.empty();
		try {
			if (nestedFrameNamesStructure != null) focus(nestedFrameNamesStructure, secsToWait);
			return getTableData(By.id(id), secsToWait);
		} catch (Exception ex) {
			if (!defaultContentFocused && (nestedFrameNamesStructure == null || nestedFrameNamesStructure.isEmpty())) { //is dirty and wasn't me who got it dirty?
				try {
					log.warn("{}Unable to obtain the data from table, switching to the main frame and trying again.", logID);
					driver.switchTo().defaultContent();
					defaultContentFocused = true;
					return getTableDataWithId(id, secsToWait);
				} catch (Exception ex2) {
					log.error("{}Unable to obtain the data from table, throwing exception", logID);
				}
			}
			throw new White_SeleniumFrameworkException(String.format("Unable to obtain the data from table with id :%s ", id), ex);
		}
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithName(String name, Integer secsToWait) {
		return getTableDataWithName(name, null, secsToWait);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithName(String name, Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		String logID = "::clickName(name, nestedFrameNamesStructure, secsToWait): ";
		log.trace("{}Start - Clicking", logID);
		if (name == null) return Optional.empty();
		try {
			if (nestedFrameNamesStructure != null) focus(nestedFrameNamesStructure, secsToWait);
			return getTableData(By.name(name), secsToWait);
		} catch (Exception ex) {
			if (!defaultContentFocused && (nestedFrameNamesStructure == null || nestedFrameNamesStructure.isEmpty())) { //is dirty and wasn't me who got it dirty?
				try {
					log.warn("{}Unable to obtain the data from table, switching to the main frame and trying again.", logID);
					driver.switchTo().defaultContent();
					defaultContentFocused = true;
					return getTableDataWithName(name, secsToWait);
				} catch (Exception ex2) {
					log.error("{}Unable to obtain the data from table, throwing exception", logID);
				}
			}
			throw new White_SeleniumFrameworkException(String.format("Unable to obtain the data from table with name :%s ", name), ex);
		}
	}
	
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithClass(String cssClass) {
		return getTableDataWithClass(cssClass, null, null);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithClass(String css, Collection<String> nestedFrameNamesStructure) {
		return getTableDataWithClass(css, nestedFrameNamesStructure, null);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithClass(String cssClass, Integer secsToWait) {
		return getTableDataWithClass(cssClass, null, secsToWait);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithClass(String cssClass, Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		String logID = "::getTableDataWithClass([cssClass, nestedFrameNamesStructure, secsToWait]): ";
		log.trace("{}Start ", logID);
		if (cssClass == null) return Optional.empty();
		try {
			if (nestedFrameNamesStructure != null) focus(nestedFrameNamesStructure, secsToWait);
			return getTableData(By.className(cssClass), secsToWait);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException(String.format("Unable to obtain the data from table with css class :%s ", cssClass), ex);
		}
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithClass(String cssClass, Collection<String> relativeNestedFrameNamesStructure,
																			   Boolean skipRetryWithNoFrames, Integer secsToWait,
																			   Boolean skipRetryWithoutWaiting) {
		String logID = "::getTableDataWithClass([cssClass, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting]): ";
		log.trace("{}Start ", logID);
		try {
			WebElement table = getElementBy(By.className(cssClass), relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
			return getTableData(table);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException(String.format("Unable to obtain the data from table with css class :%s ", cssClass), ex);
		}
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithXpath(String xpath) {
		return getTableDataWithXpath(xpath, null, null);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> scrollAndGetTableDataWithXpath(String xpath) {
		return getTableDataWithXpath(xpath, null, null, null, null, null);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithXpath(String xpath, Collection<String> nestedFrameNamesStructure) {
		return getTableDataWithXpath(xpath, nestedFrameNamesStructure, null);
	}
	
	/**
	 * Extracts all the data from a {@code <table>} and it will transform the rows ({@code <td>}s) into {@link Map}s indicating their header and cell value into its
	 * pairs.
	 * For example, this table: <br/>
	 * 			<table>
	 *             <thead>
	 *                 <tr>
	 *                     <th>First Name</th>
	 *                     <th>Email</th>
	 *                 </tr>
	 *             </thead>
	 *             <tbody id="usersBody">
	 *                 <tr>
	 *                     <td>baz</td>
	 *                     <td>baz@zinga.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>bar</td>
	 *                     <td>bar@dummy.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>foo</td>
	 *                     <td>foo@dummy.com</td>
	 *                 </tr>
	 *             </tbody>
	 *         </table> <br/>
	 * will be transformed into {@link List} objects with this format:
	 * {@code [{First Name=baz, Email=baz@zinga.com}, {First Name=bar, Email=bar@dummy.com}, {First Name=foo, Email=foo@dummy.com}]}.
	 *
	 * @param xpath      The xpath to locate the element to write to.
	 * @param secsToWait The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return {@link List} of {@link Map} representing the rows and cells of the table.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 */
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithXpath(String xpath, Integer secsToWait) {
		return getTableDataWithXpath(xpath, null, secsToWait);
	}
	
	/**
	 * Extracts all the data from a {@code <table>} and it will transform the rows ({@code <td>}s) into {@link Map}s indicating their header and cell value into its
	 * pairs.
	 * For example, this table: <br/>
	 * 			<table>
	 *             <thead>
	 *                 <tr>
	 *                     <th>First Name</th>
	 *                     <th>Email</th>
	 *                 </tr>
	 *             </thead>
	 *             <tbody id="usersBody">
	 *                 <tr>
	 *                     <td>baz</td>
	 *                     <td>baz@zinga.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>bar</td>
	 *                     <td>bar@dummy.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>foo</td>
	 *                     <td>foo@dummy.com</td>
	 *                 </tr>
	 *             </tbody>
	 *         </table> <br/>
	 * will be transformed into {@link List} objects with this format:
	 * {@code [{First Name=baz, Email=baz@zinga.com}, {First Name=bar, Email=bar@dummy.com}, {First Name=foo, Email=foo@dummy.com}]}.
	 *
	 * @param xpath      the xpath to locate the element to write to.
	 *                   * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                   *                                  outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
	 * @param secsToWait The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return {@link List} of {@link Map} representing the rows and cells of the table.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 */
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithXpath(String xpath, Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		String logID = "::getTableDataWithXpath([xpath, nestedFrameNamesStructure, secsToWait]): ";
		log.trace("{}Start ", logID);
		return getTableData(By.xpath(xpath), nestedFrameNamesStructure, null, secsToWait, null, null);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithXpath(String xpath, Collection<String> relativeNestedFrameNamesStructure,
																			   Boolean skipRetryWithNoFrames, Integer secsToWait,
																			   Boolean skipRetryWithoutWaiting, Boolean scrollToElement) {
		return getTableData(By.xpath(xpath), relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting, scrollToElement);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithLinkText(String linkText) {
		return getTableDataWithLinkText(linkText, null, null, null, null);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithLinkText(String linkText, Collection<String> relativeNestedFrameNamesStructure,
																				  Boolean skipRetryWithNoFrames, Integer secsToWait,
																				  Boolean skipRetryWithoutWaiting) {
		return getTableData(By.linkText(linkText), relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting, null);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithText(String text) {
		return getTableDataWithText(text, null, null, null, null);
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableDataWithText(String text, Collection<String> relativeNestedFrameNamesStructure,
																			  Boolean skipRetryWithNoFrames, Integer secsToWait,
																			  Boolean skipRetryWithoutWaiting) {
		String logID = "::getTableDataWithText([text, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting]): ";
		log.trace("{}Start ", logID);
		try {
			WebElement table = getElementBy(By.xpath("//table[//*//text()[contains(., '" + text + "')]]"),
											relativeNestedFrameNamesStructure,
											skipRetryWithNoFrames,
											secsToWait,
											skipRetryWithoutWaiting);
			return getTableData(table);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to obtain data from table", ex);
		}
	}
	
	public Optional<List<LinkedHashMap<String, String>>> getTableData(By locator) {
		String logID = "::getTableData([locator]): ";
		log.trace("{}Start ", logID);
		return getTableData(locator, null, null, null, null, null);
	}
	
	/**
	 * Extracts all the data from a {@code <table>} and it will transform the rows ({@code <td>}s) into {@link Map}s indicating their header and cell value into its
	 * pairs.
	 * For example, this table: <br/>
	 * 			<table>
	 *             <thead>
	 *                 <tr>
	 *                     <th>First Name</th>
	 *                     <th>Email</th>
	 *                 </tr>
	 *             </thead>
	 *             <tbody id="usersBody">
	 *                 <tr>
	 *                     <td>baz</td>
	 *                     <td>baz@zinga.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>bar</td>
	 *                     <td>bar@dummy.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>foo</td>
	 *                     <td>foo@dummy.com</td>
	 *                 </tr>
	 *             </tbody>
	 *         </table> <br/>
	 * will be transformed into {@link List} objects with this format:
	 * {@code [{First Name=baz, Email=baz@zinga.com}, {First Name=bar, Email=bar@dummy.com}, {First Name=foo, Email=foo@dummy.com}]}.
	 *
	 * @param locator    The {@link By} locator to search for the element to obtain.
	 * @param secsToWait The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return {@link List} of {@link Map} representing the rows and cells of the table.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 */
	public Optional<List<LinkedHashMap<String, String>>> getTableData(By locator, Integer secsToWait) {
		String logID = "::getTableData([locator, secsToWait]): ";
		log.trace("{}Start ", logID);
		return getTableData(locator, null, null, secsToWait, null, null);
	}
	
	/**
	 * Extracts all the data from a {@code <table>} and it will transform the rows ({@code <td>}s) into {@link Map}s indicating their header and cell value into its
	 * pairs.
	 * For example, this table: <br/>
	 * 			<table>
	 *             <thead>
	 *                 <tr>
	 *                     <th>First Name</th>
	 *                     <th>Email</th>
	 *                 </tr>
	 *             </thead>
	 *             <tbody id="usersBody">
	 *                 <tr>
	 *                     <td>baz</td>
	 *                     <td>baz@zinga.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>bar</td>
	 *                     <td>bar@dummy.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>foo</td>
	 *                     <td>foo@dummy.com</td>
	 *                 </tr>
	 *             </tbody>
	 *         </table> <br/>
	 * will be transformed into {@link List} objects with this format:
	 * {@code [{First Name=baz, Email=baz@zinga.com}, {First Name=bar, Email=bar@dummy.com}, {First Name=foo, Email=foo@dummy.com}]}.
	 *
	 * @param locator                           The {@link By} locator to search for the element to obtain.
	 * @param relativeNestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                          outer frame and ending with the frame where the element is contained. the method will not switch the focus if
	 *                                          {@code null}.
	 * @param skipRetryWithNoFrames             Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the
	 *                                          first attempt.
	 *                                          Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
	 *                                          {code false} if {@code null}
	 * @param secsToWait                        The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                                          default-explicit-waitFor property) if null.
	 * @param skipRetryWithoutWaiting           in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
	 * @param scrollToElement                   {@link Boolean} value indicating if the framework should scroll the website to look for the element.
	 * @return {@link List} of {@link Map} representing the rows and cells of the table.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 */
	public Optional<List<LinkedHashMap<String, String>>> getTableData(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames,
																	  Integer secsToWait, Boolean skipRetryWithoutWaiting, Boolean scrollToElement) {
		String logID = "::getTableData([locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting, scrollToElement]): ";
		log.trace("{}Start ", logID);
		
		if (scrollToElement == null) scrollToElement = false;
		try {
			WebElement table = getElementBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
			if (table != null)
				if (scrollToElement) scrollToElement(table);
			log.trace("{} extracting", logID);
			return getTableData(table);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException(String.format("Impossible to extract the data from the table with locator %s", locator), ex);
		}
	}
	
	/**
	 * Extracts all the data from a {@code <table>} and it will transform the rows ({@code <td>}s) into {@link Map}s indicating their header and cell value into its
	 * pairs.
	 * For example, this table: <br/>
	 * 			<table>
	 *             <thead>
	 *                 <tr>
	 *                     <th>First Name</th>
	 *                     <th>Email</th>
	 *                 </tr>
	 *             </thead>
	 *             <tbody id="usersBody">
	 *                 <tr>
	 *                     <td>baz</td>
	 *                     <td>baz@zinga.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>bar</td>
	 *                     <td>bar@dummy.com</td>
	 *                 </tr>
	 *                 <tr>
	 *                     <td>foo</td>
	 *                     <td>foo@dummy.com</td>
	 *                 </tr>
	 *             </tbody>
	 *         </table> <br/>
	 * will be transformed into {@link List} objects with this format:
	 * {@code [{First Name=baz, Email=baz@zinga.com}, {First Name=bar, Email=bar@dummy.com}, {First Name=foo, Email=foo@dummy.com}]}
	 *
	 * @param table {@link WebElement table} to extract the data from.
	 * @return {@link List} of {@link Map} representing the rows and cells of the table.
	 */
	public Optional<List<LinkedHashMap<String, String>>> getTableData(WebElement table) {
		String logID = "::getTable([driver, table]): ";
		log.trace("{}Start - Obtaining table data", logID);
		if (table == null) return Optional.empty();
		try {
			List<String> tableHeaders = table.findElements(By.xpath(".//tr//th"))
					.stream().map(WebElement::getText).collect(Collectors.toList());
			
			List<String> headers;
			if (!tableHeaders.isEmpty()) {
				headers = tableHeaders;
			} else {
				List<WebElement> tableHeaderElements = table.findElements(By.xpath(".//tbody/tr"));
				if (tableHeaderElements != null)
					headers = tableHeaderElements.get(0).findElements(By.tagName("td"))
							.stream().map(WebElement::getText).collect(Collectors.toList());
				else
					return Optional.empty();
			}
			return Optional.of(table.findElements(By.xpath(".//tbody/tr")).stream().map(tableRow -> {
				List<WebElement> tableCells = tableRow.findElements(By.tagName("td"));
				return tableCells.stream().collect(Collectors.toMap(
						(tableCell) -> headers.get(tableCells.indexOf(tableCell)), WebElement::getText,
						(x, y) -> x + ", " + y, LinkedHashMap::new));
			}).collect(Collectors.toList()));
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException(String.format("Impossible to obtain data from Table %s", table), ex);
		}
	}
	
	//</editor-fold>
//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="getElementBySpecific() Methods">
	
	//<editor-fold defaultstate="collapsed" desc="Single">
	
	/**
	 * Obtains an element from the page by its {@code CSS class} name. It will wait the seconds specified for the element to show up, how it waits is specified in the
	 * method
	 * it uses to accomplish this {@link #wait() }.
	 *
	 * @param name the name to locate the element to obtain
	 * @return The found element with the name
	 * @throws White_SeleniumFrameworkException in case the element is not found.
	 * @since 2019-03-02
	 */
	public WebElement getElementByClassName(String name) {
		log.trace("::getElementByClassName(name) - Start: Bridging.");
		return getElementByClassName(name, null);
	}
	
	/**
	 * Obtains an element from the page by its {@code CSS class} name. It will wait the seconds specified for the element to show up, how it waits is specified in the
	 * method
	 * it uses to accomplish this {@link #wait() }.
	 *
	 * @param name       the name to locate the element to obtain
	 * @param secsToWait the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return The found element with the name
	 * @throws White_SeleniumFrameworkException in case the element is not found.
	 * @since 2019-03-02
	 */
	public WebElement getElementByClassName(String name, Integer secsToWait) {
		String logID = "::getElementByClassName(name, secsToWait): ";
		log.trace("{}Start - retrieving element", logID);
		if (name == null) return null;
		try {
			return getElementBy(By.className(name), secsToWait);
		} catch (Exception ex) {
			log.debug("::getElementByName(name,secsToWait): Unable to obtain element by name: {}", name);
			return null;
		}
	}
	
	/**
	 * Obtains an element from the page by its name. It will wait the seconds specified for the element to show up, how it waits is specified in the method
	 * it uses to accomplish this {@link #wait() }. This is a bridge method that will set the seconds to waitFor as null while calling the method
	 * {@link #getElementByName(java.lang.String, java.lang.Integer) }
	 *
	 * @param name the name to locate the element to obtain
	 * @return The found element with the name
	 * @see WebDriverUtils#getElementByName(java.lang.String, java.lang.Integer)
	 * @since 2019-03-02
	 */
	public WebElement getElementByName(String name) {
		return getElementByName(name, null);
	}
	
	/**
	 * Obtains an element from the page by its name. It will wait the seconds specified for the element to show up, how it waits is specified in the method
	 * it uses to accomplish this {@link #wait() }.
	 *
	 * @param name       the name to locate the element to obtain
	 * @param secsToWait the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return The found element with the name
	 * @since 2019-03-02
	 */
	public WebElement getElementByName(String name, Integer secsToWait) {
		String logID = "::getElementByName(name, secsToWait): ";
		log.trace("{}Start - retrieving element", logID);
		if (name == null) return null;
		WebElement element;
		try {
			element = getElementBy(By.name(name), secsToWait);
		} catch (Exception ex) {
			element = null;
		}
		
		if (element == null) {
			throw new White_SeleniumFrameworkException("Unable to obtain element by name: " + name);
		}
		log.trace("{}Finish - returning element.", logID);
		return element;
	}
	
	/**
	 * Obtains an element from the page by its tag.
	 * This is a bridge method that will call the {@link #getElementByTag(java.lang.String, java.lang.Integer)} method with the parameter {@code secondsToWait} as
	 * {@code null}.
	 *
	 * @param tagName the tag to locate the element to obtain
	 * @return The found element with the tag
	 * @since 2019-03-02
	 */
	public WebElement getElementByTag(String tagName) {
		log.trace("::getElementByTag(tagName) - Bridging:");
		return getElementByTag(tagName, null);
		
	}
	
	/**
	 * Obtains an element from the page by its tag. It will wait the seconds specified for the element to show up, how it waits is specified in the method
	 * it uses to accomplish this {@link #wait() }.
	 *
	 * @param tagName    the tag to locate the element to obtain
	 * @param secsToWait the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return The found element with the tag
	 * @since 2019-03-02
	 */
	public WebElement getElementByTag(String tagName, Integer secsToWait) {
		String logID = "::getElementByTag(tagName, secsToWait): ";
		log.trace("{}Start - retrieving element", logID);
		if (tagName == null) return null;
		try {
			
			WebElement webElement = getElementBy(By.tagName(tagName), secsToWait);
			
			log.trace("{}Finish - returning element.", logID);
			return webElement;
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Impossible to obtain the element with the Tag provided", ex);
		}
		
	}
	
	/**
	 * Obtains an element from the page by its {@code CSS}. For example {@code By.cssSelector("input[name='first_name']")}.
	 * This is a bridge method that will call the {@link #getElementByCSS(java.lang.String, java.lang.Integer) } method with the parameter {@code secondsToWait} as
	 * {@code null}.
	 *
	 * @param css the {@code CSS} class name to locate the element to obtain
	 * @return The found element with the {@code CSS} specified.
	 * @since 2019-03-02
	 */
	public WebElement getElementByCSS(String css) {
		log.trace("::getElementByCSS(css,secsToWait) - Start: Bridging");
		return getElementByCSS(css, null);
	}
	
	/**
	 * Obtains an element from the page by its {@code CSS}.  For example {@code By.cssSelector("input[name='first_name']")}.
	 * It will waitFor the seconds specified for the element to show up, how it waits is specified in the method it uses to accomplish this {@link #wait() }.
	 *
	 * @param css        the {@code CSS} class name to locate the element to obtain
	 * @param secsToWait the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return The found element with the {@code CSS} specified.
	 * @since 2019-03-02
	 */
	public WebElement getElementByCSS(String css, Integer secsToWait) {
		String logID = "::getElementByCSS(css, secsToWait): ";
		log.trace("{}Start - retrieving element", logID);
		WebElement webElement;
		try {
			webElement = getElementBy(By.cssSelector(css), secsToWait);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Impossible to obtain the element with the CSS Selector provided", ex);
		}
		log.trace("{}Finish - returning element", logID);
		return webElement;
	}
	
	/**
	 * Obtains an element from the page by its {@code xPath}.
	 * This is a bridge method that will call the {@link #getElementByXPath(java.lang.String, java.lang.Integer)} method with the parameter {@code secondsToWait} as
	 * {@code null}.
	 *
	 * @param xpath The {@code xPath} to locate the element to obtain.
	 * @return The found element with the {@code xPath} provided.
	 * @see WebDriverUtils#getElementByXPath(java.lang.String, java.lang.Integer)
	 * @since 2019-03-02
	 */
	public WebElement getElementByXPath(String xpath) {
		return getElementByXPath(xpath, null, null, null, null);
	}
	
	/**
	 * Obtains an element from the page by its {@code xPath}. It will wait the seconds specified for the element to show up, how it waits is specified in the method
	 * it uses to accomplish this {@link #wait() }.
	 *
	 * @param xpath      The {@code xPath} to locate the element to obtain
	 * @param secsToWait The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return The found element with the {@code xPath} provided.
	 * @since 2019-03-02
	 */
	public WebElement getElementByXPath(String xpath, Integer secsToWait) {
		String logID = "::getElementByXPath(xpath, secsToWait): ";
		log.trace("{}Start - retrieving element", logID);
		WebElement webElement;
		try {
			webElement = getElementBy(By.xpath(xpath), secsToWait);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Impossible to obtain the element with the XPath provided", ex);
		}
		log.trace("{}Finish - returning element", logID);
		return webElement;
	}
	
	public WebElement getElementByXPath(String xpath, Boolean skipRetryWithoutWaiting) {
		log.trace(
				"::getElementByXPath(xpath, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Bridging - " +
						"retrieving " +
						"element with xpath.");
		return getElementBy(By.xpath(xpath), null, null, null, skipRetryWithoutWaiting);
		
	}
	
	public WebElement getElementByXPath(String xpath, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
										Boolean skipRetryWithoutWaiting) {
		log.trace(
				"::getElementByXPath(xpath, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Bridging - " +
						"retrieving element with xpath.");
		return getElementBy(By.xpath(xpath), relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
	}
	
	public WebElement getElementByText(String text) {
		log.trace("getElementByText(text) - Start: Bridging.");
		return getElementByText(text, null, null, null, null);
	}
	
	public WebElement getElementByText(String text, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
									   Boolean skipRetryWithoutWaiting) {
		String logID = "::getElementByText([text, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting]): ";
		log.trace("{}Start ", logID);
		WebElement element;
		try {
			element =
					getElementBy(By.xpath("//*[text() = '" + text + "']"), relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait,
								 skipRetryWithoutWaiting);
			if (element == null) {
				log.trace("{}Unable to obtain element by text by using first strategy, trying with a second one.", logID);
				element = getElementBy(By.xpath("//*[text() = '" + text + "']]"),
									   relativeNestedFrameNamesStructure,
									   skipRetryWithNoFrames,
									   secsToWait,
									   skipRetryWithoutWaiting);
			}
			log.trace("::getElementByText(text, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Finish: ");
			
			return element;
			
		} catch (Exception ex) {
			log.warn("{}Unable to obtain element by text by using first strategy, trying with a second one.", logID);
			try {
				element = getElementBy(By.xpath("//*[text() = '" + text + "']]"),
									   relativeNestedFrameNamesStructure,
									   skipRetryWithNoFrames,
									   secsToWait,
									   skipRetryWithoutWaiting);
				log.trace("::getElementByText(text, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Finish: ");
				return element;
				
			} catch (Exception e) {
				throw new White_SeleniumFrameworkException(String.format("Unable to obtain element with text: [%s] by any methods.", text), ex);
			}
		}
	}
	
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="Multiple">
	
	public List<WebElement> getElementsByClassName(String cssClass) {
		log.trace("getElementsByClassName(cssClass) - Start: Bridging.");
		return getElementsByClassName(cssClass, null, null, null, null);
	}
	
	public List<WebElement> getElementsByClassName(String cssClass, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames,
												   Integer secsToWait, Boolean skipRetryWithoutWaiting) {
		log.trace(
				"getElementsByClassName(cssClass, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Obtaining " +
						"elements.");
		try {
			
			List<WebElement> elements =
					getElementsBy(By.className(cssClass), relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
			log.trace(
					"::getElementsByClassName(cssClass, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Finish: " +
							"Obtained.");
			
			return elements;
			
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to obtain elements with class name: " + cssClass, ex);
		}
	}
	
	public List<WebElement> getElementsByXpath(String xPath) {
		log.trace("getElementsByXpath(xPath) - Start: Bridging.");
		return getElementsByXpath(xPath, null, null, null, null);
	}
	
	public List<WebElement> getElementsByXpath(String xPath, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
											   Boolean skipRetryWithoutWaiting) {
		log.trace("getElementsByXpath(xPath, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: .");
		try {
			
			List<WebElement> elements = getElementsBy(By.xpath(xPath), relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
			log.trace("::getElementsByXpath(xPath, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Finish: Obtained.");
			
			return elements;
			
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to obtain elements with xpath name: " + xPath, ex);
		}
	}
	
	//</editor-fold>
	
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="getElementsBy() Methods">
	//<editor-fold defaultstate="collapsed" desc="Single Element">
	
	/**
	 * Will check for at least one element with the specified {@link By} locator until is present on the page's DOM,
	 * obtain all coincidences with the locator, and return the first element as a {@link WebElement};
	 * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
	 * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want
	 * this to
	 * happen
	 * you can call directly that method instead of this one.
	 * If you need to specify a range of time to wait for your element to show up in the page's DOM, you can call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.lang.Integer)}
	 * <br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameters {@code skipRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} and {@code skipRetryWithoutWaiting} as {@code null};
	 *
	 * @param locator The {@link By} locator to search for the element to obtain.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public WebElement getElementBy(By locator) {
		log.trace("::getElementBy(locator) - Start: Bridging");
		return getElementBy(locator, null, null, null, null);
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, and return the first element as a {@link WebElement};
	 * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
	 * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want
	 * this to
	 * happen
	 * you can call directly that method instead of this one.
	 * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
	 * <br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) }
	 * with the parameters {@code skipRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} and {@code skipRetryWithoutWaiting} as {@code null};
	 *
	 * @param locator    The {@link By} locator to search for the element to obtain.
	 * @param secsToWait The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public WebElement getElementBy(By locator, Integer secsToWait) {
		log.trace("::getElementBy(locator, secsToWait) - Start: Bridging");
		return getElementBy(locator, null, null, secsToWait, null);
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, and return the first element as a {@link WebElement};
	 * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
	 * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want
	 * this to
	 * happen
	 * you can call directly that method instead of this one.
	 * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} parameter absolute instead of relative, you can skip this operation by
	 * calling the method {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} and setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameters {@code skipRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} as {@code null};
	 *
	 * @param locator                 The {@link By} locator to search for the element to obtain.
	 * @param secsToWait              The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                                default-explicit-waitFor property) if null.
	 * @param skipRetryWithoutWaiting In case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public WebElement getElementBy(By locator, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
		log.trace("::getElementBy(locator, secsToWait, skipRetryWithoutWaiting) - Start: Bridging");
		return getElementBy(locator, null, null, secsToWait, skipRetryWithoutWaiting);
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, obtain all coincidences with the locator, and return the elements as a {@link List}; This does not necessarily mean that the
	 * element is visible;
	 * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
	 * and then attempt to obtain the element.
	 * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by
	 * calling the method {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} and setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * Most of the methods on this class will call this method to obtain the elements they want to manipulate, so this method defines the rules that will have to
	 * interact
	 * with them.
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameter {@code skipRetryWithNoFrames} as {@code null};
	 *
	 * @param locator                           The {@link By} locator to search for the element to obtain.
	 * @param relativeNestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                          outer frame and ending with the frame where the element is contained. the method will not switch the focus if
	 *                                          {@code null}.
	 * @param secsToWait                        the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                                          default-explicit-waitFor property) if null.
	 * @param skipRetryWithoutWaiting           in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public WebElement getElementBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
		log.trace("::getElementBy(locator, relativeNestedFrameNamesStructure, secsToWait, skipRetryWithoutWaiting) - Start: Bridging");
		return getElementBy(locator, relativeNestedFrameNamesStructure, null, secsToWait, skipRetryWithoutWaiting);
	}
	
	/**
	 * Will check for at least one element with the specified {@link By} locator is present on the page's DOM,
	 * obtain all coincidences with the locator, and return the first element as a {@link WebElement};
	 * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
	 * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want
	 * this to
	 * happen
	 * you can call directly that method instead of this one.
	 * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
	 * and then attempt to obtain the element.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by
	 * calling the method {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} and setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameters {@code secsToWait} and {@code skipRetryWithoutWaiting} as {@code null};
	 *
	 * @param locator                           The {@link By} locator to search for the element to obtain.
	 * @param relativeNestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                          outer frame and ending with the frame where the element is contained. the method will not switch the focus if
	 *                                          {@code null}.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public WebElement getElementBy(By locator, Collection<String> relativeNestedFrameNamesStructure) {
		log.trace("::getElementBy(locator, relativeNestedFrameNamesStructure) - Start: Bridging");
		return getElementBy(locator, relativeNestedFrameNamesStructure, null, null, null);
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM,
	 * obtain all coincidences with the locator,  and return the first element as a {@link WebElement};
	 * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
	 * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want
	 * this to
	 * happen
	 * you can call directly that method instead of this one.
	 * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
	 * and then attempt to obtain the element.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameters {@code secsToWait} and {@code skipRetryWithoutWaiting} as {@code null};
	 *
	 * @param locator                           The {@link By} locator to search for the element to obtain.
	 * @param relativeNestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                          outer frame and ending with the frame where the element is contained. the method will not switch the focus if
	 *                                          {@code null}.
	 * @param skipRetryWithNoFrames             Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the
	 *                                          first attempt.
	 *                                          Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
	 *                                          {code false} if {@code null}
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public WebElement getElementBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames) {
		log.trace("::getElementBy(locator, relativeNestedFrameNamesStructure, skipRetryWitNoFrames) - Start: Bridging");
		return getElementBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, null, null);
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, obtain all coincidences with the locator, and return the first element as a {@link WebElement};
	 * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
	 * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want
	 * this to
	 * happen
	 * you can call directly that method instead of this one.
	 * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
	 * and then attempt to obtain the element.
	 * The method will waitFor for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameter {@code skipRetryWithoutWaiting} as {@code null};
	 *
	 * @param locator                           The {@link By} locator to search for the element to obtain.
	 * @param relativeNestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                          outer frame and ending with the frame where the element is contained. the method will not switch the focus if
	 *                                          {@code null}.
	 * @param skipRetryWithNoFrames             Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the
	 *                                          first attempt.
	 *                                          Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
	 *                                          {code false} if {@code null}
	 * @param secsToWait                        The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                                          default-explicit-waitFor property) if null.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public WebElement getElementBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait) {
		log.trace("::getElementBy(locator, relativeNestedFrameNamesStructure, skipRetryWitNoFrames, secsToWait) - Start: Bridging");
		return getElementBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, null);
		
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, obtain all coincidences with the locator, and return the first element as a {@link WebElement};
	 * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
	 * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want
	 * this to
	 * happen
	 * you can call directly that method instead of this one.
	 * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
	 * and then attempt to obtain the element.
	 * The method will waitFor for at least one element for the specified {@code secsToWait} but if it finds at least one element it will return it immediately.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * The main difference between the method
	 * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } and this is the call to
	 * the method
	 * {@link WebDriver#findElement(org.openqa.selenium.By) } vs {@link WebDriver#findElements(org.openqa.selenium.By) } and
	 * {@link WebDriverWait#until(java.util.function.Function) } on a single and multiple instances.
	 *
	 * @param locator                           The {@link By} locator to search for the element to obtain.
	 * @param relativeNestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                          outer frame and ending with the frame where the element is contained. the method will not switch the focus if
	 *                                          {@code null}.
	 * @param skipRetryWithNoFrames             Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the
	 *                                          first attempt.
	 *                                          Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
	 *                                          {code false} if {@code null}
	 * @param secsToWait                        The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                                          default-explicit-waitFor property) if null.
	 * @param skipRetryWithoutWaiting           in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public WebElement getElementBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
								   Boolean skipRetryWithoutWaiting) {
		log.trace("::getElementBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Preparing wait.");
		WebElement element = null;
		try {
			List<WebElement> elements = getElementsBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
			if (elements != null) {
				if (elements.size() > 1)
					log.warn("::getElementBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): "
									 + "There were more elements with the same locator, make sure you are getting the one you want.");
				if (elements.size() > 0) element = elements.get(0);
			}
			return element;
		} catch (Exception ex) {
			try {
				
				element = getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
				return element;
			} catch (Exception ex2) {
				throw new White_SeleniumFrameworkException("Error while waiting for the element to show up with locator:" + locator, ex);
			}
		}
	}
	
	/**
	 * Will waitFor as an expectation for checking that the element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, obtain it, and return it as a {@link WebElement};
	 * This does not necessarily mean that the element is visible;
	 * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
	 * and then attempt to obtain the element.
	 * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element it will return it immediately.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.
	 * <p>
	 * {@link WebDriver#findElement(org.openqa.selenium.By) } vs {@link WebDriver#findElements(org.openqa.selenium.By) } and
	 * {@link WebDriverWait#until(java.util.function.Function) } on a single and multiple instances.
	 *
	 * @param locator                           The {@link By} locator to search for the element to obtain.
	 * @param relativeNestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                          outer frame and ending with the frame where the element is contained. the method will not switch the focus if
	 *                                          {@code null}.
	 * @param skipRetryWithNoFrames             Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the
	 *                                          first attempt.
	 *                                          Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
	 *                                          {code false} if {@code null}
	 * @param secsToWait                        the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                                          default-explicit-waitFor property) if null.
	 * @param skipRetryWithoutWaiting           in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public WebElement getSingleForcedElementBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
											   Boolean skipRetryWithoutWaiting) {
		String logID = "::getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): ";
		log.trace("{}Start Preparing wait.", logID);
		
		if (locator == null) return null;
		if (secsToWait == null) secsToWait = getDefaultSecondsToWaitForElements();
		
		// Not sure if the first implementation works every time, will leave this both on false temporarily.
		// This will impact performance but increase the chance to actually get the  elements.
		if (skipRetryWithoutWaiting == null) skipRetryWithoutWaiting = false;
		if (skipRetryWithNoFrames == null) skipRetryWithNoFrames = false;
		
		WebElement element = null;
		try {
			
			if (relativeNestedFrameNamesStructure != null) focus(relativeNestedFrameNamesStructure, secsToWait);
			//How can we use this?:
			//WebElement myDynamicElement =
			
			//core
			element = secsToWait == 0 ? driver.findElement(locator) //no waitFor = normal find.
					: (new WebDriverWait(driver, Duration.ofSeconds(secsToWait))).until(ExpectedConditions.presenceOfElementLocated(locator));
			
			log.trace("{}Finish - waiting is over", logID);
			return element;
			//isElementVisible with visibilityOfElementLocated OR visibilityOf
			
		} catch (TimeoutException ex) {
			log.warn("{} The element [{}] Never showed up.", logID, locator);
			try {
				if (!skipRetryWithoutWaiting) {
					log.info("{}Trying without waiting.", logID);
					element = driver.findElement(locator);
					return element;
				} else {
					log.warn("{}Will not retry-without-waiting.", logID);
					throw ex;
				}
			} catch (Exception ex2) {
				throw new White_SeleniumFrameworkException("Error while looking for the element with locator [" + locator + "]", ex);
			}
			
		} catch (Exception ex) {
			log.debug("{}Couldn't obtain the element with locator:{}", logID, locator);
			//is dirty and wasn't me who got it dirty?
			if (!skipRetryWithNoFrames && !defaultContentFocused && (relativeNestedFrameNamesStructure == null || relativeNestedFrameNamesStructure.isEmpty())) {
				log.debug("{}I'll eat the exception and try again. Suppressed Exception: {}", logID, ex);
			} else {
				log.debug("{}Skipping-retry-With No Frames, Won't try again.", logID);
				throw new White_SeleniumFrameworkException("Error while waiting for the elements to show up with locator:" + locator, ex);
			}
			
		} // exception occurred Retrying with no frames
		
		// skipRetryWithNoFrames always true. Didn't get it & is dirty and wasn't me who got it dirty?
		if (element == null && !defaultContentFocused && (relativeNestedFrameNamesStructure == null || relativeNestedFrameNamesStructure.isEmpty())) {
			log.debug("{}Switching to the main frame and trying again.", logID);
			try {
				
				driver.switchTo().defaultContent();
				defaultContentFocused = true; //to not dirty
				
				log.trace("{}Finish: Using Recursion", logID);
				element = getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, true, secsToWait, skipRetryWithoutWaiting);
				
			} catch (Exception ex) {
				throw new White_SeleniumFrameworkException("Error while waiting for the element with locator:" + locator, ex);
			} //returns null if the `if-block` couldn't solve the problem.
		}
		
		return element;
		
	}
	
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="Multiple Elements">
	
	/**
	 * Will check for at least one element with the specified {@link By} locator until is present on the page's DOM,
	 * obtain all coincidences with the locator, and return the elements as a {@link List};
	 * This does not necessarily mean that the element(s are/)is visible.
	 * If you need to specify a range of time to wait for your element to show up in the page's DOM, you can call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.lang.Integer)}
	 * <br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameters {@code skipRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} and {@code skipRetryWithoutWaiting} as {@code null};
	 *
	 * @param locator The {@link By} locator to search for the element to obtain.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public List<WebElement> getElementsBy(By locator) {
		log.trace("::getElementsBy(locator) - Start: Bridging");
		return getElementsBy(locator, null, null, null, null);
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, obtain all coincidences with the locator, and return the elements as a {@link List};
	 * This does not necessarily mean that the element is visible.
	 * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
	 * <br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameters {@code skipRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} and {@code skipRetryWithoutWaiting} as {@code null};
	 *
	 * @param locator    The {@link By} locator to search for the element to obtain.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public List<WebElement> getElementsBy(By locator, Integer secsToWait) {
		log.trace("::getElementsBy(locator, secsToWait) - Start: Bridging");
		return getElementsBy(locator, null, null, secsToWait, null);
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, obtain all coincidences with the locator, and return the elements as a {@link List};
	 * This does not necessarily mean that the element is visible.
	 * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by
	 * calling the method {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} and setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameters {@code skipRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} as {@code null};
	 *
	 * @param locator                 The {@link By} locator to search for the element to obtain.
	 * @param secsToWait              the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                                default-explicit-waitFor property) if null.
	 * @param skipRetryWithoutWaiting in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public List<WebElement> getElementsBy(By locator, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
		log.trace("::getElementsBy(locator, secsToWait, skipRetryWithoutWaiting) - Start: Bridging");
		return getElementsBy(locator, null, null, secsToWait, skipRetryWithoutWaiting);
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, obtain all coincidences with the locator, and return the elements as a {@link List}; This does not necessarily mean that the
	 * element is visible;
	 * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
	 * and then attempt to obtain the element.
	 * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by
	 * calling the method {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} and setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * Most of the methods on this class will call this method to obtain the elements they want to manipulate, so this method defines the rules that will have to
	 * interact
	 * with them.
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameter {@code skipRetryWithNoFrames} as {@code null};
	 *
	 * @param locator                           The {@link By} locator to search for the element to obtain.
	 * @param relativeNestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                          outer frame and ending with the frame where the element is contained. the method will not switch the focus if
	 *                                          {@code null}.
	 * @param secsToWait                        the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                                          default-explicit-waitFor property) if null.
	 * @param skipRetryWithoutWaiting           in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
		log.trace("::getElementsBy(locator, relativeNestedFrameNamesStructure, secsToWait, skipRetryWithoutWaiting) - Start: Bridging");
		return getElementsBy(locator, relativeNestedFrameNamesStructure, null, secsToWait, skipRetryWithoutWaiting);
	}
	
	/**
	 * Will check for at least one element with the specified {@link By} locator is present on the page's DOM,
	 * obtain all coincidences with the locator, and return the elements as a {@link List}; This does not necessarily mean that the element is visible;
	 * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
	 * and then attempt to obtain the element.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by
	 * calling the method {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} and setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameters {@code secsToWait} and {@code skipRetryWithoutWaiting} as {@code null};
	 *
	 * @param locator                           The {@link By} locator to search for the element to obtain.
	 * @param relativeNestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                          outer frame and ending with the frame where the element is contained. the method will not switch the focus if
	 *                                          {@code null}.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure) {
		log.trace("::getElementsBy(locator, relativeNestedFrameNamesStructure) - Start: Bridging");
		return getElementsBy(locator, relativeNestedFrameNamesStructure, null, null, null);
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM,
	 * obtain all coincidences with the locator, and return the elements as a {@link List}; This does not necessarily mean that the element is visible;
	 * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
	 * and then attempt to obtain the element.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameters {@code secsToWait} and {@code skipRetryWithoutWaiting} as {@code null};
	 *
	 * @param locator                           The {@link By} locator to search for the element to obtain.
	 * @param relativeNestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                          outer frame and ending with the frame where the element is contained. the method will not switch the focus if
	 *                                          {@code null}.
	 * @param skipRetryWithNoFrames             Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the
	 *                                          first attempt.
	 *                                          Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
	 *                                          {code false} if {@code null}
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames) {
		log.trace("::getElementsBy(locator, relativeNestedFrameNamesStructure, skipRetryWitNoFrames) - Start: Bridging");
		return getElementsBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, null, null);
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, obtain all coincidences with the locator, and return the elements as a {@link List}; This does not necessarily mean that the
	 * element is visible;
	 * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
	 * and then attempt to obtain the element.
	 * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)}
	 * with the parameter {@code skipRetryWithoutWaiting} as {@code null};
	 *
	 * @param locator                           The {@link By} locator to search for the element to obtain.
	 * @param relativeNestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                          outer frame and ending with the frame where the element is contained. the method will not switch the focus if
	 *                                          {@code null}.
	 * @param skipRetryWithNoFrames             Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the
	 *                                          first attempt.
	 *                                          Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
	 *                                          {code false} if {@code null}
	 * @param secsToWait                        the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                                          default-explicit-waitFor property) if null.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait) {
		log.trace("::getElementsBy(locator, relativeNestedFrameNamesStructure, skipRetryWitNoFrames, secsToWait) - Start: Bridging");
		return getElementsBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, null);
		
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, obtain all coincidences with the locator, and return the elements as a {@link List}; This does not necessarily mean that the
	 * element is visible;
	 * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
	 * and then attempt to obtain the element.
	 * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * Most of the methods on this class will call this method to obtain the elements they want to manipulate, so this method defines the rules that will have to
	 * interact
	 * with them.
	 *
	 * @param locator                           The {@link By} locator to search for the element to obtain.
	 * @param relativeNestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                          outer frame and ending with the frame where the element is contained. the method will not switch the focus if
	 *                                          {@code null}.
	 * @param skipRetryWithNoFrames             Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the
	 *                                          first attempt.
	 *                                          Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
	 *                                          {code false} if {@code null}
	 * @param secsToWait                        the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                                          default-explicit-waitFor property) if null.
	 * @param skipRetryWithoutWaiting           in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	public List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
										  Boolean skipRetryWithoutWaiting) {
		String logID = "::getElementsBy([locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting]): ";
		log.trace("{}Start - Preparing wait", logID);
		
		if (locator == null) return null;
		if (secsToWait == null) secsToWait = getDefaultSecondsToWaitForElements();
		
		// Not sure if the first implementation works every time, so temporarily will leave this both on false,
		// this will impact performance but increase the chance to actually get the elements.
		if (skipRetryWithoutWaiting == null) skipRetryWithoutWaiting = false;
		if (skipRetryWithNoFrames == null) skipRetryWithNoFrames = false;
		
		List<WebElement> elements = null;
		try {
			
			if (relativeNestedFrameNamesStructure != null) focus(relativeNestedFrameNamesStructure, secsToWait);
			//I do not understand how to use this yet
			//WebElement myDynamicElement =
			
			//core
			elements = secsToWait == 0 ? driver.findElements(locator) //no waitFor = normal find.
					: (new WebDriverWait(driver, Duration.ofSeconds(secsToWait))).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			
			log.trace("{}Finish - waiting is over", logID);
			return elements;
			//isElementVisible with visibilityOfElementLocated OR visibilityOf
			
		} catch (TimeoutException ex) {
			log.warn("{}The element [{}] Never showed up.", logID, locator);
			try {
				if (!skipRetryWithoutWaiting) {
					log.warn("{}Trying without waiting", logID);
					elements = driver.findElements(locator);
					return elements;
				} else {
					log.warn("{}Skipping retry-without-waiting.", logID);
					throw ex;
				}
			} catch (Exception ex2) {
				throw new White_SeleniumFrameworkException("Error while looking for the element with locator [" + locator + "]", ex);
			}
			
		} catch (Exception ex) {
			log.debug("{}Couldn't obtain the element.", logID);
			log.trace("{}Is dirty and wasn't me who got it dirty?", logID);
			if (!skipRetryWithNoFrames && !defaultContentFocused && (relativeNestedFrameNamesStructure == null || relativeNestedFrameNamesStructure.isEmpty())) {
				log.debug("{} I'll eat the exception and try again. Suppressed Exception: {}", logID, ex);
			} else {
				log.debug("{}Skipping-retry-With No Frames Won't try again.", logID);
				throw new White_SeleniumFrameworkException("Error while waiting for the elements to show up with locator:" + locator, ex);
			}
			
		} // exception occurred Retrying with no frames
		
		// skipRetryWithNoFrames always true. Didn't get it & is dirty and wasn't me who got it dirty?
		if (elements == null && !defaultContentFocused && (relativeNestedFrameNamesStructure == null || relativeNestedFrameNamesStructure.isEmpty())) {
			log.debug("{}Switching to the main frame and trying again.", logID);
			try {
				
				driver.switchTo().defaultContent();
				defaultContentFocused = true; //to not dirty
				log.trace("{}Finish: Using Recursion", logID);
				elements = getElementsBy(locator, relativeNestedFrameNamesStructure, true, secsToWait, skipRetryWithoutWaiting);
				
			} catch (Exception ex) {
				throw new White_SeleniumFrameworkException("Error while waiting for the element with locator:" + locator, ex);
			} //returns null if the `if-block` couldn't solve the problem.
		}
		
		return elements;
		
	}
	
	//</editor-fold>
	
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="Utils">
	
	/**
	 * Opens the provided URL in the already loaded {@link WebDriver WebExplorer}.
	 * This is effectively a bridge method that uses the {@link WebDriver#get(java.lang.String) } method.
	 *
	 * @param url {@link String} to perform the operation with.
	 * @throws IllegalArgumentException - if the provided parameter is null.
	 * @author <a href='mailto:obed.vazquez@gmail.com'>Obed Vazquez</a>
	 * @since 2021-02-08
	 */
	public void openURL(String url) {
		log.trace("::openURL(url) - Start: ");
		Objects.requireNonNull(url);
		try {
			
			driver.get(url);
			
			log.trace("::openURL(url) - Finish: ");
		} catch (org.openqa.selenium.InvalidArgumentException ex) {
			throw new White_SeleniumFrameworkException("Impossible to openURL [" + url + "]. Does your URL has the correct format? [https://]", ex);
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Impossible to openURL " + url, e);
		}
	}
	
	/**
	 * Resets the focus to the default content on the page. if you need to access an element inside a frame you will have to call
	 * {@link #focus(java.util.Collection, java.lang.Integer)} or {@link #focusFrame(org.openqa.selenium.support.How, java.lang.String, java.lang.Integer)} method again
	 * to obtain the element after calling this. This method also marks the focus as clean by setting {@link #defaultContentFocused} as <code>true</code>
	 *
	 * @since 2019-03-02
	 */
	public void frameReloading() {
		String logID = "::frameReloading(): ";
		log.trace("{}Start - Resting focus", logID);
		try {
			driver.switchTo().defaultContent();
			defaultContentFocused = true;
			log.trace("{}Finish - Focus Rested", logID);
		} catch (org.openqa.selenium.UnhandledAlertException ex) {
			throw new White_SeleniumFrameworkException("Unable to focus on the default Content(resting the focus) of the page due to an alert,"
															   + " please handle the alert before changing focus.", ex);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to focus on the default Content(resting the focus) of the page.", ex);
		}
	}
	
	/**
	 * Receives an ordered collection of frame/iframe names that represent the nested frame structure of the page until the point where is possible to obtain a desired
	 * object.
	 * This is a bridge method to {@link #focus(java.util.Collection, java.lang.Integer) } setting up the <code>secsToWait</code> to null, this makes the defaults to be
	 * used.
	 *
	 * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                  outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
	 * @since 2019-03-02
	 */
	public void focus(Collection<String> nestedFrameNamesStructure) {
		focus(nestedFrameNamesStructure, null);
	}
	
	/**
	 * Receives an ordered collection of frame/iframe names that represent the nested frame structure of the page until the point where is possible to obtain a desired
	 * object.
	 *
	 * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the
	 *                                  outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
	 * @param secsToWait                the seconds to waitFor for the frame to show up in the page, uses the app default (specified in .properties with
	 *                                  default-explicit-waitFor property) if null. The focus switch seems to take some time ignoring the waitFor in case it fails to
	 *                                  find
	 *                                  the frame.
	 * @since 2019-03-02
	 */
	public void focus(Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		String logID = "::focus(nestedFrameNamesStructure, secsToWait): ";
		log.trace("{}Start - looking for focus", logID);
		
		try {
			//validations
			if (nestedFrameNamesStructure == null) {
				log.trace("{}Finish - No frames provided, the focus was not modified.", logID);
				return;
			}
			if (secsToWait == null) secsToWait = getDefaultSecondsToWaitForElements();
			
			//process
			defaultContentFocused = false;//dirty
			boolean firstFrame = true;
			String lastFrameFocusedName = "Unknown";
			for (String frameName : nestedFrameNamesStructure) {
				try {
					try {
						focusFrame(How.ID, frameName, secsToWait);
						lastFrameFocusedName = frameName;
					} catch (Exception ex) {
						log.debug("{}The frame [{}] was not found by Id trying with Name.", logID, frameName);
						focusFrame(How.NAME, frameName, secsToWait);
						lastFrameFocusedName = frameName;
					}
				} catch (Exception ex) {
					if (firstFrame) { //tries switching back to the main frame and try again.
						try {
							driver.switchTo().defaultContent();
							lastFrameFocusedName = "default";
							try {
								focusFrame(How.ID, frameName, secsToWait);
								lastFrameFocusedName = frameName;
							} catch (Exception ex2) {
								log.debug("{}The frame [{}] was not found by Id trying with Name.", logID, frameName);
								focusFrame(How.NAME, frameName, secsToWait);
								lastFrameFocusedName = frameName;
							}
							firstFrame = false;
							continue; //do not log the WARN
						} catch (Exception ex3) {
							log.trace("{}a Managed exception has occurred", logID);
						}//logs the next warn
					}
					log.warn("{}Impossible to switch focus to frame [{}] ignoring it, and keep trying with the rest of the structure.", logID, frameName);
				}
				if (firstFrame) firstFrame = false;
			}
			log.debug("{}FOCUS switched to: {}", logID, lastFrameFocusedName);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to focus one of the frames of the given structure", ex);
		}
		
	}
	
	/**
	 * This will switch the focus of the app to the provided frame/iframe. (No pun intended) This focus is needed to obtain elements inside a frame or iframe.
	 * Have to be specified if the ID or the NAME attribute of the frame/iframe is used through the <code>how</code> parameter provided. For now,
	 * a bug has being identified in Google Chrome and because of it some frames/iframes can't be obtained with traditional method so an alternative method is used
	 * in those cases it might take more time to focus, but it will ensure that the frames/iframes are being obtained correctly.
	 *
	 * @param how           {@link How} must be specified as ID or NAME; this is supposed to be specified, although it will go ahead and try with ID if not (logs a
	 *                      `WARN`).
	 * @param frameNameOrId The Name or `ID` of the frame/iframe; does nothing if null.
	 * @param secsToWait    the seconds to waitFor for the frame to show up in the page, uses the app default (specified in .properties with
	 *                      default-explicit-waitFor property) if null. The focus switch seems to take some time ignoring the waitFor in case it fails to find the frame.
	 * @since 2019-03-02
	 */
	public void focusFrame(How how, String frameNameOrId, Integer secsToWait) {
		String logID = "::focusFrame(how, frameNameOrId, secsToWait): ";
		log.trace("{}Start - changing focus to new frame", logID);
		
		try {
			//validations
			if (frameNameOrId == null) {
				log.trace("{}No frame provided, the focus was not modified", logID);
				return;
			}
			if (secsToWait == null) {
				String propertiesSecs = getProperty("white-selenium-framework.execute.default-explicit-wait");
				Integer newSecs = propertiesSecs != null ? Integer.parseInt(propertiesSecs) : null;
				secsToWait = (newSecs != null) ? newSecs : 0;
			}
			if (how != How.ID && how != How.NAME) {
				log.warn("{}The how parameter was not provided, it must be NAME or ID. Trying with ID by default.", logID);
				how = How.ID;
			}
			
			//process
			defaultContentFocused = false;//dirty
			String attribute = how.equals(How.ID) ? "id" : "name";
			try {
				WebDriverWait wait = (new WebDriverWait(driver, Duration.ofSeconds(secsToWait)));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
				log.debug("{}FOCUS switched to: {}", logID, frameNameOrId);
			} catch (Exception ex) {
				log.debug("{}Managing error showing up while waiting for the frame: {}. Error: {}", logID, frameNameOrId, ex.getStackTrace()[0]);
				log.warn("{}Impossible to obtain the frame [{}] by waiting on it, trying without wait for the element to be present, " +
								 "for more information on the warn check the DEBUG level logs.", logID, frameNameOrId);
				try {
					driver.switchTo().frame(driver.findElement(By.xpath("//frame[@" + attribute + "='" + frameNameOrId + "']")));
					log.debug("{}FOCUS switched to: {}", logID, frameNameOrId);
				} catch (Exception ex2) {
					driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@" + attribute + "='" + frameNameOrId + "']")));  //u.u
					log.debug("{}FOCUS switched to: {}", logID, frameNameOrId);
				}
			}
			
			log.trace("{}Finish - focus switched", logID);
			
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to focus on the given frame", ex);
		}
	}
	
	public void highlight(WebElement element) {
		log.trace("::highlight(element) - Start: ");
		try {
			JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
			javaScriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
			log.trace("::highlight(element) - Finish: Highlighted");
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Impossible to highlight the element", e);
		}
	}
	
	/**
	 * Assuming there is an alert popping up on your page this will just accept (click OK button) on it.
	 *
	 * @since 2019-03-02
	 */
	public void acceptAlert() {
		String logID = "::acceptAlert(): ";
		log.trace("{}Start - Accepting alert", logID);
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			//Alert alert = driver.switchTo().alert();
			alert.accept();
			log.trace("{}Finish - Alert accepted.", logID);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to accept the alert", ex);
		}
	}
	
	public void pageDown() {
		log.trace("::pageDown() - Start: ");
		try {
			
			pressKey(Keys.PAGE_DOWN);
			log.trace("::pageDown() - Finish: ");
			
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Impossible to page down.", e);
		}
	}
	
	public void pageUp() {
		log.trace("::pageUp() - Start: ");
		try {
			
			pressKey(Keys.PAGE_UP);
			log.trace("::pageUp() - Finish: ");
			
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Impossible to page up in the page.", e);
		}
	}
	
	public void scrollToTop() {
		log.trace("::scrollToTop() - Start: ");
		try {
			((JavascriptExecutor) driver).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			
			log.trace("::scrollToTop() - Finish: ");
		} catch (Exception e) {
			try {
				log.trace("::scrollToTop(): Error when scrolling to top, trying to page up there (50). ");
				for (int i = 0; i < 20; i++) {
					pageUp();
				}
			} catch (Exception e2) {
				throw new White_SeleniumFrameworkException("Error when trying again",
														   new White_SeleniumFrameworkException("Impossible to scroll to top of the page. Was the header found?", e));
			}
		}
	}
	
	public void scrollToTopJS() {
		String logID = "::scrollToTopJS([]): ";
		log.warn("{}Start - This method has not been tested! be aware", logID);
		WebElement element = driver.findElement(By.tagName("header"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public void pressKey(org.openqa.selenium.Keys key) {
		log.trace("::pressKey(key) - Start: ");
		try {
			
			if (action == null) action = new Actions(driver);
			action.sendKeys(key).build().perform();
			log.trace("::pressKey(key) - Finish: Key pressed");
			
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Impossible to press the Key: [" + key + "].", e);
		}
	}
	
	public void waitFor(Long milliseconds) {
		log.trace("::wait(milliseconds) - Start: ");
		Objects.requireNonNull(milliseconds);
		try {
			Thread.sleep(milliseconds);
			log.trace("::wait(milliseconds) - Finish: ");
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Unable to pause the thread due to an unknown internal error.", e);
		}
		
	}
	
	//<editor-fold defaultstate="collapsed" desc="PrintScreen">
	public Screenshot screenshot = new Screenshot();
	/**
	 * Used to take Screenshots of the running {@link AutomationScenario scenario}. Use:
	 * <code>
	 *     new {@link WebDriverUtils utils}().take();
	 * </code>
	 * To take a screenshot of your running Web Browser, if you need to use your own {@link WebDriver} you can specify it like this:
	 * <code>
	 *     new {@link WebDriverUtils utils}()
	 *     			.setDriver(myDriver)
	 *     			.take();
	 * </code>
	 */
	public class Screenshot{
		WebDriver screenShootDriver;
		String automationScenarioDisplayName;
		String screenshotFileName;
		String screenshotFilePath;
		
		public Screenshot(){
			initialize();
		}
		
		public void initialize(){
			screenShootDriver = driver;
			automationScenarioDisplayName = getDefaultScreenShotDisplayName();
			screenshotFilePath = getDefaultScreenshotPath();
		}
		
		private String getDefaultScreenShotDisplayName() {
			return getScreenshotFileName("Screenshot" + (++WebDriverUtils.screenShootCounter));
		}
		
		private String getScreenshotFileName(String testID){
			return  testID + " " + LocalDate.now().toString().replace(":| ", "_") + ".png";
		}
		
		private String getDefaultScreenshotPath(){
			return "./target/test-reports/screenshots/";
		}
		
		public Screenshot setDriver(WebDriver screenShootDriver){
			this.screenShootDriver = screenShootDriver;
			return this;
		}
		public Screenshot setScenarioDisplayName(String automationScenarioDisplayName){
			this.automationScenarioDisplayName = automationScenarioDisplayName;
			return this;
		}
		public Screenshot setFileName(String screenshotFileName){
			this.screenshotFileName = screenshotFileName;
			return this;
		}
		public Screenshot setFilePath(String screenshotFilePath){
			this.screenshotFilePath = screenshotFilePath;
			return this;
		}
		
		public String take(){
			String logID="::take(): ";
			log.trace("{}Start - Taking Screenshot", logID);
			try {
				String screenshotFileFullName = screenshotFilePath + (screenshotFileName == null
						?getScreenshotFileName(automationScenarioDisplayName)
						:screenshotFileName);
				Thread.sleep(1000);
				
				FileUtils.copyFile(((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE), new File(screenshotFileFullName));
				initialize();
				
				log.trace("{}Finish - Screenshot saved", logID);
				return screenshotFileFullName;
				
			} catch (java.io.IOException ex) {
				throw new White_SeleniumFrameworkException("Unable to save the screenshot", ex);
			} catch (Exception ex) {
				throw new White_SeleniumFrameworkException("Unable to take a screenshot", ex);
			}
		}
	}
	
	//</editor-fold>
	
	//region Record
	static String recordedFileName;
	
	public static void startRecording(SeleniumJupiter seleniumJupiter, String displayName){
		String logID="::startRecording([seleniumJupiter, displayName]): ";
		log.trace("{}Start ", logID);
		Objects.requireNonNull(seleniumJupiter);
		if(displayName == null) displayName = "recorded";
		try{
			recordedFileName = displayName + " " + LocalDate.now().toString().replace(":| ", "_");
			seleniumJupiter.startRecording(recordedFileName);
			log.trace("{}Finish", logID);
			
		} catch (Exception ex) {
			throw new RuntimeException("Impossible to start the recording", ex);
		}
		
	}
	
	public static void saveRecording(SeleniumJupiter seleniumJupiter){
		saveRecording(seleniumJupiter, null);
	}
	
	@SneakyThrows
	public static void saveRecording(SeleniumJupiter seleniumJupiter, String filePath){
		String logID="::saveRecording([seleniumJupiter]): ";
		log.trace("{}Start ", logID);
		Objects.requireNonNull(seleniumJupiter);
		if(filePath == null) filePath = "target/test-reports/recorded/";
		try {
			
			final int REC_TIMEOUT_SEC = 1;
			final int POLL_TIME_MSEC = 100;
			
			final String RECORDED_EXT = ".webm";
			final String RECORDED_FOLDER_PATH = System.getProperty("user.home") + "/Downloads";
			File targetFolder = new File(RECORDED_FOLDER_PATH);
			
			seleniumJupiter.stopRecording();
			
			long timeoutMs = System.currentTimeMillis() + TimeUnit.SECONDS.toMillis(REC_TIMEOUT_SEC);
			
			File recFile;
			do {
				recFile = new File(targetFolder, recordedFileName + RECORDED_EXT);
				if (System.currentTimeMillis() > timeoutMs) {
					log.error("Timeout of " + REC_TIMEOUT_SEC + " seconds waiting for recording " + recFile);
					break;
				}
				Thread.sleep(POLL_TIME_MSEC);
				
			} while (!recFile.exists());
			
			log.debug("{}Recorded File Status: {}", logID, recFile.exists());
			log.debug("{}File Name: {}", logID, recFile.getAbsolutePath());
			if (recFile.exists()) {
				File movedFile = new File(filePath + recordedFileName + RECORDED_EXT);
				try {FileUtils.delete(movedFile);} catch (NoSuchFileException ex) {}
				FileUtils.moveFile(recFile, movedFile);
			}
		}catch(Exception ex){
			throw new White_SeleniumFrameworkException("An error occurred when saving the video recording.", ex);
		}
	}
	//endregion Record
	
	//<editor-fold defaultstate="collapsed" desc="WebExplorer in use">
	
	/**
	 * Closes WebBrowser.
	 * This is faster than {@link #closeWebBrowserWindow()} but when executing several {@link AutomationScenario}s or have several windows opened this will close all of
	 * them if they are open over the same WebBrowser.
	 */
	public void forcedQuit() {
		String logID = "::forceQuit([]): ";
		log.trace("{}Start ", logID);
		try {
			driver.quit();
			log.trace("{}Finish", logID);
		} catch (org.openqa.selenium.NoSuchSessionException ex) {
			log.error(logID + "Are you trying to close an already closed Web Browser? Ignoring command. ", ex);
		}
	}
	
	/**
	 * This will close the active opened WebBrowser window.
	 *
	 * @see #forcedQuit()
	 */
	public void closeWebBrowserWindow() {
		String logID = "::quit([]): ";
		log.trace("{}Start - Closing WebBrowser", logID);
		try {
			driver.close();
			log.trace("{}Finish", logID);
		} catch (org.openqa.selenium.NoSuchSessionException ex) {
			log.error(logID + "Are you trying to close an already closed Web Browser? Ignoring command. ", ex);
		}
	}
	
	public void restartWebExplorer() {
		String logID = "::restartWebExplorer([]): ";
		log.trace("{}Start - Restarting WebDriver", logID);
		try {
			forcedQuit();
			driver = driver.getClass().getConstructor().newInstance();
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Impossible to restart the Web Explorer", ex);
		}
	}
	
	public boolean isEdgeBeingTested() {
		return driver instanceof EdgeDriver;
	}
	
	public boolean isIEBeingTested() {
		return driver instanceof InternetExplorerDriver;
	}
	
	public boolean isChromeBeingTested() {
		return driver instanceof ChromeDriver;
	}
	
	public boolean isFireFoxBeingTested() {
		return driver instanceof FirefoxDriver;
	}
	
	//</editor-fold>
	//</editor-fold>

//</editor-fold>

}
