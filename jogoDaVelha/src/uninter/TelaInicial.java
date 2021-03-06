package uninter;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JEditorPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.ComponentOrientation;

import javax.swing.ButtonGroup;
import javax.swing.DebugGraphics;
import javax.swing.JRadioButton;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;
	private JTextField nomeJogador;
	int select = 0;
	
	
	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setTitle("Jogo da Velha");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setSize(600,600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);//deixa todo os objetos na tela com valor absoluto em sua posi??o.
		contentPane.setLayout(null);
		
		//texto com o nome do jogo
		JLabel lblNewLabel_1 = new JLabel("Jogo da Velha");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Segoe Print", Font.BOLD, 35));
		lblNewLabel_1.setBounds(10, 11, 564, 51);
		contentPane.add(lblNewLabel_1);
		
		//imagem na tela inicial
		JLabel imagem = new JLabel("");
		imagem.setAlignmentX(Component.CENTER_ALIGNMENT);
		imagem.setHorizontalTextPosition(SwingConstants.CENTER);
		imagem.setFont(new Font("Tahoma", Font.PLAIN, 6));
		imagem.setHorizontalAlignment(SwingConstants.CENTER);
		imagem.setIcon(new ImageIcon(TelaInicial.class.getResource("/uninter/jogoDaVelha.jpg")));
		imagem.setBounds(10, 73, 564, 196);
		contentPane.add(imagem);
		
		//texto da parte de cima da tela
		JLabel lblNewLabel = new JLabel("DIGITE O NOME DO JOGADOR");
		lblNewLabel.setFont(new Font("Segoe Print", Font.BOLD, 33));
		lblNewLabel.setBounds(25, 267, 533, 55);
		contentPane.add(lblNewLabel);
		
		//caixa para receber o texto digitado
		nomeJogador = new JTextField();
		nomeJogador.setFont(new Font("Segoe Print", Font.BOLD, 33));
		nomeJogador.setBounds(107, 333, 369, 55);
		contentPane.add(nomeJogador);
		nomeJogador.setColumns(10);
		
		//Bot?es para escolher onivel de dificuldade
		
		ButtonGroup buttonGroup1 = new ButtonGroup();
		
		JRadioButton btnRadioDificil = new JRadioButton("Dif\u00EDcil");
		btnRadioDificil.setBackground(new Color(192, 192, 192));
		btnRadioDificil.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		btnRadioDificil.setBounds(367, 427, 109, 23);
		contentPane.add(btnRadioDificil);
				
		JRadioButton btnRadioMedio = new JRadioButton("M\u00E9dio");
		btnRadioMedio.setBackground(new Color(192, 192, 192));
		btnRadioMedio.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		btnRadioMedio.setBounds(237, 427, 109, 23);
		contentPane.add(btnRadioMedio);
		
		
		JRadioButton btnRadioFacil = new JRadioButton("F\u00E1cil");
		btnRadioFacil.setSelected(true);
		btnRadioFacil.setBackground(new Color(192, 192, 192));
		btnRadioFacil.setFont(new Font("Segoe Print", Font.PLAIN, 20));
		btnRadioFacil.setBounds(107, 427, 109, 23);
		contentPane.add(btnRadioFacil);
				
		buttonGroup1.add(btnRadioDificil);
		buttonGroup1.add(btnRadioMedio);
		buttonGroup1.add(btnRadioFacil);
		
		//bot?o para captar o nome do usu?rio e levar para o jogo
		JButton btnOK = new JButton("OK");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//envia o nome do usu?rio para classe do jogador		
				Jogador usuario = new Jogador();
				usuario.setNome(nomeJogador.getText());
				
				//envia o nivel de dificuldade para classe do computador
				boolean btnFacil = btnRadioFacil.isSelected();
				if(btnFacil == true) {select = 0;}
				
				boolean btnMedio = btnRadioMedio.isSelected();
				if(btnMedio == true) {select = 1;}
				
				boolean btnDificil = btnRadioDificil.isSelected();
				if(btnDificil == true) {select = 2;}
				
				Tabuleiro computador = new Tabuleiro();
				computador.getSelectNivel();
				
				
				//inicia a tela do jogo e fecha a tela de inicializa??o
				Tabuleiro tabuleiro = new Tabuleiro();
				tabuleiro.setVisible(true);
				dispose();
			
							
			}
		});
		btnOK.setBackground(new Color(128, 128, 128));
		btnOK.setFont(new Font("Segoe Print", Font.BOLD, 30));
		btnOK.setBounds(214, 475, 155, 55);
		contentPane.add(btnOK);
	

	}


}
