package com.wordpress.utils;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyUtil 
{
		
	//Properties Library in java used to read the properties from the properties file
	Properties propertiesObj = null;
	String filePath;
	public PropertyUtil(String filePath)
	{
		this.filePath=filePath;
		load();
	}
	
	public void load()
	{
		try{
		propertiesObj = new Properties();
		FileInputStream fis = new FileInputStream(filePath);
		propertiesObj.load(fis);
		}catch(Exception e)
		{
			e.printStackTrace();
			System.out.println("REading file got failed");
		}
		
	}
	
	
	
	public String getPropertyValue(String key)
	{
		String value = propertiesObj.getProperty(key);
		return value;
	}
		
		
		
		
		
		
}
