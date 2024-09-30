package agencia;
import java.util.Scanner;


import cliente.TelaCliente;
import menu.MenuAgencia;

public class TelaAgencia  {
	public <ContaTerminal> TelaAgencia() {
		// TODO Auto-generated constructor stub
		System.out.println("\nDigite:\n1: Relatório de cliente. \n2: Volta ao menu principal.");
		Scanner menu = new Scanner(System.in);

		int opcao = menu.nextInt();
		if (opcao == 1) {
			//Refazer o formulário 
			RelatorioGR gr=new RelatorioGR();
			gr.getClass();
		}
		if (opcao == 2) {
			System.out.println("Saindo da tela do agencia, até logo!!");
			MenuAgencia agencia=new MenuAgencia();
			agencia.getClass();
		}
		if((opcao!=1) || (opcao!=2) ){
			System.out.println("Opção inválida.");
			TelaAgencia cliente=new TelaAgencia();
			cliente.getClass();
		}
			
		
	}
}
