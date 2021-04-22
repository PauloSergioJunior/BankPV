/**
 * 
 */
package br.com.pvbank.client.resource;

import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pvbank.client.domain.dto.ClientConverterDTO;
import br.com.pvbank.client.domain.dto.ClientDTO;
import br.com.pvbank.client.service.ClientService;
import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/clients")
public class ClientResource {
	
	private final ClientService service;
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<ClientDTO> createClient(@RequestBody ClientDTO dto) {
		return ResponseEntity.ok(ClientConverterDTO.convertToClientDTO(this.service.create(ClientConverterDTO.convertToClient(dto))));
	}
	
	/*
	 * Atualiza o cliente em modo geral
	 * 
	 * O campo "active" necessita que esteja preenchido 
	 */
	@PutMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<ClientDTO> updateClient(@Valid @RequestBody ClientDTO dto,@RequestParam("id") Long id) throws Exception {
		return ResponseEntity.ok(ClientConverterDTO.convertToClientDTO(this.service.update(this.service.getById(id).get(),dto)));	
	
	}

	@GetMapping("/{id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<ClientDTO> getClientById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(ClientConverterDTO.convertToClientDTO(this.service.getById(id).get()));
	}


	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<ClientDTO>> getAllClients() {
		return ResponseEntity.ok(ClientConverterDTO.conveterListClients(this.service.getAll()));
	}

	
	@DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<ClientDTO> deleteClientById(@PathVariable Long id) {
		
		this.service.deleteClientById(id);
		
		return ResponseEntity.ok().build();
    }
}







