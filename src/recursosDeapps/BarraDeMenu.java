package recursosDeapps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class BarraDeMenu extends JMenuBar {
	
	private static final long serialVersionUID = 1L;
	private String autor = "Autor: Thiago de Oliveira Alves\ntowo497@gmail.com";
	private String versao = "Versão: 1.0 \n 13-04-2020\n\n";
	
	public BarraDeMenu() {
		JMenuBar barraDeMenu = new JMenuBar();
		JMenu menuSobre = new JMenu("Informações");
		JMenuItem autoria = new JMenuItem("Autor");
		autoria.addActionListener(new AutorListener());
		JMenuItem versao = new JMenuItem("Sobre o aplicativo");
		versao.addActionListener(new VersaoListener());
		menuSobre.add(autoria);
		menuSobre.add(versao);
		barraDeMenu.add(menuSobre);
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getVersao() {
		return versao;
	}

	public void setVersao(String versao) {
		this.versao = versao;
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
