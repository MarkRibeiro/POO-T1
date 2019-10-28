package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class ConjuntoArmas {

	public void hidroaviao(Graphics2D g2d,  double xIni, double yIni, double larg , double alt) {
		Rectangle2D rt;
		double desloca = 0;
		g2d.setPaint(new Color(64, 85, 27, 255));
		for (int i = 0; i<3 ;i++) {
			if(i == 2) {
				desloca=larg;
				rt=new Rectangle2D.Double(xIni+desloca,yIni-desloca,larg,alt);
			}
			else{
				rt=new Rectangle2D.Double(xIni+desloca,yIni,larg,alt);
				desloca=larg+larg;
			}
			g2d.fill(rt);
		}
	}
		
		public void destroyers(Graphics2D g2d,  double xIni, double yIni, double larg , double alt) {
			Rectangle2D rt;
			g2d.setPaint(new Color(255, 229, 72, 255));
			double desloca = 0;
			for (int i = 0; i<2 ;i++) {
					rt=new Rectangle2D.Double(xIni+desloca,yIni,larg,alt);
					g2d.fill(rt);
					desloca += larg;
			}
		}
		
		public void cruzadores(Graphics2D g2d,  double xIni, double yIni, double larg , double alt) {
			Rectangle2D rt;
			g2d.setPaint(new Color(255, 167, 27, 255));
			double desloca = 0;
			for (int i = 0; i<4 ;i++) {
					rt=new Rectangle2D.Double(xIni+desloca,yIni,larg,alt);
					g2d.fill(rt);
					desloca += larg;
			}
		}
		
		public void couracados(Graphics2D g2d,  double xIni, double yIni, double larg , double alt) {
			Rectangle2D rt;
			g2d.setPaint(Color.black);
			double desloca = 0;
			for (int i = 0; i < 5 ;i++) {
					rt=new Rectangle2D.Double(xIni+desloca,yIni,larg,alt);
					g2d.fill(rt);
					desloca += larg;
			}
		}
		
		public void submarinos(Graphics2D g2d,  double xIni, double yIni, double larg , double alt) {
			Rectangle2D rt;
			g2d.setPaint(Color.green);
			rt=new Rectangle2D.Double(xIni,yIni,larg,alt);
			g2d.fill(rt);
			}
		}
		

