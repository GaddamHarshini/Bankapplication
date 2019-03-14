package com.cg.bankingapp.dto;

public class BankAppDTO1 {
	
	private long transactionId;
	private long fromAccount;
	private long toAccount;
	private int amountTransferred;
	public long getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}
	public long getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(long fromAccount) {
		this.fromAccount = fromAccount;
	}
	public long getToAccount() {
		return toAccount;
	}
	public void setToAccount(long toAccount) {
		this.toAccount = toAccount;
	}
	public int getAmountTransferred() {
		return amountTransferred;
	}
	public void setAmountTransferred(int amountTransferred) {
		this.amountTransferred = amountTransferred;
	}
	public BankAppDTO1(long transactionId, long fromAccount, long toAccount, int amountTransferred) {
		super();
		this.transactionId = transactionId;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.amountTransferred = amountTransferred;
	}
	public BankAppDTO1() {
		//super();
		// TODO Auto-generated constructor stub
	}
	
	

}
