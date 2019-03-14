package com.cg.bankingapp.dto;

public class BankAppDTO {

	private long accountNo;
	private String firstName;
	private String lastName;
	private String emailId;
	private String password;
	private String panCardNo;
	private long aadharNo;
	private String address;
	private long mobileNo;
	private int balance;
	
	
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPanCardNo() {
		return panCardNo;
	}
	public void setPanCardNo(String panCardNo) {
		this.panCardNo = panCardNo;
	}
	public long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public long getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(long mobileNo) {
		this.mobileNo = mobileNo;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public BankAppDTO(long accountNo, String firstName, String lastName, String emailId, String password,
			String panCardNo, long aadharNo, String address, long mobileNo, int balance) {
		super();
		this.accountNo = accountNo;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailId = emailId;
		this.password = password;
		this.panCardNo = panCardNo;
		this.aadharNo = aadharNo;
		this.address =address;
		this.mobileNo = mobileNo;
		this.balance = balance;
	}
	public BankAppDTO() {
	//	super();
		
	}
	
	
	
	
	
}
