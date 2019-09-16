package com.revature.WaterPlant.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.ServiceException;
import com.revature.WaterPlant.service.AdminService;

public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Name = request.getParameter("name");
		String Pwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
		out.println("name:" + Name);
		out.println("Password:" + Pwd);
		boolean isValid=false;

		try {
			AdminService admin = new AdminService();
			isValid=admin.login(Name,Pwd);
		} catch (ServiceException e) {
			e.printStackTrace();
		}
		if(isValid==true) {
			response.sendRedirect("admin.jsp");
		}
		else {
	         response.sendRedirect("index.jsp?message=Invalid Login Crendentials!!!");
	     }
		}
}
