package br.com.pvbank.account.resource;

import java.util.List;

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

import br.com.pvbank.account.domain.Account;
import br.com.pvbank.account.domain.dto.AccountConverterDTO;
import br.com.pvbank.account.domain.dto.AccountDTO;
import br.com.pvbank.account.service.AccountService;
import br.com.pvbank.enuns.TypeAccountEnus;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/account")
public class AccountResource {
	
	private final AccountService service;
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<AccountDTO>> getAllClients() {
		return ResponseEntity.ok(AccountConverterDTO.conveterListAccount(this.service.getAll()));
	}
	
	@GetMapping("/{numberAccount}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<AccountDTO> getAccountByNumberAccount(@PathVariable int numberAccount) {
		return ResponseEntity.ok(AccountConverterDTO.convertToAccountDTO(this.service.getByNumberAccount(numberAccount).get()));
	}
	
	@GetMapping("/typeAccount/{typeAccount}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<AccountDTO>> getAccountByTypeAccount(@PathVariable TypeAccountEnus typeAccount) {
		return ResponseEntity.ok(AccountConverterDTO.conveterListAccount(this.service.getByTypeAccount(typeAccount)));
	}

	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<?> createAccount(@RequestBody Account account) {
		
		return ResponseEntity.ok(this.service.saveAccount(account));
	}
	

	@PutMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public ResponseEntity<AccountDTO> updateClient(@RequestBody AccountDTO dto,@RequestParam("number_account") int number_account) throws Exception {
		return ResponseEntity.ok(AccountConverterDTO.convertToAccountDTO(this.service.update(this.service.getByNumberAccount(number_account).get())));	
	
	}
	
	@DeleteMapping("/{number_account}")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<Void> deleteAccount(@PathVariable int number_account) {
	//try {
			this.service.removeByNumberAccount(number_account);
			return ResponseEntity.ok().build();
			
//		} catch (Exception e) {
//			return ResponseEntity.noContent().build();
//		}
	}
}
