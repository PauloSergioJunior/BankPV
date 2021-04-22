package br.com.pvbank.account.service;

import java.util.List;
import java.util.Optional;

import br.com.pvbank.account.domain.Account;
import br.com.pvbank.enuns.TypeAccountEnus;


public interface AccountService {
	
	List<Account> getAll();
	
	Optional<Account> getByNumberAccount(int numberAccount);
	
	void removeByNumberAccount(int numberAccount);
	
	List<Account> getByTypeAccount(TypeAccountEnus typeAccount);

	Account update(Account account);
	
	Account saveAccount(Account accountRequest);
	
	Account getAccountByID(Long id);
	
}