package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;

public class ConjuntoArmas extends JPanel {
		
	private double tamanho;
	private Color cor;
	private int matriz[][];
	public String tipo;
	
	public ConjuntoArmas(int armaMatriz[][], double tamanhoArma, Color corArma, String tipo ) {
		this.cor = corArma;
		this.tamanho = tamanhoArma;
		this.matriz = armaMatriz;
		this.tipo = tipo;
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
	
	public int[][] getMatriz(){
		return this.matriz;		
	}
	
	public void viraArma() {
		boolean virou = false;
		int auxMatriz[][] = new int[this.matriz[0].length][matriz.length];
		for(int i=0; i < this.matriz.length; i++) {
			for(int j=0; j < this.matriz[0].length; j++) {
				auxMatriz[j][i] = this.matriz[i][j];
				virou = true;
			}
		}
		this.matriz = auxMatriz;
		if(virou == true) {
			int auxMatriz2[][] = new int[auxMatriz.length][auxMatriz[0].length];
			for(int i=0; i < auxMatriz.length; i++) {{
					auxMatriz2[i] = auxMatriz[auxMatriz.length-i-1];
					virou = false;
				}
			}
			this.matriz = auxMatriz2;
		}
		
		this.setBounds(this.getX(), this.getY(), this.getHeight(), this.getWidth() );
		
	}
	
	


}
		

