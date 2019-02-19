package com.portal.automation.daimler.pages.test.search;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;

public class UserSearch  extends Search{
	public UserSearch(String propFile,Browser browser) throws Exception {
		super(browser,propFile);		
	}
	
	public static void executeAdvanceSearchTestCase() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		advSearchButton().click();
		Thread.sleep(3000);
		String tabnNme=TAB_NAME;
		String idValue=ID_COLUMN;
		String controlType=CONTROL_TYPE;
		String fieldName=FIELD_NAME;
		String inputCombinationValue=getInputCombination(INPUT_COMBINATION);
		//System.out.println("\ntabnNme="+TAB_NAME+"\nID_COLUMN="+ID_COLUMN+"\nCONTROL_TYPE="+CONTROL_TYPE+"\nFIELD_NAME="+FIELD_NAME);
		populateInputCombination(tabnNme,inputCombinationValue,idValue,controlType,fieldName,false) ;	
		if(searchButton().isEnabled()){
			searchButton().click();
			Thread.sleep(2000);
			AdvSearchStatus();			
		}
		else{
			testResult("\"SEARCH\" Button is not enable.Please provide correct data!");
			//writeDataIntoExcel(ACT_RESULT, "\"SEARCH\" Button is not enable.Please provide correct data!");
		}
		
		
	}
	public static void executeBasicSearchTestCase() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		String tabnNme=TAB_NAME;
		String idValue=ID_COLUMN;
		String controlType=CONTROL_TYPE;
		String fieldName=FIELD_NAME;
		String inputCombinationValue=getInputCombination(INPUT_COMBINATION);
		//System.out.println("\ntabnNme="+TAB_NAME+"\nID_COLUMN="+ID_COLUMN+"\nCONTROL_TYPE="+CONTROL_TYPE+"\nFIELD_NAME="+FIELD_NAME);
		populateInputCombination(tabnNme,inputCombinationValue,idValue,controlType,fieldName,false) ;	
		if(basicSearchButton().isEnabled()){
			basicSearchButton().click();
			Thread.sleep(2000);
			basicNSimpleSearchStatus();			
		}
		else{
			testResult("\"BASIC SEARCH\" Button is not enable.Please provide correct data!");
			//writeDataIntoExcel(ACT_RESULT, "\"SEARCH\" Button is not enable.Please provide correct data!");
		}
		
	}
	public static void executeSimpleSearchTestCase() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		
		String tabnNme=TAB_NAME;
		String idValue=ID_COLUMN;
		String controlType=CONTROL_TYPE;
		String fieldName=FIELD_NAME;
		String inputCombinationValue=getInputCombination(INPUT_COMBINATION);
		System.out.println("inputCombinationValue="+inputCombinationValue+"\ntabnNme="+TAB_NAME+"\nID_COLUMN="+ID_COLUMN+"\nCONTROL_TYPE="+CONTROL_TYPE+"\nFIELD_NAME="+FIELD_NAME);
		populateInputCombination(tabnNme,inputCombinationValue,idValue,controlType,fieldName,true) ;	
		if(simpleSearchButton().isEnabled()){
			simpleSearchButton().click();
			Thread.sleep(2000);
			basicNSimpleSearchStatus();			
		}
		else{
			testResult("\"SIMPLE SEARCH\" Button is not enable.Please provide correct data!");
			//writeDataIntoExcel(ACT_RESULT, "\"SEARCH\" Button is not enable.Please provide correct data!");
		}
		
	}

}
