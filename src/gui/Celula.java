package gui;

class Celula {
	double x,y;
	Arma arma;
	
	Celula(double x,double y) {
		this.x=x;
		this.y=y;
		this.arma = null;
	}
	
	Arma getArma() {
		return arma;
	}
	
}
