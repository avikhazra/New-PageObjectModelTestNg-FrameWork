package com.portal.automation.daimler.page.objects;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.portal.automation.appException.DescriptionInterface;
import com.portal.automation.appException.ElementDescriptionReader;
import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
//import com.portal.automation.appModules.DescriptionInterface;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.appmodules.PropertyReader;
import com.portal.automation.appmodules.TestAutomationCore;
import com.portal.automation.daimler.page.common.DaimlerPageBase;

public class PageObjectLoginLogout extends DaimlerPageBase{

	/* Constructor */
	public PageObjectLoginLogout(String propFile,Browser browser) throws Exception {
		super(propFile, browser);
		init(propFile);
	}
	public static String APPLICATION_URL;
	/* Webelements */
	public static String heading;
	public static String Description;
	public static String BodyDescription;
	public static String Basic_Auth_Link;
	public static String Broken_Images_Link;
	public static String Images;
	public static String EXPECTED_RESULT;
	public static String TIMER;
	public static String TIMEOUT;
	/* Reading key-values from property file */
	public void init(String propFile) throws TestAutomationPropertyLoadException{
		PropertyReader reader = new PropertyReader(propFile);
		APPLICATION_URL = reader.getProperties("StrtestUrl");
		heading = reader.getProperties("heading");
		Description= reader.getProperties("Description");
		BodyDescription= reader.getProperties("BodyDescription");
		Basic_Auth_Link= reader.getProperties("Basic_Auth_Link");
		Broken_Images_Link = reader.getProperties("Broken_Images_Link");
		Images = reader.getProperties("Images");
		TIMER=reader.getProperties("TIMER");
		TIMEOUT=reader.getProperties("TIMEOUT");
	}
	/* Open the Application URL */
	public  static void openApplicationURL() {
		try{
		
		driver.get(APPLICATION_URL);
		

		} catch (Exception e) {

		System.out.println("no url provided!!!");}
	}

	/*
	 * public static WebElement heading() throws TestAutomationException{ return
	 * getElementById(heading,DescriptionInterface.heading); }
	 * 
	 * public static WebElement Description() throws TestAutomationException{ return
	 * getElementById(Description,DescriptionInterface.Description); }
	 * 
	 * public static WebElement Basic_Auth_Link() throws TestAutomationException{
	 * return getElementById(Basic_Auth_Link,DescriptionInterface.Basic_Auth_Link);
	 * }
	 */

	public static WebElement  Broken_Images_Link() throws TestAutomationException{
	return getElementByXpath(Broken_Images_Link,DescriptionInterface.Broken_Images_Link);
	}
	
	
	
	
	public static List<WebElement> Images() throws TestAutomationException{
		return getElementsByXpath(Images,DescriptionInterface.Images);
	}
	
	
	
	
	public static int timer(){
		String timerS = readDataFromExcel(TIMER);
		int timer = Integer.parseInt(timerS);
		return timer;
	}
	public static int timeout(){
		String timeoutS = readDataFromExcel(TIMEOUT);
		int timeout = Integer.parseInt(timeoutS);
		return timeout;
	}

	public static int waitTime(){
		int waitTime = timeout() - timer();
		return waitTime;
	}

	
	public static String Description() throws TestAutomationException{
		return getElementByXpath(Description, DescriptionInterface.Description).getText();
	}

	public static void loginStatus() throws IOException, TestAutomationException{
		System.out.println("page title " + driver.getTitle() );
		if(driver.getTitle().contains("The Internet")){			
			testResult(driver.getTitle());
				
		}else {
			
			testResult(Description());
		}

	}
	
   
	
	public static void loginLinkStatus() throws IOException, TestAutomationException{
		if(driver.getPageSource().contains(readDataFromExcel(EXPECTED_RESULT))){
			testResult(readDataFromExcel(EXPECTED_RESULT));
				
		}

		else testResult("Failed to move to Login page");

	}

	public static void logoutStatus(String text) throws IOException, TestAutomationException{
		
		
		if(driver.getPageSource().contains(text)){
			System.out.println("Writing the data....................................");
			testResult(text);
				
		}

	}

	/*
	 * public static String loggedInText() throws IOException,
	 * TestAutomationException{ String userName = readDataFromExcel(USERNAMETEXT);
	 * String loggedInText = "Welcome " + userName + " to GetOne Portal"; return
	 * loggedInText;
	 * 
	 * }
	 * 
	 * public static String autoPrompt1() throws IOException,
	 * TestAutomationException{ return getElementByXpath(AUTO_TIMEOUT_PROMPT1,
	 * DescriptionInterface.AUTO_TIMEOUT_PROMPT1).getText();
	 * 
	 * 
	 * }
	 * 
	 * public static String autoPrompt2() throws IOException,
	 * TestAutomationException{ return getElementByXpath(AUTO_TIMEOUT_PROMPT2,
	 * DescriptionInterface.AUTO_TIMEOUT_PROMPT2).getText();
	 * 
	 * 
	 * }
	 */
	
	
	/*
	 * public static void autoPromptOk() throws IOException,
	 * TestAutomationException{ getElementByXpath(AUTO_PROMPT_OK,
	 * DescriptionInterface.AUTO_PROMPT_OK).click();
	 * 
	 * 
	 * }
	 */
	
}
