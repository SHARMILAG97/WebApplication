package com.revature.dao;

import java.util.List;

import com.revature.exception.DBException;
import com.revature.model.User;

public interface UserInterface {

	void AddUser(String name, String pwd, long mobileno, String address) throws DBException;
	boolean findByNameAndPassword(String Uname,String Pwd) throws DBException;
	boolean findByUNameAndPassword(long mobileno,String Pwd) throws DBException;
	 User getUser(long mobileno, String Pwd) throws DBException;
	 public  List<User> viewUser() throws DBException;
	 

}
