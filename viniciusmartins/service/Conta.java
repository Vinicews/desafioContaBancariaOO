package com.viniciusmartins.service;

import com.viniciusmartins.interfaces.IConta;

public abstract class Conta implements IConta {

	private static int AGENCIAL_PADRAO = 1;
	private static int SEQUENCIAL = 1;
	protected int agencia;
	protected int numeroConta;
	protected double saldo = 0;


	public Conta() {
		this.agencia = AGENCIAL_PADRAO;
		this.numeroConta = SEQUENCIAL++;

	}

	public Conta selecionarConta(int tipoConta) throws ValidadorException {
		if (tipoConta == 1) {
			return new ContaCorrente();

		} else if (tipoConta == 2) {
			return new ContaPoupanca();
		} else
			throw new ValidadorException();

	}

	public double sacar(double valor) {
		if (valor > saldo) {
			System.out.println("Saldo insuficiente.");
		} else
			this.saldo -= valor;

		return this.saldo;
	}

	public double depositar(double valor) {
		this.saldo += valor;
		return this.saldo;
	}

	public void transferir(double valor, Conta contaDestino) {
		if (valor > saldo) {
			System.out.println("Saldo insuficiente.");
		} else {
			this.sacar(valor);
			contaDestino.depositar(valor);
		}
	}

	protected void imprimirInfosComuns() {
		System.out.println(String.format("Agência: %d", this.agencia));
		System.out.println(String.format("Número: %d", this.numeroConta));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}

	@Override
	public void imprimirExtarto() {
		getSaldo();

	}

	public int getAgencia() {
		return agencia;
	}

	public int getNumeroConta() {
		return numeroConta;
	}

	public double getSaldo() {
		return saldo;

	}


}
