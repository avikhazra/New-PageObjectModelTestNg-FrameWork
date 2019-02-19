package com.portal.automation.daimler.pages.test.login_logout;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.page.objects.PageObjectLoginLogout;
import com.portal.automation.pages.test.TestNGTests.TestCaseIdentifier;



public class BrokenImage extends PageObjectLoginLogout{

	private BrokenImage login1;
	public BrokenImage(String propFile,Browser browser) throws Exception {
		super(propFile,browser);
				
	}
/*
	public PageBase getTestObject() throws TestAutomationPropertyLoadException, FileNotFoundException, IOException{
		login1 = new Login (propFile, browser);
		return login1;
	}*/
	
	public ExcelManager getNextTestCase() throws TestAutomationException, IOException, InterruptedException{
		
		String testCaseName= readDataFromExcel(TEST_CASE_NAME);
		if (TestCaseIdentifier.login.equals(testCaseName)){
		System.out.println("Valid Login ......");
			UserLogin.executeTestCase();
				
		}	
	
		else if (TestCaseIdentifier.BrokenImage.equals(testCaseName)){
			System.out.println("BrokenImages testing......");
			UserLogin.executeTestCase();
			
		}
		
		System.out.println(TestCaseIdentifier.BrokenImage);
		return login1;
		
	}
	

}
