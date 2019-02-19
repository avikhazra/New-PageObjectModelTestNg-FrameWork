package com.portal.automation.pages.test.TestNGTests;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.pages.test.search.Search;

public class TestSearch implements TestCaseIdentifier{

		
	@Test
	@Parameters({"browser", "search", "controller"})
	public static void FeedBackTC(Browser browser, String searchProp, String controller) {
		ExcelManager advSearch=null;
		try{
			 advSearch = new Search(browser,searchProp);
			advSearch.setController(controller);					
			while ((advSearch = advSearch.findAndGetNextTestCase())!=null){				
				advSearch.findAndGetNextTestCase();
			}
		
			
		} catch(Exception ex){
			
		}
	}
	
}


