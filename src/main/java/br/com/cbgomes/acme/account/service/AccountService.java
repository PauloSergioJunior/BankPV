package br.com.cbgomes.acme.account.service;

import java.util.List;
import java.util.Optional;

import br.com.cbgomes.acme.account.domain.Account;


public interface AccountService {
	
	List<Account> getAll();
	
	Optional<Account> getByNumberAccount(Long numberAccount);
	
	void removeByNumberAccount(Long numberAccount) throws Exception;
	
	Account create(Account account);

	List<Account> getByTypeAccount(Long typeAccount);

	void saveAccount(Account accountRequest);
	
}