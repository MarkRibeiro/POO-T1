package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import regras.*;

public class FRLogin extends JFrame{
	final int LARG_WINDOW=500;
	final int ALT_WINDOW=400;

	
	public FRLogin(FRMain m, Fachada ctrl) {
		JButton comecar = new JButton();
		JTextField jogador1 = new JTextField();
		JTextField jogador2 = new JTextField();
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		int xIni = 150, yIni = 100, yDist = 50;
		
		setTitle("Jogadores");
		setSize(LARG_WINDOW,ALT_WINDOW);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		l1.setText("Jogador1:");
		l1.setBounds(160, yIni,80, 30);
		getContentPane().add(l1);
		
		l2.setText("Jogador2:");
		l2.setBounds(160, yIni + yDist,80, 30);
		getContentPane().add(l2);
		
		jogador1.setText("Jogador1");
		jogador1.setBounds(240, yIni,100, 30);
		getContentPane().add(jogador1);
		
		jogador2.setText("Jogador2");
		jogador2.setBounds(240, yIni + yDist, 100, 30);
		getContentPane().add(jogador2);
		
		comecar.setText("Comecar");
		comecar.setBounds(200, yIni + yDist*2, 100, 40);
		comecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.getImportaNomes(jogador1.getText(), jogador2.getText());
				dispose();
				m.iniciarPosicionamento();
			}
		});
		getContentPane().add(comecar);
		setLayout(null);
	}
}
