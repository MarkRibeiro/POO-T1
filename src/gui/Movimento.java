package gui;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class Movimento implements MouseListener, MouseMotionListener{

	private int x, y;
	private PNArmas armas;
	int indice;
	
	public Movimento(JPanel panel, PNArmas armas, int indice) {
		this.armas = armas;
		this.indice = indice; 
		panel.addMouseListener(this);
		panel.addMouseMotionListener(this);
	}
	

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
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
		x = e.getX();
		y = e.getY();
		armas.whenClicked(indice);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		armas.whenReleased(e);
	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		e.getComponent().setLocation((e.getX()+e.getComponent().getX())-x,(e.getY()+e.getComponent().getY())-y);
	}

}
