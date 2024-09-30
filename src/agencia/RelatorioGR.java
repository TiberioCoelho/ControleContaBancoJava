package agencia;
import java.awt.Menu;
import java.io.BufferedReader;
import java.util.Scanner;
import menu.MenuAgencia;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;


public class RelatorioGR {
public RelatorioGR() {
	// TODO Auto-generated constructor stub
	try{
		BufferedReader bufferedReader=new BufferedReader(new FileReader("relatorioGR/relatorioGR.txt"));		
		int i;
		while((i=bufferedReader.read())!=-1){
			System.out.print((char)i);
		}
		bufferedReader.close();
        Scanner scanner=new Scanner(System.in);				
		System.out.println("\nDigite 1:  Voltar ao menu principal");
		int opcao=scanner.nextInt();
		
		if(opcao==1){
		MenuAgencia menuAgencia=new MenuAgencia();
		menuAgencia.getClass();
		}
		if(opcao!=1){
			System.out.println("Opção invalida.");
			RelatorioGR gr=new RelatorioGR();
			gr.getClass();
		}
		
	}catch(Exception e)
	{
		
	}
}
}
