package br.com.pvbank.operations.service;

import org.springframework.stereotype.Service;

import br.com.pvbank.account.service.AccountServiceImpl;
import br.com.pvbank.enuns.RateEnuns;
import br.com.pvbank.enuns.TypeAccountEnus;
import br.com.pvbank.enuns.TypeOperation;
import br.com.pvbank.extratc.domain.Extratc;
import br.com.pvbank.extratc.service.ExtratcServiceImpl;
import br.com.pvbank.transaction.dto.DepositDTO;
import br.com.pvbank.transaction.dto.TransferDTO;
import br.com.pvbank.transaction.dto.WithdrawDTO;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OperationsServiceImpl implements OperationService {

	private final AccountServiceImpl serviceAccount;

	private final ExtratcServiceImpl serviceExtratc;

	@Override
	public DepositDTO deposit(DepositDTO deposit) {

		deposit.setAccount(serviceAccount.getAccountByID(deposit.getAccount().getId()));

		if (deposit.getAccount().getBalance() < 0) {

			deposit.getAccount().setBalance(
					deposit.getValue() + deposit.getAccount().getBalance() * RateEnuns.NEGATIVE_DEPOSIT_RATE.rate);

			Extratc extractAccount = Extratc.builder(deposit.getAccount(), TypeOperation.DEPOSIT,
					TypeOperation.DEPOSIT.operationSignal + deposit.getValue().toString());

			serviceAccount.update(deposit.getAccount());

			serviceExtratc.create(extractAccount);

			return deposit;
		}

		deposit.getAccount().setBalance(deposit.getAccount().getBalance() + deposit.getValue());

		Extratc extractAccount = Extratc.builder(deposit.getAccount(), TypeOperation.DEPOSIT,
				TypeOperation.DEPOSIT.operationSignal + deposit.getValue().toString());

		serviceAccount.update(deposit.getAccount());

		serviceExtratc.create(extractAccount);

		return deposit;

	}

	@Override
	public WithdrawDTO withdraw(WithdrawDTO withdraw) {

		withdraw.setAccount(serviceAccount.getAccountByID(withdraw.getAccount().getId()));

		withdraw.getAccount().getBalance();

		withdraw.getAccount().setBalance(withdraw.getAccount().getBalance() - withdraw.getValue());

		Extratc extractAccount = Extratc.builder(withdraw.getAccount(), TypeOperation.WITHDRAW,
				TypeOperation.WITHDRAW.operationSignal + withdraw.getValue().toString());

		serviceAccount.update(withdraw.getAccount());

		serviceExtratc.create(extractAccount);

		return withdraw;

	}

	@Override
	public TransferDTO transfer(TransferDTO transfer) {

		transfer.setSourceAccount(serviceAccount.getAccountByID(transfer.getSourceAccount().getId()));
		transfer.setDestinationAccount(serviceAccount.getAccountByID(transfer.getDestinationAccount().getId()));

		if (transfer.getSourceAccount().getNumberAgency() == transfer.getDestinationAccount().getNumberAgency()
				&& verifyBalanceAccount(transfer)) {

			Extratc extractAccount = Extratc.builder(transfer.getSourceAccount(),transfer.getDestinationAccount(), TypeOperation.TRANSFER,
					TypeOperation.TRANSFER.operationSignal + transfer.getValue().toString());
			
			WithdrawDTO withdraw = new WithdrawDTO();
			withdraw.setAccount(transfer.getSourceAccount());
			withdraw.setValue(transfer.getValue());
			withdraw(withdraw);

			DepositDTO deposit = new DepositDTO();
			deposit.setAccount(transfer.getDestinationAccount());
			deposit.setValue(transfer.getValue());
			deposit(deposit);

			serviceExtratc.create(extractAccount);
			
		} else if (transfer.getSourceAccount().getNumberAgency() != transfer.getDestinationAccount().getNumberAgency()
				&& verifyBalanceAccount(transfer)
				&& transfer.getSourceAccount().getTypeAccount() == TypeAccountEnus.CurrentAccount
				&& transfer.getDestinationAccount().getTypeAccount() == TypeAccountEnus.CurrentAccount) {

			Double originalValue = transfer.getValue();

			transfer.setValue(transfer.getValue() * RateEnuns.CURRENT_ACCOUNT_RATE.rate);
			
			Extratc extractAccount = Extratc.builder(transfer.getSourceAccount(),transfer.getDestinationAccount(), TypeOperation.TRANSFER,
					TypeOperation.TRANSFER.operationSignal + transfer.getValue().toString());

			WithdrawDTO withdraw = new WithdrawDTO();
			withdraw.setAccount(transfer.getSourceAccount());
			withdraw.setValue(transfer.getValue());
			withdraw(withdraw);

			DepositDTO deposit = new DepositDTO();
			deposit.setAccount(transfer.getDestinationAccount());
			deposit.setValue(originalValue);
			deposit(deposit);

			serviceExtratc.create(extractAccount);
			
		}

		return transfer;
	}

	private boolean verifyBalanceAccount(TransferDTO transfer) {

		if (transfer.getSourceAccount().getBalance() >= transfer.getValue()) {
			return true;
		} else {
			return false;
		}

	}

}
