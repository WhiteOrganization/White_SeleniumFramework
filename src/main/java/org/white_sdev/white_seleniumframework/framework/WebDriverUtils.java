/*
 *  Filename:  WebDriverUtils.java
 *  Creation Date:  Dec 6, 2020
 *  Purpose:   
 *  Author:    Obed Vazquez
 *  E-mail:    obed.vazquez@gmail.com
 * 
 *  Web Version:https://creativecommons.org/licenses/by-nc-sa/4.0/legalcode
 *  *** ATTRIBUTION-NONCOMMERCIAL-SHAREALIKE 4.0 INTERNATIONAL (CC BY-NC-SA 4.0) ***
 * 
 * By exercising the Licensed Rights (defined below), You accept and agree to be bound by the terms and conditions of this 
 * Creative Commons Attribution-NonCommercial-ShareAlike 4.0 International Public License ("Public License"). To the extent this Public License may be interpreted as 
 * a contract, You are granted the Licensed Rights in consideration of Your acceptance of these terms and conditions, and the Licensor grants You such rights in 
 * consideration of benefits the Licensor receives from making the Licensed Material available under these terms and conditions.
 * 
 * Section 1 – Definitions.
 * 
 * Adapted Material means material subject to Copyright and Similar Rights that is derived from or based upon the Licensed Material and in which the Licensed Material 
 * is translated, altered, arranged, transformed, or otherwise modified in a manner requiring permission under the Copyright and Similar Rights held by the Licensor. 
 * For purposes of this Public License, where the Licensed Material is a musical work, performance, or sound recording, Adapted Material is always produced where the 
 * Licensed Material is synched in timed relation with a moving image.
 * Adapter's License means the license You apply to Your Copyright and Similar Rights in Your contributions to Adapted Material in accordance with the terms and 
 * conditions of this Public License.
 * BY-NC-SA Compatible License means a license listed at creativecommons.org/compatiblelicenses, approved by Creative Commons as essentially the equivalent of this 
 * Public License.
 * Copyright and Similar Rights means copyright and/or similar rights closely related to copyright including, without limitation, performance, broadcast, sound 
 * recording, and Sui Generis Database Rights, without regard to how the rights are labeled or categorized. For purposes of this Public License, the rights specified 
 * in Section 2(b)(1)-(2) are not Copyright and Similar Rights.
 * Effective Technological Measures means those measures that, in the absence of proper authority, may not be circumvented under laws fulfilling obligations under 
 * Article 11 of the WIPO Copyright Treaty adopted on December 20, 1996, and/or similar international agreements.
 * Exceptions and Limitations means fair use, fair dealing, and/or any other exception or limitation to Copyright and Similar Rights that applies to Your use of the 
 * Licensed Material.
 * License Elements means the license attributes listed in the name of a Creative Commons Public License. The License Elements of this Public License are Attribution, 
 * NonCommercial, and ShareAlike.
 * Licensed Material means the artistic or literary work, database, or other material to which the Licensor applied this Public License.
 * Licensed Rights means the rights granted to You subject to the terms and conditions of this Public License, which are limited to all Copyright and Similar Rights 
 * that apply to Your use of the Licensed Material and that the Licensor has authority to license.
 * Licensor means the individual(s) or entity(ies) granting rights under this Public License.
 * NonCommercial means not primarily intended for or directed towards commercial advantage or monetary compensation. For purposes of this Public License, the exchange 
 * of the Licensed Material for other material subject to Copyright and Similar Rights by digital file-sharing or similar means is NonCommercial provided there is no 
 * payment of monetary compensation in connection with the exchange.
 * Share means to provide material to the public by any means or process that requires permission under the Licensed Rights, such as reproduction, public display, 
 * public performance, distribution, dissemination, communication, or importation, and to make material available to the public including in ways that members of the 
 * public may access the material from a place and at a time individually chosen by them.
 * Sui Generis Database Rights means rights other than copyright resulting from Directive 96/9/EC of the European Parliament and of the Council of 11 March 1996 on 
 * the legal protection of databases, as amended and/or succeeded, as well as other essentially equivalent rights anywhere in the world.
 * You means the individual or entity exercising the Licensed Rights under this Public License. Your has a corresponding meaning.
 * Section 2 – Scope.
 * 
 * License grant.
 * Subject to the terms and conditions of this Public License, the Licensor hereby grants You a worldwide, royalty-free, non-sublicensable, non-exclusive, irrevocable 
 * license to exercise the Licensed Rights in the Licensed Material to:
 * reproduce and Share the Licensed Material, in whole or in part, for NonCommercial purposes only; and
 * produce, reproduce, and Share Adapted Material for NonCommercial purposes only.
 * Exceptions and Limitations. For the avoidance of doubt, where Exceptions and Limitations apply to Your use, this Public License does not apply, and You do not need 
 * to comply with its terms and conditions.
 * Term. The term of this Public License is specified in Section 6(a).
 * Media and formats; technical modifications allowed. The Licensor authorizes You to exercise the Licensed Rights in all media and formats whether now known or 
 * hereafter created, and to make technical modifications necessary to do so. The Licensor waives and/or agrees not to assert any right or authority to forbid You 
 * from making technical modifications necessary to exercise the Licensed Rights, including technical modifications necessary to circumvent Effective Technological 
 * Measures. For purposes of this Public License, simply making modifications authorized by this Section 2(a)(4) never produces Adapted Material.
 * Downstream recipients.
 * Offer from the Licensor – Licensed Material. Every recipient of the Licensed Material automatically receives an offer from the Licensor to exercise the Licensed 
 * Rights under the terms and conditions of this Public License.
 * Additional offer from the Licensor – Adapted Material. Every recipient of Adapted Material from You automatically receives an offer from the Licensor to exercise 
 * the Licensed Rights in the Adapted Material under the conditions of the Adapter’s License You apply.
 * No downstream restrictions. You may not offer or impose any additional or different terms or conditions on, or apply any Effective Technological Measures to, the 
 * Licensed Material if doing so restricts exercise of the Licensed Rights by any recipient of the Licensed Material.
 * No endorsement. Nothing in this Public License constitutes or may be construed as permission to assert or imply that You are, or that Your use of the Licensed 
 * Material is, connected with, or sponsored, endorsed, or granted official status by, the Licensor or others designated to receive attribution as provided in 
 * Section 3(a)(1)(A)(i).
 * 
 * Other rights.
 * 
 * Moral rights, such as the right of integrity, are not licensed under this Public License, nor are publicity, privacy, and/or other similar personality rights; 
 * however, to the extent possible, the Licensor waives and/or agrees not to assert any such rights held by the Licensor to the limited extent necessary to allow You 
 * to exercise the Licensed Rights, but not otherwise.
 * Patent and trademark rights are not licensed under this Public License.
 * To the extent possible, the Licensor waives any right to collect royalties from You for the exercise of the Licensed Rights, whether directly or through a 
 * collecting society under any voluntary or waivable statutory or compulsory licensing scheme. In all other cases the Licensor expressly reserves any right to 
 * collect such royalties, including when the Licensed Material is used other than for NonCommercial purposes.
 * Section 3 – License Conditions.
 * 
 * Your exercise of the Licensed Rights is expressly made subject to the following conditions.
 * 
 * Attribution.
 * 
 * If You Share the Licensed Material (including in modified form), You must:
 * 
 * retain the following if it is supplied by the Licensor with the Licensed Material:
 * identification of the creator(s) of the Licensed Material and any others designated to receive attribution, in any reasonable manner requested by the Licensor 
 * (including by pseudonym if designated);
 * a copyright notice;
 * a notice that refers to this Public License;
 * a notice that refers to the disclaimer of warranties;
 * a URI or hyperlink to the Licensed Material to the extent reasonably practicable;
 * indicate if You modified the Licensed Material and retain an indication of any previous modifications; and
 * indicate the Licensed Material is licensed under this Public License, and include the text of, or the URI or hyperlink to, this Public License.
 * You may satisfy the conditions in Section 3(a)(1) in any reasonable manner based on the medium, means, and context in which You Share the Licensed Material. 
 * For example, it may be reasonable to satisfy the conditions by providing a URI or hyperlink to a resource that includes the required information.
 * If requested by the Licensor, You must remove any of the information required by Section 3(a)(1)(A) to the extent reasonably practicable.
 * ShareAlike.
 * In addition to the conditions in Section 3(a), if You Share Adapted Material You produce, the following conditions also apply.
 * 
 * The Adapter’s License You apply must be a Creative Commons license with the same License Elements, this version or later, or a BY-NC-SA Compatible License.
 * You must include the text of, or the URI or hyperlink to, the Adapter's License You apply. You may satisfy this condition in any reasonable manner based on the 
 * medium, means, and context in which You Share Adapted Material.
 * You may not offer or impose any additional or different terms or conditions on, or apply any Effective Technological Measures to, Adapted Material that restrict 
 * exercise of the rights granted under the Adapter's License You apply.
 * Section 4 – Sui Generis Database Rights.
 * 
 * Where the Licensed Rights include Sui Generis Database Rights that apply to Your use of the Licensed Material:
 * 
 * for the avoidance of doubt, Section 2(a)(1) grants You the right to extract, reuse, reproduce, and Share all or a substantial portion of the contents of the 
 * database for NonCommercial purposes only;
 * if You include all or a substantial portion of the database contents in a database in which You have Sui Generis Database Rights, then the database in which You 
 * have Sui Generis Database Rights (but not its individual contents) is Adapted Material, including for purposes of Section 3(b); and
 * You must comply with the conditions in Section 3(a) if You Share all or a substantial portion of the contents of the database.
 * For the avoidance of doubt, this Section 4 supplements and does not replace Your obligations under this Public License where the Licensed Rights include other 
 * Copyright and Similar Rights.
 * Section 5 – Disclaimer of Warranties and Limitation of Liability.
 * 
 * Unless otherwise separately undertaken by the Licensor, to the extent possible, the Licensor offers the Licensed Material as-is and as-available, and makes no 
 * representations or warranties of any kind concerning the Licensed Material, whether express, implied, statutory, or other. This includes, without limitation, 
 * warranties of title, merchantability, fitness for a particular purpose, non-infringement, absence of latent or other defects, accuracy, or the presence or absence 
 * of errors, whether or not known or discoverable. Where disclaimers of warranties are not allowed in full or in part, this disclaimer may not apply to You.
 * To the extent possible, in no event will the Licensor be liable to You on any legal theory (including, without limitation, negligence) or otherwise for any direct, 
 * special, indirect, incidental, consequential, punitive, exemplary, or other losses, costs, expenses, or damages arising out of this Public License or use of the 
 * Licensed Material, even if the Licensor has been advised of the possibility of such losses, costs, expenses, or damages. Where a limitation of liability is not 
 * allowed in full or in part, this limitation may not apply to You.
 * The disclaimer of warranties and limitation of liability provided above shall be interpreted in a manner that, to the extent possible, most closely approximates an 
 * absolute disclaimer and waiver of all liability.
 * Section 6 – Term and Termination.
 * 
 * This Public License applies for the term of the Copyright and Similar Rights licensed here. However, if You fail to comply with this Public License, then Your 
 * rights under this Public License terminate automatically.
 * Where Your right to use the Licensed Material has terminated under Section 6(a), it reinstates:
 * 
 * automatically as of the date the violation is cured, provided it is cured within 30 days of Your discovery of the violation; or
 * upon express reinstatement by the Licensor.
 * For the avoidance of doubt, this Section 6(b) does not affect any right the Licensor may have to seek remedies for Your violations of this Public License.
 * For the avoidance of doubt, the Licensor may also offer the Licensed Material under separate terms or conditions or stop distributing the Licensed Material at any 
 * time; however, doing so will not terminate this Public License.
 * Sections 1, 5, 6, 7, and 8 survive termination of this Public License.
 * Section 7 – Other Terms and Conditions.
 * 
 * The Licensor shall not be bound by any additional or different terms or conditions communicated by You unless expressly agreed.
 * Any arrangements, understandings, or agreements regarding the Licensed Material not stated herein are separate from and independent of the terms and conditions of 
 * this Public License.
 * Section 8 – Interpretation.
 * 
 * For the avoidance of doubt, this Public License does not, and shall not be interpreted to, reduce, limit, restrict, or impose conditions on any use of the Licensed 
 * Material that could lawfully be made without permission under this Public License.
 * To the extent possible, if any provision of this Public License is deemed unenforceable, it shall be automatically reformed to the minimum extent necessary to make 
 * it enforceable. If the provision cannot be reformed, it shall be severed from this Public License without affecting the enforceability of the remaining terms and 
 * conditions.
 * No term or condition of this Public License will be waived and no failure to comply consented to unless expressly agreed to by the Licensor.
 * Nothing in this Public License constitutes or may be interpreted as a limitation upon, or waiver of, any privileges and immunities that apply to the Licensor or 
 * You, including from the legal processes of any jurisdiction or authority.
 * 
 * Creative Commons may be contacted at creativecommons.org.
 */

