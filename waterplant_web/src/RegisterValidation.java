package com.revature.validator;

import com.revature.exception.ValidatorException;

public class RegisterValidation {


	public  void validateMobileNo(Long mno) throws ValidatorException {

		String num = String.valueOf(mno);

		if (num.length() != 10)

			throw new ValidatorException("Invalid Mobile Number!!!");

	}
	
	public void validateName(String name) throws ValidatorException {
		
		String numbers = "(.*[0-9].*)";
		
		if(name.matches(numbers)) {
			
			throw new ValidatorException("Name should not contain numbers!!!");
		}
		
		
	}
	
public void validateMobile(String mobile) throws ValidatorException {
		
		String numbers = "(.*[A-Z].*[a-z].*)";
		
		if(mobile.matches(numbers)) {
			
			throw new ValidatorException("Mobile Number should not contain Alphabets!!!");
		}
		
		
	}
	
public void validatePassword(String pwd) throws ValidatorException {
		
		String numbers = "(.*[0-9].*)";
		int length=pwd.length();
		
		
		if ( length<8 && length>15)

			throw new ValidatorException("Password Length should be 8 to 15!!!");

		
		if(!pwd.matches(numbers)) 
			
			throw new ValidatorException("Password should contain atleast one number!!!");
		
		
}
}
