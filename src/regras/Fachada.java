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
	
	public boolean getAtaque(int linha, int coluna, int tab) {
		return ctrl.ataque(linha, coluna, tab);
	}
	
	public void getTabuleiroPronto() {
		ctrl.tabuleiroPronto();
	}
	
	public void getPainel(TrocaTabuleiros painel) {
		ctrl.painel = painel;
	}
	
	public int[][] getMascaraTabuleiro1() {
		return ctrl.mascaraTabuleiro1;
	}
	
	public int[][] getMascaraTabuleiro2() {
		return ctrl.mascaraTabuleiro2;
	}
}
