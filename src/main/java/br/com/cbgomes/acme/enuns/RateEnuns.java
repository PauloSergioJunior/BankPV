package br.com.cbgomes.acme.enuns;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum RateEnuns {

	INTEREST_RATE(0.002),
	NEGATIVE_DEPOSIT_RATE(1.005),
	CURRENT_ACCOUNT_RATE(1.0001);
	
	

	public Double rate;
	
}
