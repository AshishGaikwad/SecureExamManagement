package batu.dev.sem.utils;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	
	
	public static void loadPage(HttpServletRequest lRequest,HttpServletResponse lResponse, String lPageName)
	{
		try {
			lRequest.getRequestDispatcher("/view/"+lPageName).forward(lRequest, lResponse);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
