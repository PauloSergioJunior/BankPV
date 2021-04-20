package br.com.cbgomes.acme.operations.service;

import org.springframework.stereotype.Service;

import br.com.cbgomes.acme.enuns.RateEnuns;
import br.com.cbgomes.acme.enuns.TypeAccountEnus;
import br.com.cbgomes.acme.transaction.dto.DepositDTO;
import br.com.cbgomes.acme.transaction.dto.TransferDTO;
import br.com.cbgomes.acme.transaction.dto.WithdrawDTO;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class OperationsServiceImpl implements OperationService{

	
	@Override
	public DepositDTO deposit(DepositDTO deposit) {

		if (deposit.getAccount().getBalance() < 0) {

			deposit.getAccount().setBalance(deposit.getValue() - deposit.getAccount().getBalance() * RateEnuns.NEGATIVE_DEPOSIT_RATE.rate);

			return deposit;
		}

		deposit.getAccount().setBalance(deposit.getAccount().getBalance() + deposit.getValue());
		return deposit;

	}

	@Override
	public WithdrawDTO withdraw(WithdrawDTO withdraw) {
		
		
		if(withdraw.getAccount().getBalance() > -999) {
			
			withdraw.getAccount().setBalance(withdraw.getAccount().getBalance() - withdraw.getValue());
		
		return withdraw;
		
		}else {
			
			return null;
		}
		
	}

	@Override
	public TransferDTO transfer(TransferDTO transfer) {

		
		if(transfer.getSourceAccount().getNumberAgency() == transfer.getDestinationAccount().getNumberAgency() 
				&& verifyBalanceAccount(transfer)) {
			
			WithdrawDTO withdraw = new WithdrawDTO();
			withdraw.setAccount(transfer.getSourceAccount());
			withdraw.setValue(transfer.getValue());
			withdraw(withdraw);
			
			DepositDTO deposit = new DepositDTO();
			deposit.setAccount(transfer.getDestinationAccount());
			deposit.setValue(transfer.getValue());
			deposit(deposit);
			
		}else if(transfer.getSourceAccount().getNumberAgency() != transfer.getDestinationAccount().getNumberAgency() 
				&& verifyBalanceAccount(transfer) 
				&& transfer.getSourceAccount().getTypeAccount() == TypeAccountEnus.CurrentAccount
				&& transfer.getDestinationAccount().getTypeAccount() == TypeAccountEnus.CurrentAccount) {
			
			transfer.setValue(transfer.getValue() * RateEnuns.CURRENT_ACCOUNT_RATE.rate);
			
			WithdrawDTO withdraw = new WithdrawDTO();
			withdraw.setAccount(transfer.getSourceAccount());
			withdraw.setValue(transfer.getValue());
			withdraw(withdraw);
			
			DepositDTO deposit = new DepositDTO();
			deposit.setAccount(transfer.getDestinationAccount());
			deposit.setValue(transfer.getValue());
			deposit(deposit);
			
		}
		
//		conta corrente de diferentes agencias:
//		      **transfer = valueTransfer*1,0001);**
//		contas correntes pertencentes a mesma agencia:
//		      **transfer =-valueTransfer**
//		conta poupança rendimento:
//		      valueSavings = balance*1,002
		
		return null;
	}
	
	
	private boolean verifyBalanceAccount(TransferDTO transfer) {
		
		if(transfer.getSourceAccount().getBalance() >= transfer.getValue()) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
}
