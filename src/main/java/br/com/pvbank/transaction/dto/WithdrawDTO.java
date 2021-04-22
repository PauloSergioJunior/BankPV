package br.com.pvbank.transaction.dto;

import br.com.pvbank.account.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class WithdrawDTO {

	private Account account;

	private Double value;
	
}
