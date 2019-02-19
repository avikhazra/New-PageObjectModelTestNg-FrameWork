package com.portal.automation.pages.test.TestNGTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.pages.test.search.Search;
import com.portal.automation.pages.test.CreateBusinessPartner.CreateBusinessPartner;

public class TestCreateBusinessPartner {
		
	ExcelManager Create;
	
	@Test
	@Parameters({"createBusinessPartnerProp" , "browser","controller"})
	public void Create (String createBusinessPartnerProp, Browser browser, String controller) throws TestAutomationException, FileNotFoundException, IOException, InterruptedException{
		ExcelManager createBusinessPartner=null;
		try{
			System.out.println(":::::::::::::::::: Create Business partner:::::::::::::::::::::::::::::");
			createBusinessPartner = new CreateBusinessPartner(browser,createBusinessPartnerProp);
			createBusinessPartner.setController(controller);
			while ((createBusinessPartner = createBusinessPartner.findAndGetNextTestCase())!=null){				
				createBusinessPartner.findAndGetNextTestCase();
				}
		
			
		} catch(Exception ex){
			System.out.println("Error :::::: "+ex);
			
		}
	}
		}

	
