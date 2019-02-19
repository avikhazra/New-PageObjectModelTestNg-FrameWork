package com.portal.automation.daimler.page.objects;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import com.portal.automation.appException.TestAutomationPropertyLoadException;

public class GlobalPropertyFileReader  {
	public static HashMap <Object,Object> GlobalPropertyHashMap;
	public void PropertyFileReader(String PropertyFilePathorName)  throws TestAutomationPropertyLoadException{
		try {
			PropertyFilePathorName=	"C:\\Users\\IBM_ADMIN\\JAVA_Maven\\sampleMaven\\LoginLogout.properties";
			Properties PropertyFile = new Properties();
			FileReader reader = new FileReader(PropertyFilePathorName);
	       
			PropertyFile.load(reader);
			
			System.out.println(PropertyFile.getProperty("StrtestUrl"));
				Enumeration<?> e = PropertyFile.propertyNames();
				while (e.hasMoreElements()) {
					String Propkey = (String) e.nextElement();
					GlobalPropertyHashMap.put(Propkey.trim(),PropertyFile.getProperty(Propkey));
				}
			
		}catch(Exception ex) {}

	}

}
