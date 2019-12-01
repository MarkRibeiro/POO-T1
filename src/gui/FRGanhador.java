package gui;

import javax.swing.*;

public class FRGanhador extends JFrame{
	final int LARG_WINDOW=500;
	final int ALT_WINDOW=400;
	
	public FRGanhador(String ganhador) {
		
		setTitle("Vencedor");
		setSize(LARG_WINDOW,ALT_WINDOW);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel l1 = new JLabel();
		JButton maisUma = new JButton();
		JButton fim = new JButton();
		int xIni = 200, yIni = 40, yDist = 50;
		
		l1.setText(ganhador + " Ganhou!!!");
		l1.setBounds(195, yIni + yDist, 110, 30);
		
		maisUma.setText("Reiniciar");
		maisUma.setBounds(xIni, yIni + yDist*2, 100, 30);
		
		fim.setText("Finalizar");
		fim.setBounds(xIni, yIni + yDist*3, 100, 30);
		
		add(l1);			
		add(maisUma);
		add(fim);
		
		setLayout(null);
	}
}
