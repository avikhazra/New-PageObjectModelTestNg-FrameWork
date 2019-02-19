package com.portal.automation.daimler.page.common;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.portal.automation.appException.DescriptionInterface;
import com.portal.automation.appException.ElementDescriptionReader;
import com.portal.automation.appException.TestAutomationElementNotFoundException;
import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationGenericException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.appmodules.PropertyReader;
import com.portal.automation.appmodules.Xls_Reader;
import com.portal.automation.pages.test.TestNGTests.TestCaseIdentifier;



public class DaimlerPageBase extends ExcelManager{
	/** Constructor */
	protected String propFile;
	public String TESTDATA_N_RESULT_FILE_NAME = null;
	
	
		
	public DaimlerPageBase(String propFile,Browser browser) throws Exception {
		super(browser,propFile,0);
		this.propFile = propFile;
			
	}
	
	
	
	@Override
	public String getTestCaseXlsFile(String propFile) throws TestAutomationPropertyLoadException {
		PropertyReader reader = new PropertyReader(propFile);
		TESTDATA_N_RESULT_FILE_NAME = reader.getProperties("TESTDATA_N_RESULT_FILE_NAME");
		return TESTDATA_N_RESULT_FILE_NAME;
		
	}

	@Override
	public ExcelManager findAndGetNextTestCase(){
		ExcelManager obj =null;
		try {
			moveToNextRow();
			String testCaseName= readDataFromExcel(TEST_CASE_NAME);
			 if (("*".equals(controller) || controller.length()==0 || controller.indexOf(testCaseName)!=-1)){
				obj = getNextTestCase();
			 }
			 			
			 if((xls.getActiveRowCount(CURRENT_WORKSHEET)>currentRow && obj== null)|| currentRow==0){
				obj = findAndGetNextTestCase();
			}
		
				
		}catch(TestAutomationElementNotFoundException ex){
			
			writeDataIntoExcel(TEST_STATUS, ex.getMessage());
			obj = findAndGetNextTestCase();
		}catch(TestAutomationPropertyLoadException ex){
			
			writeDataIntoExcel(TEST_STATUS, ex.getMessage());
			obj = findAndGetNextTestCase();
			
		}catch(TestAutomationException ex){
			
			writeDataIntoExcel(TEST_STATUS, ex.getMessage());
			obj = findAndGetNextTestCase();
		}catch(Exception ex){
			
			writeDataIntoExcel(TEST_STATUS, ex.getMessage());
			obj = findAndGetNextTestCase();
		}
		
		return obj;
	}
	
	@Override
	public ExcelManager getNextTestCase() throws TestAutomationException, IOException, InterruptedException {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}



