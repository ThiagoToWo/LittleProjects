package com.towo497;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.swing.JFileChooser;

public class CountChar {
	
	public static void main(String[] args) {
		char[] letras = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z'};
		int[] histo = new int[26];		
		JFileChooser arquivo = new JFileChooser();
		arquivo.showOpenDialog(null);
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(arquivo.getSelectedFile()));
			String linha = null;
			while ((linha = br.readLine()) != null) {
				linha = linha.toLowerCase();
				char[] letrasDaLinha = linha.toCharArray();	
				//System.out.println(letrasDaLinha);
				for (Character l : letrasDaLinha) {
					if (l - 'a' >= 0 && l - 'a' < 26)
					histo[l - 'a']++;					
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
		
		TreeMap<Integer,ArrayList<Character>> ranking = new TreeMap<Integer, ArrayList<Character>>();
		
		for (int i = 0; i < 26; i++) {
			if (!ranking.containsKey(histo[i])) {
				ArrayList<Character> temp = new ArrayList<Character>();
				ranking.put(histo[i], temp);
			}
			ranking.get(histo[i]).add(letras[i]);
		}
		
		Set<Map.Entry<Integer, ArrayList<Character>>> set = ranking.entrySet();
		
		System.out.println("Arquivo: " + arquivo.getSelectedFile().getName());
		System.out.println("Letra\tQuantidade");
		for (Map.Entry<Integer, ArrayList<Character>> t : set) {
			for (Character ch : t.getValue()) {
				System.out.println(ch + "\t" + t.getKey());
			}
			
		}	
	}
}

	