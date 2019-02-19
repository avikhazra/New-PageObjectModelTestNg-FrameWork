package com.portal.automation.pages.test.TestNGTests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.pages.test.login_logout.BrokenImage;
import com.portal.automation.daimler.pages.test.login_logout.BrokenImage;


public class BrokenImageTest {
	
	ExcelManager login;
	
	@Test
	@Parameters({"loginProp","browser", "controller"})
	public void login (String loginProp, Browser browser, String controller) {
		System.out.println(loginProp);
			try{
				ExcelManager login = new BrokenImage(loginProp,browser);			
				login.setController(controller);
			while (login.findAndGetNextTestCase()!=null){									
					login.findAndGetNextTestCase();
				}
			}catch(Exception ex){
			
			}
		}
		}
	
