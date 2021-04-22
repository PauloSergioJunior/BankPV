/**
 * 
 */
package br.com.pvbank.client.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.pvbank.client.domain.Client;


@Component
public class ClientConverterDTO {

	public static ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static Client convertToClient(ClientDTO dto) {
		return modelMapper().map(dto, Client.class);
	}
	
	public static ClientDTO convertToClientDTO(Client client) {
		return modelMapper().map(client, ClientDTO.class);
	}
	
	public static List<ClientDTO> conveterListClients(List<Client> clients){
		return clients
				.stream()
				.map(c -> modelMapper().map(c, ClientDTO.class))
				.collect(Collectors.toList());
	}
	
}
