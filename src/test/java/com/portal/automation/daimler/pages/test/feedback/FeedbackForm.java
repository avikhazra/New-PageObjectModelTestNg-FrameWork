package com.portal.automation.daimler.pages.test.feedback;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.page.objects.PageObjectLoginLogout;



public class FeedbackForm extends Feedback{	
	
	public FeedbackForm(String propFile,Browser browser) throws Exception {
		super(propFile,browser);		
	}
	
	
	public static void executeTestCase() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		setImplicitlyWaitTime(3000);
		try{
			if(feedBackLink()!= null){
				feedBackLink().click();
				feedBackButton().click();
			
		feedBackName().sendKeys(readDataFromExcel(Name));
		feedBackEmailId().sendKeys(readDataFromExcel(EmailId));
		selectfeedBackCategory();
		feedBackUrl().sendKeys(readDataFromExcel(WebsiteUrl));
		selectFeedBackSatisfaction();
		feedBackMessage().sendKeys(readDataFromExcel(Message));
		clickFeedBackSubmit();
		testResult(getFeedBackResultText());
		clickFeedBackClose();
		
		driver.navigate().back();
		Thread.sleep(2000);
	}
		else writeDataIntoExcel(TEST_STATUS, "Fail. FeedBack link is not available");
	}
	catch(Exception e){

		writeDataIntoExcel(TEST_STATUS, "Exception occured. Please check the fields/data");
}
	
	}}	

