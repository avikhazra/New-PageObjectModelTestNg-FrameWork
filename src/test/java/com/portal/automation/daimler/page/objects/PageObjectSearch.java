package com.portal.automation.daimler.page.objects;

import java.io.IOException;

import org.openqa.selenium.*;
import org.openqa.selenium.WebElement;

import com.portal.automation.appException.DescriptionInterface;
import com.portal.automation.appException.ElementDescriptionReader;
import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
//import com.portal.automation.appModules.DescriptionInterface;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.appmodules.PropertyReader;
import com.portal.automation.appmodules.TestAutomationCore;
import com.portal.automation.daimler.page.common.DaimlerPageBase;

public class PageObjectSearch extends DaimlerPageBase{
	
	public static String ADVANCE_SEARCH_BUTTON ;
	public static String SEARCH_BUTTON;
	public static String BASIC_SEARCH_BUTTON;
	public static String SIMPLE_SEARCH_BUTTON;
	public static String RESULT_TABLE;
	public static String HOME_TAB;
	
	/* Excel- Test data input columns */	
	public static String INPUT_COMBINATION;
	public static String EXP_RESULT;
	public static String TAB_NAME;
	public static String ID_COLUMN;	
	public static String CONTROL_TYPE;
	public static String FIELD_NAME;

	public PageObjectSearch(Browser browser, String propFile) throws Exception {

		super(propFile,browser);
		init(propFile);

	}

	
	
	public void init(String propFile) throws TestAutomationPropertyLoadException{
		PropertyReader reader = new PropertyReader(propFile);
		ADVANCE_SEARCH_BUTTON=reader.getProperties("ADVANCE_SEARCH_BUTTON");
		SIMPLE_SEARCH_BUTTON=reader.getProperties("SIMPLE_SEARCH_BUTTON");
		BASIC_SEARCH_BUTTON=reader.getProperties("BASIC_SEARCH_BUTTON");
		SEARCH_BUTTON = reader.getProperties("SEARCH_BUTTON");
		RESULT_TABLE = reader.getProperties("RESULT_TABLE");
		HOME_TAB = reader.getProperties("HOME_TAB");
		INPUT_COMBINATION = reader.getProperties("INPUT_COMBINATION");
		EXP_RESULT = reader.getProperties("EXP_RESULT");
		TAB_NAME = reader.getProperties("TAB_NAME");
		ID_COLUMN = reader.getProperties("ID_COLUMN");
		CONTROL_TYPE = reader.getProperties("CONTROL_TYPE");
		FIELD_NAME = reader.getProperties("FIELD_NAME");
		
	}


	public static WebElement advSearchButton() throws TestAutomationException{
		return getElementByXpath(ADVANCE_SEARCH_BUTTON, DescriptionInterface.ADV_SEARCH_BTN);
	}
	public static WebElement basicSearchButton() throws TestAutomationException{
		return getElementByXpath(BASIC_SEARCH_BUTTON, DescriptionInterface.ADV_SEARCH_BTN);
	}
	public static WebElement simpleSearchButton() throws TestAutomationException{
		return getElementByXpath(SIMPLE_SEARCH_BUTTON, DescriptionInterface.ADV_SEARCH_BTN);
	}
	public static WebElement searchButton() throws TestAutomationException{
		return getElementByXpath(SEARCH_BUTTON, DescriptionInterface.SEARCH_BTN);
	}
	

	public static WebElement homeTab() throws TestAutomationException{
		return getElementByXpath(HOME_TAB, DescriptionInterface.HOME_TAB);
	}
	public static WebElement result_Table() throws TestAutomationException{
		return getElementByXpath(RESULT_TABLE, DescriptionInterface.RESULT_TABLE);
	}
	public static void AdvSearchStatus() throws IOException, TestAutomationException{
		String expectedResult=readDataFromExcel(EXP_RESULT);
		//System.out.println("result_Table()="+result_Table());
		/*if(result_Table()!=null ){
			testResult(expectedResult);			
		}
		else{
			testResult("No Search Result Found");		
		}
		
		System.out.println(":::::::::::::::::::::::::::::::::::::::::::::::::"+textPresent("No matches found"));
		if(textPresent("No matches found")!=true){
			testResult(expectedResult);	
		}
		else if(textPresent("No matches found")){			
			testResult("No Search Result Found");
		} */
		String returnValue=textnClassPresent(expectedResult);
		System.out.println("::::::::::::::::::::::::::::::::::::::::::::::::: returnValue="+returnValue);		
		String[] arrValue=returnValue.split("-");
		String textFoundValue=arrValue[0];
		String hideClassValue=arrValue[1];
		if(textFoundValue.equals("true") && hideClassValue.equals("true")){
			testResult(expectedResult);	
		}else{
			testResult("No Search Result Found");
		}
		
	}
	public static String textnClassPresent(String Text){
		String textFound = "false"; 
		String hideClass="false";
		try {
			String xpath=".//*[contains(text(),'"+ Text + "')]";
			System.out.println("xpath=");
		    driver.findElement(By.xpath(xpath));
		    textFound = "true";		    
		    WebElement ele= driver.findElement(By.xpath(xpath));
		    String cName=ele.getAttribute("class");
		    if(cName.equals("ng-binding ng-hide")){
		    	hideClass="false";
		    	}else if(cName.equals("ng-binding")){
		    		hideClass="true";		    		
		    	}	
		    System.out.println(":::::::::::::::::::::::::::::::::::\n Text="+Text+"\n cName="+cName);
		} catch (Exception e) {
		    textFound = "false";
		    hideClass="false";
		}
		String rEle=textFound+"-"+hideClass;
		
		return rEle;
		
	}
	public static void basicNSimpleSearchStatus() throws InterruptedException{
		//String SString="Overview";
		//String FString="Advanced search";
		String expectedResult=readDataFromExcel(EXP_RESULT);
		if(driver.getPageSource().contains(expectedResult)){
			testResult(expectedResult);	
		}
		else{
			testResult("No Search Result Found");
		}
	}

	@Override
	public ExcelManager getNextTestCase() throws TestAutomationException, IOException, InterruptedException
	 {
		// TODO Auto-generated method stub
		return null;
	}


}