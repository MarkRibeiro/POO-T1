package gui;

import javax.swing.*;

public class FRGanhador extends JFrame{
	final int LARG_WINDOW=500;
	final int ALT_WINDOW=400;
	
	public FRGanhador(String ganhador) {
		
		setTitle("Vencedor");
		setSize(LARG_WINDOW,ALT_WINDOW);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().add(new PNGanhador("sdjkhfsdjk"));
		

		JLabel l1 = new JLabel();
		
		l1.setText(ganhador + " Ganhou!!!");

		l1.setBounds(160, 200,180, 15);
		add(l1);		
		setLayout(null);
	}
}
