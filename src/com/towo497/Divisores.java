package com.towo497;

public class Divisores {

	public static void main(String[] args) {
		int num = 72;
		
		// encontrar os pares de inteiros cujo produto é num e exibir eles.
		for (int d = 1; d * d <= num; d++) {
			int resto = num % d;
			if (resto == 0) {
				System.out.print("(" + d + ", " + num / d + ")" + " ");
			} 
		}

	}

}
