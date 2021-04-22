package br.com.pvbank.extratc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pvbank.extratc.domain.Extratc;


@Repository
public interface ExtratcRepository extends JpaRepository<Extratc, Long>{

}
