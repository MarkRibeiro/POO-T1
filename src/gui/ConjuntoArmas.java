package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class ConjuntoArmas extends JPanel {
	
	private Arma arma;
	private Color cor;
	
	public ConjuntoArmas(Arma arma1) {
		this.arma = arma1;
		switch( arma.getTipo().toLowerCase()) {
		case "hidroaviao":
			this.cor=new Color(64, 85, 27, 255);
			break;
		case "submarino":
			this.cor = new Color(74, 148, 62, 255);
			break;
		case "destroyer":
			this.cor = new Color(255, 227, 72, 255);
			break;
		case "cruzador":
			this.cor = new Color(255, 167, 28, 255);
			break;
		case "couro":
			this.cor = new Color(155, 84, 22, 255);
			break;
		}
		this.setBackground(new Color(0, 0, 0, 0));
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		Rectangle2D rt;
		
		g2d.setStroke(new BasicStroke(2.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f));
		
			

		for(int i = 0; i < arma.getMatriz().length; i++) {
			for(int j = 0; j < arma.getMatriz()[i].length;j++) {
				rt=new Rectangle2D.Double(j*arma.getTamanho(),i*arma.getTamanho(),arma.getTamanho(),arma.getTamanho());
				if( arma.getMatriz()[i][j]==1 ) {
					g2d.setPaint(cor);
					g2d.fill(rt);
				}else{
					g2d.setPaint(new Color(0, 0, 0, 0));
					g2d.fill(rt);
				}
			}
		}
	}
	

	
	public void viraArma() {
		arma.viraArma();
		this.setBounds(this.getX(), this.getY(), this.getHeight(), this.getWidth() );
		
	}
	
	public Arma getArma() {
		return this.arma;
	}


}
		

