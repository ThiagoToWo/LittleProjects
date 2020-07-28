package com.towo497;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Esta classe disp�e m�todos para v�rios c�lculos matem�ticos.
 * @autor Thiago de O. Alves
 * @version 1.2
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
	/**Este m�todo implementa o algoritmo de Elclides para calcular e retornar o m�ximo divisor comum
	 * (greatest common divisor) entre dois inteiros.
	 * @param m um n�mero inteiro positovo.
	 * @param n um n�mero inteiro positivo.
	 * @return O mdc dos par�metros.
	 * @since 1.0
	 */
	public static long gcd(long m, long n) {
		long r;
		if (m < n) {
			long temp = m;
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
	 * Este m�todo calcula e retorna o m�nimo m�ltiplo comum (least common multiple)
	 * entre dois inteiros.
	 * @param m um interior positivo
	 * @param n um inteiro positivo.
	 * @return o mmc dos par�metros.
	 * @since 1.2
	 */
	public static long lcm(long m, long n) {
		return m * n / gcd(m, n);
	}
	/**
	 * Este m�todo verifica se um n�mero inteiro � primo.
	 * @param n um n�mero inteiro.
	 * @return true se n for primo e false se n�o for.
	 * @since 1.0
	 */
	public static boolean isPrime(long n) {
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
	public static double p(double x, double[] coef) {
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
	 * @throws IllegalArgumentException se a entrada n�o satisfizer as condi��es n > 0, p > 0 e n > p.
	 * @throws ArithmeticException caso o resultado supere o valor de um long.	 
	 * @see ArithmeticException
	 * @see IllegalArgumentException
	 * @since 1.1
	 */
	public static long perm(int n, int p) {
		if (n < 0 || p < 0 || n < p) throw new IllegalArgumentException("wrong arguments");
		int arr = 1;
		for (int i = 1; i <= p; i++, n--)
			arr *= n;
		if (arr < 0) throw new ArithmeticException("long overflow");
		return arr;		
	}
	/**
	 * Este m�todo calcula e retorna a quantidade de subconjuntos de p itens 
	 * retirados de um conjunto de n elementos.
	 * @param n o total de elementos do conjunto.
	 * @param p o m�mero de elememtos da parte agrupada.
	 * @return A combina��o de n, p a p.
	 * @throws IllegalArgumentException se a entrada n�o satisfizer as condi��es n > 0, p > 0, n > p.
	 * @throws ArithmeticException caso o resultado supere o valor de um long.	 
	 * @see ArithmeticException
	 * @see IllegalArgumentException
	 * @since 1.1
	 */
	public static long comb(int n, int p) {
		if (n < 0 || p < 0 || n < p) throw new IllegalArgumentException("wrong arguments");
		long cmb = 1;
		for (int i = 1; i <= p; i++, n--)
			cmb = cmb * n / i;
		if (cmb < 0) throw new ArithmeticException("long overflow");
		return  cmb;		
	}
	/**
	 * Este m�todo imprime no console, atrav�s de um PrintStream conectado a um OutputStream dado 
	 * pelo par�metro, o tri�ngulo de Pascal at� uma determinada linha.
	 * O m�todo usa long comb(int, int) de MyMath, ent�o est� sujeito a suas exce��es, como estouro de long.
	 * @param output um objeto OutputStream (ex. System.out).
	 * @param line o n�mero de linhas do tri�ngulo, tendo a �ltima como 61.
	 * @throws ArithmeticException caso o valor de line seja maior que 61, pois nesse caso as linhas 
	 * n�o s�o completas por ocorrerem estouros de long. 
	 * @see PrintStream
	 * @see OutputStream
	 * @see long com.towo497.MyMath.comb(int n, int p)
	 * @see ArithmeticException
	 * @since 1.1
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
	 * @param file um objeto File (ex. new File("pascal.txt")).
	 * @param line o n�mero de linhas do tri�ngulo, tendo a �ltima como 61.
	 * @throws ArithmeticException caso o valor de line seja maior que 61, pois nesse caso as linhas 
	 * n�o s�o completas por ocorrerem estouros de long. 
	 * @see PrintStream
	 * @see File
	 * @see long com.towo497.MyMath.comb(int n, int p)
	 * @see ArithmeticException
	 * @see FileNotFoundException
	 * @since 1.1
	 */
	public static void printPascal(File file, int line) {
		if (line > 61) throw new ArithmeticException("long overflow");
		PrintStream p = null;
		try {
			p = new PrintStream(file);
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
	/**
	 * Este m�todo calcula e retorna o k-�simo d�gito do inteiro positivo n. Por exemplo, se n for o 
	 * inteiro 46785, a chamada digit(n, 0) retornaria o d�gito 5 e a chamada digit(n, 3) retornaria
	 * o d�gito 6. Observe que os d�gitos s�o numerados da direita para a esquerda come�ando pelo 
	 * d�gito "0".
	 * @param n o n�mero inteiro do qual se deseja extrair os d�gitos.
	 * @param k a posi��o do d�gito a ser extra�do, sendo k = 0 o d�gito da unidade.
	 * @return O d�gito da posi��o k no n�mero n.
	 * @since 1.2
	 */
	public static int digit(long n, int k) {
		for (int i = 0; i < k; i++)
			n /= 10;
		return (int) (n % 10);
	}
	/**
	 * Este m�todo calcula e retorna x elevado a n, onde n pode ser qualquer inteiro.
	 * @param x o valor da base.
	 * @param n o expoente, que pode ser um inteiro positivo ou negativo.
	 * @return x elevado a n.
	 * @throws ArithmeticException se x = 0 e n negativo.
	 * @since 1.2
	 */
	public static double pow(double x, int n) {
		if (x == 0 && n > 0) return 0;
		if (x == 0 && n < 0) throw new ArithmeticException("division by zero");
		if (n == 0) return 1;
		double y = 1;
		for (int i = 0; i < n; i++) 
			y *= x;
		for (int i = 0; i > n; i--)
			y /= x;
		return y;
	}
	/**
	 * Este m�todo verifica se um dado inteiro � um n�mero triangular. Os 10 primeiros n�meros
	 * triangulares s�o 0, 1, 3, 6, 10, 15, 21, 28, 36 e 45.
	 * @param n um n�mero inteiro positivo.
	 * @return True caso n seja triangular e false caso cont�rio.
	 * @since 1.2
	 */
	public static boolean isTriangular(int n) {
		int x = 0;
		int dx = 1;
		while (x < n) 
			x += dx++;
		if (x == n) return true;
		else return false;
	}
	/**
	 * Este m�todo verifica se um dado inteiro � um n�mero quadrado. Os 10 primeiros n�meros
	 * quadrados s�o 0, 1, 4, 9, 16, 25, 36, 49, 64 e 81.
	 * @param n um n�mero inteiro positivo.
	 * @return true caso n seja quadrado e false caso cont�rio.
	 * @since 1.2
	 */
	public static boolean isSquare(int n) {
		int x = 0;
		while (x * x < n)
			x++;
		if (x * x == n) return true;
		else return false;
	}
	/**
	 * Este m�todo verifica se um dado inteiro � um n�mero pentagonal. Os 10 primeiros n�meros
	 * pentagonais s�o 0, 1, 5, 12, 22, 35, 51, 70, 92 e 117.
	 * @param n um n�mero inteiro positivo.
	 * @return true caso n seja pentagonal e false caso cont�rio.
	 * @since 1.2
	 */
	public static boolean isPentagonal(int n) {
		int x = 0;
		int dx = 1;
		while (x < n) {
			x += dx;
			dx += 3;
		}
		if (x == n) return true;
		else return false;
	}
}
