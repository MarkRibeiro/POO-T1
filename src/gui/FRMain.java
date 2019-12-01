package gui;

import regras.*;

import java.awt.*;
import javax.swing.*;

public class FRMain extends JFrame implements TrocaFase, Observer {
	final int LARG_WINDOW=1300;
	final int ALT_WINDOW=700;
	Fachada c; 
	PNArmas fase;
	
	public FRMain(Fachada c) {
		this.c = c;
		fase = new PNArmas(c, this); 
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_WINDOW/2;
		int y=sa/2-ALT_WINDOW/2;
		setBounds(x,y,LARG_WINDOW,ALT_WINDOW);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(fase);
		setTitle("Batalha Naval");
	}
	public void trocaFase() {
		getContentPane().remove(fase);
		getContentPane().add(new PNBatalha(c));
		revalidate();
		repaint();
	}
	
	public void iniciarPosicionamento() {
		fase.preparaInicioPartidas();
		this.setVisible(true);
	}
	
	public static void main(String args[]) {
		Fachada c = Fachada.getFachada();
		FRMain m = new FRMain(c);
		(new FRInicio(m, c)).setVisible(true);
		
	}
	@Override
	public void notify(Observable o) {
		Object lob[] =(Object[]) o.get();
		
		
		
	}
}
