package com.towo497;
/**
 * Esta classe disp�e m�todos para realizar aritm�tica com fra��es.
 * @autor Thiago de O. Alves
 * @version 1.0
 */ 
public class Rational {
	
	private int numerator;
	private int denominator;
	/**
	 * Constr�i uma fra��o com o numerador e denominador informado como par�metros
	 * e simplifica. Caso o numerador ou o denominador seja 0, a fra��o � configurada 
	 * para 0/1 como padr�o. Caso apenas o denominador seja negativo, o sinal � transportado 
	 * para o numerador. A fra��o � simplificada usando long MyMath.gcd(long,long).
	 * @param numerator o numerador da fra��o
	 * @param denominator o denominador da fra��o
	 * @see com.towo497.MyMath#gcd(long, long)
	 * @since 1.0
	 */
	public Rational(int numerator, int denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		reduce();
	}
	
	private void reduce() {
		if (numerator == 0 || denominator == 0) {
			numerator = 0;
			denominator = 1;
			return;
		}
		if (denominator < 0) {
			denominator *= -1;
			numerator *= -1;
		}
		if (denominator == 1) return;
		long g = MyMath.gcd(numerator, denominator);
		numerator /= g;
		denominator /= g;
	}
	/**
	 * Retorna uma fra��o que � resultado da soma entre a fra��o chamadora do 
	 * m�todo e a passada como par�metro.
	 * @param r fra��o a ser somada com a chamadora do m�todo
	 * @return o resultado da soma de fra��es
	 * @since 1.0
	 */
	public Rational soma(Rational r) {
		int num = this.numerator * r.denominator + r.numerator * this.denominator;
		int den = this.denominator * r.denominator;
		return new Rational(num, den);
	}
	/**
	 * Retorna uma fra��o que � resultado da subtra��o entre a fra��o chamadora do 
	 * m�todo e a passada como par�metro.
	 * @param r fra��o a ser subtra�da com a chamadora do m�todo
	 * @return o resultado da subtra��o de fra��es.
	 * @since 1.0
	 */
	public Rational subtrai(Rational r) {
		int num = this.numerator * r.denominator - r.numerator * this.denominator;
		int den = this.denominator * r.denominator;
		return new Rational(num, den);
	}	
	/**
	 * Retorna uma fra��o que � resultado da multiplica��o entre a fra��o chamadora do 
	 * m�todo e a passada como par�metro.
	 * @param r fra��o a ser multiplicada com a chamadora do m�todo
	 * @return o resultado da multiplica��o de fra��es.
	 * @since 1.0
	 */
	public Rational multiplica(Rational r) {
		int num = this.numerator * r.numerator;
		int den = this.denominator * r.denominator;
		return new Rational(num, den);
	}
	/**
	 * Retorna uma fra��o que � resultado da divis�o entre a fra��o chamadora do 
	 * m�todo e a passada como par�metro.
	 * @param r fra��o a ser dividida com a chamadora do m�todo
	 * @return o resultado da divis�o de fra��es.
	 * @since 1.0
	 */
	public Rational divide(Rational r) {
		int num = this.numerator * r.denominator;
		int den = this.denominator * r.numerator;
		return new Rational(num, den);
	}
	/**
	 * Retorna um string com a representa��o da fra��o no formato N/D ou -N/D.
	 * @since 1.0
	 */
	public String toString() {
		return String.format("%d/%d", numerator, denominator);
	}
}
