package br.com.pvbank.extratc.domain.dto;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.pvbank.extratc.domain.Extratc;

@Component
public class ExtratcConverterDTO {

	public static ModelMapper modelMapper() {
		return new ModelMapper();
	}
	
	public static List<ExtratcDTO> conveterListExtratc(List<Extratc> extratc){
		return extratc
				.stream()
				.map(c -> modelMapper().map(c, ExtratcDTO.class))
				.collect(Collectors.toList());
	}
	
}
