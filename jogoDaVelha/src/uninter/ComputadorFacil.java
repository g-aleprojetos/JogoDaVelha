package uninter;

import java.util.Random;

import javax.swing.JOptionPane;

public class ComputadorFacil extends Computador{
	
	private static int[] array = new int[9];
	private static int[] resp = new int[9];	
	
	public ComputadorFacil() {
		

	}


	public static int[] getArray() {
		
		Random random = new Random();
		int w;
		
		for(int i=0; i < 9; i++) {
			resp[i] = array[i];
		}
		
	
		do {
		
			int t = random.nextInt(9);
			w = 1;
		
			if(array[t] == 0) {
				array[t] = 2;
			
			}
			//verificação se a valor do array foi modificado
			for(int i = 0; i<9; i++) {
				if(array[i] != resp[i]) {
					w = 0;
				}
			}

		}while(w != 0);


		return array;
	}

	public static void setArray(int[] array) {
		ComputadorFacil.array = array;
	
		
	}
	
}
