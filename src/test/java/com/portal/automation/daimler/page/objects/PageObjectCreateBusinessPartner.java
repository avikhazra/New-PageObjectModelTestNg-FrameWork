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

public class PageObjectCreateBusinessPartner  extends DaimlerPageBase {
	
	/* webelements -  */
	public static String HOME_TAB;
	public static String Create_Btn ;
	public static String create_page_Result_Label;
	public static String Create_Page_Text;
	public static String CBP_BUSINESS_PARTNER_TYPE ;
	public static String CBP_PERSON_NAMING_TYPE ;
	public static String CBP_SALUTATION ;
	public static String CBP_FIRST_NAME ; 
	public static String CBP_LAST_NAME ;
	public static String CBP_STREET ;
	public static String CBP_NO ;
	public static String CBP_CITY ; 
	public static String CBP_POSTCODE ; 
	public static String CBP_COUNTRY ;
	public static String CBP_DATE_OF_BIRTH ; 
	public static String CBP_CREATE_BP_BUTTON;
	public static String CBP_CONTINUE_BUTTON;
	public static String CBP_CREATE_BP_EDIT_CONTACT_BUTTON;
	public static String CBP_CREATE_BP_SAVE_BUTTON;	
	public static String CBP_CREATE_BP_SECONDPAGE_CONTINUE_BUTTON;
	public static String CBP_CREATE_BP_THIRDPAGE_ADDRELATIONSHIP_BUTTON;
	public static String CBP_CREATE_BP_THIRDPAGE_SAVE_BUTTON;
	public static String CBP_CREATE_BP_THIRDPAGE_CONTINUE_BUTTON;
	public static String CBP_CREATE_BP_FOURTHPAGE_CONTINUE_BUTTON;	
	public static String CBP_CREATE_BP_FIFTHPAGE_BANKDETAILS_ADD_BUTTON;
	public static String CBP_CREATE_BP_FIFTHPAGE_BANKDETAILS_SAVE_BUTTON;			
	public static String CBP_CREATE_BP_FIFTHPAGE_FINISH_BUTTON;
	
	/* Excel- Test data input columns */
	public static String EXP_RESULT;
	public static String BUSINESS_PARTNER_TYPE;
	public static String PERSON_NAMING_TYPE;
	public static String SALUTATION;	
	public static String FIRST_NAME;	
	public static String LAST_NAME;
	public static String STREET;	
	public static String NO;	
	public static String CITY;
	public static String POST_CODE;
	public static String COUNTRY;
	public static String DATE_OF_BIRTH;
	
	public static String CBP_CREATE_BP_HOME_TAB;
	public static String INPUT_DATA_FIRST_PAGE;
	public static String INPUT_DATA_SECOND_PAGE;
	public static String INPUT_DATA_THIRD_PAGE;
	public static String INPUT_DATA_FIFTH_PAGE;
	public static String INPUT_COMBINATION;	
	public static String ID_COLUMN;	
	public static String CONTROL_TYPE;

	public static String INPUT_DATA_BP_CREATION;
	public static String Field_Name;
	
