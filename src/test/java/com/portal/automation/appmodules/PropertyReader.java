package com.portal.automation.appmodules;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import com.portal.automation.appException.DescriptionInterface;
import com.portal.automation.appException.ElementDescriptionReader;
import com.portal.automation.appException.TestAutomationPropertyLoadException;

public class PropertyReader {
	
    private static Properties properties;
    
    public PropertyReader() throws TestAutomationPropertyLoadException{

	}


	public PropertyReader(String propFile) throws TestAutomationPropertyLoadException{
		try{
	        FileReader reader = new FileReader(propFile);
	        properties = new Properties();
	        properties.load(reader);
		}catch(FileNotFoundException ex){
			throw new TestAutomationPropertyLoadException(propFile, "PROP_FILE",ElementDescriptionReader.getReader().getProperties(DescriptionInterface.PROP_FILE));
		}catch(IOException ex){
			throw new TestAutomationPropertyLoadException(propFile, "PROP_FILE", ElementDescriptionReader.getReader().getProperties(DescriptionInterface.PROP_FILE));
		}
	}

	public static String getProperties(String key) {
		System.out.println("Key is :::   "+key);
		String value = null;
		value = properties.getProperty(key);
		return value;
	}


}