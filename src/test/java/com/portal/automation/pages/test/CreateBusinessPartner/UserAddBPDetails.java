package com.portal.automation.pages.test.CreateBusinessPartner;

import java.io.IOException;

import com.portal.automation.appException.TestAutomationException;
import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.Browser;

public class UserAddBPDetails extends CreateBusinessPartner{

	public UserAddBPDetails(String propFile,Browser browser) throws Exception {
		super(browser, propFile);
		// TODO Auto-generated constructor stub
	}
	
		
	
	public static void executeTestCaseFillDetails() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		
		String tabnNme=INPUT_DATA_SECOND_PAGE;
		String idValue=ID_COLUMN;
		String controlType=CONTROL_TYPE;
		String fieldName=Field_Name;
		Thread.sleep(2000);		
		CBP_Button().click();
		Thread.sleep(2000);
		System.out.println("Field Name is :::::::::::::::::::::::::::::::;;;; "+fieldName);
		String inputCombination = getInputCombination(INPUT_COMBINATION);
		//System.out.println("tabnNme="+tabnNme+"; idValue="+idValue+"; controlType="+controlType+"; inputCombination="+inputCombination);
		populateInputCombination(tabnNme,inputCombination,idValue,controlType,fieldName,true) ;		
		Thread.sleep(1000);
		//CBT_CreateNewBPButtonEnableStatus();
		CBT_AddBPDetailsButtonEnableStatus();
		Thread.sleep(1000);
	}
	public static void executeTestCaseFillContact() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		String tabnNme=INPUT_DATA_SECOND_PAGE;
		String idValue=ID_COLUMN;
		String controlType=CONTROL_TYPE;
		String fieldName=Field_Name;		
		EditContact_Button().click();
		Thread.sleep(5000);
		String inputCombination=getInputCombination(INPUT_COMBINATION);
		//System.out.println("Filling up the sub form.........................");
		populateInputCombination(tabnNme,inputCombination,idValue,controlType,fieldName,false) ;	
		Thread.sleep(3000);		
		CBT_SecondPagaeSaveContactButtonEnableStatus();
		CBP_SaveContactButton().click();
		Thread.sleep(5000);		
	}
	public static void CheckSecondPageContinueButtonEnable() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
			//EditContact_Button().click();
		Thread.sleep(3000);		
		CBT_AddBPDetailsButtonEnableStatus();	
	}
	/*public static void Stub_FillDetailPage() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
	Thread.sleep(3000);	
	String tabnNme=INPUT_DATA_SECOND_PAGE;
	String idValue=ID_COLUMN;
	String controlType=CONTROL_TYPE;
	String fieldName="Field Name";
	//Thread.sleep(2000);
	String inputCombination = getInputCombination(INPUT_COMBINATION);	
	populateInputCombination(tabnNme,inputCombination,idValue,controlType,fieldName) ;		
	Thread.sleep(1000);
	
   }*/
	//THIRD PAGE
	public static void executeTestCaseFillAddRelationship() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		String tabnNme=INPUT_DATA_THIRD_PAGE;
		String idValue=ID_COLUMN;
		String controlType=CONTROL_TYPE;
		String fieldName="Field Name";		
		//CLICK 2ND PAGE CONTINUE BUTTON
		CBP_ContinueButton().click();
		//WAIT FOR FEW SECOND TO LOAD
		Thread.sleep(3000);
		///click on pencil button under thrid page
		CBP_AddRelationshipButton().click();
		//select the right data from dropdown field with input combination
		String inputCombination=getInputCombination(INPUT_COMBINATION);
		System.out.println("tabnNme="+tabnNme+" inputCombination="+ inputCombination + " idValue="+idValue+" controlType="+controlType+" fieldName="+fieldName);
		//tabnNme=null inputCombination=IC5 idValue=FEILD_REF controlType=Control Type fieldName=Field Name
		populateInputCombination(tabnNme,inputCombination,idValue,controlType,fieldName,true) ;
		//clcik the save button
		CBP_SaveBusinessRelationTypeButton().click();
		//check the enable stat of third page continue button
		CBP_ThirdPageContinueButtonEnableStatus();		
		
	}
	//Fourth Page
	public static void executeTestCaseAddAddressDetail() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		System.out.println("Checking 4th page continue button enable stat..................");
		//Click Continue on third page
		CBP_ThirdPageContinueButton().click();
		//check 4th page continue button enable stat
		CBP_FourthPageContinueButtonEnableStatus();		
	}
	
	//Fifth Page
	public static void executeTestCaseAddBankDetails() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		System.out.println("Checking 5th page Finish button enable stat..................");
		String tabnNme=INPUT_DATA_FIFTH_PAGE;
		String idValue=ID_COLUMN;
		String controlType=CONTROL_TYPE;
		String fieldName="Field Name";	
		
		//Click Continue on Fourth page
		CBP_FourthPageContinueButton().click();
		//wait 2 sec
		Thread.sleep(2000);
		//click add bank details pencil
		CBP_FifthPageaAddBankdetailsButton().click();		
		//fill bank details
		String inputCombination=getInputCombination(INPUT_COMBINATION);
		System.out.println("tabnNme="+tabnNme+" inputCombination="+ inputCombination + " idValue="+idValue+" controlType="+controlType+" fieldName="+fieldName);
		populateInputCombination(tabnNme,inputCombination,idValue,controlType,fieldName,true) ;
		//clcik save button
		CBP_FifthPageaSaveBankdetailsButton().click();
		//check 5th page finish button status
		CBP_FifthPageFinishButtonEnableStatus();
			
	}
	//CreateBusinessPartnerSuccessStatus
	public static void executeTestCaseCreateBusinessPartnerStatus() throws TestAutomationPropertyLoadException, TestAutomationException, IOException, InterruptedException{
		System.out.println("executeTestCaseCreateBusinessPartnerStatus..................");
		//click 5th page finish button
		CBP_FifthPageFinishButton().click();
		Thread.sleep(5000);		
		// Check the status
		CBP_CreateBusinessPartnerSuccessStatus();
			
	}
	
	
}
