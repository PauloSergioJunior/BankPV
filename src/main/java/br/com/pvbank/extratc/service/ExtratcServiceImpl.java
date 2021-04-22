package br.com.pvbank.extratc.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.pvbank.extratc.domain.Extratc;
import br.com.pvbank.extratc.repository.ExtratcRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ExtratcServiceImpl implements ExtratcService{

	private final ExtratcRepository repository;
	
	
	@Override
	public List<Extratc> getAll() {

		return this.repository.findAll();
	}


	@Override
	public Extratc create(Extratc extratc) {
		
		return this.repository.save(extratc);
	}
	

}
