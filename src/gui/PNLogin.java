package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import regras.Fachada;

public class PNLogin extends JPanel{
	public PNLogin(FRMain m, Fachada ctrl) {
		JButton comecar = new JButton();
		JTextField jogador1 = new JTextField();
		JTextField jogador2 = new JTextField();
		JLabel l1 = new JLabel();
		JLabel l2 = new JLabel();
		int xIni = 150, yIni = 100, yDist = 50;
		
		l1.setText("Jogador1:");
		l1.setBounds(160, yIni,80, 30);
		add(l1);
		
		l2.setText("Jogador2:");
		l2.setBounds(160, yIni + yDist,80, 30);
		add(l2);
		
		jogador1.setText("Jogador1");
		jogador1.setBounds(240, yIni,100, 30);
		add(jogador1);
		
		jogador2.setText("Jogador2");
		jogador2.setBounds(240, yIni + yDist, 100, 30);
		add(jogador2);
		
		comecar.setText("Comecar");
		comecar.setBounds(200, yIni + yDist*2, 100, 40);
		comecar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ctrl.getImportaNomes(jogador1.getText(), jogador2.getText());
				SwingUtilities.getWindowAncestor(PNLogin.this).dispose();
				m.iniciarPosicionamento();
			}
		});
		add(comecar);
		setLayout(null);
	}
}
