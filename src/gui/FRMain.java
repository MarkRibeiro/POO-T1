package gui;

import regras.*;

import java.awt.*;
import javax.swing.*;

public class FRMain extends JFrame {
	final int LARG_WINDOW=1300;
	final int ALT_WINDOW=700;
	
	public FRMain(CtrlRegras c) {
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension screenSize=tk.getScreenSize();
		int sl=screenSize.width;
		int sa=screenSize.height;
		int x=sl/2-LARG_WINDOW/2;
		int y=sa/2-ALT_WINDOW/2;
		setBounds(x,y,LARG_WINDOW,ALT_WINDOW);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().add(new PNArmas(c));
		//getContentPane().add(new PNBatalha(c));
		setTitle("Batalha Naval");
	}
	
	public static void main(String args[]) {	
		(new FRLogin()).setVisible(true);
		
	}
}
