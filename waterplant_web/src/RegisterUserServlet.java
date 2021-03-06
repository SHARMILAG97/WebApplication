package com.revature.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.protobuf.ServiceException;
import com.revature.exception.ValidatorException;
import com.revature.model.User;
import com.revature.service.UserService;
import com.revature.validator.RegisterValidation;




public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String mobileno = request.getParameter("mobileno");
		String Pwd = request.getParameter("password");
		String address = request.getParameter("address");
		Long mobile = Long.parseLong(mobileno);
		
		RegisterValidation validate =new RegisterValidation();

		UserService user = new UserService();
		

		try {
			
		validate.validateName(name);
		validate.validateMobileNo(mobile);
		validate.validatePassword(Pwd);
		validate.validateMobile(mobileno);
		
		User u= new User();
		u.setName(name);
		u.setMobileno(mobile);
		u.setPwd(Pwd);
		u.setAddress(address);
		user.registerUser(name,mobile,Pwd,address);
			
		response.sendRedirect("userlogin.jsp");
	
			
		} catch (ValidatorException e) {
			e.printStackTrace();
			response.sendRedirect("userregister.jsp?message="+e.getMessage());
		} catch (ServiceException e) {
			e.printStackTrace();
			response.sendRedirect("index.jsp?message=Invalid Login Crendentials!!!");
		}
		
	     
		}
	}


