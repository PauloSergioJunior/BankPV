package br.com.pvbank.extratc.domain.dto;

import java.time.LocalDate;

import br.com.pvbank.enuns.TypeOperation;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExtratcDTO {

	private LocalDate dateTransaction;
	
	private int originAgency;
	
	private int originAccount;
		
	private int destinationAgency;
	
	private int destinationAccount;

	private TypeOperation typeOperation;
	
	private String valueTransaction;
	
	private Double balance;
	
}
