package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import regras.*;
 
public class PNArmas extends JPanel implements MouseListener {
	double xIni=800.0,yIni=100.0,larg=30,alt=30,espLinha=0.0;
	double altQuadrado=28, largQuadrado=28;
	int iClick,jClick;
	Celula tab[][]=new Celula[32][32];
	Line2D.Double ln[]=new Line2D.Double[64];
	CtrlRegras ctrl;
	boolean b = false;
	ConjuntoArmas hidro, cruzador, destroyer, sub, couro;
	
	
	public PNArmas(CtrlRegras c) {
		double x=xIni,y=yIni;
		ctrl=c;
		
		for(int i=0;i<15;i++) {
			x=xIni;
			for(int j=0;j<15;j++) {
				tab[i][j]=new Celula(x,y);
				x+=larg+espLinha;
			}
			y+=alt+espLinha;
		}
		
		addMouseListener(this);
		
		for(int i=0;i<16;i++) {
			ln[i]=new Line2D.Double(xIni, yIni+alt*i, xIni+15*larg, yIni+alt*i);
			ln[16+i]=new Line2D.Double(xIni+larg*i, yIni, xIni+larg*i, yIni+15*alt);
		}

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		Rectangle2D rt;
		int mat[][]=ctrl.getMatriz();
		int vez=ctrl.getVez();
		double deslocaX = 500;
		double deslocaY = 0;
		
		g2d.setStroke(new BasicStroke(2.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f));
		
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				g2d.setPaint(new Color(0, 0, 0, 0));
				rt=new Rectangle2D.Double(tab[i][j].x+espLinha,tab[i][j].y+espLinha,larg,alt);
				g2d.fill(rt);
			}
		}
		g2d.setPaint(Color.black);
		
		for(int i=0;i<32;i++)
			g2d.draw(ln[i]);
		
		for(int i=0;i<15;i++) {
			g2d.drawString(String.valueOf(i+1), (int)(xIni+10+alt*i), (int)yIni-10);
			g2d.drawString(String.valueOf((char)(65+i)), (int)xIni-20, (int)(yIni+20+alt*i));
		}
		
		for (int i = 0; i < 5; i++ ) { //hidroaviao
			hidro = new ConjuntoArmas();
			hidro.hidroaviao(g2d, xIni-deslocaX, yIni+deslocaY, altQuadrado, largQuadrado);
			deslocaX-=99;
		}
		
		deslocaX=750;
		deslocaY+=50;
		
		for (int i = 0; i < 4; i++ ) {//Submarino
			sub = new ConjuntoArmas();
			sub.submarinos(g2d, xIni-deslocaX, yIni+deslocaY, altQuadrado, largQuadrado);
			deslocaX-=43;
		}		
		
		deslocaX=750;
		deslocaY+=50;
		
		for (int i = 0; i < 3; i++ ) {//Destroyer
			destroyer = new ConjuntoArmas();
			destroyer.destroyers(g2d, xIni-deslocaX, yIni+deslocaY, altQuadrado, largQuadrado);
			deslocaX-=71;
		}
		
		deslocaX=750;
		deslocaY+=50;
		
		for (int i = 0; i < 2; i++ ) {//Cruzadores
			cruzador = new ConjuntoArmas();
			cruzador.cruzadores(g2d, xIni-deslocaX, yIni+deslocaY, altQuadrado, largQuadrado);
			deslocaX-=127;
		}
		
		deslocaX=750;
		deslocaY+=50;
		
		couro = new ConjuntoArmas();
		couro.cruzadores(g2d, xIni-deslocaX, yIni+deslocaY, altQuadrado, largQuadrado);
		
		
		JButton pronto = new JButton();
		pronto.setText("Tabuleiro Pronto!");
		pronto.setBounds(570, 620, 160, 30);
		this.add(pronto);
		pronto.setEnabled(b);
		this.setLayout(null);
	}
	
	public void mouseClicked(MouseEvent e) {
		double x=e.getX(),y=e.getY();
		x-=xIni;
		y-=yIni;
		
		x = Math.floor(x/larg);
		y = Math.floor(y/alt);
		if(x>=0 && y>=0 && x<=15 && y<=15) {
			ctrl.jogada((int)y,(int)x);
			System.out.printf("(%.2f, %.2f)\n", x, y);
		}
		repaint();
	}
	
	public void mouseEntered(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}