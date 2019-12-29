package gui;

import regras.*;

import java.awt.*;
import javax.swing.*;

public class FRMain extends JFrame implements TrocaFase, Observer {
	final int LARG_WINDOW=1300;
	final int ALT_WINDOW=700;
	PNArmas fase;
	
	public FRMain() {
		fase = new PNArmas(this); 
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
		getContentPane().add(new PNBatalha(this));
		revalidate();
		repaint();
	}
	

	public void iniciarPosicionamento() {
		fase.preparaInicioPartidas();
		this.setVisible(true);
	}
	
	public static void main(String args[]) {
		FRMain m = new FRMain();
		(new FRInicio(m)).setVisible(true);
		
	}
	@Override
	public void notified(Object o) {
		Object lob[] =(Object[]) ((Observable) o).get();
		
		
		
	}
}
