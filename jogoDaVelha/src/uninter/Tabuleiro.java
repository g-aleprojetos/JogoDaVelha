package uninter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

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
	
	Bloco[] blocos = new Bloco[9];// cria os blocos onde vai ficar os botões do jogo
	String nomeJogador;
	String texto = "jogador 1";
	

	/**
	 * Create the frame.  		JOptionPane.showMessageDialog(null, nomeJogador); 
	 */

	
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
		nomeJogador = Jogador.getNome();	
		JLabel lInformacao = new JLabel(nomeJogador);
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
	

	

	
	//botões para fazer a jogada
	public class Bloco extends JButton{
		
		int quem = 0;
		public Bloco() {
			setBackground(Color.white);
		}
		
	}
	

}












