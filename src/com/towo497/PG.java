package com.towo497;

import java.util.TreeSet;

public class PG {

	public static void main(String[] args) {
		// o quanto aumentou a popução mundial nos anos de 1950 a 2005, de 5 em 5 anos.
		double[] dPopulacao = {2518629, 2755823, 3021475, 3334874, 3692492, 4063587, 4434682,
				              4830979, 5263593, 567438, 6070581, 6453628}; 
		double p;
		int ano1 = 1950;
		int anoN = 2020;
		final int incremento = 5;
		TreeSet<Double> razao = new TreeSet<Double>();
		// calcular as possíveis razões e adicionar ao conjunto de razões.
		for (int n = 1; n < 5; n++) {
			double q = dPopulacao[n] / dPopulacao[n - 1];
			razao.add(q);
		}
		
		double qMin = razao.first();
		double qMax = razao.last();
		double q = Math.sqrt(qMin * qMax);
		System.out.println("Conjunto das diferentes taxas de crescimento = " + razao);		
		System.out.println("Razão mínima: " + qMin + "; razão máxima: " + qMax);
		System.out.println("---------------------------------------------------------------------------------------------"
				           + "----------------------------");
		System.out.println("Fórmula com a razão média do quanto a população vai aumentar no ano: " + 
				           dPopulacao[0] + " * " + q + " ^ ((ano - 1950) / " + incremento + ")");
		System.out.println("---------------------------------------------------------------------------------------------"
				           + "----------------------------");
		System.out.println("Aumento populacional nos próximos anos.");
		System.out.println("\nAno\tAumento Populacional");
		// calcula o aumento populacional em um intervalo dado e armazena em um array.
		for (int i = ano1; i <= anoN; i += incremento ) {			
			p = dPopulacao[0] * Math.pow (q, ((i - 1950) /  incremento));
			System.out.printf("%d\t%.0f%n", i, p);
		}
	}

}
