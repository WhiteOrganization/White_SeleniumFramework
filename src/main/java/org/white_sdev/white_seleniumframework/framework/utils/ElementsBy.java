package org.white_sdev.white_seleniumframework.framework.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.white_sdev.white_seleniumframework.exceptions.White_SeleniumFrameworkException;

import java.time.Duration;
import java.util.Collection;
import java.util.List;

interface ElementsBy extends GeneralUtils {
	
	
	/**
	 * Will check for at least one element with the specified {@link By} locator until is present on the page's DOM,
	 * obtain all coincidences with the locator, and return the elements as a {@link List};
	 * This does not necessarily mean that the element(s are/)is visible.
	 * If you need to specify a range of time to wait for your element to show up in the page's DOM, you can call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.lang.Integer)}
	 * <br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, WebElement)}
	 * with the parameters {@code skipRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} and {@code skipRetryWithoutWaiting} as {@code null};
	 *
	 * @param locator The {@link By} locator to search for the element to obtain.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	default List<WebElement> getElementsBy(By locator) {
		log().trace("::getElementsBy(locator) - Start: Bridging");
		return getElementsBy(locator, null, null, null, null, null);
	}
	
	default List<WebElement> getElementsBy(By locator, WebElement loadingDialogToWaitFor) {
		log().trace("::getElementsBy(locator) - Start: Bridging");
		return getElementsBy(locator, null, null, null, null, loadingDialogToWaitFor);
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, obtain all coincidences with the locator, and return the elements as a {@link List};
	 * This does not necessarily mean that the element is visible.
	 * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
	 * <br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, WebElement)}
	 * with the parameters {@code skipRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} and {@code skipRetryWithoutWaiting} as {@code null};
	 *
	 * @param locator    The {@link By} locator to search for the element to obtain.
	 * @param secsToWait the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with
	 *                   default-explicit-waitFor property) if null.
	 * @return The element as {@link WebElement} or {@code null} in case it is not found.
	 * @throws White_SeleniumFrameworkException When an error is found.
	 * @since 2021-01-29
	 */
	default List<WebElement> getElementsBy(By locator, Integer secsToWait) {
		log().trace("::getElementsBy(locator, secsToWait) - Start: Bridging");
		return getElementsBy(locator, null, null, secsToWait, null, null);
	}
	
