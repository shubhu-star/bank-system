package com.bank.service;

import java.util.List;

import com.bank.entity.Account;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public  interface AccountService {
	
	
	public static final Logger Logger=
			LoggerFactory.getLogger(AccountServiceImpl.class);
	
Account createAccount(Account account);

Account getAccountById(Long id);

List<Account> getAllAccounts();

Account updateAccount(Long id, Account account);

void deleteAccount(Long id);

Account createAccount();

}