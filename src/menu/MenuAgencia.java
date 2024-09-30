package menu;

import java.util.Scanner;
import java.awt.Menu;
import java.io.File;

import agencia.TelaAgencia;
import cliente.TelaCliente;

public class MenuAgencia {
	public MenuAgencia() {
		// TODO Auto-generated constructor stub
		System.out.println("|-----------------------------------------------------------------------------------|");
		System.out.println("|Projeto de desafio de controle de conta de banco para Digital Innovation One       |");
		System.out.println("|Aluno: Tibério Coelho Inácio                                                       |");
		System.out.println("|-----------------------------------------------------------------------------------|");

		System.out.println("\nDigite:\n1: Tela Agência. \n2: Tela Cliente. \n3: Sair do sistema.");
		pastaContador();
		pastaDBCC();
		pastaDBCP();
		pastaRG();
		pastaDB();
		Scanner menu = new Scanner(System.in);
		int opcao = menu.nextInt();
		if(opcao<=3){
		if (opcao == 1) {
			TelaAgencia agencia = new TelaAgencia();
			agencia.getClass();
		}
		if (opcao == 2) {
			TelaCliente cliente = new TelaCliente();
			cliente.getClass();
		}

		if (opcao == 3) {
			System.out.println("Saindo de sistema, até logo!!");
			System.exit(0);
		}
		}else{
			System.out.println("Digite uma opcão válida");
			MenuAgencia agencia=new MenuAgencia();
			agencia.getClass();
		}
	}

	public void pastaContador() {
		File file = new File("contadorDB");

		if (!file.exists()) {
			file.mkdir();
		}
		try {
			File arquivo = new File(file + "/" + "contador.txt");
			if (arquivo.createNewFile()) {

			}
		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	public void pastaDB() {
		File db = new File("arquivoDB");
		if (!db.exists()) {

			db.mkdir();
		}
	}

	public void pastaDBCC() {
		File db = new File("contaCorrenteDB");
		if (!db.exists()) {

			db.mkdir();
		}
	}
	public void pastaDBCP() {
		File db = new File("contaPoupancaDB");
		if (!db.exists()) {

			db.mkdir();
		}
	}
	public void pastaRG(){
		File rg=new File("relatorioGR");
		if(!rg.exists()){
			rg.mkdir();
		}
		try {
	    File relatorioRG =new File("relatorioGR/relatorioGR.txt");
	    if(relatorioRG.createNewFile()){
	    	
	    }
	    
		} catch (Exception e) {
			// TODO: handle exception
		}	
	}

}
