package com.portal.automation.pages.test.TestNGTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.page.common.DaimlerPageBase;
import com.portal.automation.daimler.page.objects.PageObjectLoginLogout;
import com.portal.automation.daimler.pages.test.login_logout.BrokenImage;
import com.portal.automation.daimler.pages.test.login_logout.Logout;

public class TestLogout {
		
	ExcelManager logout;
	
	@AfterSuite
	@Parameters({"loginProp" , "browser","controller"})
	public void logout (String loginProp, Browser browser, String controller) throws TestAutomationException, FileNotFoundException, IOException, InterruptedException{
		try{
				ExcelManager logout = new Logout(loginProp,browser);
				logout.setController(controller);
				while (logout.findAndGetNextTestCase()!=null){
				logout.findAndGetNextTestCase();
			}
			
	
			
			} catch(Exception ex){
				logout.writeDataIntoExcel(logout.TEST_STATUS, ex.getMessage());	
			}
			PageObjectLoginLogout.quit();
	}
		}

	