	/**
	 * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
	 * with the specified amount of seconds, obtain all coincidences with the locator, and return the elements as a {@link List};
	 * This does not necessarily mean that the element is visible.
	 * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by
	 * calling the method {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, WebElement)}
	 * and setting the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, WebElement)}
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
	default List<WebElement> getElementsBy(By locator, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
		log().trace("::getElementsBy(locator, secsToWait, skipRetryWithoutWaiting) - Start: Bridging");
		return getElementsBy(locator, null, null, secsToWait, skipRetryWithoutWaiting, null);
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
	 * calling the method {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, WebElement)} and setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * Most of the methods on this class will call this method to obtain the elements they want to manipulate, so this method defines the rules that will have to
	 * interact
	 * with them.
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, WebElement)}
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
	default List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
		log().trace("::getElementsBy(locator, relativeNestedFrameNamesStructure, secsToWait, skipRetryWithoutWaiting) - Start: Bridging");
		return getElementsBy(locator, relativeNestedFrameNamesStructure, null, secsToWait, skipRetryWithoutWaiting, null);
	}
	
	/**
	 * Will check for at least one element with the specified {@link By} locator is present on the page's DOM,
	 * obtain all coincidences with the locator, and return the elements as a {@link List}; This does not necessarily mean that the element is visible;
	 * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
	 * and then attempt to obtain the element.
	 * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content
	 * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by
	 * calling the method {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, WebElement)} and setting
	 * the {@code skipRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error.
	 * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
	 * This is a Bridge method and will only call the method
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, WebElement)}
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
	default List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure) {
		log().trace("::getElementsBy(locator, relativeNestedFrameNamesStructure) - Start: Bridging");
		return getElementsBy(locator, relativeNestedFrameNamesStructure, null, null, null, null);
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
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, WebElement)}
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
	default List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames) {
		log().trace("::getElementsBy(locator, relativeNestedFrameNamesStructure, skipRetryWitNoFrames) - Start: Bridging");
		return getElementsBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, null, null, null);
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
	 * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean, WebElement)}
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
	default List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait) {
		log().trace("::getElementsBy(locator, relativeNestedFrameNamesStructure, skipRetryWitNoFrames, secsToWait) - Start: Bridging");
		return getElementsBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, null, null);
		
	}
	
	default List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
										   Boolean skipRetryWithoutWaiting) {
		return getElementsBy(locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting, null);
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
	default List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skipRetryWithNoFrames, Integer secsToWait,
										  Boolean skipRetryWithoutWaiting, WebElement loadingDialogToWaitFor) {
		String logID = "::getElementsBy([locator, relativeNestedFrameNamesStructure, skipRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting]): ";
		log().trace("{}Start - Preparing wait", logID);
		
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
			
			if(loadingDialogToWaitFor!=null) new WebDriverWait(driver(), Duration.ofSeconds(secsToWait)).until(ExpectedConditions.invisibilityOf(loadingDialogToWaitFor));
			
			//core
			elements = secsToWait == 0 ? driver().findElements(locator) //no waitFor = normal find.
					: (new WebDriverWait(driver(), Duration.ofSeconds(secsToWait))).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
			
			log().trace("{}Finish - waiting is over", logID);
			return elements;
			//isElementVisible with visibilityOfElementLocated OR visibilityOf
			
		} catch (TimeoutException ex) {
			log().warn("{}The element [{}] Never showed up.", logID, locator);
			try {
				if (!skipRetryWithoutWaiting) {
					log().warn("{}Trying without waiting", logID);
					elements = driver().findElements(locator);
					return elements;
				} else {
					log().warn("{}Skipping retry-without-waiting.", logID);
					throw ex;
				}
			} catch (Exception ex2) {
				throw new White_SeleniumFrameworkException("Error while looking for the element with locator [" + locator + "]", ex);
			}
			
		} catch (Exception ex) {
			log().debug("{}Couldn't obtain the element.", logID);
			log().trace("{}Is dirty and wasn't me who got it dirty?", logID);
			if (!skipRetryWithNoFrames && !defaultContentFocused() && (relativeNestedFrameNamesStructure == null || relativeNestedFrameNamesStructure.isEmpty())) {
				log().debug("{} I'll eat the exception and try again. Suppressed Exception: {}", logID, ex);
			} else {
				log().debug("{}Skipping-retry-With No Frames Won't try again.", logID);
				throw new White_SeleniumFrameworkException("Error while waiting for the elements to show up with locator:" + locator, ex);
			}
			
		} // exception occurred Retrying with no frames
		
		// skipRetryWithNoFrames always true. Didn't get it & is dirty and wasn't me who got it dirty?
		if (elements == null && !defaultContentFocused() && (relativeNestedFrameNamesStructure == null || relativeNestedFrameNamesStructure.isEmpty())) {
			log().debug("{}Switching to the main frame and trying again.", logID);
			try {
				
				driver().switchTo().defaultContent();
				defaultContentFocused(true); //to not dirty
				log().trace("{}Finish: Using Recursion", logID);
				elements = getElementsBy(locator, relativeNestedFrameNamesStructure, true, secsToWait, skipRetryWithoutWaiting, loadingDialogToWaitFor);
				
			} catch (Exception ex) {
				throw new White_SeleniumFrameworkException("Error while waiting for the element with locator:" + locator, ex);
			} //returns null if the `if-block` couldn't solve the problem.
		}
		
		return elements;
		
	}
	
}
