package com.revature.WaterPlant.service;

import com.google.protobuf.ServiceException;
import com.revature.WaterPlant.dao.UserDao;
import com.revature.WaterPlant.dao.UserInterface;
import com.revature.WaterPlant.exception.DBException;
import com.revature.WaterPlant.model.User;


public class AdminService {

	
	public boolean login(String name, String password) throws ServiceException {
		
		boolean isValid=true;
		try {
			UserInterface Udao = new UserDao();
		     isValid=Udao.findByNameAndPassword(name, password);
		} catch (DBException e) {
			e.printStackTrace();
			throw new ServiceException("Unable to login");
			
		}
		return isValid;

	}
}