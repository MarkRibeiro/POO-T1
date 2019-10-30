package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Rectangle2D;

import javax.swing.JPanel;

public class ConjuntoArmas extends JPanel implements MouseListener{
	
	
	
	public void constroi (int armaMatriz[][], Celula celulaMatriz[][], Graphics2D g2d, double tamanho, Color cor ) {
		g2d.setPaint(cor);
		Rectangle2D rt;
		double desloca = 0;		
		
		for(int i=0;i<armaMatriz.length;i++) {
			for(int j=0;j<armaMatriz[i].length;j++) {
				if(i == 0) {
					celulaMatriz[i][j]=new Celula(desloca,0);
					desloca=tamanho;
				}else {
					celulaMatriz[i][j]=new Celula(desloca,(+desloca));
					desloca=tamanho;
				}
					
			}
		}
		
		for(int i = 0; i < armaMatriz.length; i++) {
			for(int j = 0; j < armaMatriz[i].length;j++) {
				if( armaMatriz[i][j]==1 ) {
					rt=new Rectangle2D.Double(celulaMatriz[i][j].x,celulaMatriz[i][j].y,tamanho,tamanho);
					g2d.fill(rt);
				}
			}
		}
	}
		public void mouseClicked(MouseEvent e) {
			double x=e.getX(),y=e.getY();
			
			
		}
		
		public void mouseEntered(MouseEvent e) {}
		public void mousePressed(MouseEvent e) {}
		public void mouseReleased(MouseEvent e) {}
		public void mouseExited(MouseEvent e) {}		


}
		

