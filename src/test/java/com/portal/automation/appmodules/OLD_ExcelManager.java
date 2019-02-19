package com.portal.automation.appmodules;

import java.io.IOException;

import org.testng.Assert;

import com.portal.automation.appException.TestAutomationElementNotFoundException;
import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationGenericException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.PropertyReader;
import com.portal.automation.appmodules.TestAutomationCore;
import com.portal.automation.appmodules.Xls_Reader;
import com.portal.automation.daimler.page.common.DaimlerPageBase;




/**
 * Page Object base class. It provides the base structure and properties for a
 * page object to extend.
 */
public abstract class OLD_ExcelManager extends TestAutomationCore {

	 /* Common properties of the excel - test data & report file */
	 	public  String TEST_DATA_N_RESULT_WORKSHEET = null;
        public static  String TEST_CASE_NAME = null;
        public static String CURRENT_WORKSHEET =null;
        public static String EXP_RESULT = null;
        public static String ACT_RESULT = null;
        public static String TEST_STATUS = null;        
        public static int currentRow;
        public Browser  browser;
        public String controller;
        public String propFile;
	    public static Xls_Reader xls;
        public PropertyReader reader;
        
        public abstract ExcelManager getNextTestCase() throws TestAutomationException, IOException, InterruptedException;
        public abstract ExcelManager findAndGetNextTestCase();
        public abstract String getTestCaseXlsFile(String propFile) throws TestAutomationPropertyLoadException;
        
	
        
	/** Constructor 
	 * @throws Exception */
	public OLD_ExcelManager(Browser browser,String propFile,int currRow) throws Exception{
		super(browser);
		this.currentRow =currRow;
		this.browser =browser;
		this.propFile = propFile;
		initParams("PageCommon.properties");
		xls = new Xls_Reader(getTestCaseXlsFile(propFile), propFile);
				
	}
	
	

	private void initParams(String propFile) throws TestAutomationPropertyLoadException{
        PropertyReader reader = new PropertyReader(propFile);
      
        TEST_DATA_N_RESULT_WORKSHEET = reader.getProperties("TEST_DATA_N_RESULT_WORKSHEET");
        TEST_CASE_NAME = reader.getProperties("TEST_CASE_NAME");
        EXP_RESULT = reader.getProperties("EXP_RESULT");
        ACT_RESULT = reader.getProperties("ACT_RESULT");
        TEST_STATUS = reader.getProperties("TEST_STATUS");
        CURRENT_WORKSHEET = TEST_DATA_N_RESULT_WORKSHEET;
        
    }
	
	
	protected static int getCurrentRow() {
		// TODO Auto-generated method stub
		return currentRow;
	}
	
	public void setController(String controller){
		this.controller = controller;
	}
	
	public void  moveToNextRow(){	
		if(xls.getActiveRowCount(CURRENT_WORKSHEET)>currentRow) {
			currentRow++;
		}else {
			currentRow = -1;
		}
	}
	
	/* Reading from an external excel file */
	public static String readDataFromExcel(String colName) {
		int rowIndex = getCurrentRow();
		String cellValue = null;
		cellValue = xls.getCellData(CURRENT_WORKSHEET, colName, rowIndex);
		if (cellValue.contains(".")) {
			int indexOfDot = cellValue.indexOf(".");
			String subStr1 = cellValue.substring(0, indexOfDot);
			String subStr2 = cellValue.substring(indexOfDot + 1);
			if ("0".equals(subStr2)) {
				cellValue = subStr1;
			}
		}
		return cellValue;

	}
	
	
	/* Writing into an external excel file */
	public static void writeDataIntoExcel(String colName, String data) {
		
		int rowIndex = getCurrentRow();
		System.out.println("  There is some data to be written in the row number ::: "+rowIndex+"   ::::  "+data);
		xls.setCellData(CURRENT_WORKSHEET, colName, rowIndex, data);
		
	}
	
	
	/* Converting String into integer */
	public static int rowNum(String str) {
		int i = Integer.parseInt(str);

		return i;

	}

	public static int index(String str) {
		double d = Double.parseDouble(str);
		int i = (int) d;


		return i;

	}


	/* Capture the test result & status */
	public static String testStatus(String actResult, String expResult) {
		String Result = null;
		if (actResult!=""){
			if (actResult.equals(expResult)) {
				Result = "PASS";

			} else {
				Result = "FAIL";
			}}
		return Result;
	}


	public static  void testResult(String actResult){
		String expResult = readDataFromExcel(EXP_RESULT);
		
		writeDataIntoExcel(ACT_RESULT, actResult);
		String testStatus = testStatus(actResult, expResult);
		
		writeDataIntoExcel(TEST_STATUS, testStatus);

	}

	public  void testNGResult(String actResult) throws TestAutomationException{
		String expResult = readDataFromExcel(EXP_RESULT);
		Assert.assertEquals(actResult, expResult);
		
	}
	
	
}
