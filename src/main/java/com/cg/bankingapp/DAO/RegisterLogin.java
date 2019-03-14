package com.cg.bankingapp.DAO;

import com.cg.bankingapp.dto.BankAppDTO;

public interface RegisterLogin {
	
	long registration(BankAppDTO register);
	
	int login(BankAppDTO login);
	

}
