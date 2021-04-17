package br.com.cbgomes.acme.enuns;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public enum Rate {

	INTEREST_RATE(0.002);

	public Double rate;
	
}
