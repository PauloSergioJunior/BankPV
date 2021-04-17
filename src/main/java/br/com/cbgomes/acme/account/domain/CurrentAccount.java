package br.com.cbgomes.acme.account.domain;

public class CurrentAccount extends Account {

	 public static CurrentAccount builder(Account account) {
		 CurrentAccount currentAccount = new CurrentAccount();
	        currentAccount.setNumberAccount(account.getNumberAccount());
	        currentAccount.setNumberAgency(account.getNumberAgency());
	        currentAccount.setBalance(account.getBalance());
	        currentAccount.setClient(account.getClient());

	        return currentAccount;
	    }
	
}
