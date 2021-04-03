package uninter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.GridLayout;

public class Tabuleiro extends JFrame {

	private JPanel contentPane;
	
	Bloco[] blocos = new Bloco[9];// cria os blocos onde vai ficar os botões do jogo

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tabuleiro frame = new Tabuleiro();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
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
		
		//Texto que indica de quem é a vez de jogar
		JLabel lblNewLabel = new JLabel("JOGADOR");
		lblNewLabel.setForeground(new Color(0, 255, 0));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 33));
		contentPane.add(lblNewLabel, BorderLayout.NORTH);
		
		//Tela do jogo
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 0));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(3, 3, 10, 10));//Colocar uma grade 3 X 3 na tela
		
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












