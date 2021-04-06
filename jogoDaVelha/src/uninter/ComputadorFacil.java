package uninter;

import java.util.Random;

import javax.swing.JOptionPane;

public class ComputadorFacil extends Computador{
	
	private static int[] array = new int[9];
	private static int[] resp = new int[9];	
	


	public static int[] getArray() {
		
		Random random = new Random();
		int w;
		
		for(int i=0; i < 9; i++) {
			resp[i] = array[i];
		}
		
	
		do {
		
			int t = random.nextInt(9);//encolhe numero rondonico para fazer a jogada
			w = 1;
		
			if(array[t] == 0) {//verifica se o n�mero contem 0 para fazer a jogada
				array[t] = 2; // se o numero selecionado � adicionao 0 numero 2 que � do computador
			
			}
			//verifica��o se a valor do array foi modificado
			for(int i = 0; i<9; i++) {
				if(array[i] != resp[i]) {
					w = 0;//se o numero for mudado com exito � adicionado 0 na variavel w para sair do la�o 
				}
			}

		}while(w != 0);


		return array;
	}

	public static void setArray(int[] array) {
		ComputadorFacil.array = array;
	
		
	}
	
}
