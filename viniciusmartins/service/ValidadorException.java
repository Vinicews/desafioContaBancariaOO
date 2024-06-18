package com.viniciusmartins.service;

public class ValidadorException extends Exception{
	
	@Override
	public String getMessage() {
		return "Você não digitou uma opção válida.";
	}
	

	private static final long serialVersionUID = 1L;

}
