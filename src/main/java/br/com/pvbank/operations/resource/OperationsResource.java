package br.com.pvbank.operations.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pvbank.operations.service.OperationService;
import br.com.pvbank.transaction.dto.DepositDTO;
import br.com.pvbank.transaction.dto.TransferDTO;
import br.com.pvbank.transaction.dto.WithdrawDTO;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/operations")
public class OperationsResource {

	
	private final OperationService operationService;
	
	@PostMapping("/deposit")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> deposit(@RequestBody DepositDTO depositDTO) {
		
		return ResponseEntity.ok(this.operationService.deposit(depositDTO));
	}
	
	
	@PostMapping("/withdraw")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> withdraw(@RequestBody WithdrawDTO withdrawDTO) {
		
		return ResponseEntity.ok(this.operationService.withdraw(withdrawDTO));
	}
	
	
	@PostMapping("/transfer")
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<?> transfer(@RequestBody TransferDTO transferDTO) {
		
		return ResponseEntity.ok(this.operationService.transfer(transferDTO));
	}
	
}
