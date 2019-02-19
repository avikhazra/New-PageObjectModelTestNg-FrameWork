package com.portal.automation.daimler.pages.test.feedback;

import java.awt.List;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.portal.automation.appException.DescriptionInterface;
import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.page.common.DaimlerPageBase;
import com.portal.automation.daimler.page.objects.PageObjectFeedBack;
import com.portal.automation.daimler.page.objects.PageObjectLoginLogout;
import com.portal.automation.pages.test.TestNGTests.TestCaseIdentifier;



public class Feedback extends PageObjectFeedBack{

	private Feedback fb;
	public Feedback(String propFile,Browser browser) throws Exception {
		super(browser,propFile);
				
	}

	
	public ExcelManager getNextTestCase() throws TestAutomationException, IOException, InterruptedException{
		
		String testCaseName= readDataFromExcel(TEST_CASE_NAME);
		if (TestCaseIdentifier.FeedBackSubmitValid.equals(testCaseName)){
			FeedbackForm.executeTestCase();
			
		}
		
		else if (TestCaseIdentifier.FeedBackSubmitInvalid.equals(testCaseName)){
			FeedbackForm.executeTestCase();
			
		}
			
		return fb;
		
	}
	
	
	

}
