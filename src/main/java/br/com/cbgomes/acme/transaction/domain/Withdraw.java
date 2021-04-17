package br.com.cbgomes.acme.transaction.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Withdraw {

	private Double amountDrawer;
	
	private Double amountRemaining;
	
	
	
}
