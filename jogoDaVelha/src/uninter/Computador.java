package uninter;

import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class Computador {

	private static int select;
	private static int[] vetor = new int[9];
	private int[] resposta = new int[9];
	
	
	public int[] getResposta() {
		ComputadorFacil.getArray();
		return resposta;
	}

	public void setResposta(int[] resposta) {
		this.resposta = resposta;
	}

	public Computador(){
		//seleciona o nivel de dificuldade
		if(select == 0) {
						
			ComputadorFacil.setArray(vetor);

		}
		if(select == 1) {
			
			ComputadorMedio.setArray(vetor);

		}
		if(select == 2){
			
			ComputadorDificil.setArray(vetor);

		}
	
	}
	
	//mostra qual nivel de dificuldade foi escolido
	public static int getSelect() {
		return select;
	}

	public void setSelect(int select) {
		Computador.select = select;
		
	}
	
	//mostra as casas que foram usada
	public static int[] getVetor() {

		return vetor;
	}

	public void setVetor(int[] vetor) {
				
		Computador.vetor = vetor;
	
	}


}
