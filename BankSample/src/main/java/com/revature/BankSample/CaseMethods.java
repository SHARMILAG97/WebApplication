package com.revature.BankSample;

import java.sql.SQLException;
import java.util.Scanner;

public class CaseMethods {
	
	public static void Register() {
	System.out.println(" Enter Your Name");
	Scanner Nsc = new Scanner(System.in);
	String Uname = Nsc.next();
	System.out.println("Enter Email");
	Scanner Esc = new Scanner(System.in);
	String Email = Esc.next();
	System.out.println("Enter Mobile number");
	Scanner Msc = new Scanner(System.in);
	long Mobile = Msc.nextLong();
	System.out.println("Enter password");
	Scanner Psc = new Scanner(System.in);
	String Pwd = Psc.next();
	System.out.println("Enter Aadhar number");
	Scanner Asc = new Scanner(System.in);
	long Aadhar = Asc.nextLong();
	/*System.out.println("Enter Pan number");
	Scanner psc = new Scanner(System.in);
	long Pan = psc.nextLong();*/
	
	
	
	
	try {
		
		UserDAO.insert(Uname, Mobile,Email,Pwd,Aadhar);
		System.out.println();
		CaseMethods.Login();
	//	long Acc_no=SqlMethods.getAccno(Uname);
	//	System.out.println("Account Number for Customer "+Uname+" is "+Acc_no);
		System.out.println();
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}

}
	public static void Login() {
		System.out.println("Please enter Credentials for Login");
	System.out.println(" Enter UserName");
	Scanner LNsc = new Scanner(System.in);
	String LUname = LNsc.next();
	System.out.println(" Enter Password");
	Scanner LPsc = new Scanner(System.in);
	String LPwd = LPsc.next();
	
    try {
		
		boolean bl=UserDAO.findByNameAndPassword(LUname,LPwd);
		
		if(bl==true) {
			System.out.println("******Successful Login********");
			System.out.println();
		System.out.println("Welcome  "+LUname);
		System.out.println();
		long Acc_no=UserDAO.getAccno(LUname);
		System.out.println("Account Number for Customer "+LUname+" is "+Acc_no);
		
    }
		else {
			System.out.println("Invalid UserName or Password");
			System.out.println();
		Login();
	}} 
    catch (SQLException e) {
		e.printStackTrace();
	} catch (Exception e) {
		
		e.printStackTrace();
	}
	
	}
	
	
	public static void Deposit()  {
		System.out.println("Enter Account Number to Deposit ");
		Scanner Dsc = new Scanner(System.in);
		long Dacc= Dsc.nextLong();
		
		try {	
			boolean b =	UserDAO.findByAccNo(Dacc);
			
			while(!b )
			{
				System.out.println("Invalid Account");
				System.out.println("ReEnter Account Number to Deposit ");
				 Dacc= Dsc.nextLong();
			}
			long bal= UserDAO.getBalance(Dacc);	
		System.out.println("Enter Deposit Amount");
		Scanner Dsc1 = new Scanner(System.in);
		int Damt= Dsc1.nextInt();
		
		if(Damt==0)
			System.out.println("Enter Valid Amount to Deposit");
		 System.out.println();
		
			 System.out.println("Amount before Deposit :"+bal);
			 System.out.println();
			
			 
			bal+=Damt;
			UserDAO.addDeposit(Dacc,Damt, bal);
			System.out.println("Amount after Deposit :"+bal);
			 System.out.println();
			 System.out.println("**********TRANSACTION SUCCESSFULLY COMPLETED***********");
			 System.out.println();
			 System.out.println();
			
			}
		 catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Withdraw() {
		System.out.println("Enter Account Number to Withdraw");
		Scanner Wsc = new Scanner(System.in);
		long Wacc= Wsc.nextLong();
		
		try {	
			boolean b =	UserDAO.findByAccNo(Wacc);
			
			while(!b)
			{
				System.out.println("Invalid Account");
				System.out.println("ReEnter Account Number to Withdraw");
				 Wacc= Wsc.nextLong();
			}
		
			long bal= UserDAO.getBalance(Wacc);
			
			
		System.out.println("Enter Withdraw Amount");
		Scanner Wsc1 = new Scanner(System.in);
		int Wamt= Wsc1.nextInt();
		
	
		 
		 while(bal<Wamt) {
			 System.out.println("Insufficient Balance");
			 System.out.println("Available Balance:"+bal);
			 System.out.println("ReEnter Withdraw Amount");
			 Wamt= Wsc1.nextInt();
			 
		 }
		   System.out.println("Amount before Withdraw:"+bal);
			System.out.println();
			bal-=Wamt;
			UserDAO.addWithdraw(Wacc,Wamt, bal);
			System.out.println("Amount after Withdraw:"+bal);
			System.out.println();	
			System.out.println("**********TRANSACTION SUCCESSFULLY COMPLETED***********");
			System.out.println();
			System.out.println();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ViewBalance() {
		System.out.println("Enter Your Account Number to View Balance");
		Scanner Vsc = new Scanner(System.in);
		long Vacc= Vsc.nextLong();
		long bal=0l;
		try {
		boolean b =	UserDAO.findByAccNo(Vacc);
		
		if(!b)
		{
			System.out.println("Invalid Account");
			System.out.println("ReEnter Your Account Number to View Balance");
			 Vacc= Vsc.nextLong();
			
		}
		
		
			 bal= UserDAO.getBalance(Vacc);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		System.out.println("Available Balance is: "+bal);
	}
	
	public static void FundTransfer() {
		
		System.out.println("Enter From Account Number:");
		Scanner Fsc = new Scanner(System.in);
		int Facc= Fsc.nextInt();
		
		try {	
			boolean b =	UserDAO.findByAccNo(Facc);
			
			while(!b)
			{
				System.out.println("Invalid Account");
				System.out.println("ReEnter From Account Number:");
				Facc= Fsc.nextInt();
			}
		
		
		System.out.println("Enter To Account Number:");
		Scanner Tsc = new Scanner(System.in);
		int Tacc= Tsc.nextInt();
		
		boolean b1 =	UserDAO.findByAccNo(Tacc);
		
		if(!b)
		{
			System.out.println("Invalid Account");
			System.out.println("ReEnter To Account Number:");;
			Tacc= Tsc.nextInt();
		}
		
		
		long Fbal= UserDAO.getBalance(Facc);
		
	
		
		System.out.println("Enter Amount to Transfer:");
		Scanner Asc1 = new Scanner(System.in);
		long Aacc= Asc1.nextLong();
		
		if(Aacc==0)
			System.out.println("Enter Valid Amount to Transfer");
		 System.out.println();
		
	    while(Fbal<Aacc) {
	    	System.out.println("Amount available for Debit:"+Fbal);
	    	System.out.println("ReEnter Amount to Transfer:");
	    	Aacc= Asc1.nextLong();
	    	
	    }
			
			long Tbal= UserDAO.getBalance(Tacc);
			System.out.println("Amount before Debit:"+Fbal);
			System.out.println("Amount before Credit:"+Tbal);
			System.out.println();
			System.out.println();
			
			Fbal-=Aacc;
			Tbal+=Aacc;
			UserDAO.update( Facc, Tacc, Aacc,Fbal,Tbal);
			System.out.println("Amount after Debit:"+Fbal);
			System.out.println("Amount after Credit:"+Tbal);
			System.out.println("****************TRANSACTION SUCCESSFULLY COMPLETED************");
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	
}
