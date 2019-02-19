package com.portal.automation.appException;

public class TestAutomationPropertyLoadException extends TestAutomationException {
	
	public TestAutomationPropertyLoadException(Exception ex) {
		super(ex);
	}
	public TestAutomationPropertyLoadException(String elementKey,String type,String description) {
		super(elementKey,type,description);
	}
	
	/*@Override
	public String getMessage(String type, String description) {
		
		return "Loading of "+description +" "+ elementKey+" is failed";
	}*/
	
public String getMessage() {
		
		return "Loading of "+description +" "+ elementKey+" is failed";
	}

}
