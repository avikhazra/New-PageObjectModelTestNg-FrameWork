package com.portal.automation.pages.test.CreateBusinessPartner;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.omg.PortableServer.THREAD_POLICY_ID;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;
import com.portal.automation.appmodules.ExcelManager;
import com.portal.automation.daimler.page.objects.PageObjectCreateBusinessPartner;



public class UserCreateBusinessPartner extends CreateBusinessPartner {

	public UserCreateBusinessPartner(String propFile,Browser browser) throws Exception {
		super(browser, propFile);
		// TODO Auto-generated constructor stub
	}
	
	public static void executeCreateBusinessPartnerLink() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		Thread.sleep(2000);
		CreateUpdateButton().click();
		Thread.sleep(2000);
		CreateBusinessPartnerButtonClickStatus();		
	}
	public static void executeBPCreate()throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException
	{
		CreateUpdateButton().click();
		String tabnNme="";
		String idValue=ID_COLUMN;
		String controlType=CONTROL_TYPE;
		String fieldName=Field_Name;
		String inputCombinationValue=getInputCombination(INPUT_COMBINATION);
		System.out.println("inputCombinationValue="+inputCombinationValue);
		String[] inputCombinationArr=inputCombinationValue.split(",");
		for(int i=0;i<inputCombinationArr.length;i++){
			String inputCombination=inputCombinationArr[i];
			String sheetName="";
			tabnNme="Combination";
			if(i==0){
				populateInputCombination(tabnNme,inputCombination,idValue,controlType,fieldName,true) ;	
				if(CBP_Button().isEnabled()){
					CBP_Button().click();							
				}else{
					writeDataIntoExcel(ACT_RESULT, "\"Create New BP\" button under \"Create Business Partner\" Tab is not enabled.Please provide values for all mandatory fields!");
					homeTab().click();
					break;
					
					}			
				Thread.sleep(2000);
			}
			else if(i==1){					
				populateInputCombination(tabnNme,inputCombination,idValue,controlType,fieldName,false) ;
				
			}else if(i==2){						
				EditContact_Button().click();
				Thread.sleep(3000);
				populateInputCombination(tabnNme,inputCombination,idValue,controlType,fieldName,false) ;
				
				if(CBP_SaveContactButton().isEnabled()){
					CBP_SaveContactButton().click();
					Thread.sleep(2000);
				}else{
					writeDataIntoExcel(ACT_RESULT, "\"Save\" button under \"Contact\" poup is not enabled");
					homeTab().click();
					break;					
				}
				
				if(CBP_ContinueButton().isEnabled()){
					CBP_ContinueButton().click();
					Thread.sleep(2000);
				}else{
					writeDataIntoExcel(ACT_RESULT, "\"Continue\" button under \"Add BP Details\" tab is not enabled.Please provide values for all mandatory fields!");
					homeTab().click();
					break;
				}
			}
			else if(i==3){
				
				Thread.sleep(3000);						
				CBP_AddRelationshipButton().click();	
				Thread.sleep(2000);
				populateInputCombination(tabnNme,inputCombination,idValue,controlType,fieldName,true) ;
				//clcik the save button
				CBP_SaveBusinessRelationTypeButton().click();				
				Thread.sleep(10000);
				if(CBP_ThirdPageContinueButton().isEnabled()){
				CBP_ThirdPageContinueButton().click(); 
				Thread.sleep(2000);
				}
				else{
					writeDataIntoExcel(ACT_RESULT, "\"Continue\" button under \"Add Relationship\" tab is not enabled.Please provide values for all mandatory fields!");
					homeTab().click();
					break;				}
					}
			else if(i==4){
				//Do nothing.Later will implemet if any operation ahave to do in fourth page
				System.out.println(":::::::::::::::::::::::: i=4 ::::::::::::::::::::::::::::::::::::::::::::::::");
				//Click Continue on Fourth page
				if(CBP_FourthPageContinueButton().isEnabled()){
				CBP_FourthPageContinueButton().click();
				Thread.sleep(2000);
				}
				else{
					writeDataIntoExcel(ACT_RESULT, "\"Continue\" button under \"Add Address detail\" tab is not enabled.Please provide values for all mandatory fields!");
					homeTab().click();
					break;
				}
			}
			else if(i==5){
				//click add bank details pencil
				CBP_FifthPageaAddBankdetailsButton().click();	
				Thread.sleep(2000);
				populateInputCombination(tabnNme,inputCombination,idValue,controlType,fieldName,true) ;
				CBP_FifthPageaSaveBankdetailsButton().click();
				//click 5th page finish button
				if(CBP_FifthPageFinishButton().isEnabled()){
				CBP_FifthPageFinishButton().click();
				Thread.sleep(2000);	
				}
				else{
					//writeDataIntoExcel(ACT_RESULT, "\"Finish\" button under Add BankDetails tab is not enabled.Please provide values for all mandatory fields!");
					testResult("\"Finish\" button under Add BankDetails tab is not enabled.Please provide values for all mandatory fields!");	
					homeTab().click();
					break;					
				}
				// Check the status
				
				
			}
			else {
				writeDataIntoExcel(ACT_RESULT, "Business partner profile created successfully");
			}
			
					
		}
		CBP_CreateBusinessPartnerSuccessStatus();
	}
	
	
}
