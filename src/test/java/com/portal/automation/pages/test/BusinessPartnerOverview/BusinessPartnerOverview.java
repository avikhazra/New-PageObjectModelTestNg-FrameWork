package com.portal.automation.pages.test.BusinessPartnerOverview;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.page.objects.PageObjectBusinessPartnerOverview;
import com.portal.automation.daimler.page.objects.PageObjectCreateBusinessPartner;
import com.portal.automation.pages.test.CreateBusinessPartner.UserCreateBusinessPartner;
import com.portal.automation.pages.test.TestNGTests.TestCaseIdentifier;

public class BusinessPartnerOverview extends PageObjectBusinessPartnerOverview {
	BusinessPartnerOverview BusinessPartnerOverview1;	
	public BusinessPartnerOverview(Browser browser, String propFile) throws Exception {
		super(browser, propFile);
		// TODO Auto-generated constructor stub
	}

public ExcelManager getNextTestCase() throws TestAutomationException, IOException, InterruptedException{
		
		String testCaseName= readDataFromExcel(TEST_CASE_NAME);		
	
		if(TestCaseIdentifier.BPOverview.equals(testCaseName)){
			
			 UserBusinessPartnerOverview.executeBpOverView();	
			 homeTab().click();
			}		
		return BusinessPartnerOverview1;
		
	}
}
