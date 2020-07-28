package com.towo497;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Esta classe disp�e m�todos para v�rios c�lculos matem�ticos.
 * @autor Thiago de O. Alves
 * @version 1.1
 */ 
public class MyMath {
	/**
	 * Este m�todo calcula e retorna a m�dia dos n�meros de um array.
	 * @param termos um array com os valores a serem cauculados a m�dia.
	 * @return A m�dia dos valores contidos no par�metro.
	 * @since 1.0
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
	 * @throw ArithmeticException se o resultado supera um long.	 
	 * @see ArithmeticException.
	 * @since 1.0
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
	 * @return O mdc dos par�metros.
	 * @since 1.0
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
	 * @since 1.0
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
	 * @param coeficientes o array contendo os coeficientes na ordem do termo independente
	 * (coef[0]) para o termo dominante (coef[n]), onde n, o �ndice do elemento do array � o grau de seu
	 * termo no polin�mio.
	 * @return O valor num�rio do polin�mio em x.
	 * @since 1.1
	 */	
	public static double polinomio(double x, double[] coef) {
		int gr = coef.length - 1;
		double sum = coef[gr];
		for (int i = gr - 1; i >= 0; i--) {
			sum *= x;
			sum += coef[i];
		}
		return sum;
	}
	/**
	 * Este m�todo calcula e retorna a quantidade de permuta��es de p itens 
	 * retirados de um conjunto de n elementos.
	 * @param n o total de elementos do conjunto.
	 * @param p o m�mero de elememtos da parte agrupada.
	 * @return O arranjo de n, p a p.
	 * @throws ArithmeticException se a entrada n�o satisfizer as condi��es n > 0, p > 0 e n > p.	 
	 * @see ArithmeticException.
	 * @since 1.1
	 */
	public static long perm(int n, int p) {
		if (n < 0 || p < 0 || n < p) throw new ArithmeticException("wrong arguments");
		int arr = 1;
		for (int i = 1; i <= p; i++, n--)
			arr *= n;
		return arr;		
	}
	/**
	 * Este m�todo calcula e retorna a quantidade de subconjuntos de p itens 
	 * retirados de um conjunto de n elementos.
	 * @param n o total de elementos do conjunto.
	 * @param p o m�mero de elememtos da parte agrupada.
	 * @return A combina��o de n, p a p.
	 * @throws ArithmeticException se a entrada n�o satisfizer as condi��es n > 0, p > 0, n > p
	 * ou se o valor superar um long.	 
	 * @see ArithmeticException.
	 * @since 1.1
	 */
	public static long comb(int n, int p) {
		if (n < 0 || p < 0 || n < p) throw new ArithmeticException("wrong arguments");
		long cmb = 1;
		for (int i = 1; i <= p; i++, n--)
			cmb = cmb * n / i;
		if (cmb < 0) throw new ArithmeticException("long overflow");
		return  cmb;		
	}
	/**
	 * Este m�todo imprime no console, atrav�s de um PrintStream conectado a um OutputStream dado 
	 * pelo par�metro, o tri�ngulo de Pascal at� uma determinada linha.
	 * O m�todo usa long comb(int, int), ent�o est� sujeito a suas exce��es, como estouro de long.
	 * @param output um objeto OutputStream (ex. System.out).
	 * @param line o n�mero de linhas do tri�ngulo, tendo a �ltima como 61.
	 * @throws ArithmeticException caso o valor de line seja maior que 61, pois nesse caso as linhas 
	 * n�o s�o completas por ocorrerem estouros de long. 
	 * @see PrintStream, OutputStream, comb(int n, int p), ArithmeticException.
	 */
	public static void printPascal(OutputStream output, int line) {
		if (line > 61) throw new ArithmeticException("long overflow");
		PrintStream p = new PrintStream(output);
		for (int i = 0; i <= line; i++) {
			p.print(i + ":\t");
			for (int j = 0; j <= i; j++)
				p.printf("%d\t", comb(i, j));
			p.println();
		}		
	}
	/**
	 * Este m�todo imprime em um arquivo de texto o tri�ngulo de Pascal at� uma determinada linha.
	 * O m�todo usa long comb(int, int) de MyMath, ent�o est� sujeito a suas exce��es, como estouro de long.
	 * @param output um objeto File (ex. new File("pascal.txt")).
	 * @param line o n�mero de linhas do tri�ngulo, tendo a �ltima como 61.
	 * @throws ArithmeticException caso o valor de line seja maior que 61, pois nesse caso as linhas 
	 * n�o s�o completas por ocorrerem estouros de long. 
	 * @see PrintStream, File, comb(int n, int p), ArithmeticException, FileNotFoundException.
	 * @since 1.1
	 */
	public static void printPascal(File output, int line) {
		if (line > 61) throw new ArithmeticException("long overflow");
		PrintStream p = null;
		try {
			p = new PrintStream(output);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		for (int i = 0; i <= line; i++) {
			p.print(i + ":\t");
			for (int j = 0; j <= i; j++)
				p.printf("%d\t", comb(i, j));
			p.println();
		}		
	}
}
