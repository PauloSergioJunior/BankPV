package br.com.pvbank.operations.service;

import br.com.pvbank.transaction.dto.DepositDTO;
import br.com.pvbank.transaction.dto.TransferDTO;
import br.com.pvbank.transaction.dto.WithdrawDTO;

public interface OperationService {

	DepositDTO deposit(DepositDTO deposit);
	
	WithdrawDTO withdraw(WithdrawDTO withdraw);
	
	TransferDTO transfer(TransferDTO transfer);
	
}
