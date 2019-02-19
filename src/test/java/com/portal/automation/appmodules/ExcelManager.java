package com.portal.automation.appmodules;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.portal.automation.appException.DescriptionInterface;
import com.portal.automation.appException.ElementDescriptionReader;
import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationGenericException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;




/**
 * Page Object base class. It provides the base structure and properties for a
 * page object to extend.
 */
public abstract class ExcelManager extends TestAutomationCore {

	 /* Common properties of the excel - test data & report file */
	 	public  String TEST_DATA_N_RESULT_WORKSHEET = null;
        public static  String TEST_CASE_NAME = null;
        public static String CURRENT_WORKSHEET =null;
        public static String EXP_RESULT = null;
        public static String ACT_RESULT = null;
        public static String TEST_STATUS = null;  
        public static String DROPDOWN;
    	public static String TEXT;
    	public static String DATE;
    	public static String RADIO;
    	public static String CHECK_BOX;
    	public static String BOOLEAN_CHECK_BOX;
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
	public ExcelManager(Browser browser,String propFile,int currRow) throws Exception{
		super(browser);
		this.currentRow =currRow;
		this.browser =browser;
		this.propFile = propFile;
		initParams("PageCommon.properties");// Getting all common properties
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
        DROPDOWN=reader.getProperties("DROPDOWN");
		TEXT = reader.getProperties("TEXT");
		DATE = reader.getProperties("DATE");
		RADIO = reader.getProperties("RADIO_BUTTON");
		CHECK_BOX = reader.getProperties("CHECK_BOX");
		BOOLEAN_CHECK_BOX = reader.getProperties("BOOLEAN_CHECK_BOX");

        
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
	
	/* Validate input Combination */
	
	public static String validateInputCombination(String tabName, String inputCombination, String idValue,
			String controlType, String fieldName) throws TestAutomationException, InterruptedException {
		int rowCount = getRowCount(tabName);
		//
		
		String dataValidationStatus="";
		
			for (int i = 1; i < rowCount; i++) {
				String metadataType = xls.getCellData(tabName, controlType, i);
				String metadataId = xls.getCellData(tabName, idValue, i);
				String metadataValue = xls.getCellData(tabName, inputCombination, i);
				String metaDataField = xls.getCellData(tabName, fieldName, i);
				metaDataField=metaDataField.replaceAll(" ", "_");
				
				try {
					if (inputCombination != null && inputCombination.trim().length() > 0) {
						boolean isValuePresent = false;
						if (metadataValue != null && metadataValue.trim().length() > 0) {
							isValuePresent = true;
						}

						if (TEXT.equalsIgnoreCase(metadataType)) {
							
							System.out.println("metadataId="+metadataId+"\n metadataValue="+metadataValue+"\n isValuePresent="+isValuePresent+"\n metaDataField=" +metaDataField);
							dataValidationStatus=validateTextOrDateField(metadataId, metadataValue, isValuePresent, metaDataField);
							System.out.println("dataPopulationStatus="+dataValidationStatus);
						} 
						

					} else {
						//nothing to do
						dataValidationStatus="Failed";
					}
					if(dataValidationStatus!=null && dataValidationStatus.trim().contains("Exception")){
						//System.out.println("Under error!!!!!!!!!!!!!!!!!!!!");
						
						if(dataValidationStatus.trim().contains("TestAutomationException")){
							throw new TestAutomationGenericException(dataValidationStatus);
						}else if(dataValidationStatus.trim().contains("InterruptedException")){
							throw new InterruptedException(dataValidationStatus);
						}
					}
					if(dataValidationStatus.contains("Failed")){
					
						break;
					}
					
				} catch (TestAutomationException e) {
					dataValidationStatus="Failed";
					break;
				} catch (InterruptedException e) {
					dataValidationStatus="Failed";
					break;
				}

			}
			
		
		
		
		//	

      return dataValidationStatus;
	}
	
	public static String validateTextOrDateField(String elementId,String displayText, boolean isValuePresent, String fieldName) throws TestAutomationException, InterruptedException{
	    String dataValidation="";
		try{
			// sendTextById(elementId,displayText,DescriptionInterface.FIELD_TITLE);
			if(isValuePresent){
				WebElement ele = getElementByXpath(elementId,fieldName);				
				if(ele!=null){
					String tempVal=ele.getText();
					if(tempVal.trim().contains(displayText.trim())){
						dataValidation="Success";	
						}	else{
						dataValidation="Failed:::"+fieldName;	
						}
				}
			}
			
		 }catch(TestAutomationException e){ 
			 // to do : retrieve the name of the metadata and show it the error msg
	
			 writeDataIntoExcel(TEST_STATUS, e.getMessage());
			// throw e;
			 if(isValuePresent){
				 dataValidation="TestAutomationException::: "+e.getMessage();
				  }
			
			 
		 } 
		
		return dataValidation;
		
	}
	
	/*Populate input combination*/
	
	public static void populateInputCombination(String tabName, String inputCombination, String idValue,
			String controlType, String fieldName, boolean clearRequired) throws TestAutomationException, InterruptedException {
		int rowCount = getRowCount(tabName);
		//
		
		String dataPopulationStatus="";
		
			for (int i = 1; i < rowCount; i++) {
				String metadataType = xls.getCellData(tabName, controlType, i);
				String metadataId = xls.getCellData(tabName, idValue, i);
				String metadataValue = xls.getCellData(tabName, inputCombination, i);
				String metaDataField = xls.getCellData(tabName, fieldName, i);
				metaDataField=metaDataField.replaceAll(" ", "_");
				try {
					if (inputCombination != null && inputCombination.trim().length() > 0) {
						boolean isValuePresent = false;
						if (metadataValue != null && metadataValue.trim().length() > 0) {
							isValuePresent = true;
						}

						if (TEXT.equalsIgnoreCase(metadataType)) {
							
							dataPopulationStatus=populateTextOrDateField(metadataId, metadataValue, isValuePresent, metaDataField);

						} else if (DROPDOWN.equalsIgnoreCase(metadataType)) {
							dataPopulationStatus=populateDropDownField(metadataId, metadataValue, isValuePresent, metaDataField);
						} else if (RADIO.equalsIgnoreCase(metadataType)) {
							dataPopulationStatus=populateRadioOrCheckBoxField(metadataId, metadataValue, isValuePresent, metaDataField,
									clearRequired);
						} else if (BOOLEAN_CHECK_BOX.equalsIgnoreCase(metadataType)) {
							dataPopulationStatus=populateBooleanCheckBoxField(metadataId, metadataValue, isValuePresent, metaDataField,
									clearRequired);
						}

					} else {
						if (clearRequired) {
						
							clearData(metadataId, metaDataField, metadataType);
						}
					}
					if(dataPopulationStatus!=null && dataPopulationStatus.trim().contains("Exception")){
						String errorMessage=(dataPopulationStatus.trim().split(""))[1].trim();
						if(dataPopulationStatus.trim().contains("TestAutomationException")){
							throw new TestAutomationGenericException(errorMessage);
						}else if(dataPopulationStatus.trim().contains("TestAutomationException")){
							throw new InterruptedException(errorMessage);
						}
					}
					
				} catch (TestAutomationException e) {
					
			
				} catch (InterruptedException e) {
					
				}

			}
			
		
		
		
		//	


	}
	
	private static void clearData(String metadataId,String fieldName, String metadataType) {
		 try {
			 if(TEXT.equalsIgnoreCase(metadataType)){	
				 WebElement ele = getElementByXpath(metadataId,fieldName);
				 ele.clear();
			 }else if(DROPDOWN.equalsIgnoreCase(metadataType)){	
				 WebElement dropDownListBox = getElementByXpath(metadataId,fieldName);
					
					if(dropDownListBox!=null){
						Select clickThis = new Select(dropDownListBox);		
						clickThis.selectByIndex(0);
					}
				
			 }else if(RADIO.equalsIgnoreCase(metadataType)){					
				
			 }else if(BOOLEAN_CHECK_BOX.equalsIgnoreCase(metadataType)){					
				
			 }
		} catch (TestAutomationException e) {
			 writeDataIntoExcel(TEST_STATUS, e.getMessage());
		}
		
	}
	public static String populateRadioOrCheckBoxField(String elementId,String displayText, boolean isValuePresent, String fieldName,boolean clearRequired) throws TestAutomationException{		
		 String dataValidation="";
		 return  dataValidation;

	}
	
	public static String populateTextOrDateField(String elementId,String displayText, boolean isValuePresent, String fieldName) throws TestAutomationException, InterruptedException{
	    String dataValidation="";
		try{
			if(isValuePresent){
				WebElement ele = getElementByXpath(elementId,fieldName);
				
				if(ele!=null){
				
					 ele.clear();
			
				
				 if(isValuePresent){
					 Thread.sleep(500);
					 ele.sendKeys(displayText);
				 }
				}
				dataValidation="Success";
				
			}
			
		 }catch(TestAutomationException e){ 
			  writeDataIntoExcel(TEST_STATUS, e.getMessage());
			 if(isValuePresent){
				 dataValidation="TestAutomationException::: "+e.getMessage();
			 }
			
			 
		 } catch (InterruptedException e) {
			
			 writeDataIntoExcel(TEST_STATUS, e.getMessage());
			 if(isValuePresent){
				 dataValidation="InterruptedException::: "+e.getMessage();
			 }
		} 
		
		return dataValidation;
		
	}
	
	public static String populateBooleanCheckBoxField(String elementId,String displayText, boolean isValuePresent, String fieldName,boolean clearRequired) throws TestAutomationException{
		String dataValidation="";
		return dataValidation;
	}
	
	
	public static String populateDropDownField(String elementId,String displayText, boolean isValuePresent, String fieldName) throws TestAutomationException{
	 String dataValidation="";
		try{
			if(isValuePresent){
				WebElement dropDownListBox = getElementByXpath(elementId,fieldName);
				
				if(dropDownListBox!=null){
					Select clickThis = new Select(dropDownListBox);		
					clickThis.selectByIndex(0);
					if(isValuePresent){
						clickThis.selectByVisibleText(displayText);		
					}
				}
				dataValidation="Success";
			}
		
	}
	catch(TestAutomationException e){writeDataIntoExcel(TEST_STATUS, e.getMessage());		
		if(isValuePresent){
			dataValidation="TestAutomationException::: "+e.getMessage();
		}
		
		
		 
	}
		return dataValidation;
		
	}
	
	//
	
	public static  String getInputCombination(String inputCombination) throws TestAutomationException{
	
		String externalInput = readDataFromExcel(inputCombination);
		return externalInput;		
	}
	
	
	/* Writing into an external excel file */
	public static void writeDataIntoExcel(String colName, String data) {
		
		int rowIndex = getCurrentRow();	
		xls.setCellData(CURRENT_WORKSHEET, colName, rowIndex, data);
		
	}
	
	public static int getRowCount(String sheetName){
		
		int rowCount= xls.getRowCount(sheetName);
			
        return rowCount;
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
