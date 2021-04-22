package br.com.pvbank.extratc.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.pvbank.account.domain.Account;
import br.com.pvbank.enuns.TypeOperation;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "TB_EXTRATC")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Extratc implements Serializable{
	
	
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "DATE_TRANSACTION", nullable = false)
	private LocalDate dateTransaction;
	
	@Column(name = "ORIGEM_AGENCY", length = 10, nullable = false)
	private int originAgency;
	
	@Column(name = "ORIGEM_ACCOUNT", length = 10, nullable = false)
	private int originAccount;
		
	@Column(name = "DESTINATION_AGENCY", length = 10)
	private int destinationAgency;
	
	@Column(name = "DESTINATION_ACCOUNT", length = 10)
	private int destinationAccount;

	@Column(name = "TYPE_TRANSACTION", nullable = false)
	@Enumerated(EnumType.STRING)
	private TypeOperation typeOperation;
	
	@Column(name = "VALUE_TRANSACTION", nullable = false)
	private String valueTransaction;
	
	@Column(name = "BALANCE_ACCOUNT_ORIGEM", nullable = false)
	private Double balance;
	
	
	public static Extratc builder(Account accountOrigin, Account accountDestine, TypeOperation operation, String valueTransaction) {
        return new Extratc(null , LocalDate.now(), accountOrigin.getNumberAgency(), accountOrigin.getNumberAccount(),
                accountDestine.getNumberAgency(), accountDestine.getNumberAccount(), operation, valueTransaction,  accountOrigin.getBalance());
    }
    
    public static Extratc builder(Account accountOrigin, TypeOperation operation, String valueTransaction) {
        return new Extratc(null , LocalDate.now(), accountOrigin.getNumberAgency(), accountOrigin.getNumberAccount(),
                0, 0, operation, valueTransaction, accountOrigin.getBalance());
    }

}