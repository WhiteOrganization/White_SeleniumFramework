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
import org.openqa.selenium.interactions.Actions;
import org.white_sdev.white_seleniumframework.exceptions.White_SeleniumFrameworkException;
//import static org.white_sdev.white_validations.parameters.ParameterValidator.notNullValidation;

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
    
//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Methods">
    
    /**
     * A simple implementation to visualize more organized method signatures in the {@link org.slf4j.Logger logs}.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-06
     * @param methodSignature	This is the method signature to normalize with the number of tabs configured in the properties
     * @return			The signature normalized with the same number of characters (filled with tabs) than the rest of the normalized methods.
     */
    public String normalize(String methodSignature){
	try{
	    if(tabber==null){
		String numberOfTabsConfigured=getProperty("normalized-logger-tabs");
		Integer spaces=8*(numberOfTabsConfigured!=null?Integer.parseInt(numberOfTabsConfigured):7);
		Integer tabs=(spaces-(getClass().getSimpleName().length()+" - ".length()+methodSignature.length()))/8;
		tabber=methodSignature;
		for(int i=0;i<tabs;i++){
		    tabber+="\t";
		}
	    }
	    return tabber; 
	}catch(Exception ex){
	    throw new White_SeleniumFrameworkException("An error has ocurred while configuring the class logger. Impossible to configure the number of tabs required to log.",ex);
	}
    }

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
    
    public void clickClass(String css) {
	clickClass(css, null, null);
    }

    public void clickClass(String css, Collection<String> nestedFrameNamesStructure) {
	clickClass( css, nestedFrameNamesStructure, null);
    }
    
    
    public void clickXpath(String xpath) {
	clickXpath(xpath, null, null);
    }

    public void clickXpath(String xpath, Collection<String> nestedFrameNamesStructure) {
	clickXpath( xpath, nestedFrameNamesStructure, null);
    }
    
    
    
    
    public void writeId(String id, String keys) {
	writeId(id, keys, null, null);
    }

    public void writeId(String id, String keys, Collection<String> nestedFrameNamesStructure){
	 writeId(id,keys,nestedFrameNamesStructure,null);
    }
    
    /**
     * No framesets!
     * @param name
     * @param keys
     * @param nestedFrameNamesStructure 
     */
    public void writeName(String name, String keys,Collection<String> nestedFrameNamesStructure){
	writeName(name,keys,nestedFrameNamesStructure,null);
    }
    
    public void writeName(String name, String keys) {
	writeName(name, keys, null, null);
    }

    public void writeCSS(String css, String keys) {
	writeCSS(css, keys, null);
    }

    public void writeTag(String keys) {
	writeTag("input", keys, null);
    }

    public void writeTag(String tagName, String keys) {
	writeTag(tagName, keys, null);
    }

    public void writeXPath(String xpath, String keys) {
	writeXPath(xpath, keys, null);
    }

    public String textFromXpath(String xpath) {
	return textFromXpath(xpath, null, null);
    }
    
    public String textFromXpath(String xpath, Collection<String> nestedFrameNamesStructure) {
	return textFromXpath( xpath, nestedFrameNamesStructure, null);
    }
    
