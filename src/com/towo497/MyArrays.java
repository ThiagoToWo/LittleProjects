package com.towo497;

import java.util.Arrays;

/**
 * Esta classe disp�e m�todos para manipular arrays.
 * @autor Thiago de O. Alves
 * @version 1.1
 */ 
public class MyArrays {
	/**
	 * Este m�todo calcula e retorna o menor elemento de um array. 
	 * @param t um array de double.
	 * @return o menor elemento de t.
	 * @since 1.0
	 */
	public static double min(double[] t) {
		double min = t[0];
		for (int i = 1; i < t.length; i++)
			if (t[i] < min) min = t[i];
		return min;		
	}
	/**
	 * Este m�todo calcula e retorna o menor elemento de um array. 
	 * @param t um array de int.
	 * @return o menor elemento de t.
	 * @since 1.0
	 */
	public static int min(int[] t) {
		int min = t[0];
		for (int i = 1; i < t.length; i++)
			if (t[i] < min) min = t[i];
		return min;		
	}	
	/**
	 * Este m�todo calcula e retorna o menor elemento de um array bidimensional. 
	 * @param t um array de double bidimensional.
	 * @return o menor elemento de t.
	 * @since 1.0
	 */
	public static double min(double[][] t) {
		double min = t[0][0];
		for (int i = 0; i < t.length; i++)
			for (int j = 0; j < t[i].length; j++)
				if (t[i][j] < min) min = t[i][j];
		return min;		
	}
	/**
	 * Este m�todo calcula e retorna o menor elemento de um array bidimensional. 
	 * @param t um array de int bidimensional.
	 * @return o menor elemento de t.
	 * @since 1.0
	 */
	public static int min(int[][] t) {
		int min = t[0][0];
		for (int i = 0; i < t.length; i++)
			for (int j = 0; j < t[i].length; j++)
				if (t[i][j] < min) min = t[i][j];
		return min;		
	}
	/**
	 * Este m�todo calcula e retorna o maior elemento de um array. 
	 * @param t um array de double.
	 * @return o maior elemento de t.
	 * @since 1.0
	 */
	public static double max(double[] t) {
		double max = t[0];
		for (int i = 1; i < t.length; i++)
			if (t[i] > max) max = t[i];
		return max;		
	}
	/**
	 * Este m�todo calcula e retorna o maior elemento de um array. 
	 * @param t um array de int.
	 * @return o maior elemento de t.
	 * @since 1.0
	 */
	public static int max(int[] t) {
		int max = t[0];
		for (int i = 1; i < t.length; i++)
			if (t[i] > max) max = t[i];
		return max;		
	}
	/**
	 * Este m�todo calcula e retorna o maior elemento de um array bidimensional. 
	 * @param t um array de double bidimensional.
	 * @return o maior elemento de t.
	 * @since 1.0
	 */
	public static double max(double[][] t) {
		double max = t[0][0];
		for (int i = 0; i < t.length; i++)
			for (int j = 0; j < t[i].length; j++)
				if (t[i][j] > max) max = t[i][j];
		return max;		
	}
	/**
	 * Este m�todo calcula e retorna o maior elemento de um array bidimensional. 
	 * @param t um array de int bidimensional.
	 * @return o maior elemento de t.
	 * @since 1.0
	 */
	public static int max(int[][] t) {
		int max = t[0][0];
		for (int i = 0; i < t.length; i++)
			for (int j = 0; j < t[i].length; j++)
				if (t[i][j] > max) max = t[i][j];
		return max;		
	}
	/**
	 * Este m�todo retorna um array com os elementos extremos (m�nimo e m�ximo)
	 * do array passado como par�metro. 
	 * @param t um array de double.
	 * @return um array cujo primeiro elemento � o elemento m�nimo de t e o segundo � o elemento m�ximo.
	 * @since 1.0
	 */
	public static double[] getExtremes(double[] t) {
		double[] extremes = new double[2];
		double min = t[0];
		double max = t[0];
		for (int i = 1; i < t.length; i++) {
			if (t[i] < min) min = t[i];
			else if (t[i] > max) max = t[i];
		}
		extremes[0] = min;
		extremes[1] = max;
		return extremes;		
	}
	/**
	 * Este m�todo retorna um array com os elementos extremos (m�nimo e m�ximo)
	 * do array passado como par�metro. 
	 * @param t um array de int.
	 * @return um array cujo primeiro elemento � o elemento m�nimo de t e o segundo � o elemento m�ximo.
	 * @since 1.0
	 */
	public static int[] getExtremes(int[] t) {
		int[] extremes = new int[2];
		int min = t[0];
		int max = t[0];
		for (int i = 1; i < t.length; i++) {
			if (t[i] < min) min = t[i];
			else if (t[i] > max) max = t[i];
		}
		extremes[0] = min;
		extremes[1] = max;
		return extremes;		
	}
	/**
	 * Este m�todo retorna um array com os elementos extremos (m�nimo e m�ximo)
	 * do array bidimensional passado como par�metro. 
	 * @param t um array de double bidimensional.
	 * @return um array cujo primeiro elemento � o elemento m�nimo de t e o segundo � o elemento m�ximo.
	 * @since 1.0
	 */
	public static double[] getExtremes(double[][] t) {
		double[] extremes = new double[2];
		double min = t[0][0];
		double max = t[0][0];
		for (int i = 0; i < t.length; i++) 
			for (int j = 0; j < t[i].length; j++) {
				if (t[i][j] < min) min = t[i][j];
				else if (t[i][j] > max) max = t[i][j];
			}
		extremes[0] = min;
		extremes[1] = max;
		return extremes;		
	}
	/**
	 * Este m�todo retorna um array com os elementos extremos (m�nimo e m�ximo)
	 * do array bidimensional passado como par�metro. 
	 * @param t um array de int bidimensional.
	 * @return um array cujo primeiro elemento � o elemento m�nimo de t e o segundo � o elemento m�ximo.
	 * @since 1.0
	 */
	public static int[] getExtremes(int[][] t) {
		int[] extremes = new int[2];
		int min = t[0][0];
		int max = t[0][0];
		for (int i = 0; i < t.length; i++) 
			for (int j = 0; j < t[i].length; j++) {
				if (t[i][j] < min) min = t[i][j];
				else if (t[i][j] > max) max = t[i][j];
			}
		extremes[0] = min;
		extremes[1] = max;
		return extremes;		
	}
	/**
	 * Este m�todo calcula e retorna o �ndice do menor elemento de um array. 
	 * Se o elemento estiver repetido, ele retorna o da primeira ocorr�ncia dele no array.
	 * @param t um array de double.
	 * @return o �ndice do menor elemento de t.
	 * @since 1.0
	 */
	public static int minIndex(double[] t) {
		int j = 0;
		for (int i = 1; i < t.length; i++)
			if (t[i] < t[j]) j = i;
		return j;		
	}
	/**
	 * Este m�todo calcula e retorna o �ndice do menor elemento de um array. 
	 * Se o elemento estiver repetido, ele retorna o da primeira ocorr�ncia dele no array.
	 * @param t um array de int.
	 * @return o �ndice do menor elemento de t.
	 * @since 1.0
	 */
	public static int minIndex(int[] t) {
		int j = 0;
		for (int i = 1; i < t.length; i++)
			if (t[i] < t[j]) j = i;
		return j;		
	}
	/**
	 * Este m�todo calcula e retorna o �ndice do maior elemento de um array. 
	 * Se o elemento estiver repetido, ele retorna o da primeira ocorr�ncia dele no array.
	 * @param t um array de double.
	 * @return o �ndice do maior elemento de t.
	 * @since 1.0
	 */
	public static int maxIndex(double[] t) {
		int j = 0;
		for (int i = 1; i < t.length; i++)
			if (t[i] > t[j]) j = i;
		return j;		
	}
	/**
	 * Este m�todo calcula e retorna o �ndice do maior elemento de um array. 
	 * Se o elemento estiver repetido, ele retorna o da primeira ocorr�ncia dele no array.
	 * @param t um array de int.
	 * @return o �ndice do maior elemento de t.
	 * @since 1.0
	 */
	public static int maxIndex(int[] t) {
		int j = 0;
		for (int i = 1; i < t.length; i++)
			if (t[i] > t[j]) j = i;
		return j;		
	}
	/**
	 * Este m�todo conta e retorna a quantidade de vezes que um elemento aparece em um array;
	 * @param t um array de double.
	 * @param x o elemento que se deve calcular a frequ�ncia.
	 * @return a frequ�ncia de x em t.
	 * @since 1.0
	 */
	public static int frequency(double[] t, double x) {
		int count = 0;
		for (int i = 0; i < t.length; i++) 
			if (t[i] == x) count++;
		return count;
	}
	/**
	 * Este m�todo conta e retorna a quantidade de vezes que um elemento aparece em um array bidimensional;
	 * @param t um array de double bidimensional.
	 * @param x o elemento que se deve calcular a frequ�ncia.
	 * @return a frequ�ncia de x em t.
	 * @since 1.0
	 */
	public static int frequency(double[][] t, double x) {
		int count = 0;
		for (int i = 0; i < t.length; i++)
			for (int j = 0; j < t[i].length; j++)
			if (t[i][j] == x) count++;
		return count;
	}
	/**
	 * Este m�todo conta e retorna a quantidade de vezes que um elemento aparece em um array;
	 * @param t um array de int.
	 * @param x o elemento que se deve calcular a frequ�ncia.
	 * @return a frequ�ncia de x em t.
	 * @since 1.0
	 */
	public static int frequency(int[] t, int x) {
		int count = 0;
		for (int i = 0; i < t.length; i++) 
			if (t[i] == x) count++;
		return count;
	}
	/**
	 * Este m�todo conta e retorna a quantidade de vezes que um elemento aparece em um array bidimensional;
	 * @param t um array de int bidimensional.
	 * @param x o elemento que se deve calcular a frequ�ncia.
	 * @return a frequ�ncia de x em t.
	 * @since 1.0
	 */
	public static int frequency(int[][] t, int x) {
		int count = 0;
		for (int i = 0; i < t.length; i++)
			for (int j = 0; j < t[i].length; j++)
			if (t[i][j] == x) count++;
		return count;
	}
	/**
	 * Este m�todo conta e retorna a quantidade de vezes que um elemento aparece em um array;
	 * @param t um array de char.
	 * @param x o elemento que se deve calcular a frequ�ncia.
	 * @return a frequ�ncia de x em t.
	 * @since 1.0
	 */
	public static int frequency(char[] t, char x) {
		int count = 0;
		for (int i = 0; i < t.length; i++) 
			if (t[i] == x) count++;
		return count;
	}
	/**
	 * Este m�todo conta e retorna a quantidade de vezes que um elemento aparece em um array bidimensional;
	 * @param t um array de char bidimensional.
	 * @param x o elemento que se deve calcular a frequ�ncia.
	 * @return a frequ�ncia de x em t.
	 * @since 1.0
	 */
	public static int frequency(char[][] t, char x) {
		int count = 0;
		for (int i = 0; i < t.length; i++)
			for (int j = 0; j < t[i].length; j++)
			if (t[i][j] == x) count++;
		return count;
	}
	/**
	 * Este m�todo retorna um String contendo o conte�do do array;
	 * @param t o array cuja representa��o em String ser� retornada.
	 * @return a representa��o em String de t.
	 * @since 1.0
	 * @see java.util.Arrays#toString(double[]).
	 */
	public static String toString(double[] t) {
		return Arrays.toString(t);
	}
	/**
	 * Este m�todo retorna um String contendo o conte�do do array;
	 * @param t o array cuja representa��o em String ser� retornada.
	 * @return a representa��o em String de t.
	 * @since 1.0
	 * @see java.util.Arrays#toString(int[]).
	 */
	public static String toString(int[] t) {
		return Arrays.toString(t);
	}
	/**
	 * Este m�todo retorna um String contendo o conte�do do array;
	 * @param t o array cuja representa��o em String ser� retornada.
	 * @return a representa��o em String de t.
	 * @since 1.1
	 * @see java.util.Arrays#toString(char[]).
	 */
	public static String toString(char[] t) {
		return Arrays.toString(t);
	}
	/**
	 * Este m�todo retorna um String contendo o conte�do do array;
	 * @param t o array cuja representa��o em String ser� retornada.
	 * @return a representa��o em String de t.
	 * @since 1.0
	 * @see java.util.Arrays#toString(Object[]).
	 */
	public static String toString(Object[] t) {
		return Arrays.toString(t);
	}
	/**
	 * Este m�todo inverte a ordem dos elementos de um array.
	 * @param t o array ao qual a ordem dos elementos pretende ser invertida.
	 * @since 1.1
	 */
	public static void reverse(int[] t) {
		int n = t.length;
		for (int i = 0; i < n / 2; i++)
			swap(t, i, n - 1 - i);
	}		
	/**
	 * Este m�todo inverte a ordem dos elementos de um array.
	 * @param t o array ao qual a ordem dos elementos pretende ser invertida.
	 * @since 1.1
	 */
	public static void reverse(double[] t) {
		int n = t.length;
		for (int i = 0; i < n / 2; i++)
			t[i] = t[n - 1 - i];
	}
	/**
	 * Este m�todo troca de posi��o dois elementos de um array.
	 * @param t array do qual se deseja trocar a posi��o de elementos.
	 * @param i o �ndice do primeiro elemento a ser trocado.
	 * @param j o �ndice do segundo elemento a ser trocado.
	 * @since 1.1
	 */
	public static void swap(int[] t, int i, int j) {
		int temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}
	/**
	 * Este m�todo troca de posi��o dois elementos de um array.
	 * @param t array do qual se deseja trocar a posi��o de elementos.
	 * @param i o �ndice do primeiro elemento a ser trocado.
	 * @param j o �ndice do segundo elemento a ser trocado.
	 * @since 1.1
	 */
	public static void swap(double[] t, int i, int j) {
		double temp = t[i];
		t[i] = t[j];
		t[j] = temp;
	}
}
