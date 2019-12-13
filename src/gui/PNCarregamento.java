package gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;



import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import regras.*;

public class PNCarregamento extends JPanel{
	ArrayList<Observer> obs=new ArrayList<Observer>(); 
	Fachada ctrl = Fachada.getFachada();
	
	
	final JFileChooser fc = new JFileChooser();	
	FileNameExtensionFilter filter = new FileNameExtensionFilter( "Batalha Naval", "txt");
	
	
	public PNCarregamento(FRInicio m) {
		JButton novo = new JButton();
		JButton carrega = new JButton();
		JLabel nome = new JLabel();
		
		nome.setText("Batalha Naval");
		Font n = nome.getFont().deriveFont(Font.BOLD, 35);
		nome.setFont(n);
		nome.setSize(nome.getPreferredSize());
		nome.setLocation(250-nome.getWidth()/2, 195-nome.getHeight()/2);
		add(nome);
		
		novo.setText("Novo Jogo");
		novo.setBounds(190, 235, 120, 30);
		
		
		
		novo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.chamaLogin();
			}
		});
				
		add(novo);
		fc.setFileFilter(filter); 
		carrega.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int returnVal = fc.showOpenDialog(getParent());
			    if(returnVal == JFileChooser.APPROVE_OPTION) {
			       System.out.println("Voce escolheu abrir o jogo: " +
			    		 fc.getSelectedFile().getName());
			       		File arquivo = fc.getSelectedFile();
			       		ctrl.carregarJogo(arquivo);
			       		m.carregaBatalha(new PNBatalha(m.getMain()));

			    }
		
			}
		});
		carrega.setText("Carregar Jogo");
		carrega.setBounds(190, 285, 120, 30);
		add(carrega);
		
		setLayout(null);
	}
		
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		Graphics2D g2d = (Graphics2D)g;
		try {
		    File pathToFile = new File("Navio.png");
		    Image image = ImageIO.read(pathToFile);
			g2d.drawImage(image, 160, 0, 180, 180, null);
		} catch (Exception e) {
			
		}
		
	}


}
