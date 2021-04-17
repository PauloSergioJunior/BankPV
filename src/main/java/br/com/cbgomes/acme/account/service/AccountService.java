package br.com.cbgomes.acme.account.service;

import java.util.List;
import java.util.Optional;

import br.com.cbgomes.acme.account.domain.Account;
import br.com.cbgomes.acme.transaction.domain.Deposit;
import br.com.cbgomes.acme.transaction.domain.Transfer;
import br.com.cbgomes.acme.transaction.domain.Withdraw;


public interface AccountService {
	
	List<Account> getAll();
	
	Optional<Account> getByNumberAccount(Long numberAccount);
	
	void removeByNumberAccount(Long numberAccount) throws Exception;
	
	Account create(Account account);

	List<Account> getByTypeAccount(Long typeAccount);

	void saveAccount(Account accountRequest);
	
	Deposit deposit(Double value, Account sourceAccount, Account destinationAccount);
	
	Withdraw withdraw(Double value, Account sourceAccount, Account destinationAccount);
	
	Transfer transfer(Double value, Account sourceAccount, Account destinationAccount);

}