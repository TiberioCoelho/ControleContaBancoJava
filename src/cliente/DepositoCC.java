package cliente;

import java.io.File;
import cliente.TelaCliente;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import entidades.*;
import menu.MenuAgencia;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;

public class DepositoCC {
	String atual = null;
	String novoValor = null;
	String ler = null;
	String novoSaldo = null;
	double saldoAtualSaque = 0.0;
	double saldoAtualDeposito = 0.0;
	double valorSaque = 0.0;
	double valorDeposito = 0.0;
	double saldo = 0.0;
	String confirmarSim = "s";
	String confirmarNao = "n";
	String contaProcurada = null;
	String tipoContaProcurada = null;
	String tipoConta = "Conta Corrente";
	String dataHora;
	Scanner contaNumero;
	File conta;

	public DepositoCC() {
        DecimalFormat decimalFormat=new DecimalFormat("#.00");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o n�mero da conta");
		String matricula = scanner.nextLine();		
		tipoContaProcurada = "contaCorrenteDB/" + matricula + ".txt";		
		try {
			conta = new File(tipoContaProcurada);
			contaNumero = new Scanner(conta);
			if (conta.exists()) {		
				while (contaNumero.hasNextLine()) {
					ler = contaNumero.nextLine();
					System.out.println(ler);
				}
				contaNumero.close();
			} else {
				System.out.println("Conta n�o exitir! ");
			}
			 contaNumero.close();
		} catch (Exception e) {
			System.out.println("Conta n�o exitir! ");
			TelaCliente cliente = new TelaCliente();
			cliente.getClass();
		}



		EntidadeConta entidadeConta = new EntidadeConta();
		Scanner saque = new Scanner(System.in);
		System.out.print("\nDigite o valor do dep�sito ou N para sair = ");
			
		
		String seContinua = saque.nextLine().replace(",", ".");
		
		if (!confirmarNao.equals(seContinua)) {
			novoValor = seContinua;
			Pattern pattern = Pattern.compile("\\d.+", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(ler);
			String completa = ler;
			if (matcher.find()) {
				atual = matcher.group();
				saldoAtualDeposito = Double.parseDouble(atual);
				valorDeposito = Double.parseDouble(novoValor);
				saldo = saldoAtualDeposito + valorDeposito;
				novoSaldo = String.valueOf(decimalFormat.format(saldo).replace(",", "."));

			} else {
				TelaCliente cliente = new TelaCliente();
				cliente.getClass();
			}

			System.out.println("Valor atual:        " + atual);
			System.out.println("Valor do dep�sito:  " + valorDeposito);
			System.out.print("Novo " + completa.replace(atual, novoSaldo));

			// Confirma a altera��o
			Scanner confirma = new Scanner(System.in);
			System.out.println("\n\nDigite S para confirmar e N para cancelar. ");
			String letra = confirma.nextLine();
			String endereco = tipoContaProcurada;
			if (confirmarSim.equals(letra)) {
				try {
					String conteudo = new String(Files.readAllBytes(Paths.get(tipoContaProcurada)));
					String conteudoAlterado = conteudo.replace(atual, novoSaldo);
					Files.write(Paths.get(tipoContaProcurada), conteudoAlterado.getBytes());
					System.out.println(conteudoAlterado);

				} catch (Exception e) {

				}
			} else {
				TelaCliente cliente = new TelaCliente();
				cliente.getClass();
			}

			System.out.println("\nDigite:\n1: Saque de conta corrente. \n2: Saque de poupan�a. \n3: Dep�sito de conta corrente."
					+ "\n4: Dep�sito de poupan�a. \n5: Volta ao menu anterior.");
			Scanner menu3 = new Scanner(System.in);
			int opcao = menu3.nextInt();
			if (opcao == 1) {
				SaqueCC cc = new SaqueCC();
				cc.getClass();
			}
			if (opcao == 2) {
				SaqueCP cp = new SaqueCP();
				cp.getClass();
			}
			if (opcao == 3) {
				DepositoCC depositoCC = new DepositoCC();
				depositoCC.getClass();
			}
			if (opcao == 4) {
				DepositoCP depositoCP = new DepositoCP();
				depositoCP.getClass();
			}
			if (opcao == 5) {
				TelaCliente cliente = new TelaCliente();
				cliente.getClass();
			}
			if ((opcao != 1) || (opcao != 2) || (opcao != 3) || (opcao != 4) || (opcao != 5)) {
				TelaMenuDeposito deposito=new TelaMenuDeposito();
				deposito.getClass();
			}

		} else {
			TelaCliente cliente = new TelaCliente();
			cliente.getClass();
		}

	}

}
