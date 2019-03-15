package com.cg.bankingapp.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.bankingapp.dto.BankAppDTO;
import com.cg.bankingapp.dto.BankAppDTO1;

public class TransactionDAOImpl implements TransactionDAO {
    BankAppDTO bankAppDTO = new BankAppDTO();
	public int deposit(long account,int amount) {
		// TODO Auto-generated method stub
		int balance=0;
		int i=0;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","database","oracle");

			 String selectSQL = "SELECT balance FROM Customer_details WHERE account_no = ?";
			  PreparedStatement preparedStatement1 = connection.prepareStatement(selectSQL);
			  preparedStatement1.setLong(1, account);
			  ResultSet rs = preparedStatement1.executeQuery ();
			  while (rs.next()) {
			  	 balance = rs.getInt(1);	
			  	// bankAppDTO.setAccountNo(accountNo);
			 
			  }
			
            PreparedStatement preparedStatement =  connection.prepareStatement("update Customer_details set balance=? where account_no=?");
		    balance = balance+amount;
		    preparedStatement.setLong(2, account);
		    preparedStatement.setInt(1,balance );
		    
		   i=  preparedStatement.executeUpdate();
		   connection.close();
		  
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
		
		return i;
	}
	public int withdrawal(long account, int amount) {
		int balance=0;
		int i=0;
		
		try 
		{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","database","oracle");

		 String selectSQL = "SELECT balance FROM Customer_details WHERE account_no = ?";
		  PreparedStatement preparedStatement1 = connection.prepareStatement(selectSQL);
		  preparedStatement1.setLong(1, account);
		  ResultSet rs = preparedStatement1.executeQuery ();
		  while (rs.next()) {
		  	 balance = rs.getInt(1);	
		  	// bankAppDTO.setAccountNo(accountNo);
		 
		  }
		
        PreparedStatement preparedStatement =  connection.prepareStatement("update Customer_details set balance=? where account_no=?");
        if(balance>amount)
        {
	    balance = balance-amount;
	    preparedStatement.setLong(2, account);
	    preparedStatement.setInt(1,balance );
	    
	   i=  preparedStatement.executeUpdate();
	   connection.close();
        }
        else
        {
        	i=0;
        }
	  
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	

		
		
		return i;
	}
	public int showBalance(long account) {
		// TODO Auto-generated method stub
		int currentBalance=0;
		
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","database","oracle");

			 String selectSQL = "SELECT balance FROM Customer_details WHERE account_no = ?";
			  PreparedStatement preparedStatement1 = connection.prepareStatement(selectSQL);
			  preparedStatement1.setLong(1, account);
			  ResultSet rs = preparedStatement1.executeQuery ();
			  while (rs.next()) {
			  	 currentBalance = rs.getInt(1);	
			  	// bankAppDTO.setAccountNo(accountNo);
			 
			  }
			  connection.close();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return currentBalance;
	}
	public int fundTransfer(BankAppDTO1 transfer) {
		// TODO Auto-generated method stub
		int i=0;
try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","database","oracle");
		
	    PreparedStatement preparedStatement =  connection.prepareStatement("insert into transaction_details values(transaction.nextval,?,?,?)");
	  int balance1 = showBalance(transfer.getFromAccount());
	    if(balance1>transfer.getAmountTransferred())
	    {
	    preparedStatement.setLong(1,transfer.getFromAccount());
	    preparedStatement.setLong(2,transfer.getToAccount());
	    preparedStatement.setInt(3,transfer.getAmountTransferred());
	   
	   
	 i=  preparedStatement.executeUpdate(); 
	 long toAcc = transfer.getToAccount();
	  int amount1 = transfer.getAmountTransferred();
	  long fromAcc = transfer.getFromAccount();
	   deposit(toAcc, amount1);
	   withdrawal(fromAcc, amount1);
	   
	 /*  String selectSQL = "SELECT transaction_id FROM Customer_details WHERE  from_account_no= ?";
		  PreparedStatement preparedStatement1 = connection.prepareStatement(selectSQL);
		  preparedStatement1.setLong(1, transfer.getFromAccount());
		  ResultSet rs = preparedStatement1.executeQuery ();
		  while (rs.next()) {
		  	 i = rs.getLong(1);	
		  	// bankAppDTO.setAccountNo(accountNo);
		  	 System.out.println(i);*/
		 
		//  }
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
		return i;
	}
	
	

}
