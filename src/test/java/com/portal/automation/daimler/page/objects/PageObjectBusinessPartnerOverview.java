package com.portal.automation.daimler.page.objects;

import java.io.IOException;
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

public class PageObjectBusinessPartnerOverview extends DaimlerPageBase {
	public static String BP_HOME_TAB;
	//public static String BASIC_SEARCH_TEXTBOX;
	public static String BASIC_SEARCH_BUTTON;
	public static String Adv_Search_Button;
	public static String Search_Button;
	public static String ID_COLUMN;	
	public static String CONTROL_TYPE;	
	public static String Field_NAME;
	public static String TAB_NAME;
	public static String INPUT_COMBINATION;
	public static String RESULT_OUTPUT_TEXT;
	public static String RESULT_TABLE_FIRST_ROW;
	public static String USER_OVERVIEW_Link;
	public static String USER_CONTACT_Link;
	public static String USER_DETAILS_Link;
	public static String USER_BANKINFO_Link;
	/* Excel cell*/
	public static String SEARCH_TYPE;
	
	public PageObjectBusinessPartnerOverview(Browser browser, String propFile)
			throws Exception {
			super(propFile, browser);
			init(propFile);
		// TODO Auto-generated constructor stub
	}
	public void init(String propFile) throws TestAutomationPropertyLoadException{
		PropertyReader reader = new PropertyReader(propFile);
		BP_HOME_TAB=reader.getProperties("BP_HOME_TAB");
		//BASIC_SEARCH_TEXTBOX= reader.getProperties("BASIC_SEARCH_TEXTBOX");
		BASIC_SEARCH_BUTTON=reader.getProperties("BASIC_SEARCH_BUTTON");
		Adv_Search_Button=reader.getProperties("ADVANCE_SEARCH_BUTTON");
		Search_Button=reader.getProperties("SEARCH_BUTTON");
		INPUT_COMBINATION=reader.getProperties("INPUT_COMBINATION");
		ID_COLUMN = reader.getProperties("ID_COLUMN");
		Field_NAME=reader.getProperties("FIELD_NAME");
		TAB_NAME=reader.getProperties("TAB_NAME");
		CONTROL_TYPE = reader.getProperties("CONTROL_TYPE");
		RESULT_OUTPUT_TEXT = reader.getProperties("RESULT_OUTPUT_TEXT");
		RESULT_TABLE_FIRST_ROW = reader.getProperties("RESULT_TABLE_FIRST_ROW");
		USER_OVERVIEW_Link=reader.getProperties("USER_OVERVIEW_Link");
		USER_CONTACT_Link=reader.getProperties("USER_CONTACT_Link");
		USER_DETAILS_Link=reader.getProperties("USER_DETAILS_Link");
		USER_BANKINFO_Link=reader.getProperties("USER_BANKINFO_Link");
		SEARCH_TYPE=reader.getProperties("SEARCH_TYPE");
		
	}

	
	//Home Tab
	public static WebElement homeTab() throws TestAutomationException{
		return getElementByXpath(BP_HOME_TAB, DescriptionInterface.BP_HOME_TAB);
	}
	// Landing Page Advance search button
	public static WebElement bpoAdvanceSearchButton() throws TestAutomationException{
		return getElementByXpath(Adv_Search_Button, DescriptionInterface.BPO_ADVANCE_SEARCH_BUTTON);
	}
	//Basic Search Button
	public static WebElement bpoBasicSearchButton() throws TestAutomationException{
		return getElementByXpath(BASIC_SEARCH_BUTTON, DescriptionInterface.BPO_BASIC_SEARCH_BUTTON);
	}
	//Adv Search button
	public static WebElement bpoSearchButton() throws TestAutomationException{
		return getElementByXpath(Search_Button, DescriptionInterface.BPO_Search_Button);
	}
	
	//Adv Search result text
	public static WebElement bpoAdvanceSearchResultText()throws TestAutomationException{		
		return getElementByXpath(RESULT_OUTPUT_TEXT,DescriptionInterface.BPO_Result_Output_Text);
	}
	
	//Adv search 1st row of result
	public static WebElement bpoAdvanceSearchResultFirstRow()throws TestAutomationException{		
		return getElementByXpath(RESULT_TABLE_FIRST_ROW,DescriptionInterface.BPO_Result_Table_First_Row);
	}
	
	//Adv Search USER_OVERVIEW 
	public static WebElement BPO_User_Overview_Link()throws TestAutomationException{		
		return getElementByXpath(USER_OVERVIEW_Link,DescriptionInterface.BPO_User_Overview);
	}
	//Adv USER_CONTACT_Link
	public static WebElement bpoUserContactLink()throws TestAutomationException{		
		return getElementByXpath(USER_CONTACT_Link,DescriptionInterface.BPO_User_Contact);
	}
	//Adv USER_DETAILS_Link
		public static WebElement bpoUserDetailsLink()throws TestAutomationException{		
			return getElementByXpath(USER_DETAILS_Link,DescriptionInterface.BPO_User_Details);
		}
	//Adv USER_BANKINFO_Link
		public static WebElement bpoUserBankInfoLink()throws TestAutomationException{		
			return getElementByXpath(USER_BANKINFO_Link,DescriptionInterface.BPO_User_Bank_Info);
		}
	
	
	public static void advanceSearchButtonClickStatus() throws IOException, TestAutomationException{
		System.out.println("EXP_RESULT  :::::   "+EXP_RESULT);
		System.out.println("readDataFromExcel(EXP_RESULT)  ::::   "+readDataFromExcel(EXP_RESULT));
		if(driver.getPageSource().contains(readDataFromExcel(EXP_RESULT))){
			testResult(readDataFromExcel(EXP_RESULT));				
		}
		else testResult("Failed to move to Advance Search Page");
	}
	public static void ValidationStatus()throws IOException, TestAutomationException{
		///
		
	}

}
