package com.cg.bankingapp.service;

import com.cg.bankingapp.DAO.TransactionDAO;
import com.cg.bankingapp.DAO.TransactionDAOImpl;
import com.cg.bankingapp.dto.BankAppDTO;
import com.cg.bankingapp.dto.BankAppDTO1;

public class TransactionsServiceImpl implements TransactionsService {
  TransactionDAO transactionDAO = new TransactionDAOImpl();
  
	public int deposit(long account,int amount) {
		// TODO Auto-generated method stub
		int d = transactionDAO.deposit(account, amount);
		return d;
	}
	public int withdrawal(long account, int amount) {
		// TODO Auto-generated method stub
		int w = transactionDAO.withdrawal(account, amount);
		return w;
	}
	public int showBalance(long account) {
		// TODO Auto-generated method stub
		int currentBalance = transactionDAO.showBalance(account);
		return currentBalance;
	}
	public int fundTransfer(BankAppDTO1 transfer) {
		// TODO Auto-generated method stub
		int i= transactionDAO.fundTransfer(transfer);
		return i;
	}

}