	public PageObjectCreateBusinessPartner(Browser browser, String propFile) throws Exception {

		super(propFile,browser);
		init(propFile);

	}
	public void init(String propFile) throws TestAutomationPropertyLoadException{
		PropertyReader reader = new PropertyReader(propFile);
		HOME_TAB = reader.getProperties("HOME_TAB");
		Create_Btn=reader.getProperties("Create_Btn");
		create_page_Result_Label = reader.getProperties("create_page_Result_Label");
		Create_Page_Text = reader.getProperties("Create_Page_Text");		
		EXP_RESULT=reader.getProperties("EXP_RESULT");		
		
		CBP_CREATE_BP_HOME_TAB=reader.getProperties("CBP_CREATE_BP_HOME_TAB");
		CBP_CREATE_BP_BUTTON = reader.getProperties("CBP_CREATE_BP_BUTTON");
		CBP_CONTINUE_BUTTON=reader.getProperties("CBP_CONTINUE_BUTTON");
		INPUT_DATA_FIRST_PAGE=reader.getProperties("INPUT_DATA_FIRST_PAGE");
		CBP_CREATE_BP_EDIT_CONTACT_BUTTON=reader.getProperties("CBP_CREATE_BP_EDIT_CONTACT_BUTTON");
		CBP_CREATE_BP_SAVE_BUTTON=reader.getProperties("CBP_CREATE_BP_SAVE_BUTTON");
		CBP_CREATE_BP_SECONDPAGE_CONTINUE_BUTTON=reader.getProperties("CBP_CREATE_BP_SECONDPAGE_CONTINUE_BUTTON");
		
		INPUT_DATA_SECOND_PAGE=reader.getProperties("INPUT_DATA_SECOND_PAGE");
		INPUT_DATA_THIRD_PAGE=reader.getProperties("INPUT_DATA_THIRD_PAGE");
		INPUT_COMBINATION=reader.getProperties("INPUT_COMBINATION");
		ID_COLUMN = reader.getProperties("ID_COLUMN");
		CONTROL_TYPE = reader.getProperties("CONTROL_TYPE");
		/*tHIRD PAGE */
		CBP_CREATE_BP_THIRDPAGE_ADDRELATIONSHIP_BUTTON = reader.getProperties("CBP_CREATE_BP_THIRDPAGE_ADDRELATIONSHIP_BUTTON");
		CBP_CREATE_BP_THIRDPAGE_SAVE_BUTTON = reader.getProperties("CBP_CREATE_BP_THIRDPAGE_SAVE_BUTTON");
		CBP_CREATE_BP_THIRDPAGE_CONTINUE_BUTTON = reader.getProperties("CBP_CREATE_BP_THIRDPAGE_CONTINUE_BUTTON");		
		// FOURTH PAGE
		CBP_CREATE_BP_FOURTHPAGE_CONTINUE_BUTTON=reader.getProperties("CBP_CREATE_BP_FOURTHPAGE_CONTINUE_BUTTON");
		//FIFTH PAGE
		INPUT_DATA_FIFTH_PAGE = reader.getProperties("INPUT_DATA_FIFTH_PAGE");
		CBP_CREATE_BP_FIFTHPAGE_BANKDETAILS_ADD_BUTTON=reader.getProperties("CBP_CREATE_BP_FIFTHPAGE_BANKDETAILS_ADD_BUTTON");
		CBP_CREATE_BP_FIFTHPAGE_BANKDETAILS_SAVE_BUTTON=reader.getProperties("CBP_CREATE_BP_FIFTHPAGE_BANKDETAILS_SAVE_BUTTON");
		CBP_CREATE_BP_FIFTHPAGE_FINISH_BUTTON=reader.getProperties("CBP_CREATE_BP_FIFTHPAGE_FINISH_BUTTON");
		
		Field_Name=reader.getProperties("Field_Name");
		INPUT_DATA_BP_CREATION=reader.getProperties("INPUT_DATA_BP_CREATION");
	}
	public static WebElement HomeTab() throws TestAutomationException{
		return getElementByXpath(CBP_CREATE_BP_HOME_TAB, DescriptionInterface.CBP_CREATE_BP_HOME_TAB);
	}
	public static WebElement CreateUpdateButton() throws TestAutomationException{
		return getElementByXpath(Create_Btn, DescriptionInterface.Create_Btn);
	}
	public static String CreateUpdatePageTitle() throws TestAutomationException{
		return getElementByXpath(create_page_Result_Label, DescriptionInterface.create_page_Result_Label).getText();
	}
	public static void CreateBusinessPartnerButtonClickStatus() throws IOException, TestAutomationException{
		System.out.println("EXP_RESULT  :::::   "+EXP_RESULT);
		System.out.println("readDataFromExcel(EXP_RESULT)  ::::   "+readDataFromExcel(EXP_RESULT));
		if(driver.getPageSource().contains(readDataFromExcel(EXP_RESULT))){
			testResult(readDataFromExcel(EXP_RESULT));				
		}

		else testResult("Failed to move to Create Business Partner tab");

	}
	public static void CBP_SelectPartnerType() throws TestAutomationException {
		selectSpecificOptionFromDropDown(CBP_BUSINESS_PARTNER_TYPE, readDataFromExcel(BUSINESS_PARTNER_TYPE), DescriptionInterface.CBP_BUSINESS_PARTNER_TYPE);
	}
	public static void CBP_SelectPersonNameType() throws TestAutomationException {
		selectSpecificOptionFromDropDown(CBP_PERSON_NAMING_TYPE, readDataFromExcel(PERSON_NAMING_TYPE), DescriptionInterface.CBP_PERSON_NAMING_TYPE);
	}
	public static void CBP_SelectSalutation() throws TestAutomationException {
		selectSpecificOptionFromDropDown(CBP_SALUTATION, readDataFromExcel(SALUTATION), DescriptionInterface.CBP_SALUTATION);
	}
	public static WebElement CBP_FirstName() throws TestAutomationException{
		return getElementByXpath(CBP_FIRST_NAME, DescriptionInterface.CBP_FIRST_NAME);
	}
	public static WebElement CBP_LastName() throws TestAutomationException{
		return getElementByXpath(CBP_LAST_NAME, DescriptionInterface.CBP_LAST_NAME);
	}
	public static WebElement CBP_Street() throws TestAutomationException{
		return getElementByXpath(CBP_STREET, DescriptionInterface.CBP_STREET);
	}
	public static WebElement CBP_No() throws TestAutomationException{
		//System.out.println("CBP_NO ="+CBP_NO);
		return getElementByXpath(CBP_NO, DescriptionInterface.CBP_NO);
	}
	public static WebElement CBP_City() throws TestAutomationException{
		return getElementByXpath(CBP_CITY, DescriptionInterface.CBP_CITY);
	}
	public static WebElement CBP_Poscode() throws TestAutomationException{
		return getElementByXpath(CBP_POSTCODE, DescriptionInterface.CBP_POSTCODE);
	}
	public static void CBP_SelectCountry() throws TestAutomationException {
		selectSpecificOptionFromDropDown(CBP_COUNTRY, readDataFromExcel(COUNTRY), DescriptionInterface.CBP_COUNTRY);
	}
	public static WebElement CBP_DateOfBirth() throws TestAutomationException{
		return getElementByXpath(CBP_DATE_OF_BIRTH, DescriptionInterface.CBP_DATE_OF_BIRTH);
	}
	public static WebElement CBP_Button() throws TestAutomationException{
		return getElementByXpath(CBP_CREATE_BP_BUTTON, DescriptionInterface.CBP_CREATE_BP_BUTTON);
	}
	public static WebElement CBP_ContinueButton() throws TestAutomationException{
		return getElementByXpath(CBP_CONTINUE_BUTTON, DescriptionInterface.CBP_CONTINUE_BUTTON);
	}
	public static WebElement CBP_SaveContactButton() throws TestAutomationException{
		System.out.println("CBP_CREATE_BP_SAVE_BUTTON="+CBP_CREATE_BP_SAVE_BUTTON);
		return getElementByXpath(CBP_CREATE_BP_SAVE_BUTTON, DescriptionInterface.CBP_CREATE_BP_SAVE_BUTTON);
	}
	public static WebElement CBP_SecondPageContinuetButton() throws TestAutomationException{
		return getElementByXpath(CBP_CREATE_BP_SECONDPAGE_CONTINUE_BUTTON, DescriptionInterface.CBP_CREATE_BP_SECONDPAGE_CONTINUE);
	}
	public static WebElement EditContact_Button() throws TestAutomationException{
		return getElementByXpath(CBP_CREATE_BP_EDIT_CONTACT_BUTTON, DescriptionInterface.CBP_CREATE_BP_EDIT_CONTACT_BUTTON);
	}
	public static void CBT_CreateNewBPButtonClickStatus() throws IOException, TestAutomationException{
		System.out.println("EXP_RESULT  :::::   "+EXP_RESULT);
		System.out.println("readDataFromExcel(EXP_RESULT)  ::::   "+readDataFromExcel(EXP_RESULT));
		if(driver.getPageSource().contains(readDataFromExcel(EXP_RESULT))){
			testResult(readDataFromExcel(EXP_RESULT));				
		}

		else testResult("Failed to Click on Create new BP button");
	}
	public static void CBT_CreateNewBPButtonEnableStatus() throws IOException, TestAutomationException{
		String excelValue=readDataFromExcel(ACT_RESULT)+"/n";
		if(CBP_Button().isEnabled()){
			testResult(readDataFromExcel(EXP_RESULT));				
		}

		else testResult("Button is not enable");

	}
	public static void CBT_ClearData() throws IOException, TestAutomationException{
		
	

		testResult("");

	}
	//CBP_CONTINUE_BUTTON
	public static void CBT_AddBPDetailsButtonEnableStatus() throws IOException, TestAutomationException{
		System.out.println("EXP_RESULT  :::::   "+EXP_RESULT);
		System.out.println("readDataFromExcel(EXP_RESULT)  ::::   "+readDataFromExcel(EXP_RESULT));
		if(CBP_ContinueButton().isEnabled()){
			testResult(readDataFromExcel(EXP_RESULT));				
		}
		else testResult("Button is not enable");
	}
	public static void CBT_SecondPagaeContinueButtonEnableStatus() throws IOException, TestAutomationException{
		//System.out.println("EXP_RESULT  :::::   "+EXP_RESULT);
		//System.out.println("readDataFromExcel(EXP_RESULT)  ::::   "+readDataFromExcel(EXP_RESULT));
		if(CBP_SecondPageContinuetButton().isEnabled()){
			testResult(readDataFromExcel(EXP_RESULT));				
		}
		else testResult("Button is not enable");
	}
	//CBP_SaveContactButton button enable check
	public static void CBT_SecondPagaeSaveContactButtonEnableStatus() throws IOException, TestAutomationException{
		
		if(CBP_SaveContactButton().isEnabled()){
			testResult(readDataFromExcel(EXP_RESULT));				
		}
		else testResult("Save Button is not enable");
	}
	
