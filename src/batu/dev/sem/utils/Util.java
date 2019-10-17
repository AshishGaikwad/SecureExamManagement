package batu.dev.sem.utils;

import java.util.ResourceBundle;

public class Util 
{
	//Resource Bundle for reading data from properties file
	static ResourceBundle lResourceBundle = null;
	public static String getProperty(String pPropertyName,String pProperyKey)
	{
		try {
			lResourceBundle = ResourceBundle.getBundle("batu.dev.sem.resources."+pPropertyName);
			return lResourceBundle.getString(pProperyKey);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}
