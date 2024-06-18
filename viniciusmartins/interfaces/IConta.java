package com.viniciusmartins.interfaces;

import com.viniciusmartins.service.Conta;

public interface IConta {

	double sacar(double valor);

	double depositar(double valor);

	void transferir(double valor, Conta contaDestino);

	void imprimirExtarto();

}
