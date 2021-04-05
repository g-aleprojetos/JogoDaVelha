package uninter;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.AbstractButton;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;

public class Tabuleiro extends JFrame {

	private JPanel contentPane;
		
	ImageIcon iconCirculo = new ImageIcon(getClass().getResource("circulo.png"));//instacia a imagem circulo
	ImageIcon iconX = new ImageIcon(getClass().getResource("X.png"));//instancia a umagem do X
	
	Bloco[] blocos = new Bloco[9];// cria os blocos onde vai ficar os botões do jogo
	String nomeJogador  = Jogador.getNome();//Recebe o nome do jogador da classe Jogador
	String computador = "Computador";
	
	int rodadas = 0;
	int jogadorVez = 1;
	int[] array = new int[9];
	int[] resp = new int[9];
	int selectNivel = Computador.getSelect();//recebe o nivel de dificuldade da classe Computador
	int verificar = 0;

	JLabel lInformacao = new JLabel();
	Timer myTimer = new Timer();

	public Tabuleiro() {
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(600,600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		//texto que mostra de quem é a vez de jogar
		lInformacao.setText(nomeJogador);
		lInformacao.setForeground(new Color(0, 255, 0));
		lInformacao.setHorizontalAlignment(SwingConstants.CENTER);
		lInformacao.setFont(new Font("Segoe Print", Font.BOLD, 33));
		contentPane.add(lInformacao, BorderLayout.NORTH);
	
		//painel onde vai o jogo
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 3, 10, 10));

		//icrementa os blocos na tela que é um botão
		for(int i=0; i<9; i++) {
		Bloco bloco = new Bloco();
		blocos[i] = bloco;
		panel.add(bloco);
		
		}
	}
	
	//método para trocar a vez de jogar
	public void mudarVez() {
		
		
		if(jogadorVez == 1) {
				
			autoComputer();
			
		}else {
			lInformacao.setText(nomeJogador);
			lInformacao.setForeground(Color.green);
			jogadorVez = 1;
			
		}
	}
	
	//método para verificar se alguem venceu
		public boolean testarVitoria(int jog) {
			if(blocos[0].quem == jog && blocos[1].quem == jog && blocos[2].quem == jog) {
				return true;
			}
			if(blocos[3].quem == jog && blocos[4].quem == jog && blocos[5].quem == jog) {
				return true;
			}
			if(blocos[6].quem == jog && blocos[7].quem == jog && blocos[8].quem == jog) {
				return true;
			}
			if(blocos[0].quem == jog && blocos[3].quem == jog && blocos[6].quem == jog) {
				return true;
			}
			if(blocos[1].quem == jog && blocos[4].quem == jog && blocos[7].quem == jog) {
				return true;
			}
			if(blocos[2].quem == jog && blocos[5].quem == jog && blocos[8].quem == jog) {
				return true;
			}
			if(blocos[0].quem == jog && blocos[4].quem == jog && blocos[8].quem == jog) {
				return true;
			}
			if(blocos[2].quem == jog && blocos[4].quem == jog && blocos[6].quem == jog) {
				return true;
			}
			return false;
		}
		
		public void test() {
					
			//testa quem vai vencer ou se vai dar velha
			if(testarVitoria(verificar)) {
				if(verificar == 1) {
					lInformacao.setText(nomeJogador + " Campeão");
					lInformacao.setForeground(Color.green);
					JOptionPane.showMessageDialog(null, "jogador " + nomeJogador + " venceu!");
					System.exit(0);
				}else {
					lInformacao.setText(computador + " Campeão");
					lInformacao.setForeground(Color.red);
					JOptionPane.showMessageDialog(null, "O " + computador + " venceu!");
					System.exit(0);
				}
			}
			rodadas++;
			
			if(rodadas == 9) {
				JOptionPane.showMessageDialog(null, "Deu velha!");
				System.exit(0);
			}
		}

	
	//botões para fazer a jogada
	public class Bloco extends JButton{
		
		int quem = 0;
		
		public Bloco() {
			setBackground(Color.white);
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {  //preenche o bloco se for clicado
					
					if(quem == 0) {
						
							quem = 1;
							verificar = quem;
							jogadorVez = 1;
												
							for(int i=0; i<9;i++) {
								
								if(blocos[i].quem == 1) {
								
									blocos[i].setIcon(iconCirculo);
								}				
							}
							
							test();
							
							mudarVez();
			
					}
				
				}
				
			});
	
		}
		
	}
	
	
	public void autoComputer() {
		
		
		for(int i=0; i<array.length; i++) {
			
			array[i] = blocos[i].quem;
		}
		Computador comp = new Computador();
		comp.setVetor(array);
		
	
		 
		if(selectNivel == 0) {
				
			ComputadorFacil cf = new ComputadorFacil();
			resp = ComputadorFacil.getArray();
			
			for(int i=0; i<9;i++) {
								
				if(blocos[i].quem != resp[i]) {
				
					blocos[i].quem = 2;
					blocos[i].setIcon(iconX);
					verificar = 2;
									
				}
			}
		
		}else if(selectNivel == 1) {
			//JOptionPane.showMessageDialog(null, selectNivel); 
		}else {
			//JOptionPane.showMessageDialog(null, selectNivel); 
		}
	
		
		jogadorVez = 2;
		
		test();
		mudarVez();
	}
	
}


	








