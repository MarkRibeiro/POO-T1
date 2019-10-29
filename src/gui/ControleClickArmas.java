package gui;

public class ControleClickArmas {
	
	public int submarino(double vetPontos[], double x, double y){
		if( vetPontos[0] >=x && vetPontos[1]>=y && vetPontos[0]+28<=x && vetPontos[1]+28<=y) {
			return 1;
		}else if(vetPontos[2] >=x && vetPontos[3]>=y && vetPontos[2]+28<=x && vetPontos[3]+28<=y){
			return 2;
		}else if(vetPontos[4] >=x && vetPontos[5]>=y && vetPontos[4]+28<=x && vetPontos[5]+28<=y){
			return 3;
		}else if(vetPontos[6] >=x && vetPontos[7]>=y && vetPontos[6]+28<=x && vetPontos[7]+28<=y){
			return 4;
		}
		else {
			return -1;
		}
	}
}
