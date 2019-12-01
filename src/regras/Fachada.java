package regras;

public class Fachada {
	CtrlRegras ctrl;
	static Fachada f=null;
	
	private Fachada() {
		ctrl=new CtrlRegras();
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
	
	public void getTabuleiroPronto() {
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
}
