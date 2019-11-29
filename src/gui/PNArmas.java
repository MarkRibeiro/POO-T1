package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.ArrayList;
import java.awt.event.*;
import regras.*;

public class PNArmas extends JPanel implements MouseListener, ArmasObserver, TrocaTabuleiros {
	double xIni = 800.0, yIni = 100.0, larg = 30, alt = 30, espLinha = 0.0;
	JLabel jogadorAtual;
	double tamanhoQuadrado = 28;
	int iClick, jClick;
	Celula tab[][] = new Celula[32][32];
	Line2D.Double ln[] = new Line2D.Double[64];
	Fachada ctrl;
	boolean armaNoTab = false;
	int xArmaTab = 0, yArmaTab = 0;
	int matrizArmaTab[][];
	int contadorArmas = 0;
	Arma arma;
	ConjuntoArmas pintarArma;
	ArrayList<ConjuntoArmas> todasAsArmas = new ArrayList<ConjuntoArmas>();
	int hidroMatriz[][] = { { 0, 1, 0 }, { 1, 0, 1 } };
	int subMatriz[][] = { { 1, } };
	int desMatriz[][] = { { 1, 1 } };
	int cruzaMatriz[][] = { { 1, 1, 1, 1 } };
	int couroMatriz[][] = { { 1, 1, 1, 1, 1 } };
	TrocaFase t;
	
