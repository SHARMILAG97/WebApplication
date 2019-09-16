package com.revature.BankSample;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
	
	public static void insert(String uname,long mobile_no,String email,String pwd,long aadhar) throws SQLException {
		Connection con = ConnectionUtil.getConnection();
		String sql = "insert into Customer_Details(Customer_Name,Mobile_No,Email_Id,Pwd ,Aadhar_No ) values ( ?,?,?,?,?)";
		
		PreparedStatement pst = con.prepareStatement(sql);
		
		pst.setString(1, uname);
		pst.setLong(2, mobile_no);
		pst.setString(3, email);
		pst.setString(4, pwd);
		pst.setLong(5, aadhar);
		
		
		String sql1="insert into Account_Details(Customer_Name,Ifsc_code,Balance) values (?,?,?)";
		PreparedStatement pst1 =con.prepareStatement(sql1);
		
		pst1.setString(1, uname);
		pst1.setString(2, "KVB123");
		pst1.setLong(3, 0l);
		
        pst.executeUpdate();
        pst1.executeUpdate();
        
        System.out.println("********SUCCESSFULLY CREATED AN ACCOUNT***********");
        
        
       
	}
	
	public static boolean findByNameAndPassword(String Uname,String Pwd) throws SQLException {
        
        Connection con = ConnectionUtil.getConnection();
        String sql = "select * from Customer_Details where Customer_Name = ? and Pwd = ?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setString(1,Uname);
        pst.setString(2, Pwd);
        ResultSet rs = pst.executeQuery();
       
       boolean isValid;
           if(rs.next()){
               isValid=true;
           }
           else
           {
               isValid = false;
           }
           return isValid;
    }
	
public static boolean findByAccNo(long Acc_no) throws SQLException {
        
        Connection con = ConnectionUtil.getConnection();
        String sql = "select * from Account_Details where Acc_No=?";
        PreparedStatement pst = con.prepareStatement(sql);
        pst.setLong(1,Acc_no);
       
        ResultSet rs = pst.executeQuery();
       
       boolean isValid;
           if(rs.next()){
               isValid=true;
           }
           else
           {
               isValid = false;
           }
           return isValid;
    }
	
	
	
	public static void update(int Facc,int Tacc,long Aacc,long Fbal,long Tbal) throws SQLException {
		  
		 Connection con = ConnectionUtil.getConnection();
		 String sql = "update Account_Details set Balance=?,Trans_Amt=?,Transaction='Debit' where Acc_No=?  ";
		 PreparedStatement pst = con.prepareStatement(sql);
		    pst.setLong(1, Fbal);
		    pst.setLong(3, Facc);
		    pst.setLong(2, Aacc);
		    
		    String sql1 = "update Account_Details set Balance=?,Trans_Amt=?,Transaction='Credit'  where Acc_No=?  ";
		    PreparedStatement pst1 = con.prepareStatement(sql1);
		    pst1.setLong(1, Tbal);
		    pst1.setLong(3, Tacc);
		    pst1.setLong(2,Aacc);
		   
		    
		      
		      
		      
		      String sql2 = "insert into Transactions(Acc_No,Action,Trans_amt,Balance) values(?,?,?,?) ";
			  PreparedStatement pst2 = con.prepareStatement(sql2);
		      pst2.setLong(1, Facc);
			  pst2.setString(2, "debit");
			  pst2.setLong(3, Aacc);
			  pst2.setLong(4, Fbal);
				
				 String sql3 = "insert into Transactions(Acc_No,Action,Trans_amt,Balance) values(?,?,?,?) ";
				 PreparedStatement pst3 = con.prepareStatement(sql3);
			     pst3.setLong(1, Tacc);
				 pst3.setString(2, "credit");
				 pst3.setLong(3, Aacc);
				 pst3.setLong(4, Tbal);
					
		      
				 pst.executeUpdate();
			      pst1.executeUpdate();
				 pst2.executeUpdate();
			      pst3.executeUpdate();
		      
	      	 
	 }
	
	public static long getBalance(long amt) throws SQLException {
		
		Connection con = ConnectionUtil.getConnection();
		
		 String sql = "select Balance from Account_Details where Acc_No =? ";
		 PreparedStatement pst = con.prepareStatement(sql);
		 pst.setLong(1, amt);
		 ResultSet rows = pst.executeQuery();
		long bal = 0l;
		 while(rows.next()) {
			  bal = rows.getLong("Balance");
			 
		 }
		 return bal;
	}
	
public static long getAccno(String Customer_Name) throws SQLException {
		
		Connection con = ConnectionUtil.getConnection();
		
		 String sql = "select * from Customer_Details where Customer_Name=? ";
		 PreparedStatement pst = con.prepareStatement(sql);
		 pst.setString(1, Customer_Name);
		 ResultSet rows = pst.executeQuery();
		long Acc_no=0l;
		 while(rows.next()) {
			 Acc_no = rows.getLong("Acc_No");
			 
		 }
		 return Acc_no;
	}
	public static void addDeposit(long acc_no,int t_amt,long bal) throws SQLException {
		
		 Connection con = ConnectionUtil.getConnection();
		 String sql = "update Account_Details set Balance=?,Trans_amt=? where Acc_No = ? ";
		 PreparedStatement pst = con.prepareStatement(sql);
		    pst.setLong(1, bal);
		    pst.setInt(2, t_amt);
			pst.setLong(3, acc_no);
			
			
			 String sql1 = "insert into Transactions(Acc_No,Action,Trans_amt,Balance) values(?,?,?,?) ";
			 PreparedStatement pst1 = con.prepareStatement(sql1);
			    pst1.setLong(1, acc_no);
				pst1.setString(2, "deposit");
				pst1.setInt(3, t_amt);
				pst1.setLong(4, bal);
			
		 
		 pst.executeUpdate();
	      pst1.executeUpdate();
	      
	}
	
	public static void addWithdraw(long acc_no,int t_amt,long bal) throws SQLException {
		
		 Connection con = ConnectionUtil.getConnection();
		 
		 String sql = "update Account_Details set Balance=?,Trans_amt=?,Ifsc_code='KVB123',Transaction='Withdraw' where Acc_No = ? ";
		 PreparedStatement pst = con.prepareStatement(sql);
		    pst.setLong(1, bal);
		    pst.setInt(2, t_amt);
			pst.setLong(3, acc_no);
			
			
			 String sql1 = "insert into Transactions(Acc_No,Action,Trans_amt,Balance) values(?,?,?,?) ";
			 PreparedStatement pst1 = con.prepareStatement(sql1);
			    pst1.setLong(1, acc_no);
				pst1.setString(2, "Withdraw");
				pst1.setInt(3, t_amt);
				pst1.setLong(4, bal);
			
		 
		 pst.executeUpdate();
	      pst1.executeUpdate();
	      
	}
	
	
	
	}

