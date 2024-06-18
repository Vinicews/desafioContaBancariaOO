package com.viniciusmartins.service;

public class ContaPoupanca extends Conta{

	@Override
	public void imprimirExtarto() {
		System.out.println("Extrato Conta Poupança");
		super.imprimirInfosComuns();
	}
	
	 
}
