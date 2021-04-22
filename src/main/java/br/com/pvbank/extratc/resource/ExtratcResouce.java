package br.com.pvbank.extratc.resource;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.pvbank.extratc.domain.dto.ExtratcConverterDTO;
import br.com.pvbank.extratc.domain.dto.ExtratcDTO;
import br.com.pvbank.extratc.service.ExtratcService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/extratc")
public class ExtratcResouce {

	private final ExtratcService extratcService;
	
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ResponseEntity<List<ExtratcDTO>> getAll() {
		return ResponseEntity.ok(ExtratcConverterDTO.conveterListExtratc(this.extratcService.getAll()));
	}
}
