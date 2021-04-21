package br.com.cbgomes.acme.account.service;

import java.util.List;
import java.util.Optional;

import br.com.cbgomes.acme.account.domain.Account;
import br.com.cbgomes.acme.enuns.TypeAccountEnus;


public interface AccountService {
	
	List<Account> getAll();
	
	Optional<Account> getByNumberAccount(int numberAccount);
	
	void removeByNumberAccount(int numberAccount);
	
	Account create(Account account);

	List<Account> getByTypeAccount(TypeAccountEnus typeAccount);

	void saveAccount(Account accountRequest);
	
	Account getAccountByID(Long id);
	
}