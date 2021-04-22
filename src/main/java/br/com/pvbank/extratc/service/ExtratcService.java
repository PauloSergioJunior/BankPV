package br.com.pvbank.extratc.service;

import java.util.List;

import br.com.pvbank.extratc.domain.Extratc;

public interface ExtratcService {

	List<Extratc> getAll();
	
	Extratc create(Extratc extratc);
	
}