//</editor-fold>
    
    
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

    public void clickClass(String css, Integer secsToWait) {
	clickName( css, null, secsToWait);
    }
    
    public void clickClass(String css,Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
	log.trace("clickClass(css,frameNamesStructure,secsToWait) - Start","Clicking.");
	if (css == null) return;
	try {
	    
	    if(nestedFrameNamesStructure!=null) focus(nestedFrameNamesStructure,secsToWait);
	    click(By.className(css), secsToWait);

	    log.trace("::clickClass(css,frameNamesStructure,secsToWait) - Finish","Clicked.");
	} catch (Exception ex) {
	    if(!defaultContentFocused && (nestedFrameNamesStructure==null || nestedFrameNamesStructure.isEmpty())){ //is dirty and wasn't me who got it dirty?
		try{
		    log.warn("clickClass(css,frameNamesStructure,secsToWait)"," Couln't click the element, switching to the main frame and trying again.");
		    driver.switchTo().defaultContent();
		    defaultContentFocused=true;
		    clickClass(css,secsToWait);
		    return;
		}catch(Exception ex2){}//couln't handle it, throw of exception couln't be avoided.
	    }
	    throw new White_SeleniumFrameworkException("Unable to click the Button or Link with class name:" + css, ex);
	}
    }

    /**
     * Clicks the element once it founds it by waiting for it to show up and obtaining it from the page with the provided xpath. 
     * This is a bridge method to {@link #clickXpath(java.lang.String, java.util.Collection, java.lang.Integer) } it sets up the nestedFrameNamesStructure as null.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath			the xpath to locate the element to write to.
     * @param secsToWait		the seconds to wait for the element to show up in the page; uses the app default (specified in .properties with 
     *					default-explicit-wait property) if null.
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
     * @param secsToWait		the seconds to wait for the element to show up in the page; uses the app default (specified in .properties with 
     *					default-explicit-wait property) if null.
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

    
    /**
     * clicks the element once it founds it by waiting for it to show up and obtaining it from the page with the provided {@link By locator}. 
     * This method is used by several methods as the point where they all converge and in that sense the rest of the methods work as a bridge for this  
     * (For example {@link #clickId(java.lang.String, java.util.Collection, java.lang.Integer)} method will call this method by doing <code>click(By.id(id),secs)</code> ). 
     * But they add an extra layer of logic on top of the simple click method. 
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param locator	    the {@link By} object to locate the element to click.
     * @param secsToWait    the seconds to wait for the element to show up in the page; uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     */
    public void click(By locator, Integer secsToWait) {
	log.trace("clickId(name,secsToWait) - Start","Clicking.");
	if (locator == null) return;
	try {
	    Integer previousTabsCount = driver.getWindowHandles().size();
	    WebElement buttonOrLink = getElementBy(locator, secsToWait);
	    buttonOrLink.click();
	    
	    if( previousTabsCount<driver.getWindowHandles().size()){
		log.warn("clickId(name,secsToWait)","A known bug has ocurred (when a button is clicked an unwanted tab is oppened) proceding to fix it (close the tab).");
		driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL + "W");
		//new Actions(driver).keyDown(Keys.TAB).sendKeys("w").perform();
		// if there is just 1 tab:
//		driver.switchTo().window(handles[1]);
//		driver.close();
//		driver.switchTo().window(handles[0]);
	    }
	    
	    log.trace("clickId(name,secsToWait) - Finish","Clicked.");
	    
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Unable to click the Button or Link with locator:" + locator, ex);
	}
    }

    
    
    
     /**
     * Writes (sends) the given keys ({@link String text}) to the element once it founds it by waiting for it to show up and obtaining it from the page 
     * with the provided id. 
     * This is a Bridge method of {@link #writeId(java.lang.String, java.lang.String, java.util.Collection, java.lang.Integer)} that sets up nestedFrameNamesStructure as null.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param id			the id to locate the element to write to.
     * @param keys			The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param secsToWait		the seconds to wait for the element to show up in the page; uses the app default (specified in .properties with 
     *					default-explicit-wait property) if null.
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
     * @param secsToWait		the seconds to wait for the element to show up in the page; uses the app default (specified in .properties with 
     *					default-explicit-wait property) if null.
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
     * This is a Bridge method of {@link #writeName(java.lang.String, java.lang.String, java.util.Collection, java.lang.Integer)} that sets up nestedFrameNamesStructure as null.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param name			the name to locate the element to write to.
     * @param keys			The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param secsToWait		the seconds to wait for the element to show up in the page; uses the app default (specified in .properties with 
     *					default-explicit-wait property) if null.
     */
    public void writeName(String name, String keys, Integer secsToWait){
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
     * @param secsToWait		the seconds to wait for the element to show up in the page; uses the app default (specified in .properties with 
     *					default-explicit-wait property) if null.
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
     * This is a bridge method to {@link #write(org.openqa.selenium.By, java.lang.String, java.lang.Integer) } in a way setting up the {@link By#tagName(java.lang.String)} element.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param css	    the CSS class to locate the element to write to.
     * @param keys	    The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param secsToWait    the seconds to wait for the element to show up in the page; uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
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
     * @param secsToWait		the seconds to wait for the element to show up in the page; uses the app default (specified in .properties with 
     *					default-explicit-wait property) if null.
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
     * @param secsToWait    the seconds to wait for the element to show up in the page; uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
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
     * with the provided xpath. 
     * This is a bridge method to {@link #write(org.openqa.selenium.By, java.lang.String, java.lang.Integer) } in a way setting up the {@link By#tagName(java.lang.String)} element.
     *
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath	    the xpath to locate the element to write to.
     * @param keys	    The keys or {@link String text} to send to the element (usually an input) on the page.
     * @param secsToWait    the seconds to wait for the element to show up in the page; uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
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
     * @param secsToWait    the seconds to wait for the element to show up in the page; uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
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
    
    /**
     * It will obtain the containing (link) text inside of the [tag]element with the xpath specified. This is a bridge method that sets up the nestedFrameNamesStructure as null
     * while calling the method {@link #textFromXpath(java.lang.String, java.util.Collection, java.lang.Integer) }
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath	    the xpath to locate the element to obtain the text from.
     * @param secsToWait    the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		    The text of the found element with the {@link By locator}
     */
    public String textFromXpath(String xpath, Integer secsToWait) {
	return textFromXpath( xpath, null, secsToWait);
    }
    
    /**
     * It will obtain the containing (link) text inside of the [tag]element with the xpath specified.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath	    the xpath to locate the element to obtain the text from.
     * @param nestedFrameNamesStructure Ordered frame name {@link Collection} that represents the frame structure of the page, beginning from the 
     *					outer frame and ending with the frame where the element is contained. Does no switch of focus if null.
     * @param secsToWait    the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		    The text of the found element with the {@link By locator}
     */
    public String textFromXpath(String xpath,Collection<String> nestedFrameNamesStructure, Integer secsToWait) {
	log.trace("::textFromXpath(xpath,frameNamesStructure,secsToWait) - Start","Getting text from element.");
	if (xpath == null) throw new IllegalArgumentException("The provided Xpath can't be null");
	try {
	    
	    if(nestedFrameNamesStructure!=null) focus(nestedFrameNamesStructure,secsToWait);
	    String text=text(By.xpath(xpath), secsToWait);
	    log.trace("::textFromXpath(xpath,frameNamesStructure,secsToWait) - Finish","Text Obtained.");
	    return text;
	    
	} catch (Exception ex) {
	    if(!defaultContentFocused && (nestedFrameNamesStructure==null || nestedFrameNamesStructure.isEmpty())){ //is dirty and wasn't me who got it dirty?
		try{
		    log.warn("textFromXpath(xpath,frameNamesStructure,secsToWait)","Couln't get text from the element, switching to the main frame and trying again.");
		    driver.switchTo().defaultContent();
		    defaultContentFocused=true;
		    String text=textFromXpath(xpath,secsToWait);
		    return text;
		}catch(Exception ex2){}//couln't handle it, throw of exception couln't be avoided.
	    }
	    throw new White_SeleniumFrameworkException("Unable to get text from element with xpath:" + xpath, ex);
	}
    }

    /**
     * It will obtain the containing (link) text inside of the [tag]element with the {@link By locator} specified.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param locator	    the {@link By} object to locate the element to obtain the text from.
     * @param secsToWait    the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		    The text of the found element with the {@link By locator}
     */
    public String text(By locator, Integer secsToWait) {
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
    
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="View Element getters">
    /**
     * Obtains an element from the page by its name. It will wait the seconds specified for the element to show up, how it waits is specified in the method 
     * it uses to accomplish this {@link #wait() }. This is a bridge method that will set the seconds to wait as null while calling the method 
     * {@link #getElementByName(java.lang.String, java.lang.Integer) }
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
     * @param secsToWait    the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
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
     * Obtains an element from the page by its tag. It will wait the seconds specified for the element to show up, how it waits is specified in the method 
     * it uses to accomplish this {@link #wait() }.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param tagName	    the tag to locate the element to obtain
     * @param secsToWait    the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		    The found element with the tag
     */
    public WebElement getElementByTag(String tagName, Integer secsToWait) {
	log.trace("::getElementByTag(tagName) - Start","retrieving element.");
	if (tagName == null) return null;
	try {

	    WebElement webElement = getElementBy(By.tagName(tagName), secsToWait);

	    log.trace("::getElementByTag(tagName,secsToWait) - Finish","returning element.");
	    return webElement;
	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Impossible to obtain the element with the Tag provided", ex);
	}

    } // this method will not be used locally

    /**
     * Obtains an element from the page by its css class name. It will wait the seconds specified for the element to show up, how it waits is specified in the method 
     * it uses to accomplish this {@link #wait() }.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param css	    the css class name to locate the element to obtain
     * @param secsToWait    the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		    The found element with the css class name
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
    } // this method will not be used locally

    /**
     * Obtains an element from the page by its xpath. It will wait the seconds specified for the element to show up, how it waits is specified in the method 
     * it uses to accomplish this {@link #wait() }.
     * This is a bridge method that will set the seconds to wait as null while calling the method.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath	    the xpath to locate the element to obtain
     * @return		    The found element with the xpath
     * @see WebDriverUtils#getElementByXPath(java.lang.String, java.lang.Integer) 
     */
    public WebElement getElementByXPath(String xpath) {
	return getElementByXPath(xpath,null);
    }
    
    /**
     * Obtains an element from the page by its xpath. It will wait the seconds specified for the element to show up, how it waits is specified in the method 
     * it uses to accomplish this {@link #wait() }.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath	    the xpath to locate the element to obtain
     * @param secsToWait    the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		    The found element with the xpath
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
    } // this method will not be used locally

    /**
     * Obtains an element from the page by its {@link By locator}. It will wait the seconds specified for the element to show up, how it waits is specified in the method 
     * it uses to accomplish this {@link #wait() }.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param locator	    the {@link By} object to locate the element to obtain
     * @param secsToWait    the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		    The found element with the {@link By locator}
     */
    public WebElement getElementBy(By locator, Integer secsToWait) {
	log.trace("::getElementBy(locator,secsToWait) - Start","Rerieving Element.");
	if (locator == null) return null;

	WebElement element = null;
	try {

	   element = waitFor(locator, secsToWait);
	    //element = driver.findElement(locator);

	} catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Impossible to obtain the element with locator: " + locator, ex);
	}
	log.trace("::getElementBy(locator,secsToWait) - Finish","Returning Element.");
	return element;

    }

//</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Waits">
    /**
     * This will wait for an element to show up and return it looking for it with its id. This is a bridge method that will set the seconds 
     * to wat as null while calling the method.
     * {@link #waitForId(java.lang.String, java.lang.Integer) }
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param id	The name to look for the element with it.
     * @return		The element as {@link WebElement} or null in case it is not found
     */
    public WebElement waitForId(String id) {
	return waitForId(id, null);
    }

    /**
     * This will wait for an element to show up and return it looking for it with its id.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param id	    The id to look for the element with it.
     * @param secs    the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		    The element as {@link WebElement} or null in case it is not found
     */
    public WebElement waitForId(String id, Integer secs) {
	return waitFor(By.id(id), secs);
    }

    /**
     * This will wait for an element to show up and return it looking for it with its name. This is a bridge method that will set the seconds 
     * to wat as null while calling the method.
     * {@link #waitForName(java.lang.String, java.lang.Integer) }
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param name	The name to look for the element with it.
     * @return		The element as {@link WebElement} or null in case it is not found
     */
    public WebElement waitForName(String name) {
	return waitForName(name, null);
    }

    /**
     * This will wait for an element to show up and return it looking for it with its name.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param name	    The name to look for the element with it.
     * @param secs    the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		    The element as {@link WebElement} or null in case it is not found
     */
    public WebElement waitForName(String name, Integer secs) {
	return waitFor(By.name(name), secs);
    }

    /**
     * This will wait for an element to show up and return it looking for it with its CSS class name. This is a bridge method that will set the seconds 
     * to wat as null while calling the method.
     * {@link #waitForTag(java.lang.String, java.lang.Integer) }
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param css	The CSS class name to look for the element with it.
     * @return		The element as {@link WebElement} or null in case it is not found
     */
    public WebElement waitForCSS(String css) {
	return waitForCSS(css, null);
    }

    /**
     * This will wait for an element to show up and return it looking for it with its CSS class name.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param css	    The CSS class name to look for the element with it.
     * @param secsToWait    the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		    The element as {@link WebElement} or null in case it is not found
     */
    public WebElement waitForCSS(String css, Integer secsToWait) {
	return waitFor(By.cssSelector(css));
    }

    /**
     * This will wait for an element to show up and return it looking for it with its tag. This is a bridge method that will set the seconds to wait as null while calling the method 
     * {@link #waitForTag(java.lang.String, java.lang.Integer) }
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param tagName	The tag to look for the element with it.
     * @return		The element as {@link WebElement} or null in case it is not found
     */
    public WebElement waitForTag(String tagName) {
	return waitForTag(tagName, null);
    }

    /**
     * This will wait for an element to show up and return it looking for it with its tag.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param tagName	The tag to look for the element with it.
     * @param secs	the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		The element as {@link WebElement} or null in case it is not found
     */
    public WebElement waitForTag(String tagName, Integer secs) {
	return waitFor(By.tagName(tagName), secs);
    }

    /**
     * This will wait for an element to show up and return it looking for it with its xpath. This is a bridge method that will set the seconds to wait as null while calling the method 
     * {@link #waitForXPath(java.lang.String, java.lang.Integer) }
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath	The xpath to look for the element with it.
     * @return		The element as {@link WebElement} or null in case it is not found
     */
    public WebElement waitForXPath(String xpath) {
	return waitForXPath(xpath, null);
    }

    /**
     * This will wait for an element to show up and return it looking for it with its xpath.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param xpath	The xpath to look for the element with it.
     * @param secsToWait	the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		The element as {@link WebElement} or null in case it is not found
     */
    public WebElement waitForXPath(String xpath, Integer secsToWait) {
	return waitFor(By.xpath(xpath), secsToWait);
    }

    /**
     * This will wait for an element to show up and return it. This is a bridge method that will set the seconds to wait as null while calling the method 
     * {@link #waitFor(org.openqa.selenium.By, java.lang.Integer) }.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param locator	the {@link By} object to locate the element to obtain
     * @return		The element as {@link WebElement} or null in case it is not found
     */
    public WebElement waitFor(By locator) { //no local method uses this
	return waitFor(locator, null);

    }

    /**
     * This will wait for an element to show up and return it.
     * @author <a href="mailto:obed.vazquez@gmail.com">Obed Vazquez</a>
     * @since 2019-03-02
     * @param locator	the {@link By} object to locate the element to obtain
     * @param secs	the seconds to wait for the element to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null.
     * @return		The element as {@link WebElement} or null in case it is not found
     */
    public WebElement waitFor(By locator, Integer secs) {
	log.trace("::waitFor(locator,secs) - Start","preparing wait.");
	
	if (secs == null) {
	    String propertiesSecs=getProperty("default-explicit-wait");
	    Integer newSecs=propertiesSecs!=null?Integer.parseInt(propertiesSecs):null;
	    secs = newSecs!=null?newSecs:0;
	}
	if (locator == null) return null;
	WebElement element;
	try {

	    //I do not understand how to use this yet
	    //WebElement myDynamicElement = 
	    if(secs==0){//no wait = normal find.
		element=driver.findElement(locator);
	    }else{
		element= (new WebDriverWait(driver, secs)).until(ExpectedConditions.presenceOfElementLocated(locator));
	    }
	    
	    
	    log.trace("::waitFor(locator,secs) - Finish","waiting is over.");
	    return element;
	    //isElementVisible with visibilityOfElementLocated OR visibilityOf


	} catch(TimeoutException ex){
	    log.warn("waitFor(locator,secs) - The element ["+locator+"] Never showed up. Trying without waiting.");
	    try{
		element= driver.findElement(locator);
		return element;
	    }catch(Exception ex2){
		throw new White_SeleniumFrameworkException("Error while looking for the element with locator ["+locator+"]", ex);
	    }
	    
	    
	    
	}catch (Exception ex) {
	    throw new White_SeleniumFrameworkException("Error while waiting for the element with locator:" + locator, ex);
	}
    }

//</editor-fold>
    
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
     * @param secsToWait    the seconds to wait for the frame to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null. The focus switch seems to take some time ignoring the wait in case it fails to find the frame.
     */
    public void focus(Collection<String> nestedFrameNamesStructure, Integer secsToWait){
	log.trace("::focus(frameNamesStructure,secsToWait) - Start","looking for focus.");
	
	
	try{
	    //validations
	    if (nestedFrameNamesStructure == null){
		log.trace("::focus(frameNamesStructure,secsToWait) - Finish","No frames provided, the focus was not modified.");
		return;
	    }
	    if (secsToWait == null) {
		String propertiesSecs=getProperty("default-explicit-wait");
		Integer newSecs=propertiesSecs!=null?Integer.parseInt(propertiesSecs):null;
		secsToWait = (newSecs!=null)?newSecs:0;
	    }
	    
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
     * @param secsToWait    the seconds to wait for the frame to show up in the page, uses the app default (specified in .properties with 
     *			    default-explicit-wait property) if null. The focus switch seems to take some time ignoring the wait in case it fails to find the frame.
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

    public void pageDown() {
	log.trace("::pageDown(parameter) - Start: ");
	try {
	    
	    if(action==null) action = new Actions(driver);
	    action.sendKeys(Keys.PAGE_DOWN).build().perform();
	    
	    log.trace("::pageDown(parameter) - Finish: ");
	    
	} catch (Exception e) {
	    throw new RuntimeException("Impossible to complete the operation due to an unknown internal error.", e);
	}
    }
    
    public void wait(Long milisecs) throws InterruptedException{
	synchronized (driver){
	    driver.wait(milisecs);
	}
    }

}
