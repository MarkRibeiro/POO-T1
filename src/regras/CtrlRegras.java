package regras;

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
	
	public CtrlRegras() {
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
				if (getMatriz()[yf][xf] != 0) return false;
			}
		}
		return true;
	}
	
	public boolean ataque(int linha, int coluna) {
		if(getVez()==1 && mascaraTabuleiro2[linha][coluna] == 0 && jogadasNaRodada < 3) {
			if(tabuleiro2[linha][coluna] == 0)
				mascaraTabuleiro2[linha][coluna] = -1;
			else { 
				mascaraTabuleiro2[linha][coluna] = tabuleiro2[linha][coluna];
				pontosJ1 += tabuleiro2[linha][coluna];
				System.out.printf("pontosJ1: %d\n", pontosJ1);
			}
			jogadasNaRodada += 1;
		} else if(getVez()==2 && mascaraTabuleiro1[linha][coluna] == 0 && jogadasNaRodada < 3) {
			if(tabuleiro1[linha][coluna] == 0)
				mascaraTabuleiro1[linha][coluna] = -1;
			else {
				mascaraTabuleiro1[linha][coluna] = tabuleiro1[linha][coluna];
				pontosJ2 += tabuleiro1[linha][coluna];
				System.out.printf("pontosJ2: %d\n", pontosJ2);
			}
			jogadasNaRodada += 1;
		}
		return quemGanhou();
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
	
}
