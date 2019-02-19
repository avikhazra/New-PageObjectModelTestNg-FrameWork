package com.portal.automation.daimler.page.objects;

import java.io.IOException;

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

public class PageObjectFeedBack extends DaimlerPageBase{

	public PageObjectFeedBack(Browser browser, String propFile) throws Exception {

		super(propFile,browser);
		init(propFile);

	}

	/* Webelements */
	public static String FEEDBACK_LINK ;
	public static String FEEDBACK_BUTTON;
	public static String FEEDBACK_NAME;
	public static String FEEDBACK_EMAILID;
	public static String FEEDBACK_CATEGORY;
	public static String FEEDBACK_URL;
	public static String FEEDBACK_SATISFACTION;
	public static String FEEDBACK_MESSAGE;
	public static String FEEDBACK_SUBMIT;
	public static String FEEDBACK_RESULT_TEXT;
	public static String FEEDBACK_CLOSE;
	
	/* Excel- Test data input columns */
	public static String Name;
	public static String EmailId;
	public static String Category;
	public static String WebsiteUrl;
	public static String SatisfactionId;
	public static String Message;

	
	public void init(String propFile) throws TestAutomationPropertyLoadException{
		PropertyReader reader = new PropertyReader(propFile);
		FEEDBACK_LINK = reader.getProperties("FEEDBACK_LINK");
		FEEDBACK_BUTTON = reader.getProperties("FEEDBACK_BUTTON");
		FEEDBACK_NAME = reader.getProperties("FEEDBACK_NAME");
		FEEDBACK_EMAILID = reader.getProperties("FEEDBACK_EMAILID");
		FEEDBACK_CATEGORY = reader.getProperties("FEEDBACK_CATEGORY");	
		FEEDBACK_URL = reader.getProperties("FEEDBACK_URL");
		FEEDBACK_SATISFACTION = reader.getProperties("FEEDBACK_SATISFACTION");
		FEEDBACK_MESSAGE = reader.getProperties("FEEDBACK_MESSAGE");
		FEEDBACK_SUBMIT = reader.getProperties("FEEDBACK_SUBMIT");
		FEEDBACK_RESULT_TEXT = reader.getProperties("FEEDBACK_RESULT_TEXT");
		FEEDBACK_CLOSE = reader.getProperties("FEEDBACK_CLOSE");
		Name = reader.getProperties("Name");
		EmailId = reader.getProperties("EmailId");
		Category = reader.getProperties("Category");
		WebsiteUrl = reader.getProperties("WebsiteUrl");
		SatisfactionId = reader.getProperties("SatisfactionId");
		Message = reader.getProperties("Message");
	}


	public static WebElement feedBackLink() throws TestAutomationException{
		return getElementByXpath(FEEDBACK_LINK, DescriptionInterface.FEEDBACK_LINK);
	}

	public static WebElement feedBackButton() throws TestAutomationException{
		return getElementByXpath(FEEDBACK_BUTTON, DescriptionInterface.FEEDBACK_BUTTON);
	}

	public static WebElement feedBackName() throws TestAutomationException{
		return getElementByXpath(FEEDBACK_NAME, DescriptionInterface.FEEDBACK_NAME);
	}

	public static WebElement feedBackEmailId() throws TestAutomationException{
		return getElementByXpath(FEEDBACK_EMAILID, DescriptionInterface.FEEDBACK_EMAILID);
	}

	public static void selectfeedBackCategory() throws TestAutomationException{
		selectSpecificOptionFromDropDown(FEEDBACK_CATEGORY, readDataFromExcel(Category), DescriptionInterface.FEEDBACK_CATEGORY);
	}

	public static WebElement feedBackUrl() throws TestAutomationException{
		return getElementByXpath(FEEDBACK_URL, DescriptionInterface.FEEDBACK_URL);
	}

	public static void selectFeedBackSatisfaction() throws TestAutomationException, InterruptedException{
		int i = Integer.parseInt(readDataFromExcel(SatisfactionId));
		selectOptionFromRadioButton(FEEDBACK_SATISFACTION, i , DescriptionInterface.FEEDBACK_SATISFACTION);
	}
	
	public static WebElement feedBackMessage() throws TestAutomationException{
		return getElementByXpath(FEEDBACK_MESSAGE, DescriptionInterface.FEEDBACK_MESSAGE);
	}

	public static void clickFeedBackSubmit() throws TestAutomationException {
		clickElementByXpath(FEEDBACK_SUBMIT,DescriptionInterface.FEEDBACK_SUBMIT);
	}
	
	public static String getFeedBackResultText() throws TestAutomationException {
		return getElementByXpath(FEEDBACK_RESULT_TEXT,DescriptionInterface.FEEDBACK_RESULT_TEXT).getText();
	}
	
	public static void clickFeedBackClose() throws TestAutomationException {
		clickElementByXpath(FEEDBACK_CLOSE,DescriptionInterface.FEEDBACK_CLOSE);
	}

	

	@Override
	public ExcelManager getNextTestCase() throws TestAutomationException, IOException, InterruptedException
	 {
		// TODO Auto-generated method stub
		return null;
	}


}