package org.white_sdev.white_seleniumframework.framework;


import java.io.File;
import java.util.Collection;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.white_sdev.propertiesmanager.model.service.PropertyProvider.getProperty;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.white_sdev.white_seleniumframework.exceptions.White_SeleniumFrameworkException;
import static org.white_sdev.white_validations.parameters.ParameterValidator.notNullValidation;

/**
 * 
 * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
 * @since Dec 6, 2020
 */
@Slf4j
public class WebDriverUtils {
    
    
    //<editor-fold defaultstate="collapsed" desc="Attributes">

    /**
     * The default {@link WebDriver driver} of the calling class to manage all interactions.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-02-24
     */
    public WebDriver driver;

    /**
     * This is used by the method {@link #normalize(java.lang.String) } to improve the performance of the normalization process.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-06
     */
    public static String tabber=null;
    
    public Boolean defaultContentFocused=true;
    
    public static Integer screenShootCounter=1;
    
    public Actions action = null;
    
    public Integer defaultSecsToWaitForElements=null;
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    
    /**
     * Default Constructor
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since Feb 24, 2019
     * @param driver {@link WebDriver drier} of the Class is using this Util.
     */
    public WebDriverUtils(WebDriver driver) {
	this.driver = driver;
    }

    public Integer getDefaultSecondsToWaitForElements() {
	log.trace("::getDefaultSecondsToWaitForElements() - Start: ");
	try {
	    
	    if(defaultSecsToWaitForElements==null){
		try{
		    String propertiesSecs=getProperty("default-explicit-wait");
		    defaultSecsToWaitForElements=propertiesSecs!=null?Integer.parseInt(propertiesSecs):null;
		}catch(Exception ex){
		    log.error("::getDefaultSecondsToWaitForElements(): Imposible to obtain the default seconds to wait from the properties files. Defaulting to 0");
		}
	    }
	    log.trace("::getDefaultSecondsToWaitForElements() - Finish: ");
	    return defaultSecsToWaitForElements!=null?defaultSecsToWaitForElements:0;
	    
	} catch (Exception e) {
	    throw new White_SeleniumFrameworkException("Impossible to Obtain the default seconds to wait when looking for elements.", e);
	}
    }

    //<editor-fold defaultstate="collapsed" desc="Actions">
    //<editor-fold defaultstate="collapsed" desc="No Wait Bridges|Overloaded">
    //TODO OV: Generate documentation for all methods.
    public void clickId(String id) {
	clickId(id, null,null);
    }
    
    public void clickId(String id, Collection<String> nestedFrameNamesStructure) {
	clickId( id, nestedFrameNamesStructure, null);
    }
    
    public void clickName(String name) {
	clickName(name, null, null);
    }

    public void clickName(String name, Collection<String> nestedFrameNamesStructure) {
	clickName( name, nestedFrameNamesStructure, null);
    }
    
    public void clickXpath(String xpath) {
	clickXpath(xpath, null, null);
    }

    public void clickXpath(String xpath, Collection<String> nestedFrameNamesStructure) {
	clickXpath( xpath, nestedFrameNamesStructure, null);
    }
    
    
    
    
//</editor-fold>
    
	//<editor-fold defaultstate="collapsed" desc="Click">

    public void clickId(String id, Integer secsToWait){
	clickId( id, null, secsToWait);
    }
    
    public void clickId(String id,Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
	log.trace("clickId(id,frameNamesStructure,secsToWait) - Start","Clicking.");
	if (id == null) return;
	try {

	    if(nestedFrameNamesStructure!=null) focus(nestedFrameNamesStructure,secsToWait);
	    click(By.id(id), secsToWait);

	    log.trace("clickId(id,frameNamesStructure,secsToWait) - Finish","Clicked.");
	} catch (Exception ex) {
	    if(!defaultContentFocused && (nestedFrameNamesStructure==null || nestedFrameNamesStructure.isEmpty())){ //is dirty and wasn't me who got it dirty?
		try{
		    log.warn("clickId(id,frameNamesStructure,secsToWait)","Couln't click the element, switching to the main frame and trying again.");
		    driver.switchTo().defaultContent();
		    defaultContentFocused=true;
		    clickId(id,secsToWait);
		    return;
		}catch(Exception ex2){}//couln't handle it, throw of exception couln't be avoided.
	    }
	    throw new White_SeleniumFrameworkException("Unable to click the Button or Link:" + id, ex);
	}
    }

    public void clickName(String name, Integer secsToWait) {
	clickName( name, null, secsToWait);
    }
    
    public void clickName(String name,Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
	log.trace("clickName(name,frameNamesStructure,secsToWait) - Start","Clicking.");
	if (name == null) return;
	try {
	    if(nestedFrameNamesStructure!=null) focus(nestedFrameNamesStructure,secsToWait);
	    click(By.name(name), secsToWait);

	    log.trace("clickName(name,frameNamesStructure,secsToWait) - Finish","Clicked.");
	} catch (Exception ex) {
	    if(!defaultContentFocused && (nestedFrameNamesStructure==null || nestedFrameNamesStructure.isEmpty())){ //is dirty and wasn't me who got it dirty?
		try{
		    log.warn("clickName(name,frameNamesStructure,secsToWait)"," Couln't click the element, switching to the main frame and trying again.");
		    driver.switchTo().defaultContent();
		    defaultContentFocused=true;
		    clickName(name,secsToWait);
		    return;
		}catch(Exception ex2){}//couln't handle it, throw of exception couln't be avoided.
	    }
	    throw new White_SeleniumFrameworkException("Unable to click the Button or Link with name:" + name, ex);
	}
    }

    
    public void clickClass(String cssClass) {
	clickClass(cssClass,null,null);
    }
    
    public void clickClass(String css, Collection<String> nestedFrameNamesStructure) {
	clickClass( css, nestedFrameNamesStructure, null);
    }
    
    public void clickClass(String cssClass, Integer secsToWait) {
	clickClass(cssClass,null,secsToWait);
    }
    
