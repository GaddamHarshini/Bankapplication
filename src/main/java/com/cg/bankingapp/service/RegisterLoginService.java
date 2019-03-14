package com.cg.bankingapp.service;

import com.cg.bankingapp.dto.BankAppDTO;

public interface RegisterLoginService {
	
	long registration(BankAppDTO register);
	int login(BankAppDTO login);
}
