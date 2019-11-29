package gui;

import java.awt.Color;

public class Arma {
	
	private double tamanho;
	private int matriz[][];
	private String tipo;

	public Arma(int armaMatriz[][], double tamanhoArma, String tipo ) {
		this.tamanho = tamanhoArma;
		this.matriz = armaMatriz;
		this.tipo = tipo;
	}
		public int[][] getMatriz(){
			return this.matriz;		
		}
		
		public double getTamanho() {
			return this.tamanho;
		}
		
		public String getTipo() {
			return this.tipo;
		}
	
		public void viraArma(){
			boolean virou = false;
			int auxMatriz[][] = new int[this.matriz[0].length][this.matriz.length];
			for(int i=0; i < this.matriz.length; i++) {
				for(int j=0; j < this.matriz[0].length; j++) {
					auxMatriz[j][i] = this.matriz[i][j];
					virou = true;
				}
			}
			this.matriz = auxMatriz;
			if(virou == true) {
				int auxMatriz2[][] = new int[auxMatriz.length][auxMatriz[0].length];
				for(int i=0; i < auxMatriz.length; i++) {{
						auxMatriz2[i] = auxMatriz[auxMatriz.length-i-1];
						virou = false;
					}
				}
				this.matriz = auxMatriz2;
			}
		}
		
}
