package br.com.pvbank.account.domain.dto;

import br.com.pvbank.client.domain.dto.ClientDTO;
import br.com.pvbank.enuns.TypeAccountEnus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class AccountDTO {
	
	private ClientDTO client;
	
	private TypeAccountEnus typeAccount;
	
	private int numberAccount;
	
	private int numberAgency;
	
	private Double balance;

}
