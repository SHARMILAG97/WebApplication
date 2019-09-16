package com.revature.service;

import java.util.List;

import com.google.protobuf.ServiceException;
import com.revature.dao.UserDAO;
import com.revature.dao.UserInterface;
import com.revature.exception.DBException;
import com.revature.model.User;

public class UserService {

public boolean loginUser(Long mobileno, String password) throws ServiceException {
		
		boolean isValid=true;
		try {
			UserInterface Udao = new UserDAO();
		     isValid=Udao.findByUNameAndPassword(mobileno, password);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to login");
			
		}
		return isValid;

	}



public void registerUser(String name, Long mobile, String pwd, String address) throws ServiceException {
	
	
	try {
		UserInterface Udao = new UserDAO();
		
	    Udao.AddUser(name, pwd, mobile,address);
	} catch (DBException e) {
		e.printStackTrace();
		throw new ServiceException("Unable to register");
		
	}
}



public List<User> viewUsers() throws ServiceException {
	
	UserInterface Udao = new UserDAO();
	List<User> list=null;
	try {
		
	   list = Udao.viewUser();
	} catch (DBException e) {
		e.printStackTrace();
		throw new ServiceException("Unable to register");
		
	}
	return list;
}



public User getUser(Long mobileno, String pwd) {
	
	UserInterface Udao = new UserDAO();
	User user = null;
	try {
		user=Udao.getUser(mobileno, pwd);
	} catch (DBException e) {
		e.printStackTrace();
	}
	return user;
}}
