/**
 * 
 */
package br.com.cbgomes.acme.account.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.cbgomes.acme.client.domain.Client;
import br.com.cbgomes.acme.enuns.TypeAccountEnus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "tb_accounts")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(foreignKey = @ForeignKey(name = "ID_CLIENT"))
	private Client client;
	
	@Enumerated(EnumType.STRING) 
	private TypeAccountEnus typeAccount;
	
	@Column(name="number_account")
	private int numberAccount;
	
	@Column(name="number_agency")
	private int numberAgency;
	
	@Column(name="balance")
	private Double balance;
	
	
}