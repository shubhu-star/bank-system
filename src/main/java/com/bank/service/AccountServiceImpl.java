package com.bank.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.bank.entity.Account;
import com.bank.exception.AccountNotFoundException;
import com.bank.repository.AccountRepository;

@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    
    private static final Logger logger=
    		LoggerFactory.getLogger(AccountServiceImpl.class);

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account createAccount(Account account) {

        logger.info("Creating new bank account");

        logger.debug("Account service debug log");
        
        Logger.warn("Account creation type get warning");
        

        try {

            Account savedAccount = accountRepository.save(account);

            logger.info("Bank account created successfully");

            return savedAccount;

        } catch (Exception e) {

            logger.error("Failed to create bank account", e);

            throw e;
        }
    }
    @Override
    public Account getAccountById(Long id) {
    	
    	logger.info("Featching account by id:{}",id);
    	
        return accountRepository.findById(id)
                .orElseThrow(() ->{
            	logger.warn (" account not found with  id:{}",id);
                  return new AccountNotFoundException(
                        "Account not found with id: " + id );
    });
}

    @Override
    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    @Override
    public Account updateAccount(Long id, Account account) {

        Account existingAccount = accountRepository.findById(id)
                .orElseThrow(() ->
                    new AccountNotFoundException(
                        "Account not found with id: " + id
                    )
                );

        existingAccount.setAccountNumber(account.getAccountNumber());
        existingAccount.setAccountHolderName(account.getAccountHolderName());
        existingAccount.setAccountType(account.getAccountType());
        existingAccount.setBalance(account.getBalance());

        return accountRepository.save(existingAccount);
    }

    @Override
    public void deleteAccount(Long id) {
        accountRepository.deleteById(id);
    }

	@Override
	public Account createAccount() {
		// TODO Auto-generated method stub
		return null;
	}
}