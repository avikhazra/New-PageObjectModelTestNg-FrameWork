package com.portal.automation.appException;

public class TestAutomationElementNotFoundException extends TestAutomationException {
	public TestAutomationElementNotFoundException(Exception ex) {
		super(ex);
	}
	public TestAutomationElementNotFoundException(String elementKey,String type,String description) {
		
		super(elementKey,type,description);
		System.out.println("______________ elementKey _______::::"+elementKey+"   ::::  type  "+type+"   ::::::: description   "+description); 
	}

	/*@Override
	public String getMessage(String type, String description) {
		if("xpath".equalsIgnoreCase(type)){
			return "Xpath of the the element "+ description+" is not found.";
		}else if("id".equalsIgnoreCase(type)){
			return "ID of the the element "+ description+" is not found.";
		}else if("name".equalsIgnoreCase(type)){
			return "Name of the the element "+ description+" is not found.";
		} else {
			return "Element "+ description +" is not found";
		}
	}*/
	
   public String getMessage() {
		if("xpath".equalsIgnoreCase(type)){
			return "Xpath of the the element "+ description+" is not found.";
		}else if("id".equalsIgnoreCase(type)){
			return "ID of the the element "+ description+" is not found.";
		}else if("name".equalsIgnoreCase(type)){
			return "Name of the the element "+ description+" is not found.";
		} else {
			return "Element "+ description +" is not found";
		}
	}
	
	

}
