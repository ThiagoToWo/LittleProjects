package com.towo497;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class LatexMaker {

	public static void main(String[] args) {
		String cdgInit = "\\documentclass[12pt]{article}\r\n" + 
				"\r\n" + 
				"\\begin{document}\r\n" + 
				"Escreva alguma coisa e salve como .tex\n" + 
				"\\end{document}";
		ProcessBuilder pbtxt = new ProcessBuilder("notepad.exe", "testeLatex.txt");			
		ProcessBuilder pb = new ProcessBuilder("cmd","/c", "pdflatex", "testeLatex.tex");
		try {
			Process ptxt = pbtxt.start();
			BufferedWriter bw = new BufferedWriter(new FileWriter("testeLatex.txt"));
			bw.write(cdgInit);
			bw.close();
			ptxt.waitFor();
			Process p = pb.start();
			p.waitFor();
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));			
			String linha = null;
			while ((linha = br.readLine()) != null) {
				System.out.println(linha);
			}
			br.close();
		} catch (IOException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
