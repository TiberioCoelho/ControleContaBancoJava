package cliente;

import java.util.Scanner;
import transferencia.TelaTransferencia;
import transferencia.TransferenciaCP;
import menu.MenuAgencia;

public class TelaCliente {
	public TelaCliente() {
		// TODO Auto-generated constructor stub
		System.out.println("\nDigite:\n1: Cadastro de conta. \n2: Consulta cliente. \n3: Saque.  \n4: Depósito."
				+ "\n5: Transferência entre contas. \n6: Volta ao menu principal.");
		Scanner menu = new Scanner(System.in);
		int opcao = menu.nextInt();
		if (opcao == 1) {
			CadastroCliente cadastroCliente = new CadastroCliente();
			cadastroCliente.getClass();
		}
		if (opcao == 2) {
			ConsultaContaCli cli = new ConsultaContaCli();
			cli.getClass();
		}

		if (opcao == 3) {
			TelaMenuSaque saque = new TelaMenuSaque();
			saque.getClass();
		}
		if (opcao == 4) {
			TelaMenuDeposito deposito = new TelaMenuDeposito();
			deposito.getClass();

		}
		if (opcao == 5) {
			TelaTransferencia telaTransferencia=new TelaTransferencia();
			telaTransferencia.getClass();

		}
		if (opcao == 6) {
			System.out.println("Saindo da tela de cliente, até logo!!");
			MenuAgencia agencia = new MenuAgencia();
			agencia.getClass();

		}
		if((opcao!=1)||(opcao!=2)||(opcao!=3)||(opcao!=4)||(opcao!=5)||(opcao!=6)){
			System.out.println("Opção inválida.");
			TelaCliente cliente=new TelaCliente();
			cliente.getClass();
		}
	}

}
