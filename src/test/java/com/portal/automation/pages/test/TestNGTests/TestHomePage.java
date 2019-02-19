package com.portal.automation.pages.test.TestNGTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.page.objects.PageObjectLoginLogout;
import com.portal.automation.daimler.pages.test.login_logout.HomePage;


public class TestHomePage {
	
	ExcelManager homePage;
	
	@BeforeSuite
	@Parameters({"loginProp","browser", "controller"})
	public void login (String loginProp, Browser browser, String controller) throws TestAutomationException, FileNotFoundException, IOException, InterruptedException{
		
			try{
				ExcelManager homePage = new HomePage(loginProp,browser);
				System.out.println("Test Message at login method");
				homePage.maximiseBrowser();
				((PageObjectLoginLogout) homePage).openApplicationURL();
				homePage.setController(controller);
			while (homePage.findAndGetNextTestCase()!=null){
				homePage.findAndGetNextTestCase();
				}
				
		
			} catch(Exception ex){
			
			}
		}
		}
	
