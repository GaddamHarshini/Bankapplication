package com.cg.bankingapp.service;

import com.cg.bankingapp.DAO.RegisterLogin;
import com.cg.bankingapp.DAO.RegisterLoginImpl;
import com.cg.bankingapp.dto.BankAppDTO;

public class RegisterLoginServiceImpl implements RegisterLoginService {
	RegisterLogin registerLogin = new RegisterLoginImpl();

	public long registration(BankAppDTO register) {
		// TODO Auto-generated method stub
		long accountNo = registerLogin.registration(register);
		return accountNo;
	}

	public int login(BankAppDTO login) {
		// TODO Auto-generated method stub
		int logging = registerLogin.login(login);
		
		return logging;
	}

}
