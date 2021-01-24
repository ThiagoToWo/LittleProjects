package testes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class LeitorCSV {
	
	public static void main(String[] args) {
		ArrayList<String[]> listaDeAlunos = new ArrayList<String[]>();
		StringTokenizer stk;
		//ArrayList<ArrayList<String[]>> listaDeArquivos = new ArrayList<ArrayList<String[]>>();
		/*JFileChooser load = new JFileChooser();
		load.showOpenDialog(null);*/
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader("C:\\Users\\Thiago ToWo\\Downloads\\Registro de Frequência - 25.05.20 - Segunda.xlsx - Respostas ao formulário 1.csv")));
			String line = in.nextLine();
			while (in.hasNextLine()) {				
				line = in.nextLine();
				stk = new StringTokenizer(line, ",");
				String[] element = new String[stk.countTokens()];
				for (int i = 0; i < element.length; i++) {
					element[i] = stk.nextToken();
				}
				listaDeAlunos.add(element);
			}
			//listaDeArquivos.add(listaDeAlunos);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		print(listaDeAlunos,6);
	}
	
	private static void print(ArrayList<String[]> el, int ... is) {
		for (String[] e : el) {
			for (int i = 0; i < is.length; i++) {
				if (i % 2 == 0)	System.out.println(e[is[i]]);
				else System.out.println("\t" + e[is[i]]);
			}				
		}
	}
	
	private static void printComCondicao(ArrayList<String[]> el, String match, int colunaMatch, int ... colunaPrint) {
		for (String[] e : el) {
			System.out.println(Arrays.toString(e));
			if (e[colunaMatch].matches(match)) {
				for (int coluna : colunaPrint) {
					System.out.println("\t" + e[coluna]);
				}
			} else continue;							
		}
	}
}
