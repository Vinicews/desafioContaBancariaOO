package com.viniciusmartins.service;

public class ContaCorrente extends Conta {

	@Override
	public void imprimirExtarto() {
		System.out.println("Extarto Conta Corrente: ");
		super.imprimirInfosComuns();
	}


}
