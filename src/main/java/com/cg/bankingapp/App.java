package com.cg.bankingapp;

import java.util.Scanner;

import com.cg.bankingapp.DAO.TransactionDAO;
import com.cg.bankingapp.DAO.TransactionDAOImpl;
import com.cg.bankingapp.dto.BankAppDTO;
import com.cg.bankingapp.service.RegisterLoginService;
import com.cg.bankingapp.service.RegisterLoginServiceImpl;
import com.cg.bankingapp.service.TransactionsService;
import com.cg.bankingapp.service.TransactionsServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	static RegisterLoginService registerLoginService = new RegisterLoginServiceImpl();
    static BankAppDTO bankAppDTO = new BankAppDTO();
   static TransactionsService transactionsService = new TransactionsServiceImpl();
    
    public static void main( String[] args )
    {
    	
    	do {
    		System.out.println("1.Register\n 2.Login");
       Scanner sc = new Scanner(System.in);
       int i=sc.nextInt();
       switch (i) {
	case 1:  
	          System.out.println("Enter first name");
	          String firstName = sc.next();
	          bankAppDTO.setFirstName(firstName);
	          
	          System.out.println("Enter last Name");
	         String lastName=sc.next();
	          bankAppDTO.setLastName(lastName);
	          
	          System.out.println("Enter emailid");
	          String emailId = sc.next();
	          bankAppDTO.setEmailId(emailId);
	          
	          System.out.println("Enter password");
	          String password = sc.next();
	          bankAppDTO.setPassword(password);
	          
	          System.out.println("Enter pancard number");
	          String pancardNo = sc.next();
	          bankAppDTO.setPanCardNo(pancardNo);
	          
	          System.out.println("Enter aadhar no");
	          long aadharNo= sc.nextLong();
	          bankAppDTO.setAadharNo(aadharNo);
	          
	          System.out.println("Enter address");
	          String address  = sc.next();
	          bankAppDTO.setAddress(address);
	          
	          System.out.println("Enter mobile no");
	          long mobileNo=sc.nextLong();
	          bankAppDTO.setMobileNo(mobileNo);
	          
	       long a=   registerLoginService.registration(bankAppDTO);
	        
		break;
	case 2: 
		
		System.out.println("Enter account number");
		long accountNo = sc.nextLong();
		bankAppDTO.setAccountNo(accountNo);
		System.out.println("Enter password");
		String enterdpassword = sc.next();
		bankAppDTO.setPassword(enterdpassword);
		
		
		int login=registerLoginService.login(bankAppDTO);
		if(login==1)
		{
			System.out.println("logged in successfully");
			do
			{
			System.out.println("\n1.Deposit\n2.withdrawal\n3.showbalance\n4.fundtransfer");
			int l = sc.nextInt();
			switch (l) {
			case 1: System.out.println("enter the amount to be deposited");
			      int depositAmount = sc.nextInt();
			     int d= transactionsService.deposit(bankAppDTO.getAccountNo(), depositAmount);
			     if(d==1)
			     {
			    	 System.out.println("deposit done successfully");
			     }
			     else
			     {
			    	 System.out.println("failure while updating");
			     }
			     
			     break;
			      
			case 2: System.out.println("Enter the amount for withdrawal");
			          int withdrawalamount = sc.nextInt();
			        int w =   transactionsService.withdrawal(bankAppDTO.getAccountNo(), withdrawalamount);
				
			        if(w==1)
			        {
			        	System.out.println("withdrawal done successfully");
			        }
			        else
			        {
			        	System.out.println("insufficient balance");
			        }
				break;
			case 3: int currentbalance=transactionsService.showBalance(bankAppDTO.getAccountNo());
                       System.out.println("The available balance in your account is: "+currentbalance);
                break;    
                
			case 4: 
				
				
				break;
			default:
				break;
			}
			}while(true);
			
			
		}
		else
		{
			System.out.println("login failed\n please enter valid account no and password");
		}

	default:
		break;
	}
    	}while(true);
    }
}
