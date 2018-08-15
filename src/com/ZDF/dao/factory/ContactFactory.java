package com.ZDF.dao.factory;

import java.util.ResourceBundle;

public class ContactFactory {
	public static ResourceBundle bundle;
	static{
		bundle = ResourceBundle.getBundle("instance");
	}
	
	public static <T> T getInstance(String key,Class<T> classType){
		String className = bundle.getString(key);
		try {
			return (T)Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO: handle exception
			throw new RuntimeException(e);
		}
	}
}
