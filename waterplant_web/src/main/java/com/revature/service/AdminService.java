package com.revature.service;

import com.google.protobuf.ServiceException;
import com.revature.dao.UserDAO;
import com.revature.dao.UserInterface;
import com.revature.exception.DBException;

public class AdminService {
public boolean login(String name, String password) throws ServiceException {
		
		boolean isValid=true;
		try {
			UserInterface Udao = new UserDAO();
		     isValid=Udao.findByNameAndPassword(name, password);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to login");
			
		}
		return isValid;

	}

}