	/*THIRD PAGE*/
	public static WebElement CBP_AddRelationshipButton() throws TestAutomationException{
		return getElementByXpath(CBP_CREATE_BP_THIRDPAGE_ADDRELATIONSHIP_BUTTON, DescriptionInterface.CBP_CREATE_BP_THIRDPAGE_ADDRELATIONSHIP_BUTTON);
	}
	public static WebElement CBP_SaveBusinessRelationTypeButton() throws TestAutomationException{
		return getElementByXpath(CBP_CREATE_BP_THIRDPAGE_SAVE_BUTTON, DescriptionInterface.CBP_CREATE_BP_THIRDPAGE_SAVE_BUTTON);
	}
	public static WebElement CBP_ThirdPageContinueButton() throws TestAutomationException{
		return getElementByXpath(CBP_CREATE_BP_THIRDPAGE_CONTINUE_BUTTON, DescriptionInterface.CBP_CREATE_BP_THIRDPAGE_CONTINUE_BUTTON);
	}
	public static void CBP_ThirdPageContinueButtonEnableStatus() throws IOException, TestAutomationException{
		System.out.println("Into CBT_CreateNewBPButtonEnableStatus");
		System.out.println("EXP_RESULT  :::::   "+EXP_RESULT);
		System.out.println("readDataFromExcel(EXP_RESULT)  ::::   "+readDataFromExcel(EXP_RESULT));
		if(CBP_ThirdPageContinueButton().isEnabled()){
			testResult(readDataFromExcel(EXP_RESULT));				
		}

		else testResult("Button is not enable");

	}
	
	
	//Fourth Page
	public static WebElement CBP_FourthPageContinueButton() throws TestAutomationException{
		return getElementByXpath(CBP_CREATE_BP_FOURTHPAGE_CONTINUE_BUTTON, DescriptionInterface.CBP_CREATE_BP_FOURTHPAGE_CONTINUE_BUTTON);
	}
	public static void CBP_FourthPageContinueButtonEnableStatus() throws IOException, TestAutomationException{
		System.out.println("Into CBT_CreateNewBPButtonEnableStatus");
		System.out.println("EXP_RESULT  :::::   "+EXP_RESULT);
		System.out.println("readDataFromExcel(EXP_RESULT)  ::::   "+readDataFromExcel(EXP_RESULT));
		if(CBP_FourthPageContinueButton().isEnabled()){
			testResult(readDataFromExcel(EXP_RESULT));				
		}

		else testResult("Button is not enable");

	}
	
