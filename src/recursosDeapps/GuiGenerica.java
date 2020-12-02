package recursosDeapps;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GuiGenerica extends JFrame {
	private String autor = "Autor: Thiago de Oliveira Alves\ntowo497@gmail.com";
	private String versao = "Versão: 1.0 \n 13-04-2020\n\n";
	
	public void construir() {
		setTitle("");
		
		// barra de menu
		JMenuBar barraDeMenu = new JMenuBar();
		JMenu menuSobre = new JMenu("Informações");
		JMenuItem autoria = new JMenuItem("Autor");
		autoria.addActionListener(new AutorListener());
		JMenuItem versao = new JMenuItem("Sobre o aplicativo");
		versao.addActionListener(new VersaoListener());
		menuSobre.add(autoria);
		menuSobre.add(versao);
		barraDeMenu.add(menuSobre);
		setJMenuBar(barraDeMenu);
		
		// painel norte
		JPanel painelNorte = new JPanel();
		getContentPane().add(BorderLayout.NORTH, painelNorte);
		
		// painel central
		JPanel painelCentral = new JPanel();
		getContentPane().add(BorderLayout.CENTER, painelCentral);
		
		// painel sul
		JPanel painelSul = new JPanel();
		getContentPane().add(BorderLayout.SOUTH, painelSul);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocation(800, 100);
		setSize(300, 900);
		setVisible(true);
	}
	
	private class AutorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			JOptionPane.showMessageDialog(null, autor, "Sobre mim", JOptionPane.INFORMATION_MESSAGE);

		}

	}
	
	private class VersaoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, versao, "Sobre este", JOptionPane.INFORMATION_MESSAGE);

		}

	}	
	
}

