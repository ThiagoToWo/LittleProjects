package recursosDeapps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

// classe responsável pela janela do aplicativo
public class JanelaDeTexto extends JFrame{
	
	private JTextArea areaDeTexto;	
	private JScrollPane barraDeRolagem;
	private String autor = "Autor: Thiago de Oliveira Alves\ntowo497@gmail.com";
	private String versao = "Versão: 1.0 \n 13-04-2020\n\n";
	
	
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

	public JScrollPane getBarraDeRolagem() {
		return barraDeRolagem;
	}

	public void setBarraDeRolagem(JScrollPane barraDeRolagem) {
		this.barraDeRolagem = barraDeRolagem;
	}	
	
	public JTextArea getAreaDeTexto() {
		return areaDeTexto;
	}

	public void setAreaDeTexto(JTextArea areaDeTexto) {
		this.areaDeTexto = areaDeTexto;
	}

	// constrói a janela do aplicativo
	public void construir() {
		
		// cria e configura barra de menu
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
		
		JPanel background = new JPanel();
		background.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		background.setLayout(new BoxLayout(background, BoxLayout.Y_AXIS));
		areaDeTexto = new JTextArea(20, 10);
		areaDeTexto.setLineWrap(true);
		areaDeTexto.setEditable(false);			
		areaDeTexto.setCaretPosition(0);
		// cria configura e adiciona a barra de rolagem da área de texto ao painel de fundo
		barraDeRolagem = new JScrollPane(areaDeTexto);		
		background.add(barraDeRolagem);
		
		//adiciona os componentes no frame		
		add(background);		
		// configura o frame
		setSize(800, 1000);
		setLocation(600, 20);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}	
	
	public class AutorListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {			
			JOptionPane.showMessageDialog(null, autor, "Sobre mim", JOptionPane.INFORMATION_MESSAGE);

		}

	}
	
	public class VersaoListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane.showMessageDialog(null, versao, "Sobre este", JOptionPane.INFORMATION_MESSAGE);

		}

	}	
	
}

