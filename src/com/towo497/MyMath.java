package com.towo497;
/**
 * Esta classe dispõe métodos para vários cálculos matemáticos.
 * @autor Thiago de O. Alves
 * @version 1.0
 */ 
public class MyMath {
	/**
	 * Este método calcula e retorna a média dos números de um array.
	 * @param termos um array com os valores a serem cauculados a média.
	 * @return A média dos valores contidos no parâmetro.
	 */
	public static double media(double[] termos) {
		double soma = 0;
		for (int i = 0; i < termos.length; i++) {
			soma += termos[i];
		}
		return soma / termos.length;
	}
	/**
	 * Este método calcula e retorna o fatorial de um inteiro positivo.
	 * @param n um inteiro positivo de 0 a 20.
	 * @return O fatorial do parâmetro n ou lança uma ArithmeticException se o resultado estoura um long.
	 * @throws ArithmeticException se o resultado supera um long.	 
	 * @see ArithmeticException.
	 */
	public static long fatorial(int n) {
		if (n < 2) return 1;
		if (n > 20) throw new ArithmeticException("long overflow");
		long fac = 1;
		for (int i = 2; i <= n; i++) {
			fac *= i;
		}
		return fac;
	}
	/**Este método implementa o algoritmo de Elclides para calcular e retornar o mdc
	 * (máximo divisor comum) entre dois inteiros.
	 * @param m um número inteiro positovo.
	 * @param n um número inteiro positivo.
	 * @return O mdc dos parâmetros
	 */
	public static int mdc(int m, int n) {
		int r;
		if (m < n) {
			int temp = m;
			m = n;
			n = temp;
		}
		while (n > 0) {
			r = m % n;
			m = n;
			n = r;
		}
		return m;
	}
	/**
	 * Este método verifica se um número inteiro é primo.
	 * @param n um número inteiro.
	 * @return true se n for primo e false se não for.
	 */
	public static boolean isPrime(int n) {
		if (n < 0) n *= -1;
		if (n < 2) return false;
		if (n < 4) return true;
		if (n % 2 == 0) return false;
		for (int i = 3; i * i <= n; i++) 
			if (n % i == 0) return false;
		return true;		
	}
	/**
	 * Este método implementa o algoritmo de Horner para calcular o valor numérico de polinômios.
	 * @param x o valor numérico da variável x.
	 * @param coeficientes o array contendo os coeficientes na ordem do termo dominante
	 * (coeficientes[0]) para o termo independente.
	 * @return O valor numério do polinômio em x.
	 */	
	public static double polinomio(double x, double[] coeficientes) {
		double sum = coeficientes[0];
		for (int i = 1; i < coeficientes.length; i++) {
			sum *=x;
			sum += coeficientes[i];
		}
		return sum;
	}
}
