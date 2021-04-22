/**
 * 
 */
package br.com.pvbank.client.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name= "tb_clients")
public class Client implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8585355753261079546L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID_CLIENT")
	private Long id;
	
	private String name;
	
	private String phone;
	
	private String email;
	
	private String address;
	
	private String cpf;
	
	private String cnpj;
	
	@Column(nullable = false)
	private boolean active;
	
}




