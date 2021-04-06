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
		
			if(array[t] == 0) {//verifica se o número contem 0 para fazer a jogada
				array[t] = 2; // se o numero selecionado é adicionao 0 numero 2 que é do computador
			
			}
			//verificação se a valor do array foi modificado
			for(int i = 0; i<9; i++) {
				if(array[i] != resp[i]) {
					w = 0;//se o numero for mudado com exito é adicionado 0 na variavel w para sair do laço 
				}
			}

		}while(w != 0);


		return array;
	}

	public static void setArray(int[] array) {
		ComputadorFacil.array = array;
	
		
	}
	
}
