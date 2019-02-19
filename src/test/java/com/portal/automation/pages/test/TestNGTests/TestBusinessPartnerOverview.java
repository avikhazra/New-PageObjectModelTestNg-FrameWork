package com.portal.automation.pages.test.TestNGTests;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.pages.test.BusinessPartnerOverview.BusinessPartnerOverview;


public class TestBusinessPartnerOverview {
	
	ExcelManager Overview;	
	@Test
	@Parameters({"BusinessPartnerOverviewProp" , "browser","controller"})
	public void Overview (String createBusinessPartnerProp, Browser browser, String controller) throws TestAutomationException, FileNotFoundException, IOException, InterruptedException{
		ExcelManager businessPartnerOverview=null;
	
		try{
			System.out.println("::::::::::::::::::Business Partner Overview:::::::::::::::::");
			businessPartnerOverview = new BusinessPartnerOverview(browser,createBusinessPartnerProp);
			businessPartnerOverview.setController(controller);			
			while ((businessPartnerOverview = businessPartnerOverview.findAndGetNextTestCase())!=null){				
				businessPartnerOverview.findAndGetNextTestCase();
				}
		
			
		} catch(Exception ex){
			System.out.println("Error :::::: "+ex);
			
		}
	}
		

}
