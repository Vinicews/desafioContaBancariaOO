package com.viniciusmartins.main;

import java.util.Scanner;

import com.viniciusmartins.model.Cliente;
import com.viniciusmartins.service.Conta;
import com.viniciusmartins.service.ValidadorException;

public class Main {

	public static void main(String[] args) throws ValidadorException {

		try {
			Conta conta;
			Conta contaDestino = new Conta();
			Cliente clientes = new Cliente();
			Scanner entrada = new Scanner(System.in);

			System.out.print("Digite o seu nome: ");
			clientes.setNome(entrada.next());

			System.out.print("Digite o seu sobrenome: ");
			clientes.setSobrenome(entrada.next());

			System.out.println("Selecione o tipo de conta: " + "\n1 - Corrente " + "\n2 - Poupança");
			conta = new Conta().selecionarConta(entrada.nextInt());

			System.out.println("Olá, " + clientes.getNome() + " " + clientes.getSobrenome()
					+ ", parabéns por abrir sua conta no nosso banco. O número de sua conta é " + conta.getNumeroConta()
					+ "" + " o seu slado é " + conta.getSaldo());
			int opcao = 0;
			while (opcao != 6) {

				System.out.println("\n\nDeseja realizar alguma operação? Selecione uma opção." + "\n1 - Depositar"
						+ "\n2 - Sacar" + "\n3 - Transferir" + "\n4 - Consultar extrato Corrente "
						+ "\n5 - Consultar extrato Poupança" + "\n6 - Sair");
				opcao++;
				opcao = entrada.nextInt();

				switch (opcao) {
				case 1:
					System.out.print("Digite o valor que deseja depositar. ");
					conta.depositar(entrada.nextDouble());
					break;

				case 2:
					System.out.print("Digite o valor que deseja sacar. ");
					conta.sacar(entrada.nextDouble());
					break;
				case 3:
					System.out.print("Digite o valor que deseja transferir. ");
					conta.transferir(entrada.nextDouble(), contaDestino);
					break;
				case 4:
					conta.imprimirExtarto();
					break;
				case 5:
					conta.imprimirExtarto();
					break;
				case 6:
					System.out.println("Você saiu.");
					
				}
			}
			
			entrada.close();
		} catch (ValidadorException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
				


