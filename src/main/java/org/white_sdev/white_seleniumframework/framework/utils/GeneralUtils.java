package org.white_sdev.white_seleniumframework.framework.utils;

import io.github.bonigarcia.seljup.SeleniumJupiter;
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
import org.white_sdev.white_seleniumframework.framework.AutomationScenario;
import org.white_sdev.white_seleniumframework.framework.RecordingUtils;
import org.white_sdev.white_seleniumframework.framework.WebDriverUtils;

import java.io.File;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

import static org.white_sdev.white_seleniumframework.utils.PropertiesReader.getProperty;

public interface GeneralUtils {
	org.slf4j.Logger log();
	WebDriver driver();
	void driver(WebDriver driver);
	boolean defaultContentFocused();
	void defaultContentFocused(boolean defaultContentFocused);
	Integer getDefaultSecondsToWaitForElements();
	
	
	/**
	 * Opens the provided URL in the already loaded {@link WebDriver WebExplorer}.
	 * This is effectively a bridge method that uses the {@link WebDriver#get(java.lang.String) } method.
	 *
	 * @param url {@link String} to perform the operation with.
	 * @throws IllegalArgumentException - if the provided parameter is null.
	 * @author <a href='mailto:obed.vazquez@gmail.com'>Obed Vazquez</a>
	 * @since 2021-02-08
	 */
	default void openURL(String url) {
		log().trace("::openURL(url) - Start: ");
		Objects.requireNonNull(url);
		try {
			
			driver().get(url);
			
			log().trace("::openURL(url) - Finish: ");
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
	default void frameReloading() {
		String logID = "::frameReloading(): ";
		log().trace("{}Start - Resting focus", logID);
		try {
			driver().switchTo().defaultContent();
			defaultContentFocused(true);
			log().trace("{}Finish - Focus Rested", logID);
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
	default void focus(Collection<String> nestedFrameNamesStructure) {
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
	default void focus(Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
		String logID = "::focus(nestedFrameNamesStructure, secsToWait): ";
		log().trace("{}Start - looking for focus", logID);
		
		try {
			//validations
			if (nestedFrameNamesStructure == null) {
				log().trace("{}Finish - No frames provided, the focus was not modified.", logID);
				return;
			}
			if (secsToWait == null) secsToWait = getDefaultSecondsToWaitForElements();
			
			//process
			defaultContentFocused(false);//dirty
			boolean firstFrame = true;
			String lastFrameFocusedName = "Unknown";
			for (String frameName : nestedFrameNamesStructure) {
				try {
					try {
						focusFrame(How.ID, frameName, secsToWait);
						lastFrameFocusedName = frameName;
					} catch (Exception ex) {
						log().debug("{}The frame [{}] was not found by Id trying with Name.", logID, frameName);
						focusFrame(How.NAME, frameName, secsToWait);
						lastFrameFocusedName = frameName;
					}
				} catch (Exception ex) {
					if (firstFrame) { //tries switching back to the main frame and try again.
						try {
							driver().switchTo().defaultContent();
							lastFrameFocusedName = "default";
							try {
								focusFrame(How.ID, frameName, secsToWait);
								lastFrameFocusedName = frameName;
							} catch (Exception ex2) {
								log().debug("{}The frame [{}] was not found by Id trying with Name.", logID, frameName);
								focusFrame(How.NAME, frameName, secsToWait);
								lastFrameFocusedName = frameName;
							}
							firstFrame = false;
							continue; //do not log the WARN
						} catch (Exception ex3) {
							log().trace("{}a Managed exception has occurred", logID);
						}//logs the next warn
					}
					log().warn("{}Impossible to switch focus to frame [{}] ignoring it, and keep trying with the rest of the structure.", logID, frameName);
				}
				if (firstFrame) firstFrame = false;
			}
			log().debug("{}FOCUS switched to: {}", logID, lastFrameFocusedName);
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
	default void focusFrame(How how, String frameNameOrId, Integer secsToWait) {
		String logID = "::focusFrame(how, frameNameOrId, secsToWait): ";
		log().trace("{}Start - changing focus to new frame", logID);
		
		try {
			//validations
			if (frameNameOrId == null) {
				log().trace("{}No frame provided, the focus was not modified", logID);
				return;
			}
			if (secsToWait == null) {
				String propertiesSecs = getProperty("white-selenium-framework.execute.default-explicit-wait");
				Integer newSecs = propertiesSecs != null ? Integer.parseInt(propertiesSecs) : null;
				secsToWait = (newSecs != null) ? newSecs : 0;
			}
			if (how != How.ID && how != How.NAME) {
				log().warn("{}The how parameter was not provided, it must be NAME or ID. Trying with ID by default.", logID);
				how = How.ID;
			}
			
			//process
			defaultContentFocused(false);//dirty
			String attribute = how.equals(How.ID) ? "id" : "name";
			try {
				WebDriverWait wait = (new WebDriverWait(driver(), Duration.ofSeconds(secsToWait)));
				wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
				log().debug("{}FOCUS switched to: {}", logID, frameNameOrId);
			} catch (Exception ex) {
				log().debug("{}Managing error showing up while waiting for the frame: {}. Error: {}", logID, frameNameOrId, ex.getStackTrace()[0]);
				log().warn("{}Impossible to obtain the frame [{}] by waiting on it, trying without wait for the element to be present, " +
								 "for more information on the warn check the DEBUG level logs.", logID, frameNameOrId);
				try {
					driver().switchTo().frame(driver().findElement(By.xpath("//frame[@" + attribute + "='" + frameNameOrId + "']")));
					log().debug("{}FOCUS switched to: {}", logID, frameNameOrId);
				} catch (Exception ex2) {
					driver().switchTo().frame(driver().findElement(By.xpath("//iframe[@" + attribute + "='" + frameNameOrId + "']")));  //u.u
					log().debug("{}FOCUS switched to: {}", logID, frameNameOrId);
				}
			}
			
			log().trace("{}Finish - focus switched", logID);
			
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to focus on the given frame", ex);
		}
	}
	
	default void highlight(WebElement element) {
		log().trace("::highlight(element) - Start: ");
		try {
			JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver();
			javaScriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
			log().trace("::highlight(element) - Finish: Highlighted");
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Impossible to highlight the element", e);
		}
	}
	
	/**
	 * Assuming there is an alert popping up on your page this will just accept (click OK button) on it.
	 *
	 * @since 2019-03-02
	 */
	default void acceptAlert() {
		String logID = "::acceptAlert(): ";
		log().trace("{}Start - Accepting alert", logID);
		try {
			WebDriverWait wait = new WebDriverWait(driver(), Duration.ofSeconds(2));
			Alert alert = wait.until(ExpectedConditions.alertIsPresent());
			//Alert alert = driver().switchTo().alert();
			alert.accept();
			log().trace("{}Finish - Alert accepted.", logID);
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Unable to accept the alert", ex);
		}
	}
	
	default void pageDown() {
		log().trace("::pageDown() - Start: ");
		try {
			
			pressKey(Keys.PAGE_DOWN);
			log().trace("::pageDown() - Finish: ");
			
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Impossible to page down.", e);
		}
	}
	
	default void pageUp() {
		log().trace("::pageUp() - Start: ");
		try {
			
			pressKey(Keys.PAGE_UP);
			log().trace("::pageUp() - Finish: ");
			
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Impossible to page up in the page.", e);
		}
	}
	
	default void scrollToTop() {
		log().trace("::scrollToTop() - Start: ");
		try {
			((JavascriptExecutor) driver()).executeScript("window.scrollTo(0, -document.body.scrollHeight)");
			
			log().trace("::scrollToTop() - Finish: ");
		} catch (Exception e) {
			try {
				log().trace("::scrollToTop(): Error when scrolling to top, trying to page up there (50). ");
				for (int i = 0; i < 20; i++) {
					pageUp();
				}
			} catch (Exception e2) {
				throw new White_SeleniumFrameworkException("Error when trying again",
														   new White_SeleniumFrameworkException("Impossible to scroll to top of the page. Was the header found?", e));
			}
		}
	}
	
	default void scrollToTopJS() {
		String logID = "::scrollToTopJS([]): ";
		log().warn("{}Start - This method has not been tested! be aware", logID);
		WebElement element = driver().findElement(By.tagName("header"));
		JavascriptExecutor js = (JavascriptExecutor) driver();
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	default void pressKey(org.openqa.selenium.Keys key) {
		log().trace("::pressKey(key) - Start: ");
		try {
			
			Actions action = new Actions(driver());
			action.sendKeys(key).build().perform();
			log().trace("::pressKey(key) - Finish: Key pressed");
			
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Impossible to press the Key: [" + key + "].", e);
		}
	}
	
	default void waitFor(Long milliseconds) {
		log().trace("::waitFor(milliseconds) - Start: ");
		Objects.requireNonNull(milliseconds);
		try {
			Thread.sleep(milliseconds);
			log().trace("::wait(milliseconds) - Finish: ");
		} catch (Exception e) {
			throw new White_SeleniumFrameworkException("Unable to pause the thread due to an unknown internal error.", e);
		}
	}
	
	
	
	//<editor-fold defaultstate="collapsed" desc="Record">
	static String startRecording(SeleniumJupiter seleniumJupiter, WebDriver driver, String displayName) {
		return RecordingUtils.startRecording(seleniumJupiter, driver, displayName);
	}
	
	static Optional<File> saveRecording(SeleniumJupiter seleniumJupiter, String displayName) {
		return RecordingUtils.saveRecording(seleniumJupiter, displayName);
	}
	
	static Optional<File> saveRecording(SeleniumJupiter seleniumJupiter, String displayName, String filePath, String fileName) {
		return RecordingUtils.saveRecording(seleniumJupiter, displayName, filePath, fileName);
	}
	
	//</editor-fold>
	
	//<editor-fold defaultstate="collapsed" desc="WebExplorer in use">
	
	/**
	 * Closes WebBrowser.
	 * This is faster than {@link #closeWebBrowserWindow()} but when executing several {@link AutomationScenario}s or have several windows opened this will close all of
	 * them if they are open over the same WebBrowser.
	 */
	default void forcedQuit() {
		String logID = "::forceQuit([]): ";
		log().trace("{}Start ", logID);
		try {
			driver().quit();
			log().trace("{}Finish", logID);
		} catch (org.openqa.selenium.NoSuchSessionException ex) {
			log().error(logID + "Are you trying to close an already closed Web Browser? Ignoring command. ", ex);
		}
	}
	
	/**
	 * This will close the active opened WebBrowser window.
	 *
	 * @see #forcedQuit()
	 */
	default void closeWebBrowserWindow() {
		String logID = "::quit([]): ";
		log().trace("{}Start - Closing WebBrowser", logID);
		try {
			driver().close();
			log().trace("{}Finish", logID);
		} catch (org.openqa.selenium.NoSuchSessionException ex) {
			log().error(logID + "Are you trying to close an already closed Web Browser? Ignoring command. ", ex);
		}
	}
	
	default void restartWebExplorer() {
		String logID = "::restartWebExplorer([]): ";
		log().trace("{}Start - Restarting WebDriver", logID);
		try {
			forcedQuit();
			driver(driver().getClass().getConstructor().newInstance());
		} catch (Exception ex) {
			throw new White_SeleniumFrameworkException("Impossible to restart the Web Explorer", ex);
		}
	}
	
	default boolean isEdgeBeingTested() {
		return driver() instanceof EdgeDriver;
	}
	
	default boolean isIEBeingTested() {
		return driver() instanceof InternetExplorerDriver;
	}
	
	default boolean isChromeBeingTested() {
		return driver() instanceof ChromeDriver;
	}
	
	default boolean isFireFoxBeingTested() {
		return driver() instanceof FirefoxDriver;
	}
	
	//</editor-fold>
	
}
