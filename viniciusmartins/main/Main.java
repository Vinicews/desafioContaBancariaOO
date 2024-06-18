package com.viniciusmartins.main;

import java.util.Scanner;

import com.viniciusmartins.model.Banco;
import com.viniciusmartins.model.Cliente;
import com.viniciusmartins.service.Conta;
import com.viniciusmartins.service.ContaCorrente;
import com.viniciusmartins.service.ContaPoupanca;
import com.viniciusmartins.service.ValidadorException;

public class Main {

	public static void main(String[] args) throws ValidadorException {

		Conta cc = new ContaCorrente();
		Conta pp = new ContaPoupanca();
		Cliente clientes = new Cliente();
		Banco banco = new Banco();

		try {
			Scanner entrada = new Scanner(System.in);

			System.out.print("Digite o seu nome: ");
			clientes.setNome(entrada.next());

			System.out.print("Digite o seu sobrenome: ");
			clientes.setSobrenome(entrada.next());
			
			System.out.print("Digite o nome do banco: ");
			banco.setNome(entrada.next());
			
			

			System.out.println("Selecione o tipo de conta: " + "\n1 - Corrente " + "\n2 - Poupança");

			int opcaoConta = 0;
			if (opcaoConta == 1) {
				cc.selecionarConta(entrada.nextInt());
			} else if (opcaoConta == 2) {
				pp.selecionarConta(entrada.nextInt());
			}
			opcaoConta = entrada.nextInt();

			System.out.println("Olá, " + clientes.getNome() + " " + clientes.getSobrenome()
					+ ", parabéns por abrir sua conta no banco " + banco.getNome() + ".");
			int opcaoMenu = 0;
			while (opcaoMenu != 6) {

				System.out.println("\n\nDeseja realizar alguma operação? Selecione uma opção." + "\n1 - Depositar"
						+ "\n2 - Sacar" + "\n3 - Transferir" + "\n4 - Consultar extrato Corrente "
						+ "\n5 - Consultar extrato Poupança" + "\n6 - Sair");
				opcaoMenu++;
				opcaoMenu = entrada.nextInt();

				switch (opcaoMenu) {
				case 1:
					System.out.print("Digite o valor que deseja depositar. ");
					if (opcaoMenu == 1 && opcaoConta == 1) {
						cc.depositar(entrada.nextDouble());
					} else if (opcaoMenu == 1 && opcaoConta == 2) {
						pp.depositar(entrada.nextDouble());
					}
					break;

				case 2:
					System.out.print("Digite o valor que deseja sacar. ");
					if (opcaoMenu == 2 && opcaoConta == 1) {
						cc.sacar(entrada.nextDouble());
					} else if (opcaoMenu == 2 && opcaoConta == 2) {
						pp.sacar(entrada.nextDouble());
					}
					break;
				case 3:
					System.out.print("Digite o valor que deseja transferir. ");
					if (opcaoMenu == 3 && opcaoConta == 1) {
						cc.transferir(entrada.nextDouble(), pp);
					} else if (opcaoMenu == 3 && opcaoConta == 2) {
						pp.transferir(entrada.nextDouble(), cc);
					}
					break;
				case 4:
					cc.imprimirExtarto();
					break;
				case 5:
					pp.imprimirExtarto();
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

