/**
 * 
 */
package br.com.pvbank.account.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import br.com.pvbank.account.domain.Account;

@Component
public class AccountConverterDTO {

	@Bean
	public static ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static Account convertToAccount(AccountDTO dto) {
		return modelMapper().map(dto, Account.class);
	}
	
	public static AccountDTO convertToAccountDTO(Account account) {
		return modelMapper().map(account, AccountDTO.class);
	}
	
	public static List<AccountDTO> conveterListAccount(List<Account> accounts){
		return accounts
				.stream()
				.map(c -> modelMapper().map(c, AccountDTO.class))
				.collect(Collectors.toList());
	}
	
}
