package com.towo497;
/**
 * Esta classe dispõe métodos para realizar aritmética com frações.
 * @autor Thiago de O. Alves
 * @version 1.0
 */ 
public class Rational {
	
	private int numerator;
	private int denominator;
	/**
	 * Constrói uma fração com o numerador e denominador informado como parâmetros
	 * e simplifica. Caso o numerador ou o denominador seja 0, a fração é configurada 
	 * para 0/1 como padrão. Caso apenas o denominador seja negativo, o sinal é transportado 
	 * para o numerador. A fração é simplificada usando long MyMath.gcd(long,long).
	 * @param numerator o numerador da fração
	 * @param denominator o denominador da fração
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
	 * Retorna uma fração que é resultado da soma entre a fração chamadora do 
	 * método e a passada como parâmetro.
	 * @param r fração a ser somada com a chamadora do método
	 * @return o resultado da soma de frações
	 * @since 1.0
	 */
	public Rational soma(Rational r) {
		int num = this.numerator * r.denominator + r.numerator * this.denominator;
		int den = this.denominator * r.denominator;
		return new Rational(num, den);
	}
	/**
	 * Retorna uma fração que é resultado da subtração entre a fração chamadora do 
	 * método e a passada como parâmetro.
	 * @param r fração a ser subtraída com a chamadora do método
	 * @return o resultado da subtração de frações.
	 * @since 1.0
	 */
	public Rational subtrai(Rational r) {
		int num = this.numerator * r.denominator - r.numerator * this.denominator;
		int den = this.denominator * r.denominator;
		return new Rational(num, den);
	}	
	/**
	 * Retorna uma fração que é resultado da multiplicação entre a fração chamadora do 
	 * método e a passada como parâmetro.
	 * @param r fração a ser multiplicada com a chamadora do método
	 * @return o resultado da multiplicação de frações.
	 * @since 1.0
	 */
	public Rational multiplica(Rational r) {
		int num = this.numerator * r.numerator;
		int den = this.denominator * r.denominator;
		return new Rational(num, den);
	}
	/**
	 * Retorna uma fração que é resultado da divisão entre a fração chamadora do 
	 * método e a passada como parâmetro.
	 * @param r fração a ser dividida com a chamadora do método
	 * @return o resultado da divisão de frações.
	 * @since 1.0
	 */
	public Rational divide(Rational r) {
		int num = this.numerator * r.denominator;
		int den = this.denominator * r.numerator;
		return new Rational(num, den);
	}
	/**
	 * Retorna um string com a representação da fração no formato N/D ou -N/D.
	 * @since 1.0
	 */
	public String toString() {
		return String.format("%d/%d", numerator, denominator);
	}
}
