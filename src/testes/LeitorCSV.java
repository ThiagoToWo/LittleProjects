package testes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import javax.print.attribute.IntegerSyntax;
import javax.swing.JFileChooser;

public class LeitorCSV {
	
	public static void main(String[] args) {
		ArrayList<String[]> elementList = new ArrayList<String[]>();
		ArrayList<ArrayList<String[]>> listaDeProvas = new ArrayList<ArrayList<String[]>>();
		JFileChooser load = new JFileChooser();
		load.showOpenDialog(null);
		Scanner in;
		try {
			in = new Scanner(new BufferedReader(new FileReader(load.getSelectedFile())));
			while (in.hasNextLine()) {
				String line = in.nextLine();
				String[] element = line.split(",");
				elementList.add(element);
			}
			listaDeProvas.add(elementList);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		print(elementList, 2, 8);
	}
	
	private static void print(ArrayList<String[]> el, int ... is) {
		for (String[] e : el) {
			for (int i = 0; i < is.length; i++) {
				if (i % 2 == 0)	System.out.println(e[is[i]]);
				else System.out.println("\t" + e[is[i]]);
			}				
		}
	}
	
	
}
