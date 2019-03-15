package com.cg.bankingapp.DAO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.bankingapp.dto.BankAppDTO;

class RegisterLoginImplTest {
	static RegisterLoginImpl registerLoginImpl;
	

	@BeforeAll
	public static void init()
	{
		registerLoginImpl = new RegisterLoginImpl();
	}

	@Test
	void testRegistration() {
		BankAppDTO bankAppDTO = new BankAppDTO();
		//flatRegistrationDTO.setFlat_REG_NO();
		bankAppDTO.setFirstName("abcdef");
		bankAppDTO.setLastName("xyz");
		bankAppDTO.setEmailId("abcdef@gmail.com");
		bankAppDTO.setPassword("abcd");
		bankAppDTO.setPanCardNo("th3456789");
		bankAppDTO.setAadharNo(23456789);
		bankAppDTO.setAddress("hyd");
		bankAppDTO.setMobileNo(567890123);
		bankAppDTO.setBalance(0);
		long a=registerLoginImpl.registration(bankAppDTO);
		
		assertEquals(98765452, a);
	}

	@Test
	void testLogin() {
		BankAppDTO banAppDTO = new BankAppDTO();
		banAppDTO.setAccountNo(98765435);
		banAppDTO.setPassword("harshini");
		assertEquals(1, registerLoginImpl.login(banAppDTO));
	}

}
