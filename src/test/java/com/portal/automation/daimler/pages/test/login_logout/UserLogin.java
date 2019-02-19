package com.portal.automation.daimler.pages.test.login_logout;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.page.objects.PageObjectLoginLogout;



public class UserLogin extends BrokenImage{	
	
	public UserLogin(String propFile,Browser browser) throws Exception {
		super(propFile,browser);		
	}
	
	
	public static void executeTestCase() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		Thread.sleep(2000);
		
		openApplicationURL();
		Thread.sleep(2000);
		Broken_Images_Link().click();
		
		for(WebElement Image: Images() ) {
			if (Image.getAttribute("naturalWidth").equals("0")) {
				System.out.println( "Image: "+Image.getAttribute("outerHTML") + " is broken.");
			}else {
				System.out.println( "Image: "+Image.getAttribute("outerHTML") + " is not broken.");
			}
		}
		loginStatus();
		
	}


}
