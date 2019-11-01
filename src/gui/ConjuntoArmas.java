package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class ConjuntoArmas extends JPanel {
		
	private double tamanho;
	private Color cor;
	private int matriz[][];
	
	public ConjuntoArmas(int armaMatriz[][], double tamanhoArma, Color corArma ) {
		this.cor = corArma;
		this.tamanho = tamanhoArma;
		this.matriz = armaMatriz;
		
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
		
		
		
		
		//addMouseListener(this);
		//this.setLayout(null);
		//this.setVisible(true);
		for(int i = 0; i < matriz.length; i++) {
			for(int j = 0; j < matriz[i].length;j++) {
				rt=new Rectangle2D.Double(j*tamanho,i*tamanho,tamanho,tamanho);
				if( matriz[i][j]==1 ) {
					g2d.setPaint(cor);
					g2d.fill(rt);
				}else{
					g2d.setPaint(new Color(0, 0, 0, 0));
					g2d.fill(rt);
				}
			}
		}
	}
	
	


}
		

