package transferencia;
import java.util.Scanner;

import cliente.TelaCliente;
public class TelaTransferencia {
	public TelaTransferencia() {
		// TODO Auto-generated constructor stub
		Scanner scanner=new Scanner(System.in);
		System.out.println("\nDigite: \n1: Transferência de conta corrente para poupança. \n2: Transferência de conta poupança para corrente."
				+ " \n3: Voltar a menu anterior. ");
		int opcao=scanner.nextInt();
		if(opcao==1){
			TransferenciaCP  cp=new TransferenciaCP();
			cp.getClass();
		}
		if(opcao==2){
		    TransferenciaPC pc=new TransferenciaPC();
		    pc.getClass();
		}
		if(opcao==3){
		    TelaCliente cliente=new TelaCliente();
		    cliente.getClass();
		}
		if ((opcao != 1) || (opcao != 2) || (opcao != 3)) {
			TelaCliente cliente = new TelaCliente();
			cliente.getClass();
		}
	}

}
