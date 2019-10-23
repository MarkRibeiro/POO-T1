package regras;

public class CtrlRegras {
	int vez=5;
	int jogadas = 9;
	int tabuleiro [][]= { 
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
	
	public int[][] getMatriz() {
		return tabuleiro;
	}
	
	public int getVez() {
		return vez;
	}	
	
	public void jogada(int linha, int coluna) {
		if (tabuleiro[linha][coluna]==0) {
			tabuleiro[linha][coluna]=getVez();
			if(vez==5) {
				vez=-1;
			}else {
				vez=5;
			}
		}
	}
	
	int quemGanhou() {
		int soma1 =0, soma2 = 0;
		for(int i=0;i<3;i++) {
			soma1 = soma2 = 0;
			for(int j =0;j<3;j++) {
				soma1 += tabuleiro[i][j];
				soma2 += tabuleiro[i][j];
			}
			if(soma1 == 15 || soma2 == 15) return 5;
			if(soma1 == -3 || soma2 == -3) return -1;
		}
		soma1 = soma2 = 0;
		for(int i =0;i<3;i++) {
		    soma1+= tabuleiro[i][i];
		    soma2=+tabuleiro[i][2-i];
		}
		if(soma1 == 15 || soma2 == 15) return 5;
		if(soma1 == -3 || soma2 == -3) return -1;
		if(jogadas==9) return 7;
		return 0;
	}
	
	
	
}
