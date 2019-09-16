package com.revature.Sample.com.revature;

public class Sample {
	
	
		public static void main(String[] args) {

	        String name = "Naresh";
	        String department = null;
	        try {
	            //validateStudentDetails(name, department);
	            addStudentToDatabase(name, department);
	        }
	        catch(Exception e) {
	            e.printStackTrace();
	            System.out.println(e.getMessage());
	        }
	        finally {
	            System.out.println("Finally");
	        }

	    }

	    
	    public static void validateStudentDetails(String name, String department) throws Exception {
	        System.out.println("Validation");

	        if (name == null) {
	            //throw is to raise an exception
	            throw new Exception("Invalid Name");
	        }
	        if (department == null) {
	            throw new Exception("Invalid Department");
	        }
	    
	    }

	    public static void addStudentToDatabase(String name, String department) {
	        System.out.println("Adding Student Details to DB");
	        System.out.println("Name:" + name);
	        System.out.println("Department:" + department);
	    }

	}

	


