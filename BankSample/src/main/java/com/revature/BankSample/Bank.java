package com.revature.BankSample;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;
import java.util.Scanner;

public class Bank {

	
	public static void main(String[] args) {
		
		System.out.println("************WELCOME TO kVB BANK*************");
		System.out.println();
		System.out.print("1.Register OR Create Account	||	");
		System.out.println("2.Login");
		System.out.println("~~~~~~~~~~~~SELECT 1 FOR NEW USER~~~~~~~~~~~~~");
		System.out.println("~~~~~~~~~~~~SELECT 2 FOR EXISTING USER~~~~~~~~~~~");
		System.out.println("Please Enter Your Option to Proceed");
		int choice= 0;
		Scanner sc = new Scanner(System.in);
		 choice = sc.nextInt();
		
		if(choice==1) {
			CaseMethods.Register();
			
		}
		
		
		
		else {
			
			CaseMethods.Login();
		}
			
			do {
				
		System.out.println();	
			
		System.out.println("~~~~~~~~~~SELECT AN ACTION TO PERFORM~~~~~~~~~~~~~");
		System.out.print("3.Deposit	||	");
		System.out.print("4.Withdraw	||	");
		System.out.print("5.View Balance	||	");
		System.out.print("6.Fund Transfer	||	");
		System.out.println("0.Quit");
		
		System.out.println("If you want to continue, then enter your choice");
			
		Scanner sc1 = new Scanner(System.in);
		 choice = sc1.nextInt();
		
		switch(choice) {
			
		case 3:
			
				CaseMethods.Deposit();
				break;	
			
		case 4:
			
				CaseMethods.Withdraw();
				break;	
			
		case 5:
			
				CaseMethods.ViewBalance();
				break;
				
		case 6:
			
			CaseMethods.FundTransfer();
			break;
			
		
		}
		System.out.println();
		
		
		}while(choice != 0  );
			
		
			System.out.println("((((((((((((((((((((THANK YOU))))))))))))))))))))");
		

	}

}
