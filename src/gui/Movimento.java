package gui;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Movimento implements MouseListener, MouseMotionListener{

	private int x, y;
	private PNArmas armas;
	int indice;
	int tamQuadrado;
	
	public Movimento(JPanel panel, PNArmas armas, int tamanhoQuadrado, int indice) {
		this.armas = armas;
		this.indice = indice;
		this.tamQuadrado = tamanhoQuadrado;
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
	}
	

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton() == MouseEvent.BUTTON3) {
			armas.whenOtherClicked(3,indice);
		}else if(e.getButton() == MouseEvent.BUTTON2) {
			armas.whenOtherClicked(2,indice);
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		x = e.getX()/tamQuadrado;
		y = e.getY()/tamQuadrado;
		armas.whenClicked(indice);//passar o x e y (divide pelo tamanho do quadrado)
		offsetX = e.getX();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		armas.whenReleased(e, indice);
		offsetX = 0;
	}

	int offsetX = 0;
	@Override
	public void mouseDragged(MouseEvent e) {
		Component z = e.getComponent();
		z.setLocation((e.getX()+e.getComponent().getX())-x,(e.getY()+e.getComponent().getY())-y);
	}

}
