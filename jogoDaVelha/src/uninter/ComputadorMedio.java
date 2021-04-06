package uninter;

import java.util.Random;

public class ComputadorMedio {

	private static int[] array = new int[9];
	private static int[] resp = new int[9];
		
	public static int[] getArray() {
		

		
		for(int i=0; i < 9; i++) {
			resp[i] = array[i];
		}
		
	
		if((resp[0] == 1) || (resp[2] == 1) || (resp[6] == 1) || (resp[8] == 1) ) {
			
			if(resp[4] == 0) {
			array[4] = 2;
			}else {
				 rond();
			}
		
		}else if((resp[4] != 0)){
			
			if(resp[0] != 0) {array[0] = 2;}
			else if(resp[2] != 0) {array[2] = 2;}
			else if(resp[6] != 0) {array[6] = 2;}
			else if(resp[8] != 0) {array[8] = 2;}
			else {rond();}
			
		}else {
			rond();
		}
		
		return array;
	}
	
		
	
	public static void setArray(int[] array) {
		ComputadorMedio.array = array;
	}	
	
	public static void rond() {
		Random random = new Random();
		int w;
		
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
	}
	
	
	
	
}
