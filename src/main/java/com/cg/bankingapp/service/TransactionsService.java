package com.cg.bankingapp.service;

import com.cg.bankingapp.dto.BankAppDTO;
import com.cg.bankingapp.dto.BankAppDTO1;

public interface TransactionsService {
	
	int deposit(long account, int amount);
	int withdrawal(long account,int amount);
    int showBalance(long account);
    int fundTransfer(BankAppDTO1 transfer);
}
