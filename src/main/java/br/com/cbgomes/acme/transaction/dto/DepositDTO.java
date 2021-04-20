package br.com.cbgomes.acme.transaction.dto;

import br.com.cbgomes.acme.account.domain.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DepositDTO {

	private Account account;

	private Double value;
}
