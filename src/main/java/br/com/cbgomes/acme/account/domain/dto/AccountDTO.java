package br.com.cbgomes.acme.account.domain.dto;

import br.com.cbgomes.acme.client.domain.dto.ClientDTO;
import br.com.cbgomes.acme.enuns.TypeAccount;
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
	
	private TypeAccount typeAccount;
	
	private int numberAccount;
	
	private int numberAgency;
	
	private Double balance;

}
