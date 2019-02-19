package com.portal.automation.daimler.pages.test.login_logout;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.page.objects.PageObjectLoginLogout;



public class AutoLogout extends BrokenImage{	



	public AutoLogout(String propFile,Browser browser) throws Exception {
		super(propFile,browser);		
	}
	

	public static void executeTestCase() throws TestAutomationException, IOException, InterruptedException{
		UserLogin.executeTestCase();
		Thread.sleep((timer())*1000);
		try{
		 writeDataIntoExcel(TEST_STATUS, "Failed to logout successfully");
		 writeDataIntoExcel(TEST_STATUS, "Fail. Alert is not present");
	 
	
		
		}catch(Exception e){

		writeDataIntoExcel(TEST_STATUS, "Exception occured");
}
	
}}

		
		
	
	