	public PNArmas(Fachada c, TrocaFase t) {
		double x = xIni, y = yIni; 
		ctrl = c;
		ctrl.getPainel(this);
		this.t = t;
		jogadorAtual = new JLabel();
		jogadorAtual.setBounds(545, 20, 210, 15);

		add(jogadorAtual);

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
		//TODO: mudar de true para false
		pronto.setEnabled(true);
		pronto.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				ctrl.getTabuleiroPronto();
				//TODO: Descomentar a linha a baixo
				//pronto.setEnabled(false);
				contadorArmas = 0;
			}
		});
		this.setLayout(null);

	}

	public void preparaInicioPartidas() {
		jogadorAtual.setText(ctrl.getCtrlNomeVez() + " posicione suas armas");
	}
	/*************************************************
	 * Construindo Armas
	 *************************************************************/
	public void construindoArmas() {
		double deslocaX = 750;
		double deslocaY = 115;
		int indice = 0;

		for (int i = 0; i < 5; i++) { // Hidroavioes
			arma = new Arma(hidroMatriz, tamanhoQuadrado + 2, "Hidroaviao");
			System.out.printf(">%s<\n", arma.toString());
			pintarArma = new ConjuntoArmas(arma);
			System.out.printf("sdgsdfgsdfgsdf\n");
			Movimento mv = new Movimento(pintarArma, this, indice);
			pintarArma.setBounds((int) (xIni - deslocaX), (int) yIni, (int) (tamanhoQuadrado + 2) * 3,
					(int) (tamanhoQuadrado + 2) * 2);
			pintarArma.setLayout(null);
			deslocaX -= 99;
			todasAsArmas.add(pintarArma);
			indice += 1;
		}

		deslocaX = 750;

		for (int i = 0; i < 4; i++) { // Submarinos
			arma = new Arma(subMatriz, tamanhoQuadrado, "Submarino");
			pintarArma = new ConjuntoArmas(arma);
			Movimento mv = new Movimento(pintarArma, this, indice);
			pintarArma.setBounds((int) (xIni - deslocaX), (int) (yIni + deslocaY), (int) tamanhoQuadrado,
					(int) tamanhoQuadrado);
			pintarArma.setLayout(null);
			deslocaX -= 43;
			todasAsArmas.add(pintarArma);
			indice += 1;
		}

		deslocaX = 750;
		deslocaY += 87;

		for (int i = 0; i < 3; i++) { // Destroyer
			arma = new Arma(desMatriz, tamanhoQuadrado + 2, "Destroyer");
			pintarArma = new ConjuntoArmas(arma);
			Movimento mv = new Movimento(pintarArma, this, indice);
			pintarArma.setBounds((int) (xIni - deslocaX), (int) (yIni + deslocaY), (int) (tamanhoQuadrado * 2) + 2,
					(int) tamanhoQuadrado);
			pintarArma.setLayout(null);
			deslocaX -= 71;
			todasAsArmas.add(pintarArma);
			indice += 1;
		}

		deslocaX = 750;
		deslocaY += 87;

		for (int i = 0; i < 2; i++) { // Cruzador
			arma = new Arma(cruzaMatriz, tamanhoQuadrado + 6,  "Cruzador");
			pintarArma = new ConjuntoArmas(arma);
			Movimento mv = new Movimento(pintarArma, this, indice);
			pintarArma.setBounds((int) (xIni - deslocaX), (int) (yIni + deslocaY), (int) (tamanhoQuadrado * 4) + 6,
					(int) tamanhoQuadrado);
			pintarArma.setLayout(null);
			deslocaX -= 127;
			todasAsArmas.add(pintarArma);
			indice += 1;
		}

		deslocaX = 750;
		deslocaY += 87;

		arma = new Arma(couroMatriz, tamanhoQuadrado + 8, "Couro");
		pintarArma = new ConjuntoArmas(arma);
		Movimento mv = new Movimento(pintarArma, this, indice);
		pintarArma.setBounds((int) (xIni - deslocaX), (int) (yIni + deslocaY), (int) (tamanhoQuadrado * 5) + 8,
				(int) tamanhoQuadrado);
		pintarArma.setLayout(null);
		todasAsArmas.add(pintarArma);

		/******************* Paint Armas *********************/
		for (int i = 0; i < todasAsArmas.size(); i++) {
			this.add(todasAsArmas.get(i));
		}
	}

	/*******************************************************
	 * End Construindo Armas
	 ***************************************************************/

	JButton pronto;

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Rectangle2D rt;
		int mat[][] = ctrl.getCtrlMatriz();
		int vez = ctrl.getCtrlVez();
		g2d.setStroke(new BasicStroke(2.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f));

		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (tab[i][j].arma != null) {
					g2d.setPaint(new Color(172, 223, 135, 255));
				} else {
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
		repaint();
	}

	public void trocaTabuleiros() {
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (tab[i][j].arma != null) {
					switch (tab[i][j].arma.getTipo()) {
					case "Hidroaviao": {
						ctrl.getSoltaMouse(i, j, 1);
						break;
					}

					case "Submarino": {
						ctrl.getSoltaMouse(i, j, 2);
						break;
					}

					case "Destroyer": {
						ctrl.getSoltaMouse(i, j, 3);
						break;
					}

					case "Cruzador": {
						ctrl.getSoltaMouse(i, j, 4);
						break;
					}

					case "Couro": {
						ctrl.getSoltaMouse(i, j, 5);
						break;
					}

					}
				}
				tab[i][j].arma = null;
			}
		}
	}

	public void atualizaInterface() {
		for (int i = 0; i < todasAsArmas.size(); i++) {
			this.remove(todasAsArmas.get(i));
		}
		jogadorAtual.setText(ctrl.getCtrlNomeVez() + " posicione suas armas");
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
		double x = e.getX(), y = e.getY();
		x -= xIni;
		y -= yIni;

		x = Math.floor(x / larg);
		y = Math.floor(y / alt);
		if (x >= 0 && y >= 0 && x <= 15 && y <= 15) {
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
			return new Point(0, 0);
		}
		Point pos = comp.getLocation();
		Point parentOff = getPositionRelativeTo(root, comp.getParent());
		return new Point(pos.x + parentOff.x, pos.y + parentOff.y);
	}

	@Override
	public void whenReleased(MouseEvent e, int posicao) {
		double x = SwingUtilities.convertPoint(e.getComponent(), e.getX(), e.getY(), this).getX(),
				y = SwingUtilities.convertPoint(e.getComponent(), e.getX(), e.getY(), this).getY();
		x -= xIni;
		y -= yIni;
		x = Math.floor(x / larg);
		y = Math.floor(y / alt);
		if (e.getButton() != MouseEvent.BUTTON3) {
			if (x >= 0 && y >= 0 && x <= 15 && y <= 15) {
				System.out.printf("(%.2f, %.2f)\n", x, y);
				xArmaTab = (int) x;
				yArmaTab = (int) y;
				armaNoTab = true;
				matrizArmaTab = todasAsArmas.get(posicao).getArma().getMatriz();
				this.remove(todasAsArmas.get(posicao));
				contadorArmas++;
				if (contadorArmas == 15) {
					pronto.setEnabled(true);
				}
				for (int i = 0; i < matrizArmaTab.length; i++) {
					for (int j = 0; j < matrizArmaTab[i].length; j++) {
						if (matrizArmaTab[i][j] == 1) {
							tab[yArmaTab + i][xArmaTab + j].arma = todasAsArmas.get(posicao).getArma();
						}
					}
				}

			} else {
				this.add(todasAsArmas.get(posicao));
			}
		}

		revalidate();
		repaint();
	}

	@Override
	public void whenOtherClicked(int butao, int posicao) {
		if (butao == 3) {
			todasAsArmas.get(posicao).viraArma();
		}

	}
}