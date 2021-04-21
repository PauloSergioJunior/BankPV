package br.com.cbgomes.acme.operations.service;

import java.text.DecimalFormat;

import org.springframework.stereotype.Service;

import br.com.cbgomes.acme.account.service.AccountServiceImpl;
import br.com.cbgomes.acme.enuns.RateEnuns;
import br.com.cbgomes.acme.enuns.TypeAccountEnus;
import br.com.cbgomes.acme.transaction.dto.DepositDTO;
import br.com.cbgomes.acme.transaction.dto.TransferDTO;
import br.com.cbgomes.acme.transaction.dto.WithdrawDTO;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class OperationsServiceImpl implements OperationService{

	
	private final AccountServiceImpl serviceAccount;
	
	@Override
	public DepositDTO deposit(DepositDTO deposit) {

		deposit.setAccount(serviceAccount.getAccountByID(deposit.getAccount().getId()));
		
		if (deposit.getAccount().getBalance() < 0) {

			deposit.getAccount().setBalance(deposit.getValue() + deposit.getAccount().getBalance() * RateEnuns.NEGATIVE_DEPOSIT_RATE.rate);
			
			serviceAccount.create(deposit.getAccount());
			
			return deposit;
		}

		deposit.getAccount().setBalance(deposit.getAccount().getBalance() + deposit.getValue());
		
		serviceAccount.create(deposit.getAccount());
		
		return deposit;

	}

	@Override
	public WithdrawDTO withdraw(WithdrawDTO withdraw) {
		
		withdraw.setAccount(serviceAccount.getAccountByID(withdraw.getAccount().getId()));
		
		if(withdraw.getAccount().getBalance() > -999) {
			
			withdraw.getAccount().setBalance(withdraw.getAccount().getBalance() - withdraw.getValue());
		
			serviceAccount.create(withdraw.getAccount());
			
		return withdraw;
		
		}else {
			
			return null;
		}
		
	}

	@Override
	public TransferDTO transfer(TransferDTO transfer) {

		transfer.setSourceAccount(serviceAccount.getAccountByID(transfer.getSourceAccount().getId()));
		transfer.setDestinationAccount(serviceAccount.getAccountByID(transfer.getDestinationAccount().getId()));
		
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
			
			
			Double originalValue = transfer.getValue();
			
			transfer.setValue(transfer.getValue() * RateEnuns.CURRENT_ACCOUNT_RATE.rate);
			
			WithdrawDTO withdraw = new WithdrawDTO();
			withdraw.setAccount(transfer.getSourceAccount());
			withdraw.setValue(transfer.getValue());
			withdraw(withdraw);
			
			DepositDTO deposit = new DepositDTO();
			deposit.setAccount(transfer.getDestinationAccount());
			deposit.setValue(originalValue);
			deposit(deposit);
			
		}

		
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
