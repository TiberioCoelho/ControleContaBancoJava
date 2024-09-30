package cliente;

import java.util.Scanner;

import menu.MenuAgencia;

public class TelaMenuDeposito {
	public TelaMenuDeposito() {
		// TODO Auto-generated constructor stub
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Digite: \n1: Depósito na conta corrente. \n2: Depósito na conta poupança. \n3: Volta ao menu anterior.");
		int opcao = scanner.nextInt();
		if (opcao == 1) {
			DepositoCC cc = new DepositoCC();
			cc.getClass();
		}
		if (opcao == 2) {
			DepositoCP cp = new DepositoCP();
			cp.getClass();
		}
		if (opcao == 3) {
			TelaCliente cliente = new TelaCliente();
			cliente.getClass();

		}
		if ((opcao != 1) || (opcao != 2) || (opcao != 3)) {
			MenuAgencia agencia=new MenuAgencia();
			agencia.getClass();
		}
	}

}
