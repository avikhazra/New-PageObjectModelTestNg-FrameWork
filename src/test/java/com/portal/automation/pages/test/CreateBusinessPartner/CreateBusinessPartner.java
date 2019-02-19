package com.portal.automation.pages.test.CreateBusinessPartner;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.page.objects.PageObjectCreateBusinessPartner;
import com.portal.automation.pages.test.TestNGTests.TestCaseIdentifier;


public class CreateBusinessPartner extends PageObjectCreateBusinessPartner {
	CreateBusinessPartner CreateBusinessPartner1;
	
	public CreateBusinessPartner(Browser browser, String propFile) throws Exception {
		super(browser, propFile);
		// TODO Auto-generated constructor stub
	}
	
public ExcelManager getNextTestCase() throws TestAutomationException, IOException, InterruptedException{
		
		String testCaseName= readDataFromExcel(TEST_CASE_NAME);		
		
		/*if (TestCaseIdentifier.BPOverview.equals(testCaseName)){
		System.out.println("Create Business Partner landing page click......");
		UserCreateBusinessPartner.executeCreateBusinessPartnerLink();
		}
		
		 else*/ if(TestCaseIdentifier.crtBPCreate.equals(testCaseName)){
			 System.out.println("Create Business Partner Success......");
			 UserCreateBusinessPartner.executeBPCreate();
			 driver.navigate().refresh();
			 HomeTab().click();			 
			}		
		return CreateBusinessPartner1;
		
	}

}
