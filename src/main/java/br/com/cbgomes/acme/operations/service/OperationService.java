package br.com.cbgomes.acme.operations.service;

import br.com.cbgomes.acme.transaction.dto.DepositDTO;
import br.com.cbgomes.acme.transaction.dto.TransferDTO;
import br.com.cbgomes.acme.transaction.dto.WithdrawDTO;

public interface OperationService {

	DepositDTO deposit(DepositDTO deposit);
	
	WithdrawDTO withdraw(WithdrawDTO withdraw);
	
	TransferDTO transfer(TransferDTO transfer);
	
}
