package br.com.cbgomes.acme.account.domain;

import javax.persistence.Column;

import br.com.cbgomes.acme.enuns.RateEnuns;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountSavings extends Account {
	
	@Column(name = "RATE_PER_MONTH")
    private Double interestRate;


    public static AccountSavings builder(Account account) {
    	AccountSavings accountSavings = new AccountSavings();
        accountSavings.setNumberAccount(account.getNumberAccount());
        accountSavings.setNumberAgency(account.getNumberAgency());
        accountSavings.setBalance(account.getBalance());
        accountSavings.setClient(account.getClient());
        accountSavings.setInterestRate(RateEnuns.INTEREST_RATE.rate);

        return accountSavings;
    }
    
}
