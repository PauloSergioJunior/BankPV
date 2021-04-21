package br.com.cbgomes.acme.account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.cbgomes.acme.enuns.RateEnuns;
import br.com.cbgomes.acme.enuns.TypeAccountEnus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class AccountSavings extends Account {
	
	@Column(name = "RATE_PER_MONTH")
    private Double interestRate;
	
	public AccountSavings(Account account, Double rate) {
		super(null,account.getClient(),TypeAccountEnus.AccountSaving,account.getNumberAccount(),account.getNumberAgency(),account.getBalance());
		this.interestRate = rate;
	}


    public static AccountSavings builder(Account account) {
        return new AccountSavings(account,RateEnuns.INTEREST_RATE.rate);
    }
    
}
