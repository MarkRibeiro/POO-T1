package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.event.*;
import regras.*;
 
public class PNBatalha extends JPanel implements MouseListener {
	double xIni=800.0,yIni=100.0,larg=30,alt=30,espLinha=0.0;
	int iClick,jClick;
	JLabel jogadorAtual;
	Celula tab1[][]=new Celula[32][32];
	Celula tab2[][]=new Celula[32][32];
	Line2D.Double ln1[]=new Line2D.Double[64];
	Line2D.Double ln2[]=new Line2D.Double[64];
	Fachada ctrl;
	
	public PNBatalha(Fachada c) {
		Double x=xIni;
		Double y=yIni;
		ctrl=c;
		jogadorAtual = new JLabel();
		jogadorAtual.setBounds(598, 20, 104, 15);
		jogadorAtual.setText(ctrl.getCtrlNomeVez() + " ataca");
		add(jogadorAtual);
		setLayout(null);
		for(int i=0;i<15;i++) {
			x=xIni;
			for(int j=0;j<15;j++) {
				tab2[i][j]=new Celula(x,y);
				x+=larg+espLinha;
			}
			y+=alt+espLinha;
		}
		
		y=yIni;
		for(int i=0;i<15;i++) {
			x=xIni/16;
			for(int j=0;j<15;j++) {
				tab1[i][j]=new Celula(x,y);
				x+=larg+espLinha;
			}
			y+=alt+espLinha;
		}
		
		addMouseListener(this);
		
		for(int i=0;i<16;i++) {
			ln1[i]=new Line2D.Double(xIni, yIni+alt*i, xIni+15*larg, yIni+alt*i);
			ln1[16+i]=new Line2D.Double(xIni+larg*i, yIni, xIni+larg*i, yIni+15*alt);
		}
		
		for(int i=0;i<16;i++) {
			ln2[i]=new Line2D.Double(xIni/16, yIni+alt*i, xIni/16+15*larg, yIni+alt*i);
			ln2[16+i]=new Line2D.Double(xIni/16+larg*i, yIni, xIni/16+larg*i, yIni+15*alt);
		}

	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d=(Graphics2D) g;
		Rectangle2D rt;
		int mat[][]=ctrl.getCtrlMatriz();
		int vez=ctrl.getCtrlVez();
		int mascaraTabuleiro1[][] = ctrl.getMascaraTabuleiro1();
		int mascaraTabuleiro2[][] = ctrl.getMascaraTabuleiro2();
		
		g2d.setStroke(new BasicStroke(2.0f,
                BasicStroke.CAP_BUTT,
                BasicStroke.JOIN_MITER,
                10.0f));
		
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				//System.out.print(ctrl.tabuleiro1[i][j]);
				if(mascaraTabuleiro1[i][j] == -1)
					g2d.setPaint(new Color(0, 0, 255, 255));
				else if(mascaraTabuleiro1[i][j] == 1)
					g2d.setPaint(new Color(64, 85, 27, 255));
				else if(mascaraTabuleiro1[i][j] == 2)
					g2d.setPaint(new Color(74, 148, 62, 255));
				else if(mascaraTabuleiro1[i][j] == 3)
					g2d.setPaint(new Color(255, 227, 72, 255));
				else if(mascaraTabuleiro1[i][j] == 4)
					g2d.setPaint(new Color(255, 167, 28, 255));
				else if(mascaraTabuleiro1[i][j] == 5)
					g2d.setPaint(new Color(155, 84, 22, 255));
				else 
					g2d.setPaint(new Color(0,0,0,0));
				rt=new Rectangle2D.Double(tab1[i][j].x+espLinha,tab1[i][j].y+espLinha,larg,alt);
				g2d.fill(rt);
			}
		}
		
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				//System.out.print(ctrl.tabuleiro1[i][j]);
				if(mascaraTabuleiro2[i][j] == -1)
					g2d.setPaint(new Color(0, 0, 255, 255));
				else if(mascaraTabuleiro2[i][j] == 1)
					g2d.setPaint(new Color(64, 85, 27, 255));
				else if(mascaraTabuleiro2[i][j] == 2)
					g2d.setPaint(new Color(74, 148, 62, 255));
				else if(mascaraTabuleiro2[i][j] == 3)
					g2d.setPaint(new Color(255, 227, 72, 255));
				else if(mascaraTabuleiro2[i][j] == 4)
					g2d.setPaint(new Color(255, 167, 28, 255));
				else if(mascaraTabuleiro2[i][j] == 5)
					g2d.setPaint(new Color(155, 84, 22, 255));
				else 
					g2d.setPaint(new Color(0,0,0,0));
				rt=new Rectangle2D.Double(tab2[i][j].x+espLinha,tab2[i][j].y+espLinha,larg,alt);
				g2d.fill(rt);
			}
		}
		
		for(int i=0;i<32;i++) {
			if(ctrl.getCtrlVez() == 1)
				g2d.setPaint(Color.red);
			else
				g2d.setPaint(Color.black);
			g2d.draw(ln1[i]);
			if(ctrl.getCtrlVez() == 2)
				g2d.setPaint(Color.red);
			else
				g2d.setPaint(Color.black);
			g2d.draw(ln2[i]);
		}
		
		g2d.setPaint(Color.black);
		
		for(int i=0;i<15;i++) {
			g2d.drawString(String.valueOf(i+1), (int)(xIni+10+alt*i), (int)yIni-10);
			g2d.drawString(String.valueOf((char)(65+i)), (int)xIni-20, (int)(yIni+20+alt*i));
			g2d.drawString(String.valueOf(i+1), (int)(xIni/16+10+alt*i), (int)yIni-10);
			g2d.drawString(String.valueOf((char)(65+i)), (int)xIni/16-20, (int)(yIni+20+alt*i));
		}
		
	}
	
	public void mouseClicked(MouseEvent e) {
		double x=e.getX(),y=e.getY();
		int numero;
		int vez = ctrl.getCtrlVez();
		if(x>=650) { 
			x-=xIni;
			numero = 2;
		}
		else { 
			x-=xIni/16;
			numero = 1;
		}
		y-=yIni;
		
		x = Math.floor(x/larg);
		y = Math.floor(y/alt);
		if(x>=0 && y>=0 && x<=15 && y<=15) {
			if(ctrl.getAtaque((int)y,(int)x, numero) == false)
				SwingUtilities.getWindowAncestor(this).dispose();
			else {
				System.out.printf("(%.2f, %.2f) %d\n", x, y, numero);
			}
			int novaVez = ctrl.getCtrlVez();
			
			if(vez != novaVez) {
				jogadorAtual.setText(ctrl.getCtrlNomeVez() + " ataca");
			}
		}
		repaint();
	}
	
	public void mouseEntered(MouseEvent e) {
		
	}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
}