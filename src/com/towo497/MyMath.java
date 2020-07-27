package com.towo497;
/**
 * Esta classe disp�e m�todos para v�rios c�lculos matem�ticos.
 * @autor Thiago de O. Alves
 * @version 1.0
 */ 
public class MyMath {
	/**
	 * Este m�todo calcula e retorna a m�dia dos n�meros de um array.
	 * @param termos um array com os valores a serem cauculados a m�dia.
	 * @return A m�dia dos valores contidos no par�metro.
	 */
	public static double media(double[] termos) {
		double soma = 0;
		for (int i = 0; i < termos.length; i++) {
			soma += termos[i];
		}
		return soma / termos.length;
	}
	/**
	 * Este m�todo calcula e retorna o fatorial de um inteiro positivo.
	 * @param n um inteiro positivo de 0 a 20.
	 * @return O fatorial do par�metro n ou lan�a uma ArithmeticException se o resultado estoura um long.
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
	/**Este m�todo implementa o algoritmo de Elclides para calcular e retornar o mdc
	 * (m�ximo divisor comum) entre dois inteiros.
	 * @param m um n�mero inteiro positovo.
	 * @param n um n�mero inteiro positivo.
	 * @return O mdc dos par�metros
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
	 * Este m�todo verifica se um n�mero inteiro � primo.
	 * @param n um n�mero inteiro.
	 * @return true se n for primo e false se n�o for.
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
	 * Este m�todo implementa o algoritmo de Horner para calcular o valor num�rico de polin�mios.
	 * @param x o valor num�rico da vari�vel x.
	 * @param coeficientes o array contendo os coeficientes na ordem do termo dominante
	 * (coeficientes[0]) para o termo independente.
	 * @return O valor num�rio do polin�mio em x.
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
