package com.ZDF.utils;

import java.util.HashMap;
import java.util.Map;

public class ReadProperties {
	private Map<String,String> properties = new HashMap<String, String>();
	private static ReadProperties instance = new ReadProperties();
	private ReadProperties(){}
	
	public static ReadProperties getInstance(){
		return instance;
	}
	
	public String getProperty(String propertyKey){
		return properties.get(propertyKey);
	}
	
	public void addProperty(String propertyKey,String propertyValue){
		properties.put(propertyKey, propertyValue);
	}
}
