package gui;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

public class ConjuntoArmas {

	public void hidroaviao(Graphics2D g2d,  double xIni, double yIni, double larg , double alt) {
		Rectangle2D rt;
		double desloca = 0;
		g2d.setPaint(Color.green);
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
}
