package gui;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PNGanhador extends JPanel {
	public PNGanhador(String ganhador) {
		JLabel l1 = new JLabel();
		
		l1.setText(ganhador + " Ganhou!!!");

		l1.setBounds(160, 200,180, 15);
		add(l1);		
		revalidate();
	}
}
