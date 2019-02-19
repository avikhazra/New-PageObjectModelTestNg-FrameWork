package com.portal.automation.appException;

import com.portal.automation.appException.TestAutomationPropertyLoadException;
import com.portal.automation.appmodules.PropertyReader;

public class ElementDescriptionReader extends PropertyReader implements DescriptionInterface{
    private static PropertyReader reader;
    public static  PropertyReader getReader()throws TestAutomationPropertyLoadException{
        if(reader == null){
            reader = new ElementDescriptionReader();
        }
         
       
        return reader;
    }
    private ElementDescriptionReader()throws TestAutomationPropertyLoadException {
        super("ErrorMessageDescription.properties");
    }
}