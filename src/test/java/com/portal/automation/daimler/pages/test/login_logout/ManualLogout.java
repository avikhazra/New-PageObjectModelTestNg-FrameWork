package com.portal.automation.daimler.pages.test.login_logout;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;




public class ManualLogout extends BrokenImage{	



	public ManualLogout(String propFile,Browser browser) throws Exception {
		super(propFile,browser);		
	}


	public static void executeTestCase() throws TestAutomationException, InterruptedException, IOException{
		try{
			setImplicitlyWaitTime(5000);
			logoutStatus(readDataFromExcel(EXPECTED_RESULT));	
			driver.close();
			driver.quit();
			driver=null;

		}catch(Exception e){
            System.out.println("Exception is :::::: "+e);
			writeDataIntoExcel(TEST_STATUS, "Exception occured");
		}


	}}







