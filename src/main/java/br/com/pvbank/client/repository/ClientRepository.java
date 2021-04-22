/**
 * 
 */
package br.com.pvbank.client.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pvbank.client.domain.Client;


@Repository
public interface ClientRepository extends JpaRepository<Client, Long> {

	Optional<Client> findByEmail(String email);
}
