package regras;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import gui.FRGanhador;

public class CtrlRegras {
	private int vez=1;
	private int jogadas = 9;
	private int prontos = 0;
	private int pontosJ1 = 0;
	private int pontosJ2 = 0;
	private int jogadasNaRodada = 0;
	private TrocaTabuleiros painel;
	private String jogadores[] = new String[2];
	static CtrlRegras global = new CtrlRegras();
	private int ultimoTiro;
	private int tabuleiro1 [][]= { 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	private int tabuleiro2 [][]= { 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	private int mascaraTabuleiro1 [][]= { 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	private int mascaraTabuleiro2 [][]= { 
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}};
	
	private CtrlRegras() {
	}
	
	public void reset() {
		global = new CtrlRegras();
	}
	
	public void importaNomes(String n1, String n2) {
		jogadores[0] = n1;
		jogadores[1] = n2;
	}
	
	public String getNomeOponente(){
		if(getVez() == 1) {
			return jogadores[1];
		}else {
			return jogadores[0];
		}
	}
	
	public String getNomeVez(){
		if(getVez() == 1) {
			return jogadores[0];
		}else {
			return jogadores[1];
		}
	}
	
	public int[][] getMatriz() {
		if(getVez() == 1) {
			return tabuleiro1;
		} else {
			return tabuleiro2;
		}
	}
	
	public int getVez() {
		return vez;
	}	
	
	public void soltaMouse(int linha, int coluna, int tipo) {
		if(getVez() == 1) {
			tabuleiro1[linha][coluna] = tipo;
		}else {
			tabuleiro2[linha][coluna] = tipo;
		}
	}
	
	boolean checarQuadrado(int x, int y) {
		if ((x < 0 || x >= 15) || (y < 0 || y >= 15)) {
			return false;
		}
		for (int xoff = -1; xoff <= 1; xoff++) {
			for (int yoff = -1; yoff <= 1; yoff++) {
				int xf = x + xoff;
				int yf = y + yoff;
				if ((xf < 0 || xf >= 15) || (yf < 0 || yf >= 15)) {
					continue;
				}
				if (getMatriz()[yf][xf] != 0) {
					return false;
				}
			}
		}
		return true;
	}
	
	public boolean ataque(int linha, int coluna) {
		if(getVez()==1 && mascaraTabuleiro2[linha][coluna] == 0 && jogadasNaRodada < 3) {
			if(tabuleiro2[linha][coluna] == 0) {
				mascaraTabuleiro2[linha][coluna] = 10;
				tabuleiro2[linha][coluna] = 10;
			}
			else { 
				if(mascaraTabuleiro2[linha][coluna]<0) {
					mascaraTabuleiro2[linha][coluna] = (tabuleiro2[linha][coluna]);
				}else {
					mascaraTabuleiro2[linha][coluna] = (tabuleiro2[linha][coluna]*-1);
				}
				pontosJ1 += tabuleiro2[linha][coluna];

				System.out.printf("pontosJ1: %d\n", pontosJ1);
			}
			ultimoTiro = tabuleiro2[linha][coluna];
			jogadasNaRodada += 1;
		} else if(getVez()==2 && mascaraTabuleiro1[linha][coluna] == 0 && jogadasNaRodada < 3) {
			if(tabuleiro1[linha][coluna] == 0) {
				mascaraTabuleiro1[linha][coluna] = 10;
				tabuleiro1[linha][coluna] = 10;
			}
			else {
				if(mascaraTabuleiro1[linha][coluna]<0) {
					mascaraTabuleiro1[linha][coluna] = (tabuleiro1[linha][coluna]);
				}else {
					mascaraTabuleiro1[linha][coluna] = (tabuleiro1[linha][coluna]*-1);
				}
				pontosJ2 += tabuleiro1[linha][coluna];
				
				System.out.printf("pontosJ2: %d\n", pontosJ2);
			}
			ultimoTiro = tabuleiro1[linha][coluna];
			jogadasNaRodada += 1;
		}
		return quemGanhou();
	}
	
	public int getUltimoTiro() {
		return ultimoTiro;
	}
	
	boolean quemGanhou() {
		// TODO: Mudar de 10 para 98
		if(pontosJ1 == 10) {
			return false;
		} else if(pontosJ2 == 10) {
			return false;
		}
		return true;
	}
	
	public void tabuleiroPronto() {
		prontos += 1;
		if(prontos == 2) {
			painel.trocaTabuleiros();
			vez = 1;
			painel.fimPosicionamento();
			painel.atualizaInterface();
		}else {
			painel.trocaTabuleiros();
			vez=2;
			painel.atualizaInterface();
		}
	}
	
	public void passaVez() {
		if(getVez() == 1)
			vez = 2;
		else if(getVez() == 2)
			vez = 1;
		
		jogadasNaRodada = 0;
	}
	
	
	public void salvarJogo(boolean fimDeVez, int vez, int pontos1, int pontos2 ) {
		if(fimDeVez == true) {
			File arquivo;
			FileWriter fr = null;
			String arq = "";
			try {
				arquivo = new File("BatalhaNaval.txt");
				fr = new FileWriter(arquivo);
				
				/*Salvar tabuleiro 1*/
				for (int i = 0; i<15; i++) {
					for (int j = 0; j < 15; j++) {
						if(mascaraTabuleiro1[j][i]<0) {
							arq = arq + Integer.toString(mascaraTabuleiro1[j][i]);
						} else {
							arq = arq + Integer.toString(tabuleiro1[j][i]);
						}
						if(i == 14 && j == 14) {
							arq = arq + "\n";
 						} else {
 							arq = arq + ";"; 
 						}
						
					}
				}
				
				/*Salvar tabuleiro 2*/
				for (int i = 0; i<15; i++) {
					for (int j = 0; j < 15; j++) {
						if(mascaraTabuleiro1[j][i]<0) {
							arq = arq + Integer.toString(mascaraTabuleiro1[j][i]);
						} else {
							arq = arq + Integer.toString(tabuleiro1[j][i]);
						}
						if(i == 14 && j == 14) {
							arq = arq + "\n";
 						} else {
 							arq = arq + ";"; 
 						}
						
					}
				}
				
				arq = arq + Integer.toString(vez) + "\n";
				arq = arq + Integer.toString(pontos1) + "\n";
				arq = arq + Integer.toString(pontos2) + "\n";
				arq = arq + jogadores[0] + "\n" + jogadores[1] + "\n";
				
				fr.write(arq);
			} catch (IOException e1) {
				e1.printStackTrace();
				
				
			} finally {
				try {
					fr.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
	
	
	public void carregarJogo(File BatalhaNaval) {
		String linha;
		int numLinha = 0;
		int quadrado;
		
		try {
			Scanner sc = new Scanner(BatalhaNaval); 
	    while (sc.hasNextLine()) {
	    	linha = sc.nextLine();
	    	String infoJogo[]= linha.split(";");
	    	int v =0 ;
	    	if(numLinha == 0) {
	    		for (int coluna = 0; coluna<15; coluna++) {
	    			for (int fileira = 0; fileira < 15; fileira++) {
	    	    		quadrado = Integer.parseInt(infoJogo[v++]);
	    				if(quadrado < 0 || quadrado == 10) {
	    					mascaraTabuleiro1[fileira][coluna] = quadrado;
	    				} else {
	    					tabuleiro1[fileira][coluna] = quadrado;
	    				}
	    			}
	    		}
	    	} else if (numLinha == 1){
	    		for (int coluna = 0; coluna <15; coluna ++) {
	    			for (int fileira = 0; fileira < 15; fileira++) {
		    			quadrado = Integer.parseInt(infoJogo[v++]);
	    				if(quadrado < 0 || quadrado == 10) {
	    					mascaraTabuleiro2[fileira][coluna] = quadrado;
	    				} else {
	    					tabuleiro2[fileira][coluna] = quadrado;
	    				}
	    			}
	    		}
	    	} else if (numLinha == 2) {
	    		vez = Integer.parseInt(infoJogo[0]);
	    	} else if (numLinha == 3) {
	    		pontosJ1 = Integer.parseInt(infoJogo[0]);
	    	} else if (numLinha == 4) {
	    		pontosJ2 = Integer.parseInt(infoJogo[0]);
		    } else if (numLinha == 5) {
		    	jogadores[0] = infoJogo[0];
		    } else {
		    	jogadores[1] = infoJogo[0];
		    }
	    	numLinha++;
	  } 
	    sc.close();
		}catch ( FileNotFoundException e) {
			e.printStackTrace();
			
			return;
		}
	}
	
	public boolean fimDeVez() {
		if(jogadasNaRodada == 3)
			return true;
		else
			return false;
	}
	
	public int[][] getTabuleiro1(){
		return this.tabuleiro1;
	}
	
	public int[][] getTabuleiro2(){
		return this.tabuleiro2;
	}
	
	public int[][] getMascaraTabuleiro1(){
		return this.mascaraTabuleiro1;
	}
	
	public int[][] getMascaraTabuleiro2(){
		return this.mascaraTabuleiro2;
	}
	
	public void setPainel(TrocaTabuleiros painel) {
		this.painel = painel;
	}
	
	public int PontosJ1() {
		return pontosJ1;
	}
	
	public int PontosJ2() {
		return pontosJ2;
	}
	
	
}
