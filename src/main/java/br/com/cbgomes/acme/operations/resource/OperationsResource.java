package br.com.cbgomes.acme.operations.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.cbgomes.acme.operations.service.OperationService;
import br.com.cbgomes.acme.transaction.dto.DepositDTO;
import br.com.cbgomes.acme.transaction.dto.TransferDTO;
import br.com.cbgomes.acme.transaction.dto.WithdrawDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/operations")
public class OperationsResource {

	
	private final OperationService operationService;
	
	@PostMapping("/deposit")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> deposit(@RequestBody DepositDTO depositDTO) {
		
		this.operationService.deposit(depositDTO);
		
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/withdraw")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> withdraw(@RequestBody WithdrawDTO withdrawDTO) {
		
		this.operationService.withdraw(withdrawDTO);
		
		return ResponseEntity.ok().build();
	}
	
	
	@PostMapping("/transfer")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> transfer(@RequestBody TransferDTO transferDTO) {
		
		this.operationService.transfer(transferDTO);
		
		return ResponseEntity.ok().build();
	}
	
}
