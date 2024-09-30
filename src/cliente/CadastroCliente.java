package cliente;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import entidades.*;
import menu.MenuAgencia;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import agencia.TelaAgencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import configuracaoBanco.Configuracaodobanco;

public class CadastroCliente {
	int opcao=0;
	int novaOpcao=0;

	public CadastroCliente() {
		while (true) {
			try {

				String agencia = "";
				String nomeCliente = "";
				String tipoContaCC = "Conta Corrente";
				String confirmarSim = "s";
				String confirmarNao = "n";
				int contadorIncre = lerIncremento();
				contadorIncre++;
				incrementar(contadorIncre);
				EntidadeConta entidadeConta = new EntidadeConta();
				LocalDateTime dateTime = LocalDateTime.now();
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
				String dataHora = dateTime.format(dateTimeFormatter);

				// Campos para registros
				Configuracaodobanco configuracaodobanco = new Configuracaodobanco();
				// Cadastro de conta
				entidadeConta.setNumero(lerIncremento());
				// Cadastro de Agência
				agencia = configuracaodobanco.getNumeroAgencia();
				entidadeConta.setAgencia(agencia);
				Scanner cliente = new Scanner(System.in);

				// Cadastro de cliente
				System.out.println("Digite nome do Cliente:  ");

				nomeCliente += cliente.nextLine();
				entidadeConta.setNomeCliente(nomeCliente);

				System.out.println("\nObrigado por criar uma conta em nosso banco!\n " + "\nCadastro:      " + dataHora
						+ "\nCliente:       " + entidadeConta.getNomeCliente() + " \nAgência:       "
						+ entidadeConta.getAgencia() + " \nConta:         " + entidadeConta.getNumero()
						+ " \nTipo de conta: " + "\n" + tipoContaCC + " \nSaldo:         "
						+ entidadeConta.getSaldoContaCorrente() + " \nConta poupança"

						+ " \nSaldo:         " + entidadeConta.getSaldoContaPoupanca() + "\n");
				System.out.println("\nDigite S para confirmar e N para cancelar. ");
				Scanner confirma = new Scanner(System.in);
				String letra = confirma.nextLine();
				// Gravar arquivos
				if (confirmarSim.equals(letra)) {
					try {
						FileWriter myWriter = new FileWriter("arquivoDB" + "/" + contadorIncre + ".txt", true);
						myWriter.write("\nCadastro:      " + dataHora + " \nCliente:       "
								+ entidadeConta.getNomeCliente() + " \nAgência:       " + entidadeConta.getAgencia()
								+ " \nConta:         " + entidadeConta.getNumero() + "\n");
						myWriter.close();
						FileWriter relatorioGR = new FileWriter("relatorioGR/relatorioGR.txt", true);
						relatorioGR.write("\nConta:         " + entidadeConta.getNumero() + " \nCliente:       "
								+ entidadeConta.getNomeCliente() + "" + "\t\r\n");
						relatorioGR.close();
						FileWriter contaCorrente = new FileWriter("contaCorrenteDB" + "/" + contadorIncre + ".txt");
						contaCorrente.write(
								"\nConta corrente " + " \nSaldo:         " + entidadeConta.getSaldoContaCorrente());
						contaCorrente.close();
						FileWriter contaPoupanca = new FileWriter("contaPoupancaDB" + "/" + contadorIncre + ".txt");
						contaPoupanca
								.write("Conta poupança" + " \nSaldo:         " + entidadeConta.getSaldoContaPoupanca());
						contaPoupanca.close();

						System.out.println("Dados salvos, bem vindo ao nosso banco !");

					} catch (IOException e) {
						System.out.println("Um erro ocorreu.");
						e.printStackTrace();
					}
				} else if (confirmarNao.equals(letra)) {
					contadorIncre--;
					incrementar(contadorIncre);
				}

			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("Verificar os campos de números ");

			}
			System.out.println(
					"\nDigite:\n1: Cadatro de conta. \n2: Consulta de Saldo.\n3: Saque \n4: Depósito. \n5: Volta ao menu principal.");

			Scanner menu2 = new Scanner(System.in);
			opcao = menu2.nextInt();
			
			if (opcao == 1) {
				CadastroCliente cadastroCliente = new CadastroCliente();
				cadastroCliente.getClass();
			}
			if (opcao == 2) {
				ConsultaContaCli cli = new ConsultaContaCli();
				cli.getClass();
			}
			if (opcao == 3) {
				TelaMenuSaque menuSaque = new TelaMenuSaque();
				menuSaque.getClass();
			}
			if (opcao == 4) {
				TelaMenuDeposito deposito = new TelaMenuDeposito();
				deposito.getClass();
			}
			if (opcao == 5) {
				MenuAgencia agencia = new MenuAgencia();
				agencia.getClass();
			}

			if ((opcao != 1) || (opcao != 2) || (opcao != 3) || (opcao != 4) || (opcao != 5)) {
				TelaAgencia agencia=new TelaAgencia();
				agencia.getClass();
			}	

		}
	}

	// Método para contador
	private static int lerIncremento() {
		int contador = 0;
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader("contadorDB/contador.txt"));
			String ler = bufferedReader.readLine();
			if (ler != null) {
				contador = Integer.parseInt(ler);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return contador;
	}

	// Método para gravar no arquivo do contador
	private static int incrementar(int contador) {
		try {
			BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("contadorDB/contador.txt"));
			bufferedWriter.write(String.valueOf(contador));
			bufferedWriter.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return contador;

	}

}
