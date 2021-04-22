/**
 * 
 */
package br.com.pvbank.client.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.pvbank.client.domain.Client;
import br.com.pvbank.client.domain.dto.ClientDTO;
import br.com.pvbank.client.repository.ClientRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements ClientService {
	
	
	private final ClientRepository repository;


	@Override
	public List<Client> getAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Client> getById(Long id) {
		return this.repository.findById(id);
	}

	@Override
	public Optional<Client> getByEmail(String email) {
		return this.repository.findByEmail(email);
	}

	@Override
	public Client create(Client client) {
		return this.repository.save(client);
	}
	
	@Override
	public Client update(Client client, ClientDTO clientDTO) {
		
		client.setName(clientDTO.getName().isBlank() ? client.getName() : clientDTO.getName());
		
		client.setAddress(clientDTO.getAddress().isBlank() ? client.getAddress() : clientDTO.getAddress());
		
		client.setEmail(clientDTO.getEmail().isBlank() ? client.getEmail() : clientDTO.getEmail());
		
		client.setPhone(clientDTO.getPhone().isBlank() ? client.getPhone() : clientDTO.getPhone());
		
		client.setCpf(clientDTO.getCpf().isBlank() ? client.getCpf() : clientDTO.getCpf());
		
		client.setCnpj(clientDTO.getCnpj().isBlank() ? client.getCnpj() : clientDTO.getCnpj());
		
		client.setActive(clientDTO.isActive());
		
		return this.repository.save(client);
	}

	@Override
	public void deleteClientById(Long id) {
		
		 this.repository.deleteById(id);
	}



}
