package com.frameworkUtil;

import java.util.HashMap;
import java.util.Map;

public class PropertiesUtil {

	private  java.util.Properties  properties;

	public PropertiesUtil(String propertyFileName) {
		properties = new java.util.Properties();
		setProperties(propertyFileName);
	}

	private void setProperties(String propertyFileName) {

		try {
			properties.load(new java.io.FileInputStream(propertyFileName));

		} catch (java.io.FileNotFoundException fileNotFoundException) {
			fileNotFoundException.printStackTrace();
		} catch (java.io.IOException ioException) {
			ioException.printStackTrace();
		}

	}
	
	/*public  Map<String, String> getcoverages() {
		
		Map<String, String> mp=new HashMap<>();
		
		properties.forEach((k,v) -> {
			
			if (k.toString().startsWith("pre.")) {
				mp.put(k.toString(), v.toString());
			}

		});
		
		return mp;

	}*/
	
		
	

	public String getPropertyValue(String propertyName) {
		

		return properties.getProperty(propertyName);

	}

}
