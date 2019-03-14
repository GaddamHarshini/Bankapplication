package com.cg.bankingapp;

import java.util.Scanner;

import com.cg.bankingapp.dto.BankAppDTO;
import com.cg.bankingapp.service.RegisterLoginService;
import com.cg.bankingapp.service.RegisterLoginServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	static RegisterLoginService registerLoginService = new RegisterLoginServiceImpl();
    static BankAppDTO bankAppDTO = new BankAppDTO();
    public static void main( String[] args )
    {
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
			System.out.println("login successful");
		}
		else
		{
			System.out.println("login failed");
		}

	default:
		break;
	}
    }
}
