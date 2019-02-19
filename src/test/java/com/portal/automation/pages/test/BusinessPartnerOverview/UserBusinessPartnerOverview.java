package com.portal.automation.pages.test.BusinessPartnerOverview;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.omg.PortableServer.THREAD_POLICY_ID;

import com.portal.automation.appException.ElementDescriptionReader;
import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.page.objects.PageObjectCreateBusinessPartner;


public class UserBusinessPartnerOverview extends BusinessPartnerOverview {

	public UserBusinessPartnerOverview(Browser browser, String propFile) throws Exception {
		super(browser, propFile);
		// TODO Auto-generated constructor stub
	}

	public static void executeBpOverView()
			throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException {
		Thread.sleep(3000);
		String searchType=readDataFromExcel(SEARCH_TYPE);
		String tabnNme = "";
		String idValue = ID_COLUMN;
		String controlType = CONTROL_TYPE;
		String fieldName = Field_NAME;
		String inputCombinationValue = getInputCombination(INPUT_COMBINATION);		
	
		String[] inputCombinationArr = inputCombinationValue.split(",");
		
		for (int i = 0; i < inputCombinationArr.length; i++) {

			String inputCombination = inputCombinationArr[i];
			String sheetName = "";
			tabnNme = TAB_NAME;
			if (i == 0) {
				
				
				
							if(searchType.trim().equals("AdvancedSearch")){	
								bpoAdvanceSearchButton().click();
								populateInputCombination(tabnNme, inputCombination, idValue, controlType, fieldName, true);
										if (bpoSearchButton().isEnabled()) {
											bpoSearchButton().click();
											Thread.sleep(5000);
										} else {
											writeDataIntoExcel(TEST_STATUS, "Search button under Search Tab is not enabled");
											break;
										}
										if (bpoAdvanceSearchResultText().isDisplayed()) {											
											bpoAdvanceSearchResultFirstRow().click();
											Thread.sleep(5000);
										}
							}	
							else if(searchType.equals("BasicSearch")){
								populateInputCombination(tabnNme, inputCombination, idValue, controlType, fieldName, true);
								if(bpoBasicSearchButton().isEnabled()){
								bpoBasicSearchButton().click();
								Thread.sleep(5000);
								}
								else {
									writeDataIntoExcel(TEST_STATUS, "Basic Search button is not enabled");
									break;
								}
								
							}
				
				
				

			} else if (i == 1) {
				
				String dataValidation=validateInputCombination(tabnNme, inputCombination, idValue, controlType, fieldName);
				if(dataValidation.equals("Success")){
                	 testResult(readDataFromExcel(EXP_RESULT));
			     }else if(dataValidation.contains("Failed")){
			    	 if(dataValidation.contains(":::")){
			    		 String filedDetails=dataValidation.split(":::")[1];
					     String actualFieldName=ElementDescriptionReader.getReader().getProperties(filedDetails);	
					     testResult(actualFieldName+" value is not matching with the expected one.");
					     break;
			    	 }
			    	
			     }

				}else if(i==2){		
					bpoUserContactLink().click(); Thread.sleep(5000);
					String dataValidation=validateInputCombination(tabnNme, inputCombination, idValue, controlType, fieldName);
					if(dataValidation.equals("Success")){
	                	 testResult(readDataFromExcel(EXP_RESULT));
				     }else if(dataValidation.contains("Failed")){
				    	 if(dataValidation.contains(":::")){
				    		 String filedDetails=dataValidation.split(":::")[1];
						     String actualFieldName=ElementDescriptionReader.getReader().getProperties(filedDetails);	
						     testResult(actualFieldName+" value is not matching with the expected one.");
						     break;
				    	 }			    	
				     }
	
				}else if(i==3){	
					bpoUserDetailsLink().click(); Thread.sleep(5000);
					String dataValidation=validateInputCombination(tabnNme, inputCombination, idValue, controlType, fieldName);
					if(dataValidation.equals("Success")){
	                	 testResult(readDataFromExcel(EXP_RESULT));
				     }else if(dataValidation.contains("Failed")){
				    	 if(dataValidation.contains(":::")){
				    		 String filedDetails=dataValidation.split(":::")[1];
						     String actualFieldName=ElementDescriptionReader.getReader().getProperties(filedDetails);	
						     testResult(actualFieldName+" value is not matching with the expected one.");
						     break;
				    	 }			    	
				     }
			}else if(i==4){		
				bpoUserBankInfoLink().click(); Thread.sleep(5000);
				String dataValidation=validateInputCombination(tabnNme, inputCombination, idValue, controlType, fieldName);
				if(dataValidation.equals("Success")){
                	 testResult(readDataFromExcel(EXP_RESULT));
			     }else if(dataValidation.contains("Failed")){
			    	 if(dataValidation.contains(":::")){
			    		 String filedDetails=dataValidation.split(":::")[1];
					     String actualFieldName=ElementDescriptionReader.getReader().getProperties(filedDetails);	
					     testResult(actualFieldName+" value is not matching with the expected one.");
					     break;
			    	 }			    	
			     }
			}
			

		
		}

	}
	}
	
