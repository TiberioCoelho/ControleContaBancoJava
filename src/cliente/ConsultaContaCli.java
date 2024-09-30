package cliente;

import java.io.File;
import cliente.TelaCliente;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import transferencia.*;
import entidades.*;
import menu.MenuAgencia;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class ConsultaContaCli {
	String atual = null;
	String novoValor = null;
	String ler = null;
	String lerCC = null;
	String lerCP = null;
	String novoSaldo = null;
	double saldoAtualSaque = 0.0;
	double saldoAtualDeposito = 0.0;
	double valorSaque = 0.0;
	double valorDeposito = 0.0;
	double saldo = 0.0;
	String confirmarSim = "s";
	String confirmarNao = "n";
	String contaProcurada = null;
	String contaProcuradaCC = null;
	String contaProcuradaCP = null;
	String tipoConta = "Conta Corrente";
	String dataHora;
	Scanner contaNumero;
	Scanner contaNumeroCC;
	Scanner contaNumeroCP;
	File conta,contaCC,contaCP;

	public ConsultaContaCli() {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o número da conta");
		String matricula = scanner.nextLine();
		contaProcurada = "arquivoDB/" + matricula + ".txt";
		contaProcuradaCC = "contaCorrenteDB/" + matricula + ".txt";
		contaProcuradaCP = "contaPoupancaDB/" + matricula + ".txt";
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		dataHora = dateTime.format(dateTimeFormatter);
		try {
			conta = new File(contaProcurada);
			contaCC = new File(contaProcuradaCC);
			contaCP = new File(contaProcuradaCP);
			contaNumero = new Scanner(conta);
			contaNumeroCC = new Scanner(contaCC);
			contaNumeroCP = new Scanner(contaCP);
			
			if (conta.exists()) {
				// System.out.println(conta.getName());
				while (contaNumero.hasNextLine()) {
					ler = contaNumero.nextLine();
					System.out.println(ler);
				}
				contaNumero.close();
			} else {
				System.out.println("Conta não exitir! ");
			}
			if (contaCC.exists()) {
				// System.out.println(conta.getName());
				while (contaNumeroCC.hasNextLine()) {
					lerCC = contaNumeroCC.nextLine();
					System.out.println(lerCC);
				}
				contaNumeroCC.close();
			} else {
				System.out.println("Conta não exitir! ");
			}
			if (contaCP.exists()) {
				// System.out.println(conta.getName());
				while (contaNumeroCP.hasNextLine()) {
					lerCP = contaNumeroCP.nextLine();
					System.out.println(lerCP);
				}
				contaNumeroCP.close();
			} else {
				System.out.println("Conta não exitir! ");
			}
			// contaNumero.close();
		} catch (Exception e) {
			System.out.println("Conta não exitir! ");
			TelaCliente cliente = new TelaCliente();
			cliente.getClass();
		}

		// encontrarConta();

		System.out.println("\nDigite:\n1: Saque.\n2: Depósito. \n3: Transferência. \n4: Volta ao menu anterior.");
		Scanner menu3 = new Scanner(System.in);
		int opcao = menu3.nextInt();
		if (opcao == 1) {
			TelaMenuSaque menuSaque=new TelaMenuSaque();
			menuSaque.getClass();
		}
		if (opcao == 2) {
			TelaMenuDeposito menuDeposito=new TelaMenuDeposito();
			menuDeposito.getClass();
		}
		if (opcao == 3) {
			TelaTransferencia telaTransferencia=new TelaTransferencia();
			telaTransferencia.getClass();
		}
		if (opcao == 4) {
			TelaCliente cliente = new TelaCliente();
			cliente.getClass();
		}
		if ((opcao != 1) || (opcao != 2) || (opcao != 3) || (opcao != 4)) {
			TelaCliente telaCliente=new TelaCliente();
			telaCliente.getClass();
		}
	}

	

	

}
