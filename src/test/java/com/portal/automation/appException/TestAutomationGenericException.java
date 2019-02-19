package com.portal.automation.appException;

public class TestAutomationGenericException extends TestAutomationException{
	
	public TestAutomationGenericException(Exception  ex) {
    	super(ex);
    }
	
	public TestAutomationGenericException(String description) {
		super(description);
	}
	
	/*@Override
	public String getMessage(String type, String description){
		  return description;
	  }*/
	
	public String getMessage(){
		  return description;
	  }

}
