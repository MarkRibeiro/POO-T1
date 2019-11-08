package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.event.*;
import regras.*;

public class PNArmas extends JPanel implements MouseListener, ArmasObserver, TrocaTabuleiros {
	double xIni = 800.0, yIni = 100.0, larg = 30, alt = 30, espLinha = 0.0;
	double tamanhoQuadrado = 28;
	int iClick, jClick;
	Celula tab[][] = new Celula[32][32];
	Line2D.Double ln[] = new Line2D.Double[64];
	CtrlRegras ctrl;
	boolean b = false, armaNoTab = false;
	int xArmaTab = 0, yArmaTab = 0;
	int matrizArmaTab[][];
	int contadorArmas = 0;
	ConjuntoArmas hidro, sub, destroyer, cruzador, couro;
	ArrayList<ConjuntoArmas> todasAsArmas = new ArrayList<ConjuntoArmas>();
	int hidroMatriz[][] = { { 0, 1, 0 }, { 1, 0, 1 } };
	int subMatriz[][] = { { 1, } };
	int desMatriz[][] = { { 1, 1 } };
	int cruzaMatriz[][] = { { 1, 1, 1, 1 } };
	int couroMatriz[][] = { { 1, 1, 1, 1, 1 } };
	TrocaFase t;
	public PNArmas(CtrlRegras c, TrocaFase t) {
		double x = xIni, y = yIni;
		ctrl = c;
		ctrl.painel = this;
		this.t = t;

		for (int i = 0; i < 15; i++) {
			x = xIni;
			for (int j = 0; j < 15; j++) {
				tab[i][j] = new Celula(x, y);
				x += larg + espLinha;
			}
			y += alt + espLinha;
		}

		addMouseListener(this);

		for (int i = 0; i < 16; i++) {
			ln[i] = new Line2D.Double(xIni, yIni + alt * i, xIni + 15 * larg, yIni + alt * i);
			ln[16 + i] = new Line2D.Double(xIni + larg * i, yIni, xIni + larg * i, yIni + 15 * alt);
		}
		construindoArmas();
		pronto = new JButton();
		pronto.setText("Tabuleiro Pronto!");
		pronto.setBounds(570, 620, 160, 30);
		this.add(pronto);
		pronto.setEnabled(b);
		pronto.addActionListener(new ActionListener() {

		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	ctrl.tabuleiroPronto();
		    }
		});
		this.setLayout(null);
	
	}

	/*************************************************Construindo Armas*************************************************************/
	public void construindoArmas() {
		double deslocaX = 750;
		double deslocaY = 115;
		int indice = 0;
		
		for (int i = 0; i < 5; i++) { // Hidroavioes
			hidro = new ConjuntoArmas(hidroMatriz, tamanhoQuadrado + 2, new Color(64, 85, 27, 255), "Hidroaviao");
			Movimento mv = new Movimento(hidro, this, indice);
			hidro.setBounds((int) (xIni - deslocaX), (int) yIni, (int) (tamanhoQuadrado + 2) * 3,(int) (tamanhoQuadrado + 2) * 2);
			hidro.setLayout(null);
			deslocaX -= 99;
			todasAsArmas.add(hidro);
			indice += 1;
		}

		deslocaX = 750;

		for (int i = 0; i < 4; i++) { // Submarinos
			sub = new ConjuntoArmas(subMatriz, tamanhoQuadrado, new Color(74, 148, 62, 255), "Submarino");
			Movimento mv = new Movimento(sub, this, indice);
			sub.setBounds((int) (xIni - deslocaX), (int) (yIni + deslocaY), (int) tamanhoQuadrado,(int) tamanhoQuadrado);
			sub.setLayout(null);
			deslocaX -= 43;
			todasAsArmas.add(sub);
			indice += 1;
		}

		deslocaX = 750;
		deslocaY += 87;

		for (int i = 0; i < 3; i++) { // Destroyer
			destroyer = new ConjuntoArmas(desMatriz, tamanhoQuadrado + 2, new Color(255, 227, 72, 255), "Destroyer");
			Movimento mv = new Movimento(destroyer, this, indice);
			destroyer.setBounds((int) (xIni - deslocaX), (int) (yIni + deslocaY), (int) (tamanhoQuadrado * 2) + 2,(int) tamanhoQuadrado);
			destroyer.setLayout(null);
			deslocaX -= 71;
			todasAsArmas.add(destroyer);
			indice += 1;
		}

		deslocaX = 750;
		deslocaY += 87;

		for (int i = 0; i < 2; i++) { // Cruzador
			cruzador = new ConjuntoArmas(cruzaMatriz, tamanhoQuadrado + 6, new Color(255, 167, 28, 255), "Cruzador");
			Movimento mv = new Movimento(cruzador, this, indice);
			cruzador.setBounds((int) (xIni - deslocaX), (int) (yIni + deslocaY), (int) (tamanhoQuadrado * 4) + 6,(int) tamanhoQuadrado);
			cruzador.setLayout(null);
			deslocaX -= 127;
			todasAsArmas.add(cruzador);
			indice += 1;
		}

		deslocaX = 750;
		deslocaY += 87;

		couro = new ConjuntoArmas(couroMatriz, tamanhoQuadrado + 8, new Color(155, 84, 22, 255), "Couro");
		Movimento mv = new Movimento(couro, this, indice);
		couro.setBounds((int) (xIni - deslocaX), (int) (yIni + deslocaY), (int) (tamanhoQuadrado * 5) + 8, (int) tamanhoQuadrado);
		couro.setLayout(null);
		todasAsArmas.add(couro);
		

		/*******************Paint Armas*********************/
		for (int i = 0; i < todasAsArmas.size(); i++) {
			this.add(todasAsArmas.get(i));
		}
	}
		
	/*******************************************************End Construindo Armas***************************************************************/
	
	JButton pronto;
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Rectangle2D rt;
		int mat[][] = ctrl.getMatriz();
		int vez = ctrl.getVez();
		g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f));

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if(tab[i][j].arma!=null) {
					g2d.setPaint(new Color(172,223,135, 255));
				}else {
					g2d.setPaint(new Color(0, 0, 0, 0));
				}
				rt = new Rectangle2D.Double(tab[i][j].x + espLinha, tab[i][j].y + espLinha, larg, alt);
				g2d.fill(rt);
			}
		}
		g2d.setPaint(Color.black);

		for (int i = 0; i < 32; i++)
			g2d.draw(ln[i]);

		for (int i = 0; i < 15; i++) {
			g2d.drawString(String.valueOf(i + 1), (int) (xIni + 10 + alt * i), (int) yIni - 10);
			g2d.drawString(String.valueOf((char) (65 + i)), (int) xIni - 20, (int) (yIni + 20 + alt * i));
		}


	}
	public void fimPosicionamento() {
		t.trocaFase();
	}
	
	public void trocaTabuleiros() {
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if(tab[i][j].arma != null){
					switch (tab[i][j].arma.tipo) {
					case "Hidroaviao": {
						ctrl.jogada(i, j, 1);
						break;
					}
					
					case "Submarino": {
						ctrl.jogada(i, j, 2);
						break;
					}
					
					case "Destroyer": {
						ctrl.jogada(i, j, 3);
						break;
					}
					
					case "Cruzador": {
						ctrl.jogada(i, j, 4);
						break;
					}
					
					case "Couro": {
						ctrl.jogada(i, j, 5);
						break;
					}
					
					}
				}
				tab[i][j].arma = null;
			}
		}
		
		for(int i=0;i<todasAsArmas.size();i++) {
			this.remove(todasAsArmas.get(i));
			
		}
		todasAsArmas.clear();
		construindoArmas();
		repaint();
	}
	public void mouseClicked(MouseEvent e) {
		double x = e.getX(), y = e.getY();
		

	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mousePressed(MouseEvent e) {
	}


	@Override
	public void mouseReleased(MouseEvent e) {
		double x=e.getX(),y=e.getY();
		x-=xIni;
		y-=yIni;

		x = Math.floor(x/larg);
		y = Math.floor(y/alt);
		if(x>=0 && y>=0 && x<=15 && y<=15) {
			System.out.printf("(%.2f, %.2f)\n", x, y);
		
		
		} 
		repaint();
	}
	
	public void mouseUp(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void whenClicked(int posicao) {
		repaint();
	}
	public static Point getPositionRelativeTo(Component root, Component comp) {
	    if (comp.equals(root)) { 
	    	return new Point(0,0); 
	    }
	    Point pos = comp.getLocation();
	    Point parentOff = getPositionRelativeTo(root, comp.getParent());
	    return new Point(pos.x + parentOff.x, pos.y + parentOff.y);
	}
	@Override
	public void whenReleased(MouseEvent e, int posicao) {
		System.out.println(SwingUtilities.convertPoint(e.getComponent(), e.getX(), e.getY(), this));
		double x=SwingUtilities.convertPoint(e.getComponent(), e.getX(), e.getY(), this).getX(),y=SwingUtilities.convertPoint(e.getComponent(), e.getX(), e.getY(), this).getY();
		x-=xIni;
		y-=yIni;
		x = Math.floor(x/larg);
		y = Math.floor(y/alt);
		if(e.getButton() != MouseEvent.BUTTON3) {
			if(x>=0 && y>=0 && x<=15 && y<=15) {
				System.out.printf("(%.2f, %.2f)\n", x, y);
				xArmaTab = (int)x;
				yArmaTab = (int)y;
				armaNoTab =true;
				matrizArmaTab= todasAsArmas.get(posicao).getMatriz();
				this.remove(todasAsArmas.get(posicao));
				contadorArmas++;
				if(contadorArmas == 15) {
					pronto.setEnabled(true);
				}
				for (int i = 0; i < matrizArmaTab.length; i++) {
					for (int j = 0; j< matrizArmaTab[i].length; j++) {
						if (matrizArmaTab[i][j] == 1) {
							tab[yArmaTab+i][xArmaTab+j].arma=todasAsArmas.get(posicao);
						}
					}
				}
				
			}else {
				this.add(todasAsArmas.get(posicao));
			}
		}
		
		revalidate();
		repaint();
	}

	@Override
	public void whenOtherClicked(int butao, int posicao) {
		if(butao == 3) {
			todasAsArmas.get(posicao).viraArma();
		}
		
	}
}