    public void clickClass(String cssClass,Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
	log.trace("clickClass(css,frameNamesStructure,secsToWait) - Start","Clicking.");
	if (cssClass == null) return;
	try {
	    
	    if(nestedFrameNamesStructure!=null) focus(nestedFrameNamesStructure,secsToWait);
	    click(By.className(cssClass), secsToWait);

	    log.trace("::clickClass(css,frameNamesStructure,secsToWait) - Finish","Clicked.");
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Unable to click the Button or Link with class name:" + cssClass, ex);
	}
    }
    
    public void clickClass(String cssClass, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait, Boolean skipRetryWithoutWaiting){
	log.trace("clickClass(cssClass, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Clicking.");
	try {
	    
	    WebElement element=getElementBy(By.className(cssClass),relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
	    element.click();
	    log.trace("::clickClass(cssClass, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Finish: Clicked.");
	    
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Unable to click the Button or Link with class name: " + cssClass, ex);
	}
    }
    

    /**
     * Clicks the element once it founds it by waiting for it to show up and obtaining it from the page with the provided xpath. 
     * This is a bridge method to {@link #clickXpath(java.lang.String, java.util.Collection, java.lang.Integer) } it sets up the nestedFrameNamesStructure as null.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath			the xpath to locate the element to write to.
     * @param secsToWait		the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with 
					default-explicit-waitFor property) if null.
     */
    public void clickXpath(String xpath, Integer secsToWait) {
	clickXpath( xpath, null, secsToWait);
    }
    
    /**
     * Clicks the element once it founds it by waiting for it to show up and obtaining it from the page with the provided xpath. 
     * This is a bridge method to {@link #click(org.openqa.selenium.By, java.lang.Integer) } in a way setting up the {@link By#tagName(java.lang.String)} element.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath			the xpath to locate the element to write to.
     * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
     * @param secsToWait		the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with 
					default-explicit-waitFor property) if null.
     */
    public void clickXpath(String xpath,Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
	log.trace("clickXpath(xpath,frameNamesStructure,secsToWait) - Start","Clicking.");
	if (xpath == null) return;
	try {

	    if(nestedFrameNamesStructure!=null) focus(nestedFrameNamesStructure,secsToWait);
	    click(By.xpath(xpath), secsToWait);

	    log.trace("::clickXpath(xpath,frameNamesStructure,secsToWait) - Finish","Clicked.");
	} catch (Exception ex) {
	    if(!defaultContentFocused && (nestedFrameNamesStructure==null || nestedFrameNamesStructure.isEmpty())){ //is dirty and wasn't me who got it dirty?
		try{
		    log.warn("clickClass(css,frameNamesStructure,secsToWait)","Couln't click the element, switching to the main frame and trying again.");
		    driver.switchTo().defaultContent();
		    defaultContentFocused=true;
		    clickXpath(xpath,secsToWait);
		    return;
		}catch(Exception ex2){}//couln't handle it, throw of exception couln't be avoided.
	    }
	    throw new White_SeleniumFrameworkException("Unable to click the Button or Link with xpath:" + xpath, ex);
	}
    }

    public void clickLinkText(String linkText){
	clickLinkText(linkText,null, null, null, null);
    }
    
    public void clickLinkText(String linkText, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait, Boolean skipRetryWithoutWaiting){
	click(By.linkText(linkText),relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
    }
    
    public void click(By locator){
	log.trace("click(locator) - Start: Bridging.");
	click(locator,null,null,null,null);
    }
    
    /**
     * clicks the element once it founds it by waiting for it to show up and obtaining it from the page with the provided {@link By locator}. 
     * This method is used by several methods as the point where they all converge and in that sense the rest of the methods work as a bridge for this  
     * (For example {@link #clickId(java.lang.String, java.util.Collection, java.lang.Integer)} method will call this method by doing <code>click(By.id(id),secs)</code> ). 
     * But they add an extra layer of logic on top of the simple click method. 
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param locator	    the {@link By} object to locate the element to click.
     * @param secsToWait    the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     */
    public void click(By locator, Integer secsToWait) {
	log.trace("click(locator,secsToWait) - Start: Bridging.");
	click(locator,null,null,secsToWait,null);
    }

    public void click(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
	log.trace("::click(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: ");
	try{
	    getElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting).click();
	}catch(Exception ex){
	    throw new White_SeleniumFrameworkException("Unable to click the element",ex);
	}
    }
    
    public void clickText(String text){
	clickText(text,null,null,null,null);
    }
    
    public void clickText(String text, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait, Boolean skipRetryWithoutWaiting){
	try{
	    WebElement element=getElementByText(text,relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
	    element.click();
	}catch(Exception ex){
	    throw new White_SeleniumFrameworkException("Unable to click the element",ex);
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
     * that sets up {@code secsToWait} & {@code nestedFrameNamesStructure} as {@code null}.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param id			the id to locate the element to write to.
     * @param keys			The keys or {@link String text} to send to the element (usually an input) on the page.
     * @throws White_SeleniumFrameworkException When a generic error is found.
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
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param id			the id to locate the element to write to.
     * @param keys			The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public void writeId(String id, String keys, Collection<String> nestedFrameNamesStructure){
	 writeId(id,keys,nestedFrameNamesStructure,null);
    }
    
     /**
     * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page 
     * with the provided id. 
     * This is a Bridge method of {@link #writeId(java.lang.String, java.lang.String, java.util.Collection, java.lang.Integer)} 
     * that sets up {@code nestedFrameNamesStructure} as {@code null}.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param id			the id to locate the element to write to.
     * @param keys			The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param secsToWait		the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with 
					default-explicit-waitFor property) if null.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public void writeId(String id, String keys, Integer secsToWait){
	 writeId(id,keys,null,secsToWait);
    }
    
    /**
     * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page 
     * with the provided id. 
     * This is a bridge method to {@link #write(org.openqa.selenium.By, java.lang.String, java.lang.Integer) } in a way setting up the {@link By#tagName(java.lang.String)} element.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param id			the id to locate the element to write to.
     * @param keys			The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
     * @param secsToWait		the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with 
					default-explicit-waitFor property) if null.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public void writeId(String id, String keys,Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
	log.trace("writeId(id,keys,frameNamesStructure,secsToWait) - Start","writing.");
	try {
	    if (id == null) return;
	    if (keys == null) keys = "";

	    if(nestedFrameNamesStructure!=null) focus(nestedFrameNamesStructure,secsToWait);
	    write(By.id(id), keys, secsToWait);

	    log.trace("::writeId(id,keys,frameNamesStructure,secsToWait) - Finish","Writed.");
	} catch (Exception ex) {
	    if(!defaultContentFocused && (nestedFrameNamesStructure==null || nestedFrameNamesStructure.isEmpty())){ //is dirty and wasn't me who got it dirty?
		try{
		    log.warn("getElementByName(name,frameNamesStructure,secsToWait)","Couln't write on the element by name, switching to the main frame and trying again.");
		    driver.switchTo().defaultContent();
		    defaultContentFocused=true;
		    writeId(id,keys,secsToWait);
		    return;
		}catch(Exception ex2){}//couln't handle it, throw of exception couln't be avoided.
	    }
	    throw new White_SeleniumFrameworkException("Unable to write in element (Input?) with Id: " + id, ex);
	}
    }
    
    /**
     * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page 
     * with the provided name. 
     * This is a bridge method to {@link #writeName(java.lang.String, java.lang.String, java.util.Collection, java.lang.Integer)} 
     * with {@code nestedFrameNamesStructure} & {@code secsToWait} as {@code null}.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param name			the name to locate the element to write to.
     * @param keys			The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public void writeName(String name, String keys,Collection<String> nestedFrameNamesStructure){
	log.trace("writeName(name,keys,nestedFrameNamesStructure) - Start: Bridging");
	writeName(name,keys,nestedFrameNamesStructure,null);
    }
    
    /**
     * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page 
     * with the provided name. 
     * This is a bridge method to {@link #writeName(java.lang.String, java.lang.String, java.util.Collection, java.lang.Integer)} 
     * with {@code nestedFrameNamesStructure} & {@code secsToWait} as {@code null}.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param name			the name to locate the element to write to.
     * @param keys			The keys or {@link String text} to send to the element (usually an input) on the page.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public void writeName(String name, String keys) {
	log.trace("writeName(name,keys) - Start: Bridging");
	writeName(name, keys, null, null);
    }

    /**
     * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page 
     * with the provided name. 
     * This is a bridge method to {@link #writeName(java.lang.String, java.lang.String, java.util.Collection, java.lang.Integer)} with {@code nestedFrameNamesStructure} as {@code null}.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param name			the name to locate the element to write to.
     * @param keys			The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param secsToWait		the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with 
					default-explicit-waitFor property) if null.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public void writeName(String name, String keys, Integer secsToWait){
	log.trace("writeName(name,keys,secsToWait) - Start: Bridging");
	writeName(name, keys,null, secsToWait);
    }
    
    /**
     * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page 
     * with the provided name. 
     * This particular method does not use {@link #write(org.openqa.selenium.By, java.lang.String, java.lang.Integer) } like its siblings.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param name			the name to locate the element to write to.
     * @param keys			The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
     * @param secsToWait		the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with 
					default-explicit-waitFor property) if null.
     */
    public void writeName(String name, String keys,Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
	log.trace("writeName(name,keys,frameNamesStructure,secsToWait) - Start","writing.");
	if (name == null) return;

	try{
	    WebElement input;
	    try {

		if(nestedFrameNamesStructure!=null) focus(nestedFrameNamesStructure,secsToWait);
		input = getElementByName(name, secsToWait);

	    } catch (Exception ex) {
		input = null;
	    }

	    if (input == null) {
		try {
		    log.warn("getElementByName(name,frameNamesStructure,secsToWait)","Couln't find the element by name looking for it wih XPath. Name: "+ name);
		    //driver.switchTo().frame("main"); //this should be done by the method getElementBy(locator,secsToWait)
		    input = getElementByXPath("//input[@name='" + name + "']", secsToWait);
		} catch (Exception ex) {
		    input = null;
		    if(!defaultContentFocused && (nestedFrameNamesStructure==null || nestedFrameNamesStructure.isEmpty())){ //is dirty and wasn't me who got it dirty?
			log.warn("getElementByName(name,frameNamesStructure,secsToWait)","Couln't find the element by XPath, switching to the main frame and trying again.");
			driver.switchTo().defaultContent();
			defaultContentFocused=true;
			writeName(name,keys,secsToWait);
			return;
		    }

		}
	    }
	    
	    input.sendKeys(keys);
	    log.trace("writeName(name,keys,frameNamesStructure,secsToWait) - Finish","keys sent.");
	    
	}catch(Exception ex){
	    throw new White_SeleniumFrameworkException("Unable to write in element (Input?) with Name: " + name, ex);
	}
    }

    /**
     * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page 
     * with the provided CSS class. 
     * This is a bridge method to {@link #writeCSS(java.lang.String, java.lang.String, java.lang.Integer) } with {@code secsToWait} as {@code null}.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param css	    the CSS class to locate the element to write to.
     * @param keys	    The keys or {@link String text} to send to the element (usually an input) on the page.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public void writeCSS(String css, String keys) {
	log.trace("writeCSS(css,keys) - Start: Bridging");
	writeCSS(css,keys,null);
    }
    
    /**
     * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page 
     * with the provided CSS class. 
     * This is a bridge method to {@link #write(org.openqa.selenium.By, java.lang.String, java.lang.Integer) } in a way setting up the {@link By#tagName(java.lang.String)} element.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param css	    the CSS class to locate the element to write to.
     * @param keys	    The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param secsToWait    the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public void writeCSS(String css, String keys, Integer secsToWait) {
	log.trace("writeCSS(css,keys,secsToWait) - Start","writing.");
	if (css == null) return;
	try {
	    write(By.cssSelector(css), keys, secsToWait);

	    log.trace("::writeCSS(name,keys,secsToWait) - Finish","keys sent.");
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Unable to write in element (Input?) with CSS: " + css, ex);
	}
    }

    /**
     * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page 
     * with the default tag <code>input</code>. 
     * This is a Bridge method of {@link #writeTag(java.lang.String, java.lang.String, java.lang.Integer)} that sets up the tagName as "input".
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param keys			The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param secsToWait		the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with 
					default-explicit-waitFor property) if null.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public void writeTag(String keys, Integer secsToWait) {
	writeTag("input", keys, secsToWait);
    }

    /**
     * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page 
     * with the provided tag. 
     * This is a bridge method to {@link #write(org.openqa.selenium.By, java.lang.String, java.lang.Integer) } in a way setting up the {@link By#tagName(java.lang.String)} element.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param tagName	    the tag to locate the element to write to.
     * @param keys	    The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param secsToWait    the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public void writeTag(String tagName, String keys, Integer secsToWait) {
	log.trace("::writeTag(css,keys,secsToWait) - Start","writing.");
	if (tagName == null) return;
	try {
	    write(By.tagName(tagName), keys, secsToWait);

	    log.trace("::writeTag(name,keys,secsToWait) - Finish","keys sent.");
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Unable to write in element (Input?) with Tag: " + tagName, ex);
	}
    }

    /**
     * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page 
     * with the provided {@code xPath}. 
     * This is a bridge method to {@link #write(org.openqa.selenium.By, java.lang.String, java.lang.Integer) } in a way setting up the {@link By#tagName(java.lang.String)} element.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath	    The {@code xPath} to locate the element to write to.
     * @param keys	    The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param secsToWait    the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public void writeXPath(String xpath, String keys, Integer secsToWait) {
	log.trace("::writeXPath(css,keys,secsToWait) - Start","writing.");
	if (xpath == null) return;
	try {
	    write(By.xpath(xpath), keys, secsToWait);

	    log.trace("::writeXPath(name,keys,secsToWait) - Finish","keys sent.");
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
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param locator	    the {@link By} object to locate the element to obtain the text from.
     * @param keys	    The key or {@link String text} to send to the element (usually an input) on the page.
     * @param secsToWait    the seconds to waitFor for the element to show up in the page; uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public void write(By locator, String keys, Integer secsToWait) {
	log.trace("::write(input,keys,secsToWait) - Start","Clicking.");
	try {
	    if (locator == null) return;
	    if (keys == null) keys = "";

	    WebElement input = getElementBy(locator, secsToWait);
	    input.sendKeys(keys);

	    log.trace("::write(id,keys,secsToWait) - Finish","Writed.");
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Unable to write in element (Input?) with locator: " + locator, ex);
	}

    }
    
    //</editor-fold>
    
    public String textFromXpath(String xpath) {
	return getTextFromXpath(xpath, null, null,null,null);
    }
    
    public String textFromXpath(String xpath, Collection<String> nestedFrameNamesStructure) {
	return getTextFromXpath( xpath, nestedFrameNamesStructure,null, null,null);
    }
    
    /**
     * It will obtain the containing (link) text inside of the [tag]element with the xpath specified. This is a bridge method that sets up the nestedFrameNamesStructure as null
     * while calling the method {@link #textFromXpath(java.lang.String, java.util.Collection, java.lang.Integer) }
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath	    the xpath to locate the element to obtain the text from.
     * @param secsToWait    the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @return		    The text of the found element with the {@link By locator}
     */
    public String getTextFromXpath(String xpath, Integer secsToWait) {
	return getTextFromXpath( xpath, null,null, secsToWait,null);
    }
    
    /**
     * It will obtain the containing (link) text inside of the [tag]element with the {@code xPath} specified.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath	    The {@code xPath} to locate the element to obtain the text from.
     * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
     * @param secsToWait    the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @return		    The text of the found element with the {@link By locator}
     */
    public String getTextFromXpath(String xpath,Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
	log.trace("::textFromXpath(xpath,frameNamesStructure,secsToWait) - Start: Bridging.");
	return getTextFromXpath( xpath, nestedFrameNamesStructure,null, secsToWait,null);
    }
    
    public String getTextFromXpath(String xpath, Collection<String> nestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait, Boolean skipRetryWithoutWaiting){
	try{
	    return getTextFrom(By.xpath(xpath),nestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
	}catch(Exception ex){
	    throw new White_SeleniumFrameworkException("Unable to obtain text from element with xPath: " + xpath, ex);
	}
    }
	    
    
    
    /**
     * Will obtain the containing text inside of the element with the {@link By locator} specified.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param locator	    the {@link By} object to locate the element to obtain the text from.
     * @param secsToWait    the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @return		    The text of the found element with the {@link By locator}
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public String getTextFrom(By locator, Integer secsToWait) {
	log.trace("::text(locator,secsToWait) - Start","Getting text from element.");
	try {
	    if (locator == null) return null;

	    WebElement label = getElementBy(locator, secsToWait);
	    String text=label.getText(); 
	    log.trace("::text(locator,secsToWait) - Finish","Text Obtained.");
	    return text;

	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Unable to obtain text from element with locator: " + locator, ex);
	}

    }

    /**
     * Will obtain the containing text inside of the element with the {@link By locator} specified; If the {@code nestedFrameNamesStructure} parameter is provided 
     * this Method will try to focus on the last frame specified in the {@code structure} and then attempt to obtain the element's text. If the first attempt resulted in 
     * {@code null} or threw an exception it will attempt to get the element without the {@code nestedFrameNamesStructure} if the parameter {@code retryInCaseOfError} is true
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param locator			The {@link By} object to locate the element to obtain the text from.
     * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. Will not switch of focus if {@code null}.
     * @param skypRetryWithNoFrames	Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the first attempt. 
     *					Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
     *					{code false} if {@code null}
     * @param secsToWait		The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
					default-explicit-waitFor property) if null.
     * @param skipRetryWithoutWaiting	Should the method try again without the Nested Frames Structure on the second time in case of an error on the first attempt. 
     *					{code false} if {@code null}
     * @return	    A {@link String} with the text inside the found element with the given {@link By locator} or {@code null} if the element with that locator was not found.
     * @throws White_SeleniumFrameworkException When a generic error is found.
     */
    public String getTextFrom(By locator, Collection<String> nestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
	log.trace("::getTextFrom(locator, nestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Getting text from element.");
	
	try {
	    
	    WebElement label = getElementBy(locator, nestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
	    return label.getText(); 
	    
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Unable to obtain text from element with locator: " + locator, ex);
	}
    }
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getElementBySpecific() Methods">
    
	//<editor-fold defaultstate="collapsed" desc="Single">

    /**
     * Obtains an element from the page by its {@code CSS class} name. It will wait the seconds specified for the element to show up, how it waits is specified in the method 
     * it uses to accomplish this {@link #wait() }.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param name	    the name to locate the element to obtain
     * @return		    The found element with the name
     * @throws White_SeleniumFrameworkException in case the element is not found.
     */
    public WebElement getElementByClassName(String name) {
	log.trace("::getElementByClassName(name) - Start: Bridging.");
	return getElementByClassName(name,null);
    }
    
    /**
     * Obtains an element from the page by its {@code CSS class} name. It will wait the seconds specified for the element to show up, how it waits is specified in the method 
     * it uses to accomplish this {@link #wait() }.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param name	    the name to locate the element to obtain
     * @param secsToWait    the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @return		    The found element with the name
     * @throws White_SeleniumFrameworkException in case the element is not found.
     */
    public WebElement getElementByClassName(String name, Integer secsToWait) {
	log.trace("::getElementByName(name,secsToWait) - Start","retrieving element.");
	if (name == null) return null;
	try {
	    return getElementBy(By.className(name), secsToWait);
	} catch (Exception ex) {
	    log.debug("::getElementByName(name,secsToWait): Unable to obtain element by name: {}",name);
	    return null;
	}
    }
    
    /**
     * Obtains an element from the page by its name. It will wait the seconds specified for the element to show up, how it waits is specified in the method 
     * it uses to accomplish this {@link #wait() }. This is a bridge method that will set the seconds to waitFor as null while calling the method 
 {@link #getElementByName(java.lang.String, java.lang.Integer) }
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param name	    the name to locate the element to obtain
     * @return		    The found element with the name
     * @see WebDriverUtils#getElementByName(java.lang.String, java.lang.Integer)  
     */
    public WebElement getElementByName(String name) {
	return getElementByName(name, null);
    }

    /**
     * Obtains an element from the page by its name. It will wait the seconds specified for the element to show up, how it waits is specified in the method 
     * it uses to accomplish this {@link #wait() }.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param name	    the name to locate the element to obtain
     * @param secsToWait    the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @return		    The found element with the name
     */
    public WebElement getElementByName(String name, Integer secsToWait) {
	log.trace("::getElementByName(name,secsToWait) - Start","retrieving element.");
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
	log.trace("::getElementByName(name,secsToWait) - Finish","returning element.");
	return element;
    }

    /**
     * Obtains an element from the page by its tag. 
     * This is a bridge method that will call the {@link #getElementByTag(java.lang.String, java.lang.Integer)} method with the parameter {@code secondsToWait} as {@code null}.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param tagName	    the tag to locate the element to obtain
     * @return		    The found element with the tag
     */
    public WebElement getElementByTag(String tagName) {
	log.trace("::getElementByTag(tagName) - Bridging:");
	return getElementByTag(tagName, null);

    }

    /**
     * Obtains an element from the page by its tag. It will wait the seconds specified for the element to show up, how it waits is specified in the method 
     * it uses to accomplish this {@link #wait() }.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param tagName	    the tag to locate the element to obtain
     * @param secsToWait    the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @return		    The found element with the tag
     */
    public WebElement getElementByTag(String tagName, Integer secsToWait) {
	log.trace("::getElementByTag(tagName,secsToWait) - Start","retrieving element.");
	if (tagName == null) return null;
	try {

	    WebElement webElement = getElementBy(By.tagName(tagName), secsToWait);

	    log.trace("::getElementByTag(tagName,secsToWait) - Finish","returning element.");
	    return webElement;
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Impossible to obtain the element with the Tag provided", ex);
	}

    }

    /**
     * Obtains an element from the page by its {@code CSS}. For example {@code By.cssSelector("input[name='first_name']")}.
     * This is a bridge method that will call the {@link #getElementByCSS(java.lang.String, java.lang.Integer) } method with the parameter {@code secondsToWait} as {@code null}.
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param css	    the {@code CSS} class name to locate the element to obtain
     * @return		    The found element with the {@code CSS} specified.
     */
    public WebElement getElementByCSS(String css) {
	log.trace("::getElementByCSS(css,secsToWait) - Start: Bridging");
	return getElementByCSS(css,null);
    }
    
    /**
     * Obtains an element from the page by its {@code CSS}.  For example {@code By.cssSelector("input[name='first_name']")}.
 It will waitFor the seconds specified for the element to show up, how it waits is specified in the method it uses to accomplish this {@link #wait() }.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param css	    the {@code CSS} class name to locate the element to obtain
     * @param secsToWait    the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @return		    The found element with the {@code CSS} specified.
     */
    public WebElement getElementByCSS(String css, Integer secsToWait) {
	log.trace("::getElementByCSS(css,secsToWait) - Start","retrieving element.");
	WebElement webElement = null;
	try {
	    webElement = getElementBy(By.cssSelector(css), secsToWait);
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Impossible to obtain the element with the CSS Selector provided", ex);
	}
	log.trace("::getElementByCSS(css,secsToWait) - Finish","returning element.");
	return webElement;
    }

    /**
     * Obtains an element from the page by its {@code xPath}. 
     * This is a bridge method that will call the {@link #getElementByXPath(java.lang.String, java.lang.Integer)} method with the parameter {@code secondsToWait} as {@code null}.
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath	    The {@code xPath} to locate the element to obtain.
     * @return		    The found element with the {@code xPath} provided.
     * @see WebDriverUtils#getElementByXPath(java.lang.String, java.lang.Integer) 
     */
    public WebElement getElementByXPath(String xpath) {
	return getElementByXPath(xpath,null, null, null, null);
    }
    
    /**
     * Obtains an element from the page by its {@code xPath}. It will wait the seconds specified for the element to show up, how it waits is specified in the method 
     * it uses to accomplish this {@link #wait() }.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath	    The {@code xPath} to locate the element to obtain
     * @param secsToWait    The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @return		    The found element with the {@code xPath} provided.
     */
    public WebElement getElementByXPath(String xpath, Integer secsToWait) {
	log.trace("::getElementByXPath(xpath,secsToWait) - Start","retrieving element.");
	WebElement webElement = null;
	try {
	    webElement = getElementBy(By.xpath(xpath), secsToWait);
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Impossible to obtain the element with the XPath provided", ex);
	}
	log.trace("::getElementByXPath(xpath,secsToWait) - Finish","returning element.");
	return webElement;
    } 

    public WebElement getElementByXPath(String xpath, Boolean skipRetryWithoutWaiting){
	log.trace("::getElementByXPath(xpath, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Bridging - retrieving element with xpath.");
	return getElementBy(By.xpath(xpath),null, null, null, skipRetryWithoutWaiting);
	
    }
    
    public WebElement getElementByXPath(String xpath, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait, Boolean skipRetryWithoutWaiting){
	log.trace("::getElementByXPath(xpath, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Bridging - retrieving element with xpath.");
	return getElementBy(By.xpath(xpath),relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
    }
    
    public WebElement getElementByText(String text){
	log.trace("getElementsByText(text) - Start: Bridging.");
	return getElementByText(text, null, null, null, null);
    }
    
    public WebElement getElementByText(String text, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait, Boolean skipRetryWithoutWaiting){
	log.trace("getElementByText(text, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: ");
	try {
	    
	    WebElement element=getElementBy(By.xpath("//*[text() = '"+text+"']"),relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
	    log.trace("::getElementByText(text, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Finish: ");
	    
	    return element;
	    
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Unable to obtain element with text: " + text, ex);
	}
    }
    
    //</editor-fold>

	//<editor-fold defaultstate="collapsed" desc="Multiple">

    public List<WebElement> getElementsByClassName(String cssClass){
	log.trace("getElementsByClassName(cssClass) - Start: Clicking.");
	return getElementsByClassName(cssClass,null,null,null,null);
    }
    
    public List<WebElement> getElementsByClassName(String cssClass, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait, Boolean skipRetryWithoutWaiting){
	log.trace("getElementsByClassName(cssClass, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Clicking.");
	try {
	    
	    List<WebElement> elements=getElementsBy(By.className(cssClass),relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
	    log.trace("::getElementsByClassName(cssClass, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Finish: Clicked.");
	    
	    return elements;
	    
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Unable to obtain element with class name: " + cssClass, ex);
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
     * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want this to happen
     * you can call directly that method instead of this one.
     * If you need to specify a range of time to wait for your element to show up in the page's DOM, you can call the method 
     * {@link #getElementsBy(org.openqa.selenium.By, java.lang.Integer)} 
     * <br>
     * This is a Bridge method and will only call the method 
     * {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameters {@code skypRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} and {@code skipRetryWithoutWaiting} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public WebElement getElementBy(By locator) {
	log.trace("::getElementBy(locator) - Start: Bridging");
	return getElementBy(locator, null, null, null, null);
    }
    
    /**
     * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
     * with the specified amount of seconds, and return the first element as a {@link WebElement}; 
     * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
     * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want this to happen
     * you can call directly that method instead of this one.
     * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
     * <br>
     * This is a Bridge method and will only call the method 
     * {@link #waitForElements(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameters {@code skypRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} and {@code skipRetryWithoutWaiting} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param secsToWait		The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
					default-explicit-waitFor property) if null.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public WebElement getElementBy(By locator, Integer secsToWait) {
	log.trace("::getElementBy(locator, secsToWait) - Start: Bridging");
	return getElementBy(locator, null, null, secsToWait, null);
    }
    
    /**
     * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
     * with the specified amount of seconds, and return the first element as a {@link WebElement}; 
     * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
     * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want this to happen
     * you can call directly that method instead of this one.
     * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
     * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content 
     * of the page making effectively the {@code relativeNestedFrameNamesStructure} parameter absolute instead of relative, you can skip this operation by 
     * calling the method {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} and setting
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * This is a Bridge method and will only call the method 
     * {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameters {@code skypRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param secsToWait		The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
					default-explicit-waitFor property) if null.
     * @param skipRetryWithoutWaiting	In case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public WebElement getElementBy(By locator, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
	log.trace("::getElementBy(locator, secsToWait, skipRetryWithoutWaiting) - Start: Bridging");
	return getElementBy(locator, null, null, secsToWait, skipRetryWithoutWaiting);
    }
    
    /**
     * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
     * with the specified amount of seconds, obtain all coincidences with the locator, and return the elements as a {@link List}; This does not necessarily mean that the element is visible; 
     * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
     * and then attempt to obtain the element.
     * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
     * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content 
     * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by 
     * calling the method {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} and setting
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * Most of the methods on this class will call this method to obtain the elements they want to manipulate, so this method defines the rules that will have to interact with them.
     * This is a Bridge method and will only call the method 
     * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameter {@code skypRetryWithNoFrames} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param relativeNestedFrameNamesStructure	Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. the method will not switch the focus if {@code null}.
     * @param secsToWait	the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @param skipRetryWithoutWaiting in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public WebElement getElementBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
	log.trace("::getElementBy(locator, relativeNestedFrameNamesStructure, secsToWait, skipRetryWithoutWaiting) - Start: Bridging");
	return getElementBy(locator, relativeNestedFrameNamesStructure, null, secsToWait, skipRetryWithoutWaiting);
    }
    
    /**
     * Will check for at least one element with the specified {@link By} locator is present on the page's DOM, 
     * obtain all coincidences with the locator, and return the first element as a {@link WebElement}; 
     * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
     * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want this to happen
     * you can call directly that method instead of this one.
     * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
     * and then attempt to obtain the element.
     * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content 
     * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by 
     * calling the method {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} and setting 
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * This is a Bridge method and will only call the method 
     * {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameters {@code secsToWait} and {@code skipRetryWithoutWaiting} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param relativeNestedFrameNamesStructure	Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. the method will not switch the focus if {@code null}.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public WebElement getElementBy(By locator, Collection<String> relativeNestedFrameNamesStructure) {
	log.trace("::getElementBy(locator, relativeNestedFrameNamesStructure) - Start: Bridging");
	return getElementBy(locator, relativeNestedFrameNamesStructure, null, null, null);
    }
    
    /**
     * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM, 
     * obtain all coincidences with the locator,  and return the first element as a {@link WebElement}; 
     * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
     * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want this to happen
     * you can call directly that method instead of this one.
     * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
     * and then attempt to obtain the element.
     * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content 
     * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by setting 
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * This is a Bridge method and will only call the method 
     * {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameters {@code secsToWait} and {@code skipRetryWithoutWaiting} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param relativeNestedFrameNamesStructure	Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. the method will not switch the focus if {@code null}.
     * @param skypRetryWithNoFrames	Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the first attempt. 
     *					Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
     *					{code false} if {@code null}
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public WebElement getElementBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames) {
	log.trace("::getElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWitNoFrames) - Start: Bridging");
	return getElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, null, null);
    }
    
    /**
     * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
     * with the specified amount of seconds, obtain all coincidences with the locator, and return the first element as a {@link WebElement}; 
     * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
     * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want this to happen
     * you can call directly that method instead of this one.
     * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
 and then attempt to obtain the element.
 The method will waitFor for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
     * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content 
     * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by setting 
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * This is a Bridge method and will only call the method 
     * {@link #getElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameter {@code skipRetryWithoutWaiting} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param relativeNestedFrameNamesStructure	Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. the method will not switch the focus if {@code null}.
     * @param skypRetryWithNoFrames	Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the first attempt. 
     *					Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
     *					{code false} if {@code null}
     * @param secsToWait		The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
					default-explicit-waitFor property) if null.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public WebElement getElementBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait) {
	log.trace("::getElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWitNoFrames, secsToWait) - Start: Bridging");
	return getElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, null);
	
    }
    
    /**
     * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
     * with the specified amount of seconds, obtain all coincidences with the locator, and return the first element as a {@link WebElement}; 
     * This does not necessarily mean that the element is visible; If an exception is thrown this will retry the operation looking for a single element calling method
     * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } If you don't want this to happen
     * you can call directly that method instead of this one.
     * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
 and then attempt to obtain the element.
 The method will waitFor for at least one element for the specified {@code secsToWait} but if it finds at least one element it will return it immediately.
     * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content 
     * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by setting 
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * The main difference between the method 
     * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } and this is the call to the method
     * {@link WebDriver#findElement(org.openqa.selenium.By) } vs {@link WebDriver#findElements(org.openqa.selenium.By) } and
     * {@link WebDriverWait#until(java.util.function.Function) } on a single and multiple instances.
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param relativeNestedFrameNamesStructure	Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. the method will not switch the focus if {@code null}.
     * @param skypRetryWithNoFrames	Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the first attempt. 
     *					Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
     *					{code false} if {@code null}
     * @param secsToWait		The seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
					default-explicit-waitFor property) if null.
     * @param skipRetryWithoutWaiting in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public WebElement getElementBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
	log.trace("::getElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Preparing wait.");
	WebElement element=null;
	try{
	    List<WebElement> elements= getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
	    if(elements!=null){
		if(elements.size()>1) log.warn("::getElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): "
			    + "There were more elements with the same locator, make sure you are getting the one you want.");
		element=elements.get(0);
	    }
	    return element;
	}catch(Exception ex){
	    try{
		
		element=getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting);
		return element;
	    }catch(Exception ex2){
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
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * The main difference between the method 
     * {@link #getSingleForcedElementBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean) } and this is the call to the method
     * {@link WebDriver#findElement(org.openqa.selenium.By) } vs {@link WebDriver#findElements(org.openqa.selenium.By) } and
     * {@link WebDriverWait#until(java.util.function.Function) } on a single and multiple instances.
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param relativeNestedFrameNamesStructure	Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. the method will not switch the focus if {@code null}.
     * @param skypRetryWithNoFrames	Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the first attempt. 
     *					Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
     *					{code false} if {@code null}
     * @param secsToWait	the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @param skipRetryWithoutWaiting in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public WebElement getSingleForcedElementBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
	log.trace("::getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWitNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Preparing wait.");
	
	if (locator == null) return null;
	if (secsToWait == null) secsToWait=getDefaultSecondsToWaitForElements();
	
	//I'm not sure if the first implementation works every time, so temporarily will leave this both on false, this will impacts performance but increase the chance to get elements.
	if(skipRetryWithoutWaiting==null) skipRetryWithoutWaiting=false; 
	if(skypRetryWithNoFrames==null) skypRetryWithNoFrames=false;
	
	WebElement element=null;
	try {
	    
	    if(relativeNestedFrameNamesStructure!=null) focus(relativeNestedFrameNamesStructure,secsToWait);
	    //I do not understand how to use this yet
	    //WebElement myDynamicElement = 
	    
	    //core
	    element=secsToWait==0?driver.findElement(locator) //no waitFor = normal find.
		    : (new WebDriverWait(driver, secsToWait)).until(ExpectedConditions.presenceOfElementLocated(locator));
	    
	    log.trace("::getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Finish","waiting is over.");
	    return element;
	    //isElementVisible with visibilityOfElementLocated OR visibilityOf
	    
	} catch(TimeoutException ex){
	    
	    log.warn("getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): The element ["+locator+"] Never showed up.");
	    try{
		if(!skipRetryWithoutWaiting){
		    log.warn("getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): Trying without waiting.");
		    element= driver.findElement(locator);
		    return element;
		}else {
		    log.warn("getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): Skiping retry-without-waiting.");
		    throw ex;
		}
	    }catch(Exception ex2){
		throw new White_SeleniumFrameworkException("Error while looking for the element with locator ["+locator+"]", ex);
	    }
	    
	    
	}catch (Exception ex) {
	    log.debug("getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): Couln't obtain the element with locator:{}",locator);
	    
//	    if(skypRetryWithNoFrames || defaultContentFocused || (relativeNestedFrameNamesStructure!=null && !relativeNestedFrameNamesStructure.isEmpty()) ) //caller wants to skip, or main is already focused, or it was my fault that is dirty
	    if(!skypRetryWithNoFrames && !defaultContentFocused && (relativeNestedFrameNamesStructure==null || relativeNestedFrameNamesStructure.isEmpty())){ //is dirty and wasn't me who got it dirty?
		log.debug("getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): I'll eat the exception and try again. Suppressed Exception: {}",ex);
	    }else{
		log.debug("getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): Skiping-retry-Wit No Frames Won't try again.");
		throw new White_SeleniumFrameworkException("Error while waiting for the elements to show up with locator:" + locator, ex);
	    }
	    
	} // exception ocurred Retring with no frames
	
	if(element==null && !skypRetryWithNoFrames && !defaultContentFocused && (relativeNestedFrameNamesStructure==null || relativeNestedFrameNamesStructure.isEmpty())){ //didn't get it & is dirty and wasn't me who got it dirty?
	    log.debug("getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): Switching to the main frame and trying again.");
	    try{
		
		driver.switchTo().defaultContent();
		defaultContentFocused=true; //to not dirty
		
		log.trace("::getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Finish: Using Recursion");
		element= getSingleForcedElementBy(locator, relativeNestedFrameNamesStructure, true, secsToWait, skipRetryWithoutWaiting);
		
	    }catch(Exception ex){
		throw new White_SeleniumFrameworkException("Error while waiting for the element with locator:" + locator, ex);
	    } //returns null if the "if" couldn't solve the problem.
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
     * with the parameters {@code skypRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} and {@code skipRetryWithoutWaiting} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
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
     * {@link #waitForElements(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameters {@code skypRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} and {@code skipRetryWithoutWaiting} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param secsToWait	the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
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
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * This is a Bridge method and will only call the method 
     * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameters {@code skypRetryWithNoFrames} and {@code relativeNestedFrameNamesStructure} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param secsToWait	the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @param skipRetryWithoutWaiting in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public List<WebElement> getElementsBy(By locator, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
	log.trace("::getElementsBy(locator, secsToWait, skipRetryWithoutWaiting) - Start: Bridging");
	return getElementsBy(locator, null, null, secsToWait, skipRetryWithoutWaiting);
    }
    
    /**
     * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
     * with the specified amount of seconds, obtain all coincidences with the locator, and return the elements as a {@link List}; This does not necessarily mean that the element is visible; 
     * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
     * and then attempt to obtain the element.
     * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
     * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content 
     * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by 
     * calling the method {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} and setting
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * Most of the methods on this class will call this method to obtain the elements they want to manipulate, so this method defines the rules that will have to interact with them.
     * This is a Bridge method and will only call the method 
     * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameter {@code skypRetryWithNoFrames} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param relativeNestedFrameNamesStructure	Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. the method will not switch the focus if {@code null}.
     * @param secsToWait	the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @param skipRetryWithoutWaiting in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
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
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * This is a Bridge method and will only call the method 
     * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameters {@code secsToWait} and {@code skipRetryWithoutWaiting} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param relativeNestedFrameNamesStructure	Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. the method will not switch the focus if {@code null}.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
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
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * This is a Bridge method and will only call the method 
     * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameters {@code secsToWait} and {@code skipRetryWithoutWaiting} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param relativeNestedFrameNamesStructure	Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. the method will not switch the focus if {@code null}.
     * @param skypRetryWithNoFrames	Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the first attempt. 
     *					Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
     *					{code false} if {@code null}
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames) {
	log.trace("::getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWitNoFrames) - Start: Bridging");
	return getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, null, null);
    }
    
    /**
     * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
     * with the specified amount of seconds, obtain all coincidences with the locator, and return the elements as a {@link List}; This does not necessarily mean that the element is visible; 
     * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
     * and then attempt to obtain the element.
     * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
     * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content 
     * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by setting 
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * This is a Bridge method and will only call the method 
     * {@link #getElementsBy(org.openqa.selenium.By, java.util.Collection, java.lang.Boolean, java.lang.Integer, java.lang.Boolean)} 
     * with the parameter {@code skipRetryWithoutWaiting} as {@code null};
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param relativeNestedFrameNamesStructure	Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. the method will not switch the focus if {@code null}.
     * @param skypRetryWithNoFrames	Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the first attempt. 
     *					Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
     *					{code false} if {@code null}
     * @param secsToWait	the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait) {
	log.trace("::getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWitNoFrames, secsToWait) - Start: Bridging");
	return getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, null);
	
    }
    
    /**
     * Will waitFor as an expectation for checking that at least one element with the specified {@link By} locator is present on the page's DOM
     * with the specified amount of seconds, obtain all coincidences with the locator, and return the elements as a {@link List}; This does not necessarily mean that the element is visible; 
     * If the {@code relativeNestedFrameNamesStructure} parameter is provided this method will try to focus on the last frame specified in this structure
     * and then attempt to obtain the element.
     * The method will wait for at least one element for the specified {@code secsToWait} but if it finds at least one element will return it immediately.
     * <p>If there is an error, the method will, by default, try to get the element again but changing the focus to the main content 
     * of the page making effectively the {@code relativeNestedFrameNamesStructure} absolute instead of relative, you can skip this operation by setting 
     * the {@code skypRetryWithNoFrames} parameter to {@code true}, This will help your script to not modify the driver's focus if there is an error. 
     * <i>If you don't know what does this "focus change" is, will probably mean that it won't have an impact on your scenario</i>.</p><br>
     * Most of the methods on this class will call this method to obtain the elements they want to manipulate, so this method defines the rules that will have to interact with them.
     * 
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2021-01-29
     * @param locator			The {@link By} locator to search for the element to obtain.
     * @param relativeNestedFrameNamesStructure	Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. the method will not switch the focus if {@code null}.
     * @param skypRetryWithNoFrames	Whether the method should try again without the Nested Frames Structure on the second time in case of an error on the first attempt. 
     *					Setting this to false will cause a change of focus for your driver to the main frame in case of an error.
     *					{code false} if {@code null}
     * @param secsToWait	the seconds to waitFor for the element to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null.
     * @param skipRetryWithoutWaiting in case of an exception this will determine if a no-waiting retry should be used to try to obtain the element again.
     * @return		The element as {@link WebElement} or {@code null} in case it is not found.
     * @throws White_SeleniumFrameworkException When an error is found.
     */
    public List<WebElement> getElementsBy(By locator, Collection<String> relativeNestedFrameNamesStructure, Boolean skypRetryWithNoFrames, Integer secsToWait, Boolean skipRetryWithoutWaiting) {
	log.trace("::getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWitNoFrames, secsToWait, skipRetryWithoutWaiting) - Start: Preparing wait.");
	
	if (locator == null) return null;
	if (secsToWait == null) secsToWait=getDefaultSecondsToWaitForElements();
	
	//I'm not sure if the first implementation works every time, so temporarily will leave this both on false, this will impacts performance but increase the chance to get elements.
	if(skipRetryWithoutWaiting==null) skipRetryWithoutWaiting=false; 
	if(skypRetryWithNoFrames==null) skypRetryWithNoFrames=false;
	
	List<WebElement> elements=null;
	try {
	    
	    if(relativeNestedFrameNamesStructure!=null) focus(relativeNestedFrameNamesStructure,secsToWait);
	    //I do not understand how to use this yet
	    //WebElement myDynamicElement = 
	    
	    //core
	    elements=secsToWait==0?driver.findElements(locator) //no waitFor = normal find.
		    : (new WebDriverWait(driver, secsToWait)).until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	    
	    log.trace("::getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Finish","waiting is over.");
	    return elements;
	    //isElementVisible with visibilityOfElementLocated OR visibilityOf
	    
	} catch(TimeoutException ex){
	    
	    log.warn("getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): The element ["+locator+"] Never showed up.");
	    try{
		if(!skipRetryWithoutWaiting){
		    log.warn("getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): Trying without waiting.");
		    elements= driver.findElements(locator);
		    return elements;
		}else {
		    log.warn("getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): Skiping retry-without-waiting.");
		    throw ex;
		}
	    }catch(Exception ex2){
		throw new White_SeleniumFrameworkException("Error while looking for the element with locator ["+locator+"]", ex);
	    }
	    
	    
	}catch (Exception ex) {
	    log.debug("getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): Couln't obtain the element.");
	    
//	    if(skypRetryWithNoFrames || defaultContentFocused || (relativeNestedFrameNamesStructure!=null && !relativeNestedFrameNamesStructure.isEmpty()) ) //caller wants to skip, or main is already focused, or it was my fault that is dirty
	    if(!skypRetryWithNoFrames && !defaultContentFocused && (relativeNestedFrameNamesStructure==null || relativeNestedFrameNamesStructure.isEmpty())){ //is dirty and wasn't me who got it dirty?
		log.debug("getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): I'll eat the exception and try again. Suppressed Exception: {}",ex);
	    }else{
		log.debug("getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): Skiping-retry-Wit No Frames Won't try again.");
		throw new White_SeleniumFrameworkException("Error while waiting for the elements to show up with locator:" + locator, ex);
	    }
	    
	} // exception ocurred Retring with no frames
	
	if(elements==null && !skypRetryWithNoFrames && !defaultContentFocused && (relativeNestedFrameNamesStructure==null || relativeNestedFrameNamesStructure.isEmpty())){ //didn't get it & is dirty and wasn't me who got it dirty?
	    log.debug("getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting): Switching to the main frame and trying again.");
	    try{
		
		driver.switchTo().defaultContent();
		defaultContentFocused=true; //to not dirty
		
		log.trace("::getElementsBy(locator, relativeNestedFrameNamesStructure, skypRetryWithNoFrames, secsToWait, skipRetryWithoutWaiting) - Finish: Using Recursion");
		elements= getElementsBy(locator, relativeNestedFrameNamesStructure, true, secsToWait, skipRetryWithoutWaiting);
		
	    }catch(Exception ex){
		throw new White_SeleniumFrameworkException("Error while waiting for the element with locator:" + locator, ex);
	    } //returns null if the "if" couldn't solve the problem.
	}
	
	return elements;
	
    }

    //</editor-fold>
    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Utils">

    /**
     * Resets the focus to the default content on the page. if you need to access an element inside of a frame you will have to call 
     * {@link #focus(java.util.Collection, java.lang.Integer) } or {@link #focusFrame(org.openqa.selenium.support.How, java.lang.String, java.lang.Integer) method again
     * to obtain the element after calling this. This method also marks the focus as clean by setting {@link #defaultContentFocused} as <code>true</code>
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     */
    public void frameReloading(){
	log.trace("::frameReloading() - Start","Reseting focus.");
	try{
	    driver.switchTo().defaultContent();
	    defaultContentFocused=true;
	    log.trace("::frameReloading() - Finish","Focus Reseted.");
	}catch(org.openqa.selenium.UnhandledAlertException ex){
	    throw new White_SeleniumFrameworkException("Unable to focus on the default Content(reseting the focus) of the page due to an alert,"
		    + " please handle the alert before changing focus.", ex);
	}catch(Exception ex){
	    throw new White_SeleniumFrameworkException("Unable to focus on the default Content(reseting the focus) of the page.", ex);
	}
    }
    
    /**
     * Receives an ordered collection of frame/iframe names that represent the nested frame structure of the page until the point where is possible to obtain a desired object.
     * This is a bridge method to {@link #focus(java.util.Collection, java.lang.Integer) } setting up the <code>secsToWait</code> to null, this makes the defaults to be used.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
     */
    public void focus(Collection<String> nestedFrameNamesStructure){
	focus(nestedFrameNamesStructure,null);
    }
    
    /**
     * Receives an ordered collection of frame/iframe names that represent the nested frame structure of the page until the point where is possible to obtain a desired object.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
     * @param secsToWait    the seconds to waitFor for the frame to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null. The focus switch seems to take some time ignoring the waitFor in case it fails to find the frame.
     */
    public void focus(Collection<String> nestedFrameNamesStructure, Integer secsToWait){
	log.trace("::focus(frameNamesStructure,secsToWait) - Start","looking for focus.");
	
	
	try{
	    //validations
	    if (nestedFrameNamesStructure == null){
		log.trace("::focus(frameNamesStructure,secsToWait) - Finish","No frames provided, the focus was not modified.");
		return;
	    }
	    if (secsToWait == null) secsToWait=getDefaultSecondsToWaitForElements();
	    
	    //process
	    defaultContentFocused=false;//dirty
	    Boolean firstFrame=true;
	    String lastFrameFocusedName="Unkown";
	    for(String frameName:nestedFrameNamesStructure){
		try{
		    try{
			focusFrame(How.ID,frameName,secsToWait);
			lastFrameFocusedName=frameName;
		    }catch(Exception ex){
			log.debug("focus(frameNamesStructure,secsToWait)","The frame ["+frameName+"] was not found by Id trying with Name.");
			focusFrame(How.NAME,frameName,secsToWait);
			lastFrameFocusedName=frameName;
		    }
		}catch(Exception ex){
		    if(firstFrame){ //tries switching back to the main frame and try again.
			try{
			    driver.switchTo().defaultContent();
			    lastFrameFocusedName="default";
			    try{
				focusFrame(How.ID,frameName,secsToWait);
				lastFrameFocusedName=frameName;
			    }catch(Exception ex2){
				log.debug("focus(frameNamesStructure,secsToWait)","The frame ["+frameName+"] was not found by Id trying with Name.");
				focusFrame(How.NAME,frameName,secsToWait);
				lastFrameFocusedName=frameName;
			    }
			    if(firstFrame)firstFrame=false;
			    continue; //do not log the warn
			}catch(Exception ex3){}//logs the next warn
		    }
		    log.warn("focus(frameNamesStructure,secsToWait)","Impossible to switch "
			    + "focus to frame ["+frameName+"] igniring it, and keep trying with the rest of the structure.");
		}
		if(firstFrame)firstFrame=false;
	    }
	    log.debug("focus(frameNamesStructure,secsToWait)","FOCUS switched to :"+lastFrameFocusedName);
	}catch(Exception ex){
	    throw new White_SeleniumFrameworkException("Unable to focus one of the frames of the given structure", ex);
	}
	
	
	
    }
    
    /**
     * This will switch the focus of the app to the provided frame/iframe. (No pun intended) This focus is needed to obtain elements inside of a frame or iframe.
     * Have to be specified if the ID or the NAME attribute of the frame/iframe is used through the <code>how</code> parameter provided. For now, 
     * a bug has being identified in Google Chrome and because of it some frames/iframes cant be obtained with traditional method so an alternative method is used
     * in those cases it might take more time to focus but it will ensure that the frames/iframes are being obtained correctly.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param how	    {@link How} must be specified as ID or NAME; this is supposed to be specified although it will go ahead and try with ID if not (logs a warn).
     * @param frameNameOrId The Name or Id of the frame/iframe; does nothing if null.
     * @param secsToWait    the seconds to waitFor for the frame to show up in the page, uses the app default (specified in .properties with 
			    default-explicit-waitFor property) if null. The focus switch seems to take some time ignoring the waitFor in case it fails to find the frame.
     */
    public void focusFrame(How how,String frameNameOrId,Integer secsToWait){
	log.trace("::focusFrame(how,frameNameOrId,secsToWait) - Start","changing focus to new frame.");
	
	try{
	    //validations
	    if (frameNameOrId == null){
		log.trace("::focusFrame(how,frameNameOrId,secsToWait) - Finish","No frame provided, the focus was not modified.");
		return;
	    }
	    if (secsToWait == null) {
		String propertiesSecs=getProperty("default-explicit-wait");
		Integer newSecs=propertiesSecs!=null?Integer.parseInt(propertiesSecs):null;
		secsToWait = (newSecs!=null)?newSecs:0;
	    }
	    if(how==null || (how!=How.ID && how!=How.NAME)){
		log.warn("focusFrame(how,frameNameOrId,secsToWait)","The how parameter was not provided, it must be NAME or ID. Trying with ID by default.");
		how=How.ID;
	    }
	    
	    //process
	    defaultContentFocused=false;//dirty
	    String attribute=how.equals(How.ID)?"id":"name";
	    try{
		var wait = (new WebDriverWait(driver, secsToWait));
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNameOrId));
		log.debug("focusFrame(how,frameNameOrId,secsToWait)","FOCUS switched to :"+frameNameOrId);
	    }catch(Exception ex){
		log.debug("focusFrame(how,frameNameOrId,secsToWait)","Error while waiting for the frame: "+frameNameOrId+". Error: "+ex.getStackTrace()[0]);
		log.warn("focusFrame(how,frameNameOrId,secsToWait)","Impossible to obtain the frame ["+frameNameOrId+"] by waiting on it, "
			+ "trying without wait for the element to be pressent, for more information on the warn check the debug logs.");
		try{
		    driver.switchTo().frame(driver.findElement(By.xpath("//frame[@"+attribute+"='"+frameNameOrId+"']")));
		    log.debug("focusFrame(how,frameNameOrId,secsToWait)","FOCUS switched to :"+frameNameOrId);
		}catch(Exception ex2){
		    driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@"+attribute+"='"+frameNameOrId+"']")));  //u.u
		    log.debug("focusFrame(how,frameNameOrId,secsToWait)","FOCUS switched to :"+frameNameOrId);
		}
	    }
	    
	    log.trace("::focusFrame(how,frameNameOrId,secsToWait) - Finish","focus switched.");
	    
	}catch(Exception ex){
	    throw new White_SeleniumFrameworkException("Unable to focus on the given frame", ex);
	}
    }
    
    public void highlight(WebElement element){
	JavascriptExecutor javaScriptExecutor = (JavascriptExecutor) driver;
	javaScriptExecutor.executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid red;');", element);
    }
    
    /**
     * Assuming there is an alert popping up on your page this will just accept (click OK button) on it.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     */
    public void acceptAlert(){
	log.trace("::acceptAlert() - Start","Accepting alert.");
	try {
	    WebDriverWait wait = new WebDriverWait(driver, 2);
	    Alert alert=wait.until(ExpectedConditions.alertIsPresent());
	    //Alert alert = driver.switchTo().alert();
	    alert.accept();
	    log.trace("::acceptAlert() - Finish","Alert accepted.");
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
	    throw new White_SeleniumFrameworkException("Impossible to complete the operation due to an unknown internal error.", e);
	}
    }
    
    public void pageUp() {
	log.trace("::pageUp() - Start: ");
	try {
	    
	    pressKey(Keys.PAGE_UP);
	    log.trace("::pageUp() - Finish: ");
	    
	} catch (Exception e) {
	    throw new White_SeleniumFrameworkException("Impossible to complete the operation due to an unknown internal error.", e);
	}
    }
    
    public void pressKey(org.openqa.selenium.Keys key){
	log.trace("::pressKey(key) - Start: ");
	try {
	    
	    if(action==null) action = new Actions(driver);
	    action.sendKeys(key).build().perform();
	    log.trace("::pressKey(key) - Finish: Key pressed");
	    
	} catch (Exception e) {
	    throw new White_SeleniumFrameworkException("Impossible to complete the operation due to an unknown internal error.", e);
	}
    }
    
    public void waitFor(Long milisecs){
	log.trace("::wait(milisecs) - Start: ");
	notNullValidation(milisecs);
	try{
	    synchronized (driver){
		driver.wait(milisecs);
	    }
	    log.trace("::wait(milisecs) - Finish: ");
	}catch(Exception e){
	    throw new White_SeleniumFrameworkException("Unable to pause the thread due to an unknown internal error.", e);
	}
	
    }

    
	//<editor-fold defaultstate="collapsed" desc="PrntScrn">

    public String takeScreenShot(){
	return takeScreenShot((String)null);
    }
    
    public String takeScreenShot(TestCase tc){
	String screenShotFileName="["+driver.getClass().getSimpleName()+"] "+tc.getTestFullName()+".png";
	return takeScreenShot(screenShotFileName);
    }
    
    public String takeScreenShot(String screenShotFileName){
	log.trace("::takeScreenShoot() - Start","Taking a Screenshot.");
	try{
	    if(screenShotFileName==null) screenShotFileName=getDefaultScreenShotFileName();
	    
	    Thread.sleep(1000);
	    File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    File copy=new File(screenShotFileName);
	    FileUtils.copyFile(screenShotFile,copy );
	    log.trace("::takeScreenShoot() - Finish","Screenshot saved.");
	    return copy.getAbsolutePath();
	    
	}catch(java.io.IOException ex){
	    throw new White_SeleniumFrameworkException("Unable to save the screenshot", ex);
	}catch(Exception ex){
	    throw new White_SeleniumFrameworkException("Unable to take a screenshot", ex);
	}
    }
    //</editor-fold>
    
	//<editor-fold defaultstate="collapsed" desc="WebExplorer in use">

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

     private String getDefaultScreenShotFileName() {
	String fileName="screenshot"+WebDriverUtils.screenShootCounter+".png";
	WebDriverUtils.screenShootCounter++;
	return fileName;
    }
    //</editor-fold>
    //</editor-fold>
    
//</editor-fold>

}
