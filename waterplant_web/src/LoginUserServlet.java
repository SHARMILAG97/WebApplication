package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.validator.RegisterValidation;

public class LoginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String mobileno = request.getParameter("mobileno");
		String Pwd = request.getParameter("password");
		PrintWriter out = response.getWriter();
		Long mobile = Long.parseLong(mobileno);
		RegisterValidation validate =new RegisterValidation();
		
		out.println("mobileno:" + mobile);
		out.println("Password:" + Pwd);
		boolean isValid=false;

		try {
			validate.validateMobileNo(mobile);
			UserService user = new UserService();
			User u1 =null;
			isValid=user.loginUser(mobile,Pwd);
			u1=user.getUser( mobile,  Pwd);
			HttpSession session = request.getSession();
			session.setAttribute("LOGGED_IN_USER", u1);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(isValid==true) {
			response.sendRedirect("useroperations.jsp");
		}
		else {
	         response.sendRedirect("userlogin.jsp?message=Invalid Login Crendentials!!!");
	     }
		}

}
