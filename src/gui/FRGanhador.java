package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import regras.Fachada;

public class FRGanhador extends JFrame{
    final int LARG_WINDOW=500;
    final int ALT_WINDOW=400;

    public FRGanhador(FRMain m, Fachada ctrl, String ganhador) {
        setTitle("Vencedor");
        setSize(LARG_WINDOW,ALT_WINDOW);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        JLabel l1 = new JLabel();
        JButton maisUma = new JButton();
        JButton fim = new JButton();
        int xIni = 200, yIni = 40, yDist = 50;
        l1.setText(ganhador + " Ganhou!!!");
        l1.setBounds(195, yIni + yDist, 110, 30);

        maisUma.setText("Reiniciar");
        maisUma.setBounds(xIni, yIni + yDist*2, 100, 30);
        maisUma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Fachada ctrl = Fachada.getFachada();
            	ctrl.resetCtrl();
            	FRMain m = new FRMain();
            	FRInicio ini = new FRInicio(m);
            	ini.setVisible(true);
            	dispose();
            }
        });

        fim.setText("Finalizar");
        fim.setBounds(xIni, yIni + yDist*3, 100, 30);
        fim.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                 System.exit(0);
            }
        });
        
        add(l1);
        add(maisUma);
        add(fim);

        setLayout(null);
    }
}