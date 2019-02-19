package com.portal.automation.daimler.pages.test.login_logout;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;



public class UserHomePage extends HomePage{	
	
	public UserHomePage(String propFile,Browser browser) throws Exception {
		super(propFile,browser);		
	}
	
	
	public static void executeTestCase() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		setImplicitlyWaitTime(15000);
		System.out.println("WITING 10 SEC.....");
		Thread.sleep(10000);
		loginLinkStatus();
		
	}


}
