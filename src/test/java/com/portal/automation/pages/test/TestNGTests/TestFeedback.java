package com.portal.automation.pages.test.TestNGTests;

import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.appmodules.PropertyReader;
import com.portal.automation.appmodules.Xls_Reader;
//import com.portal.automation.appModules.ExcelManager;
import com.portal.automation.daimler.page.common.DaimlerPageBase;
import com.portal.automation.daimler.page.objects.PageObjectFeedBack;
import com.portal.automation.daimler.pages.test.feedback.Feedback;

public class TestFeedback implements TestCaseIdentifier{

		
	@Test
	@Parameters({"browser", "feedbackProp", "controller"})
	public static void FeedBackTC(Browser browser, String feedbackProp, String controller) throws TestAutomationException, IOException{
		try{
			ExcelManager fb = new Feedback(feedbackProp,browser);
			fb.setController(controller);
					
			while ((fb = fb.findAndGetNextTestCase())!=null){				
				fb = fb.findAndGetNextTestCase();
			}
		
			
		} catch(Exception ex){
			System.out.println(ex.getMessage());	
		}
	}
	
}


