package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.*;
import regras.*;
 
public class PNBatalha extends JPanel implements MouseListener {
	double xIni=800.0,yIni=100.0,larg=30,alt=30,espLinha=0.0;
	int iClick,jClick;
	JLabel jogadorAtual, adversarioAtual;
	JLabel situacao;
	String navio;
	Celula tab1[][]=new Celula[32][32];
	Celula tab2[][]=new Celula[32][32];
	Line2D.Double ln1[]=new Line2D.Double[64];
	Line2D.Double ln2[]=new Line2D.Double[64];
	Fachada ctrl;
	FRMain m;
	JButton passarVez = new JButton();
	JButton salvar = new JButton();
	
	public PNBatalha(FRMain m) {
		Double x=xIni;
		Double y=yIni;
		ctrl=Fachada.getFachada();
		this.m = m;
		jogadorAtual = new JLabel();
		adversarioAtual = new JLabel();
		situacao = new JLabel();
		jogadorAtual.setBounds(50, 20, 450, 15);
		adversarioAtual.setBounds(800, 20, 450, 15);
		situacao.setBounds(550, 343, 200, 15);
		jogadorAtual.setText("Tabuleiro de " + ctrl.getCtrlNomeVez());
		adversarioAtual.setText("Tabuleiro de (adversario) " + ctrl.getCtrlNomeOponente());
		add(jogadorAtual);
		add(adversarioAtual);
		add(situacao);
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
		passarVez.setEnabled(false);
		passarVez.setText("Passar Vez");
		passarVez.setBounds(600, 590, 100, 30);
		passarVez.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passarVez.setEnabled(false);
				salvar.setEnabled(false);
				
				ctrl.passaVez();
				situacao.setText("");
				jogadorAtual.setText("Tabuleiro de " + ctrl.getCtrlNomeVez());
				adversarioAtual.setText("Tabuleiro de (adversario) " + ctrl.getCtrlNomeOponente());
				repaint();
			}
		});
		add(passarVez);
		
		salvar.setEnabled(false);
		salvar.setText("Salvar Jogo");
		salvar.setBounds(50, 590, 120, 30);
		add(salvar);
		setLayout(null);

	}
	
	public void preparaInicioPartidas() {
		jogadorAtual.setText(ctrl.getCtrlNomeVez() + " posicione suas armas");
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
		int[][] conteudoTab1 = null;
		int[][] conteudoTab2 = null;
		int[][] masc = null;
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if (ctrl.getCtrlVez() == 1) {
					conteudoTab1 = ctrl.getTabuleiro1();
					masc = mascaraTabuleiro1;
				} else {
					conteudoTab1 = ctrl.getTabuleiro2();
					masc = mascaraTabuleiro2;
				}
				if(masc[i][j] == 10)
					g2d.setPaint(new Color(0, 0, 255, 255));
				else if (masc[i][j] < 0)
					g2d.setPaint(new Color(255, 0, 0, 255));
				else if(conteudoTab1[i][j] == 1) 
					g2d.setPaint(new Color(64, 85, 27, 255));
				else if(conteudoTab1[i][j] == 2) 
					g2d.setPaint(new Color(74, 148, 62, 255));
				else if(conteudoTab1[i][j] == 3)
					g2d.setPaint(new Color(255, 227, 72, 255));
				else if(conteudoTab1[i][j] == 4) 
					g2d.setPaint(new Color(255, 167, 28, 255));
				else if(conteudoTab1[i][j] == 5) 
					g2d.setPaint(new Color(155, 84, 22, 255));
				else 
					g2d.setPaint(new Color(0,0,0,0));
				rt=new Rectangle2D.Double(tab1[i][j].x+espLinha,tab1[i][j].y+espLinha,larg,alt);
				g2d.fill(rt);
			}
		}
		
		for(int i=0;i<15;i++) {
			for(int j=0;j<15;j++) {
				if (ctrl.getCtrlVez() == 2) {
					conteudoTab2 = mascaraTabuleiro1;
				} else {
					conteudoTab2 = mascaraTabuleiro2;
				}
				if(conteudoTab2[i][j] == 10)
					g2d.setPaint(new Color(0, 0, 255, 255));
				else if(conteudoTab2[i][j] == 1 || conteudoTab2[i][j] == -1)
					g2d.setPaint(new Color(64, 85, 27, 255));
				else if(conteudoTab2[i][j] == 2 || conteudoTab2[i][j] == -2)
					g2d.setPaint(new Color(74, 148, 62, 255));
				else if(conteudoTab2[i][j] == 3 || conteudoTab2[i][j] == -3)
					g2d.setPaint(new Color(255, 227, 72, 255));
				else if(conteudoTab2[i][j] == 4 || conteudoTab2[i][j] == -4)
					g2d.setPaint(new Color(255, 167, 28, 255));
				else if(conteudoTab2[i][j] == 5 || conteudoTab2[i][j] == -5)
					g2d.setPaint(new Color(155, 84, 22, 255));
				else 
					g2d.setPaint(new Color(0,0,0,0));
				rt=new Rectangle2D.Double(tab2[i][j].x+espLinha,tab2[i][j].y+espLinha,larg,alt);
				g2d.fill(rt);
			}
		}
		
		for(int i=0;i<32;i++) {
			g2d.setPaint(Color.red);
			g2d.draw(ln1[i]);
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
		x-=xIni;
		y-=yIni;
		
		x = Math.floor(x/larg);
		y = Math.floor(y/alt);
		if(x>=0 && y>=0 && x<=15 && y<=15) {
			if(ctrl.getAtaque((int)y,(int)x) == false) {

				FRGanhador g = new FRGanhador(this.m, ctrl, ctrl.getCtrlNomeVez());
				g.setBackground(Color.red);
				g.setVisible(true);
				SwingUtilities.getWindowAncestor(this).dispose();
			}
			else {
				int ultimoTiro = ctrl.getUltimoTiro();
				if(ultimoTiro == 1) {
					navio = "hidroaviao";
				}
				if(ultimoTiro == 2) {
					navio = "submarino";
				}
				if(ultimoTiro == 3) {
					navio = "destroyer";
				}
				if(ultimoTiro == 4) {
					navio = "cruzador";
				}
				if(ultimoTiro == 5) {
					navio = "couracado";
				}
				situacao.setText("Parte do " + navio + " acertada");
				if(ultimoTiro == 10) {
					situacao.setText("Tiro na agua");
				}
				if(ctrl.fimDeVez() == true){
					salvar.setEnabled(true);
					passarVez.setEnabled(true);
					salvar.addActionListener(new ActionListener() { //TODO: observer do salvar
						public void actionPerformed(ActionEvent e) {
							ctrl.salvarJogo(ctrl.getFimDeVez(), ctrl.getCtrlVez(), ctrl.getPontosJogador1() , ctrl.getPontosJogador2());
						}
					});
				}
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