package regras;

import java.io.File;

public class Fachada {
	CtrlRegras ctrl;
	static Fachada f=null;
	
	private Fachada() {
		ctrl=CtrlRegras.global;
	}
	
	public void resetCtrl(){
		ctrl.reset();
		ctrl = CtrlRegras.global;
	}
	
	public static Fachada getFachada() {
		if(f==null)
			f=new Fachada();
		
		return f;	
	}
	
	public void getImportaNomes(String n1, String n2) {
		ctrl.importaNomes(n1, n2); 
	}
	
	public String getCtrlNomeVez(){
		return ctrl.getNomeVez();
	}
	
	
	public int[][] getCtrlMatriz() {
		return ctrl.getMatriz();
	}
	
	public int getCtrlVez() {
		return ctrl.getVez();
	}
	
	public void getSoltaMouse(int linha, int coluna, int tipo) {
		ctrl.soltaMouse(linha, coluna, tipo);
	}
	
	public boolean getAtaque(int linha, int coluna) {
		return ctrl.ataque(linha, coluna);
	}
	
	public void tabuleiroPronto() {
		ctrl.tabuleiroPronto();
	}
	
	public void getPainel(TrocaTabuleiros painel) {
		ctrl.setPainel(painel);
	}
	

	public String getCtrlNomeOponente(){
		return ctrl.getNomeOponente();
	}
	
	public int[][] getMascaraTabuleiro1() {
		return ctrl.getMascaraTabuleiro1();
	}
	
	public int[][] getMascaraTabuleiro2() {
		return ctrl.getMascaraTabuleiro2();
	}
		
	public int[][] getTabuleiro1(){
		return ctrl.getTabuleiro1();
	}
	
	public int [][] getTabuleiro2(){
		return ctrl.getTabuleiro2();
	}
	
	public void passaVez() {
		ctrl.passaVez();
	}
	
	public boolean fimDeVez() {
		return ctrl.fimDeVez();
	}
	public boolean checarQuadrado(int x, int y) {
		return ctrl.checarQuadrado(x, y);
	}
	
	public void salvarJogo(boolean tresAtaques, int vez, int pontos1, int pontos2, File arquivo) {
		ctrl.salvarJogo(tresAtaques, vez, pontos1, pontos2, arquivo);
	}
	
	public boolean getFimDeVez() {
		return ctrl.fimDeVez();
	}
	
	public int getPontosJogador1() {
		return ctrl.PontosJ1();
	}
	
	public int getPontosJogador2() {
		return ctrl.PontosJ2();
	}

	public void carregarJogo(File BatalhNaval) {
		ctrl.carregarJogo(BatalhNaval);
	}
	
	public int getUltimoTiro() {
		return ctrl.getUltimoTiro();
	}
	
	public void addObserver(Observer o) {
		ctrl.addObserver(o);
	}

	public void removeObserver(Observer o) {
		ctrl.removeObserver(o);
	}
}
