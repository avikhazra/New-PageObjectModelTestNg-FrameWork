package com.portal.automation.appException;

public abstract class TestAutomationException extends Exception{
    public static String elementKey;
    public static String type;
    public static String description;

    public TestAutomationException(Exception  ex) {
    	description = ex.getMessage();
    	ex.printStackTrace();
    }
    
    public TestAutomationException(String description) {
    	this.description = description;
    }
    
    public TestAutomationException(String elementKey,String type,String description) {
         this.elementKey = elementKey;
         this.type = type;
         this.description = description;
    }
   // public abstract String getMessage(String type, String description);
	
}

