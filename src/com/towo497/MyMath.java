package com.towo497;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintStream;

/**
 * Esta classe disp�e m�todos para v�rios c�lculos matem�ticos.
 * @autor Thiago de O. Alves
 * @version 1.4
 */ 
public class MyMath {
	/**
	 * Este m�todo calcula e retorna a m�dia dos n�meros de um array.
	 * @param t um array com os valores a serem cauculados a m�dia.
	 * @return A m�dia dos valores contidos no par�metro.
	 * @since 1.0
	 */
	public static double average(double[] t) {
		double soma = 0;
		for (int i = 0; i < t.length; i++) {
			soma += t[i];
		}
		return soma / t.length;
	}
	/**
	 * Este m�todo calcula e retorna o fatorial de um inteiro positivo.
	 * @param n um inteiro positivo de 0 a 20.
	 * @return O fatorial do par�metro n ou lan�a uma ArithmeticException se o resultado estoura um long.
	 * @throws ArithmeticException se o resultado supera um long.	 
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
	 * @return O mmc dos par�metros.
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
	 * Este m�todo preenche e retorna um array booleano de tamanho especificado 
	 * no par�metro onde apenas os �ndices primos s�o true.
	 * @param length o tamanho do array a ser retornado.
	 * @return Um array boolean de �ndices primos true.
	 * @since 1.3
	 */
	public static boolean[] sieve(int length) {
		boolean[] isPrime = new boolean[length];
		for (int i = 2; i < isPrime.length; i++)
			isPrime[i] = true;	
		for (int p = 2; p*p <= isPrime.length; p++)			
				for (int n = 2 * p; n < isPrime.length; n += p)
					isPrime[n] = false;
		return isPrime;
			
	}
	/**
	 * Este m�todo implementa o algoritmo de Horner para calcular o valor num�rico de polin�mios.
	 * @param x o valor num�rico da vari�vel x.
	 * @param coef o array contendo os coeficientes na ordem do termo independente
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
	 * @see com.towo497.MyMath#comb(int, int)
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
	 * @see com.towo497.MyMath#comb(int, int)
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
	 * @return true caso n seja triangular e false caso cont�rio.
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
	/**
	 * Este m�todo calcula e retorna o produto interno dos primeiros n elementos de dois arrays.
	 * @param s o primeiro array do produto interno.
	 * @param n o n�mero de elementos dos dois arrays envolvidos no produto interno entre eles.
	 * @param t o segundo array do produto interno.
	 * @return O produto interno dos primeiros n elementos de s e t.
	 * @since 1.3
	 */
	public static double innerProduct(double[] s, int n, double[] t) {
		double p = 0;
		for (int i = 0; i < n; i++)
			p += s[i] * t[i];
		return p;		
	}
	/**
	 * Este m�todo calcula e retorna o produto interno dos primeiros n elementos de dois arrays.
	 * @param s o primeiro array para o c�lculo do produto interno.
	 * @param n o n�mero de elementos dos dois arrays envolvidos no produto interno entre eles.
	 * @param t o segundo array para o c�lculo do produto interno.
	 * @return O produto interno dos primeiros n elementos de s e t.
	 * @since 1.3
	 */
	public static int innerProduct(int[] s, int n, int[] t) {
		int p = 0;
		for (int i = 0; i < n; i++)
			p += s[i] * t[i];
		return p;		
	}
	/**
	 * Este m�todo calcula e retorna o produto externo (array 3 x 3) dos tr�s
	 * primeiros elementos de dois arrays.
	 * @param s o primeiro array para o c�lculo do produto externo.
	 * @param t o segundo array para o c�lculo do produto externo.
	 * @return o produto externo 3 x 3 entre s e t.
	 * @since 1.3
	 */
	public static double[][] outerProduct3(double[] s, double[] t) {
		double[][] op = new double[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				op[i][j] = s[i] * t[j];
		return op;
	}
	/**
	 * Este m�todo calcula e retorna o produto externo (array 3 x 3) dos tr�s
	 * primeiros elementos de dois arrays.
	 * @param s o primeiro array para o c�lculo do produto externo.
	 * @param t o segundo array para o c�lculo do produto externo.
	 * @return o produto externo 3 x 3 entre s e t.
	 * @since 1.3
	 */
	public static int[][] outerProduct3(int[] s, int[] t) {
		int[][] op = new int[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				op[i][j] = s[i] * t[j];
		return op;
	}
	/**
	 * Este m�todo calcula e retorna o desvio absoluto m�dio dos elementos de um array. Este m�todo usa o 
	 * m�todo double average(double[]) de MyMath para calcular as m�dias necess�rias.
	 * @param t o array do qual se deseja extrair o desvio absoluto m�dio dos elementos.
	 * @return O desvio absoluto m�dio dos elementos do array passado como par�metro.
	 * @since 1.4
	 * @see com.towo497.MyMath#average(double[])
	 */
	public static double meandev(double[] t) {
		double[] dev = new double[t.length];
		double mean = average(t);
		for (int i = 0; i < t.length; i++)
			dev[i] = Math.abs(t[i] - mean);
		double md = average(dev);
		return md;		
	}
	/**
	 * Este m�todo calcula a m�dia dos elementos do array passado como par�metro e retorna um array com
	 * o desvio da m�dia de cada elemento respectivo deste array. Ele usa o m�todo double average(double[])
	 * de MyMath para calcular a m�dia desses elementos antes de calcular o desvio da m�dia.
	 * @param t o array do qual se deseja extrair o desvio da m�dia de cada elemento.
	 * @return Um array com o desvio da m�dia de cada elemento de t.
	 * @since 1.4
	 * @see com.towo497.MyMath#average(double[])
	 */
	public static double[] dev(double[] t) {
		double[] dev = new double[t.length];
		double mean = average(t);
		for (int i = 0; i < t.length; i++)
			dev[i] = t[i] - mean;
		return dev;		
	}
	/**
	 * Este m�todo calcula e retorna o desvio padr�o dos elementos de um array. Este m�todo usa o 
	 * m�todo double average(double[]) de MyMath para calcular a m�dia dos elementos do conjunto.
	 * @param t o array do qual se deseja extrair o desvio padr�o dos elementos.
	 * @return O desvio padr�o dos elementos do array passado como par�metro. � baseado na f�rmula
	 * sqrt(sum / (t.length - 1)).
	 * @since 1.4
	 * @see com.towo497.MyMath#average(double[])
	 * @see java.lang.Math#sqrt(double)
	 */
	public static double stdev(double[] t) {
		double dev = 0;
		double sum = 0;
		double mean = average(t);
		for (int i = 0; i < t.length; i++) {
			dev = t[i] - mean;
			sum += dev * dev;
		}	
		return Math.sqrt(sum / (t.length - 1));		
	}
	/**
	 * Este m�todo calcula e retorna um array com o escore padr�o, ou escore Z, de cada elemento de um
	 * array passado como par�metro. Ele usa os m�todos double average(double[]) e double stdev(double[])
	 * de MyMath para calcular a m�dia e o desvio padr�o desses elementos.
	 * @param t o array do qual se deseja extrair o escore padr�o de cada elemento.
	 * @return Um array com o escore padr�o de cada elemento de t.
	 * @since 1.4
	 * @see com.towo497.MyMath#average(double[])
	 * @see com.towo497.MyMath#stdev(double[])
	 */
	public static double[] z(double[] t) {
		double[] z = new double[t.length]; 
		double m = average(t);
		double s = stdev(t);
		for (int i = 0; i < t.length; i++)
			z[i] = (t[i] - m) / s;
		return z;
	}
	/**
	 * Este m�todo calcula e retorna um array com uma classifica��p de A a E para de cada elemento de um
	 * array passado como par�metro de acordo com sua posi��o na distribui��o normal (escore padr�o).
	 * A classifica��o � de acordo com a seguinte distribui��o:
	 * A: 1,5 <= z
	 * B: 0,5 <= z < 1,5
	 * C: -0,5 <= z < 0,5
	 * D: -1,5 <= z < -0,5 
	 * E: z < -1,5
	 * Desta forma, se os n�veis forem normalmente distribu�dos, este algoritmo produzir� aproximadamente
	 * 7% de As, 24% de Bs, 38% de Cs, 24% de Ds e 7% de Es. Aqui os valores de z s�o o escore padr�o.
	 * Ele usa os m�todos double average(double[]) e double stdev(double[]) de MyMath para calcular a m�dia
	 * e o desvio padr�o desses elementos.
	 * @param t o array do qual se deseja extrair a classifica��o de cada elemento.
	 * @return Um array com o escore padr�o de cada elemento de t.
	 * @since 1.4
	 * @see com.towo497.MyMath#average(double[])
	 * @see com.towo497.MyMath#stdev(double[])
	 */
	public static char[] grade(double[] t) {
		double[] z = new double[t.length]; 
		char[] g = new char[t.length];
		double m = average(t);
		double s = stdev(t);
		for (int i = 0; i < t.length; i++) {
			z[i] = (t[i] - m) / s;
			if (z[i] >= 1.5) g[i] = 'A';
			else if (z[i] >= 0.5) g[i] = 'B';
			else if (z[i] >= -0.5) g[i] = 'C';
			else if (z[i] >= -1.5) g[i] = 'D';
			else g[i] = 'E';
		}
		return g;
	}
}
