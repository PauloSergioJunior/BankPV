package br.com.cbgomes.acme.account.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.cbgomes.acme.account.domain.Account;
import br.com.cbgomes.acme.account.domain.AccountSavings;
import br.com.cbgomes.acme.account.domain.CurrentAccount;
import br.com.cbgomes.acme.account.repository.AccountRepository;
import br.com.cbgomes.acme.client.domain.Client;
import br.com.cbgomes.acme.client.service.ClientService;
import br.com.cbgomes.acme.enuns.TypeAccount;
import br.com.cbgomes.acme.transaction.domain.Deposit;
import br.com.cbgomes.acme.transaction.domain.Transfer;
import br.com.cbgomes.acme.transaction.domain.Withdraw;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {
	
	private final AccountRepository repository;
	private final ClientService clientService;
	
	@Override
	public List<Account> getAll() {
		return this.repository.findAll();
	}

	@Override
	public Optional<Account> getByNumberAccount(Long numberAccount) {
		return this.repository.findByNumberAccount(numberAccount);
	}
	
	@Override
	public List<Account> getByTypeAccount(Long numberAccount) {
		return this.repository.findByTypeAccount(numberAccount);
	}
	
	@Override
	public void removeByNumberAccount(Long numberAccount) throws Exception {
		Account account = this.repository.findByNumberAccount(numberAccount).get();
		if(account != null) {
			 this.repository.delete(account);
		}
		
		throw new Exception("Account not found");
	}
	
	@Override
	public Account create(Account account) {
		return this.repository.save(account);
	}
	
	@Override
    public void saveAccount(Account accountRequest) {

        Long idClient = accountRequest.getClient().getId();
        Client client = null;
        Account account = null; 

        if(accountRequest.getTypeAccount().compareTo(TypeAccount.CurrentAccount) > 0){

            client = clientService.getById(idClient).get();

            accountRequest.setClient(client);
            account = CurrentAccount.builder(accountRequest);
        }
        else if(accountRequest.getTypeAccount().compareTo(TypeAccount.AccountSaving) > 0) {

            client = clientService.getById(idClient).get();

            accountRequest.setClient(client);
            account = AccountSavings.builder(accountRequest);
        }
        else {
            throw new RuntimeException("Mensagem");
        }

        repository.save(account);
        
    }

	@Override
	public Deposit deposit(Double value, Account sourceAccount) {

		if (sourceAccount.getBalance() < 0) {

			sourceAccount.setBalance(value - sourceAccount.getBalance() * 1.005);

			Deposit deposit = new Deposit();
			deposit.setAmountReceived(value);
			deposit.setAmountCurrent(sourceAccount.getBalance());
			return deposit;
		}

		sourceAccount.setBalance(sourceAccount.getBalance() + value);
		Deposit deposit = new Deposit();
		deposit.setAmountReceived(value);
		deposit.setAmountCurrent(sourceAccount.getBalance());

		return deposit;

	}

	@Override
	public Withdraw withdraw(Double value, Account sourceAccount) {
		
		Withdraw withdraw = new Withdraw();
		
		if(sourceAccount.getBalance() > -999) {
			
		sourceAccount.setBalance(sourceAccount.getBalance() - value);
		
		withdraw.setAmountDrawer(value);
		withdraw.setAmountRemaining(sourceAccount.getBalance());
		
		return withdraw;
		
		}else {
			
			return new Withdraw();
		}
		
	}

	@Override
	public Transfer transfer(Double value, Account sourceAccount, Account destinationAccount) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}