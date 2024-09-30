package cliente;

import java.io.File;
import cliente.TelaCliente;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import entidades.*;
import menu.MenuAgencia;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;


public class SaqueCC {
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
	String tipoConta = "Conta Corrente";
	String dataHora;
	Scanner contaNumero;
	File conta;
	

	public SaqueCC() {
		DecimalFormat decimalFormat=new DecimalFormat("#.00");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o número da conta");
		String matricula = scanner.nextLine();
		contaProcurada = "contaCorrenteDB/" + matricula + ".txt";
		LocalDateTime dateTime = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
		dataHora = dateTime.format(dateTimeFormatter);
		try {
			conta = new File(contaProcurada);
			contaNumero = new Scanner(conta);
			if (conta.exists()) {				
				while (contaNumero.hasNextLine()) {
					ler = contaNumero.nextLine();
					System.out.println(ler);
				}
				contaNumero.close();
			} else {
				System.out.println("Conta não exitir! ");
			}
			contaNumero.close();
		} catch (Exception e) {
			System.out.println("Conta não exitir! ");
			TelaCliente cliente = new TelaCliente();
			cliente.getClass();
		}

		// encontrarConta();
		EntidadeConta entidadeConta = new EntidadeConta();
		Scanner saque = new Scanner(System.in);
		System.out.print("\nDigite o valor do saque ou N para sair = ");
		String seContinua = saque.nextLine().replace(",", ".");
		if (!confirmarNao.equals(seContinua)) {
			novoValor = seContinua;
			Pattern pattern = Pattern.compile("\\d.+", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(ler);
			String completa = ler;
			if (matcher.find()) {
				double condLerCC = Double.parseDouble(matcher.group());
				double condNovoValor = Double.parseDouble(novoValor);
				if (condLerCC > condNovoValor) {
				atual = String.valueOf(matcher.group());
				saldoAtualSaque = Double.parseDouble(atual);
				valorSaque = Double.parseDouble(novoValor);
				saldo = saldoAtualSaque - valorSaque;
				novoSaldo = String.valueOf(decimalFormat.format(saldo).replace(",", "."));
				
				}else {
					System.out.println("Valor do saque maior que o saldo. ");
					TelaCliente cliente=new TelaCliente();
					cliente.getClass();
					
				}
			}
			System.out.println("Valor atual:        " + atual);
			System.out.println("Valor do saque:     " + valorSaque);
			System.out.print("Novo " + completa.replace(atual, novoSaldo));

			// Confirma a alteração
			Scanner confirma = new Scanner(System.in);
			System.out.println("\n\nDigite S para confirmar e N para cancelar. ");
			String letra = confirma.nextLine();
			String endereco = contaProcurada;
			if (confirmarSim.equals(letra)) {
				try {
					String conteudo = new String(Files.readAllBytes(Paths.get(contaProcurada)));
					String conteudoAlterado = conteudo.replace(atual, novoSaldo);
					Files.write(Paths.get(contaProcurada), conteudoAlterado.getBytes());
					System.out.println(conteudoAlterado);
				} catch (Exception e) {
				}
			} else {
				TelaCliente cliente = new TelaCliente();
				cliente.getClass();
			}
			System.out.println("\nDigite:\n1: Saque de conta corrente. \n2: Saque de poupança. \n3: Depósito de conta corrente."
					+ "\n4: Depósito de poupança. \n5: Volta ao menu anterior.");
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
				TelaMenuSaque menuSaque=new TelaMenuSaque();
				menuSaque.getClass();
			}

		} else {
			TelaCliente cliente = new TelaCliente();
			cliente.getClass();
		}

	}

}
