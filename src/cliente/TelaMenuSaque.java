package cliente;

import java.util.Scanner;

import menu.MenuAgencia;

public class TelaMenuSaque {
	public TelaMenuSaque() {
		// TODO Auto-generated constructor stub
		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"Digite: \n1: Saque de conta corrente. \n2: Saque de conta poupança. \n3: Voltar ao menu principal.");
		int opcao = scanner.nextInt();
		if (opcao == 1) {
			SaqueCC cc = new SaqueCC();
			cc.getClass();
		}
		if (opcao == 2) {
			SaqueCP cp = new SaqueCP();
			cp.getClass();
		}
		if (opcao == 3) {
			TelaCliente cliente = new TelaCliente();
			cliente.getClass();
		}
		if ((opcao != 1) || (opcao != 2) || (opcao != 3)) {
			TelaCliente cliente = new TelaCliente();
			cliente.getClass();
		}
	}

}
