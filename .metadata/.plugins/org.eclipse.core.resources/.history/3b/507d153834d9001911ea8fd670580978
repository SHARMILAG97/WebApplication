package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.revature.model.User;
import com.revature.service.UserService;

 
public class ViewUsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		List<User> list = null; 
		
	try {
		UserService user = new UserService();
		list=user.viewUsers();
		
		
		} catch (Exception e) {
		e.printStackTrace();
	}
	if(list!=null) {
		//response.sendRedirect("admin.jsp");
	}
	else {
        // response.sendRedirect("index.jsp?message=Invalid Login Crendentials!!!");
     }
	Gson gson = new Gson();
	String json = gson.toJson(list);
	
	PrintWriter out = response.getWriter();
	out.println(json);
	out.flush();
	}
	


}
