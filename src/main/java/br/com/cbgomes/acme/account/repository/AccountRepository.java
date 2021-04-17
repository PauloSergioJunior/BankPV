package br.com.cbgomes.acme.account.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cbgomes.acme.account.domain.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long>{

	Optional<Account> findByNumberAccount(Long numberAccount);
	List<Account> findByTypeAccount(Long typeAccount);
}
