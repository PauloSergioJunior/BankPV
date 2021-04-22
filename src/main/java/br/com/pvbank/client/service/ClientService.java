/**
 * 
 */
package br.com.pvbank.client.service;

import java.util.List;
import java.util.Optional;

import br.com.pvbank.client.domain.Client;
import br.com.pvbank.client.domain.dto.ClientDTO;


public interface ClientService {
	
	List<Client> getAll();
	
	Optional<Client> getById(Long id);
	
	Optional<Client> getByEmail(String email);
	
	Client create(Client client);
	
	Client update(Client client, ClientDTO clientDTO);
	
	void deleteClientById(Long id);

}
