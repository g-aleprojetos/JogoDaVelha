package uninter;

import java.util.Random;

import javax.swing.JOptionPane;

public class ComputadorFacil extends Computador{
	
	private static int[] array = new int[9];
		


	public static int[] getArray() {
		int w;
		Random random = new Random();
		do {
		
			int t = random.nextInt(9);//gera um n�mero randomico at� nove
			w = t;//varivel de verifica��o do DO While, se caso for zero repete o la�o se n�o ele sai.
			//verifica se o n�mero do array � zero ou n�o
			if(array[t] == 0) {
				array[t] = 2;// se array for zero vai ser modificado para 2 que � o numero do computador
				w = 0;//zera a variavel para sair do la�o
				 
			}
			
		
		
		}while(w != 0);


		return array;
	}

	public static void setArray(int[] array) {
		ComputadorFacil.array = array;
	
		
	}


	
	
	
	
	
	
}
