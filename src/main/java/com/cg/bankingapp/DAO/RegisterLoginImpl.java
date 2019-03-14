package com.cg.bankingapp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.cg.bankingapp.dto.BankAppDTO;

import oracle.net.aso.l;

public class RegisterLoginImpl implements RegisterLogin{
	   BankAppDTO bankAppDTO = new BankAppDTO();

	public long registration(BankAppDTO register) {
		int i = 0;
		long accountNo = 0;
		
		try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","database","oracle");
		
	    PreparedStatement preparedStatement =  connection.prepareStatement("insert into Customer_details values(CUSTOMER.nextval,?,?,?,?,?,?,?,?,?)");
	    
	    Random random = new Random();
	    
	  //  bankAppDTO.setAccountNo(random.nextInt(1000000000));
	    bankAppDTO.setBalance(0);
	    
	 //  preparedStatement.setLong(1, bankAppDTO.getAccountNo());
	    preparedStatement.setString(1, register.getFirstName());
	    preparedStatement.setString(2, register.getLastName());
	    preparedStatement.setString(3, register.getEmailId());
	    preparedStatement.setString(4, register.getPassword());
	    preparedStatement.setString(5, register.getPanCardNo());
	    preparedStatement.setLong(6, register.getAadharNo());
	    preparedStatement.setString(7, register.getAddress());
	    preparedStatement.setLong(8, register.getMobileNo());
	    preparedStatement.setInt(9, bankAppDTO.getBalance());
	    
	   

	    
	  
	  i=  preparedStatement.executeUpdate();
	  
	  
	  String selectSQL = "SELECT account_no FROM Customer_details WHERE mobile_no = ?";
	  PreparedStatement preparedStatement1 = connection.prepareStatement(selectSQL);
	  preparedStatement1.setLong(1, register.getMobileNo());
	  ResultSet rs = preparedStatement1.executeQuery ();
	  while (rs.next()) {
	  	 accountNo = rs.getLong(1);	
	  	// bankAppDTO.setAccountNo(accountNo);
	 
	  }
	  connection.close();
		}
		 catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		return accountNo;
	}

	public int login(BankAppDTO login) {
		// TODO Auto-generated method stub
		long accountNo = 0;
		String password = null;
		int i=0;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","database","oracle");
		
			
			 String selectSQL = "SELECT account_no,password FROM Customer_details where account_no=? ";
			  PreparedStatement preparedStatement1 = connection.prepareStatement(selectSQL);
			 preparedStatement1.setLong(1, login.getAccountNo());
			  ResultSet rs = preparedStatement1.executeQuery ();
			  while (rs.next()) {
			  	accountNo=rs.getLong(1);
			  	password=rs.getString(2);
			  	System.out.println(accountNo);
			  	System.out.println(password);
			  	
			  	if(accountNo==login.getAccountNo())
			  	{
		  			

			  		if(password.equals(login.getPassword()))
			  		{
			  			i=1;

			  		}
			  	}
			  	
		}
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		  	
		 
		  
		
		
		
		
			return i;
	}

}
