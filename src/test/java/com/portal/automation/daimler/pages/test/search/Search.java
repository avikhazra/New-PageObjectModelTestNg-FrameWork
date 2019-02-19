package com.portal.automation.daimler.pages.test.search;

import java.io.IOException;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.page.objects.PageObjectSearch;
import com.portal.automation.pages.test.TestNGTests.TestCaseIdentifier;

import bsh.Console;

public class Search extends PageObjectSearch {
	Search search;
	public Search(Browser browser, String propFile) throws Exception {
		super(browser, propFile);
		
	}
	
	public ExcelManager getNextTestCase() throws TestAutomationException, IOException, InterruptedException{
		String testCaseName= readDataFromExcel(TEST_CASE_NAME);
		/*if(testCaseName.equalsIgnoreCase(TestCaseIdentifier.advSearchClick)){
			AdvSearchButtonClick.executeTestCase();
		}else if(testCaseName.equalsIgnoreCase(TestCaseIdentifier.validAdvSearch)){
			AdvancedSearch.executeTestCase();
		}else  if(testCaseName.equalsIgnoreCase(TestCaseIdentifier.inValidAdvSearch)){
			AdvancedSearch.executeTestCase();
		}*/
		if(testCaseName.equalsIgnoreCase(TestCaseIdentifier.advSearch)){
			UserSearch.executeAdvanceSearchTestCase();
			homeTab().click();
		}	
		if(testCaseName.equalsIgnoreCase(TestCaseIdentifier.basicSearch)){
			UserSearch.executeBasicSearchTestCase();
			homeTab().click();
		}	
		if(testCaseName.equalsIgnoreCase(TestCaseIdentifier.simpleSearch)){
			
			UserSearch.executeSimpleSearchTestCase();
			homeTab().click();
		}	
		
		return search;
	}

}
