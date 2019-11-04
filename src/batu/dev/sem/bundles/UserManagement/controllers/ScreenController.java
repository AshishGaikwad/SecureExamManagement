package batu.dev.sem.bundles.UserManagement.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import batu.dev.sem.bundles.UserManagement.daoimpl.ScreenDaoImpl;
import batu.dev.sem.bundles.UserManagement.entity.ScreenEntity;

/**
 * Servlet implementation class ScreenController
 */
@WebServlet({ "/ScreenController", "/screen" })
public class ScreenController extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession lHttpSession =request.getSession();
		ScreenDaoImpl lScreenDaoImpl = new ScreenDaoImpl();
		PrintWriter out = response.getWriter();
		String lRequestType = request.getParameter("RequestType");
		Gson gson = new Gson();
		
		
		switch (lRequestType) {
		case "GetScreenParentList":
			System.out.println("Called");
			
			List<ScreenEntity> pScreenList = lScreenDaoImpl.getScreenAll("WHERE screens.screen_url = '#'");
			System.out.println("pScreenList =="+pScreenList);
			out.print(gson.toJson(pScreenList));
			break;

		default:
			break;
		}
		
		
		
		
	}

}
