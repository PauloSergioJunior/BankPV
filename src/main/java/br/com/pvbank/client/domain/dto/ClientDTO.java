/**
 * 
 */
package br.com.pvbank.client.domain.dto;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ClientDTO {

	private String name;
	
	private String phone;
	
	private String email;
	
	private String address;
	
	private String cpf;
	
	private String cnpj;
	
	@NotNull
	private boolean active;
	
}
