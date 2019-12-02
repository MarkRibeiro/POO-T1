package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import regras.*;

public class FRInicio extends JFrame{
	final int LARG_WINDOW=500;
	final int ALT_WINDOW=400;
	FRMain m;
	Fachada ctrl;
	PNCarregamento carregamento = new PNCarregamento(this);
	
	public FRInicio(FRMain m, Fachada ctrl) {
		this.m = m;
		this.ctrl = ctrl;
		setTitle("Batalha Naval");
		setSize(LARG_WINDOW,ALT_WINDOW);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(carregamento);
	}
	
	public void chamaLogin() {
		remove(carregamento);
		getContentPane().add(new PNLogin(m, ctrl));
		//getContentPane().add(new PNGanhador("casa"));
		setTitle("Jogadores");
		revalidate();
	}
	
	public void carregaBatalha(PNBatalha b) {
		int width=1300;
		int height=700;

		remove(carregamento);
		getContentPane().add(b);
		this.setBounds(0,0, width, height);
		revalidate();
		repaint();
	}
	
	public FRMain getMain() {
		return m;
	}
}
