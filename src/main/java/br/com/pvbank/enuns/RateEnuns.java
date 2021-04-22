package br.com.pvbank.enuns;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum RateEnuns {

	INTEREST_RATE(0.002),
	NEGATIVE_DEPOSIT_RATE(1.005),
	CURRENT_ACCOUNT_RATE(1.0001);
	
	

	public final Double rate;
	
}
