package br.com.cbgomes.acme.account.domain;

import javax.persistence.Entity;

import br.com.cbgomes.acme.enuns.TypeAccountEnus;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
public class CurrentAccount extends Account {

	
	public CurrentAccount(Account account) {
		super(null,account.getClient(),TypeAccountEnus.CurrentAccount,account.getNumberAccount(),account.getNumberAgency(),account.getBalance());
    
	}
	
	 public static CurrentAccount builder(Account account) {
	        return  new CurrentAccount(account);
	    }
	
}
