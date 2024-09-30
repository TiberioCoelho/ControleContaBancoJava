package transferencia;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import cliente.DepositoCC;
import cliente.DepositoCP;
import cliente.SaqueCC;
import cliente.SaqueCP;
import cliente.TelaCliente;
import entidades.EntidadeConta;


public class TransferenciaCP {
	String atual = null;
	String atualCP = null;
	String novoValorCP = null;

	String novoValor = null;
	String ler = null;
	String lerCC = null;
	String lerCP = null;
	String novoSaldo = null;
	String novoSaldoCP = null;
	double saldoAtual = 0.0;
	double saldoAtualCP = 0.0;
	double valorTransferido = 0.0;
	double valorTransferidoCP = 0.0;
	double valorSaque = 0.0;
	double valorDeposito = 0.0;
	double saldo = 0.0;
	double saldoCP = 0.0;
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
	File conta, contaCC, contaCP;
	

	public TransferenciaCP() {
		// TODO Auto-generated constructor stub
		DecimalFormat decimalFormat=new DecimalFormat("#.00");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Digite o número da conta");
		String matricula = scanner.nextLine();
		contaProcurada = "arquivoDB/" + matricula + ".txt";
		contaProcuradaCC = "contaCorrenteDB/" + matricula + ".txt";
		contaProcuradaCP = "contaPoupancaDB/" + matricula + ".txt";
		// scanner.close();
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

		EntidadeConta entidadeConta = new EntidadeConta();
		Scanner saque = new Scanner(System.in);
		System.out.print("\nDigite o valor para tranferência ou N para sair = ");
		String seContinua = saque.nextLine().replace(",", ".");

		if (!confirmarNao.equals(seContinua)) {
			novoValor = seContinua;
			novoValorCP = novoValor;

			Pattern pattern = Pattern.compile("\\d.+", Pattern.CASE_INSENSITIVE);
			Matcher matcher = pattern.matcher(lerCC);
			Pattern patternCP = Pattern.compile("\\d.+", Pattern.CASE_INSENSITIVE);
			Matcher matcherCP = patternCP.matcher(lerCP);
			String completaCP = lerCP;
			String completa = lerCC;

			if (matcher.find()) {
				double condLerCC = Double.parseDouble(matcher.group());
				double condNovoValor = Double.parseDouble(novoValor);
				if (condLerCC > condNovoValor) {
					atual = matcher.group();
					saldoAtual = Double.parseDouble(atual);
					valorTransferido = Double.parseDouble(novoValor);
					saldo = saldoAtual - valorTransferido;
					novoSaldo = String.valueOf(decimalFormat.format(saldo).replace(",", "."));
				} else {
					System.out.println("valor para a transferência maior que o saldo. ");
					novoValor = null;
					TransferenciaCP cp = new TransferenciaCP();
					cp.getClass();
				}

			} else {
				TelaCliente cliente = new TelaCliente();
				cliente.getClass();
			}
			if (matcherCP.find()) {
				atualCP = matcherCP.group();
				saldoAtualCP = Double.parseDouble(atualCP);
				valorTransferidoCP = Double.parseDouble(novoValorCP);
				saldoCP = saldoAtualCP + valorTransferidoCP;
				novoSaldoCP = String.valueOf(saldoCP);
			} else {
				TelaCliente cliente = new TelaCliente();
				cliente.getClass();
			}

			System.out.println("Conta Corrente:");
			System.out.println("Valor atual:        " + atual);
			System.out.println("Valor transferido:  " + valorTransferido);
			System.out.print("Novo " + completa.replace(atual, novoSaldo));
			System.out.println("\nPoupança:");
			System.out.println("Valor atual:        " + atualCP);
			System.out.println("Valor transferido:  " + valorTransferidoCP);
			System.out.print("Novo " + completaCP.replace(atualCP, novoSaldoCP));

			// Confirma a alteração
			Scanner confirma = new Scanner(System.in);
			System.out.println("\n\nDigite S para confirmar e N para cancelar. ");
			String letra = confirma.nextLine();
			// String endereco = contaProcurada;
			if (confirmarSim.equals(letra)) {
				try {
					String conteudo = new String(Files.readAllBytes(Paths.get(contaProcuradaCC)));
					String conteudoAlterado = conteudo.replace(atual, novoSaldo);
					Files.write(Paths.get(contaProcuradaCC), conteudoAlterado.getBytes());
					System.out.println(conteudoAlterado);
					// Gravar dados no arquivo conta poupança
					String conteudoCP = new String(Files.readAllBytes(Paths.get(contaProcuradaCP)));
					String conteudoAlteradoCP = conteudoCP.replace(atualCP, novoSaldoCP);
					Files.write(Paths.get(contaProcuradaCP), conteudoAlteradoCP.getBytes());
					System.out.println(conteudoAlteradoCP);
				} catch (Exception e) {

				}
			} else {
				TelaCliente cliente = new TelaCliente();
				cliente.getClass();
			}

			System.out.println(
					"\nDigite:\n1: Saque de conta corrente. \n2: Saque de poupança. \n3: Depósito de conta corrente."
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
			if ((opcao != 1) || (opcao != 2) || (opcao != 3)|| (opcao != 4)|| (opcao != 5)) {
				System.out.println("Opção inválida.");
				TelaTransferencia telaTransferencia=new TelaTransferencia();
				telaTransferencia.getClass();
			}

		} else {
			TelaCliente cliente = new TelaCliente();
			cliente.getClass();
		}

	}

}
