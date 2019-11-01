package batu.dev.sem.utils;

import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import batu.dev.sem.bundles.UserManagement.daoimpl.ScreenDaoImpl;
import batu.dev.sem.bundles.UserManagement.entity.ScreenEntity;
import batu.dev.sem.bundles.UserManagement.entity.UserEntity;

public class Util 
{
	//Resource Bundle for reading data from properties file
	static ResourceBundle lResourceBundle = null;
	private static Gson gson = new Gson();
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
	
	StringBuffer lMenuBuffer =  new StringBuffer();
	
	
	public static String createMenus(HttpServletRequest lRequest)
	{
		ScreenDaoImpl lScreenDaoImpl = new ScreenDaoImpl();
		HttpSession lSession = lRequest.getSession();
		UserEntity lEntity = (UserEntity)lSession.getAttribute("USER_ENTITY");
		List<ScreenEntity> lList = lScreenDaoImpl.getScreenForUser(lEntity.getUserId());
		
		
		
		
		return menuBuilder(lList);
		
	}
	
	
	
	public static String menuBuilder(List<ScreenEntity> lList){
		StringBuilder lMenuBuffer = new StringBuilder();
		List<ScreenEntity> lScreensList = lList;
//----------FIRST LEVEL MENU
		lMenuBuffer.append("<ul class=\"nav nav-main\">");
		for (int i = 0; i < lScreensList.size(); i++) {
			if(lScreensList.get(i).getScreenParentId() == 0)
			{
					if((  lScreensList.get(i).getScreenUrl()).equals("#"))
					{
						lMenuBuffer.append("<li class=\"nav-parent\">");
						lMenuBuffer.append("<a>");
						lMenuBuffer.append("<i class=\"fa "+lScreensList.get(i).getScreenMenuIcon()+"\" aria-hidden=\"true\"></i>");
						lMenuBuffer.append("<span>"+lScreensList.get(i).getScreenName()+"</span>");
						lMenuBuffer.append("</a>");
			
						lMenuBuffer.append("<ul class=\"nav nav-children\">");
//------------------------SECOND LEVEL MENU START-----------------------------------------------------------------------------		-				
						for (int j = 0; j < lScreensList.size(); j++) {
							
							
							if(lScreensList.get(j).getScreenParentId() == lScreensList.get(i).getScreenId())
							{
									if((  lScreensList.get(j).getScreenUrl()).equals("#"))
									{
										lMenuBuffer.append("<li class=\"nav-parent\">");
										lMenuBuffer.append("<a>");
//										lMenuBuffer.append("<i class=\"fa "+lScreensList.get(j).getScreenMenuIcon()+"\" aria-hidden=\"true\"></i>");
										lMenuBuffer.append("<span>"+lScreensList.get(j).getScreenName()+"</span>");
										lMenuBuffer.append("</a>");
							
										lMenuBuffer.append("<ul class=\"nav nav-children\">");
//------------------------THIRD LEVEL MENU START-----------------------------------------------------------------------------	
										for (int k = 0; k < lScreensList.size(); k++) {
											
											
											if(lScreensList.get(k).getScreenParentId() == lScreensList.get(j).getScreenId())
											{
													if((  lScreensList.get(k).getScreenUrl()).equals("#"))
													{
														lMenuBuffer.append("<li class=\"nav-parent\">");
														lMenuBuffer.append("<a>");
//														lMenuBuffer.append("<i class=\"fa "+lScreensList.get(j).getScreenMenuIcon()+"\" aria-hidden=\"true\"></i>");
														lMenuBuffer.append("<span>"+lScreensList.get(k).getScreenName()+"</span>");
														lMenuBuffer.append("</a>");
											
														lMenuBuffer.append("<ul class=\"nav nav-children\">");
				//------------------------FOURTH LEVEL MENU START-----------------------------------------------------------------------------	
														
														for (int l = 0; l < lScreensList.size(); l++) {
															
															
															if(lScreensList.get(l).getScreenParentId() == lScreensList.get(k).getScreenId())
															{
																	if((  lScreensList.get(l).getScreenUrl()).equals("#"))
																	{
																		lMenuBuffer.append("<li class=\"nav-parent\">");
																		lMenuBuffer.append("<a>");
//																		lMenuBuffer.append("<i class=\"fa "+lScreensList.get(j).getScreenMenuIcon()+"\" aria-hidden=\"true\"></i>");
																		lMenuBuffer.append("<span>"+lScreensList.get(l).getScreenName()+"</span>");
																		lMenuBuffer.append("</a>");
															
																		lMenuBuffer.append("<ul class=\"nav nav-children\">");
								//------------------------FIFTH LEVEL MENU START-----------------------------------------------------------------------------	
																		for (int m = 0; m < lScreensList.size(); m++) {
																			
																			
																			if(lScreensList.get(m).getScreenParentId() == lScreensList.get(l).getScreenId())
																			{
																					if((  lScreensList.get(m).getScreenUrl()).equals("#"))
																					{
																						lMenuBuffer.append("<li class=\"nav-parent\">");
																						lMenuBuffer.append("<a>");
//																						lMenuBuffer.append("<i class=\"fa "+lScreensList.get(j).getScreenMenuIcon()+"\" aria-hidden=\"true\"></i>");
																						lMenuBuffer.append("<span>"+lScreensList.get(m).getScreenName()+"</span>");
																						lMenuBuffer.append("</a>");
																			
																						lMenuBuffer.append("<ul class=\"nav nav-children\">");
												//------------------------FIFTH LEVEL MENU START-----------------------------------------------------------------------------	
																						
												//------------------------FIFTH LEVEL MENU START-----------------------------------------------------------------------------	
																						lMenuBuffer.append("</ul>");
																						lMenuBuffer.append("</li>");
																					}else 
																					{
																						lMenuBuffer.append(
																									"<li>"
																										+ "<a href=\"#\"   onclick=\"setUpUrl('"+Base64.getEncoder().encodeToString(gson.toJson(lScreensList.get(m)).getBytes()).toString()+"')\">"
																										+"	<span>"+lScreensList.get(m).getScreenName()+"</span>"
																										+ "</a>"
																								+	 "</li>");
																					}
																			}
																		}
								//------------------------FIFTH LEVEL MENU START-----------------------------------------------------------------------------	
																		lMenuBuffer.append("</ul>");
																		lMenuBuffer.append("</li>");
																	}else 
																	{
																		lMenuBuffer.append(
																					"<li>"
																						+ "<a href=\"#\"   onclick=\"setUpUrl('"+Base64.getEncoder().encodeToString(gson.toJson(lScreensList.get(l)).getBytes()).toString()+"')\">"
																						+"	<span>"+lScreensList.get(l).getScreenName()+"</span>"
																						+ "</a>"
																				+	 "</li>");
																	}
															}
														}
														
														
														
				//------------------------FOURTH LEVEL MENU START-----------------------------------------------------------------------------	
														lMenuBuffer.append("</ul>");
														lMenuBuffer.append("</li>");
													}else 
													{
														lMenuBuffer.append(
																	"<li>"
																		+ "<a href=\"#\"   onclick=\"setUpUrl('"+Base64.getEncoder().encodeToString(gson.toJson(lScreensList.get(k)).getBytes()).toString()+"')\">"
																		+"	<span>"+lScreensList.get(k).getScreenName()+"</span>"
																		+ "</a>"
																+	 "</li>");
													}
											}
										}
//------------------------THIRD LEVEL MENU START-----------------------------------------------------------------------------	
										lMenuBuffer.append("</ul>");
										lMenuBuffer.append("</li>");
									}else 
									{
										lMenuBuffer.append(
													"<li>"
														+ "<a href=\"#\"  onclick=\"setUpUrl('"+Base64.getEncoder().encodeToString(gson.toJson(lScreensList.get(j)).getBytes()).toString()+"')\">"
														+"	<span>"+lScreensList.get(j).getScreenName()+"</span>"
														+ "</a>"
												+	 "</li>");
									}
							}
						}
						
						
//-------------=SECOND LEVEL MENU END-------------------------------------------------------------------------------------						
						lMenuBuffer.append("</ul>");
						lMenuBuffer.append("</li>");
					}else 
					{
						lMenuBuffer.append(
									"<li>"
										+ "<a href=\"#\"  onclick=\"setUpUrl('"+Base64.getEncoder().encodeToString(gson.toJson(lScreensList.get(i)).getBytes()).toString()+"')\">"
										+ "	<i class=\"fa "+lScreensList.get(i).getScreenMenuIcon()+"\" aria-hidden=\"true\"></i>"
										+"	<span>"+lScreensList.get(i).getScreenName()+"</span>"
										+ "</a>"
								+	 "</li>");
					}
			}
		}
		lMenuBuffer.append("</ul>");
		
		return lMenuBuffer.toString();
	}
	
	
	public static void main(String[] args) {
		ScreenDaoImpl lScreenDaoImpl = new ScreenDaoImpl();
		
		System.out.println(menuBuilder(lScreenDaoImpl.getScreenForUser(1)));
	}
	
}
