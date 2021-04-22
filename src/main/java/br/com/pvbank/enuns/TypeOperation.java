package br.com.pvbank.enuns;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum TypeOperation {

	DEPOSIT("+"),
	WITHDRAW("-"),
	TRANSFER("");
	
	public final String operationSignal;
}
