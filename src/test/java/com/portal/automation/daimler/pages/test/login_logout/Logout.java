package com.portal.automation.daimler.pages.test.login_logout;

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



public class Logout extends PageObjectLoginLogout{

	private Logout logout1;
	public Logout(String propFile,Browser browser) throws Exception {
		super(propFile,browser);
				
	}

	public ExcelManager getTestObject() throws Exception{
		logout1 = new Logout (propFile, browser);
		return logout1;
	}
	
	public ExcelManager getNextTestCase() throws TestAutomationException, InterruptedException, IOException{
		
		String testCaseName= readDataFromExcel(TEST_CASE_NAME);
		if (TestCaseIdentifier.manualLogout.equals(testCaseName)){
			{
				ManualLogout.executeTestCase();
			} 
			
		}
		
		

		return null;
		
	}
	

}