	//Fifth Page
	public static WebElement CBP_FifthPageaAddBankdetailsButton() throws TestAutomationException{
		return getElementByXpath(CBP_CREATE_BP_FIFTHPAGE_BANKDETAILS_ADD_BUTTON, DescriptionInterface.CBP_CREATE_BP_FIFTHPAGE_BANKDETAILS_ADD_BUTTON);
	}
	public static WebElement CBP_FifthPageaSaveBankdetailsButton() throws TestAutomationException{
		return getElementByXpath(CBP_CREATE_BP_FIFTHPAGE_BANKDETAILS_SAVE_BUTTON, DescriptionInterface.CBP_CREATE_BP_FIFTHPAGE_BANKDETAILS_SAVE_BUTTON);
	}
	public static WebElement CBP_FifthPageFinishButton() throws TestAutomationException{
		return getElementByXpath(CBP_CREATE_BP_FIFTHPAGE_FINISH_BUTTON, DescriptionInterface.CBP_CREATE_BP_FIFTHPAGE_FINISH_BUTTON);
	}
	public static void CBP_FifthPageFinishButtonEnableStatus() throws IOException, TestAutomationException{
		System.out.println("Into CBT_CreateNewBPButtonEnableStatus");
		System.out.println("EXP_RESULT  :::::   "+EXP_RESULT);
		System.out.println("readDataFromExcel(EXP_RESULT)  ::::   "+readDataFromExcel(EXP_RESULT));
		if(CBP_FifthPageFinishButton().isEnabled()){
			testResult(readDataFromExcel(EXP_RESULT));				
		}
		else testResult("Button is not enable");
	}
	
	public static void CBP_CreateBusinessPartnerSuccessStatus() throws IOException, TestAutomationException{
		System.out.println("EXP_RESULT  :::::   "+EXP_RESULT);
		System.out.println("readDataFromExcel(EXP_RESULT)  ::::   "+readDataFromExcel(EXP_RESULT));
		//if(driver.getPageSource().contains(readDataFromExcel(EXP_RESULT))){
		if(driver.getPageSource().contains("Create Business Partner") != true){	
			testResult(readDataFromExcel(ACT_RESULT));				
		}

		else testResult("Failed to Cretae  Create Business Partner Profile");

	}
	
	public static WebElement homeTab() throws TestAutomationException{
		return getElementByXpath(HOME_TAB, DescriptionInterface.HOME_TAB);
	}
	
	@Override
	public ExcelManager getNextTestCase() throws TestAutomationException, IOException, InterruptedException
	 {
		// TODO Auto-generated method stub
		return null;
	}
}