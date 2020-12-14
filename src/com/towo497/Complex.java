package com.towo497;
/**
 * Esta classe disp�e m�todos para realizar opera��es com n�meros complexos.
 * @autor Thiago de O. Alves
 * @version 1.0
 */
public class Complex {
	
	private double real;
	private double imag;
	private double mod2;
	private double mod;
	private static int precis = 4;
	/**
	 * Constr�i um n�mero complexo dados suas partes real e imagin�ria.
	 * @param real a parte real
	 * @param imag a parte imagin�ria
	 * @since 1.0
	 */
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
		mod2 = real * real + imag * imag;
		mod = Math.sqrt(mod2);	
	}	
	/**
	 * Retorna a parte real do n�mero complexo que chama o m�todo.
	 * @return a parte real
	 * @since 1.0
	 */
	public double getReal() {
		return real;
	}
	/**
	 * Retorna a parte imagin�ria do n�mero complexo que chama o m�todo.
	 * @return a parte imagin�ria
	 * @since 1.0
	 */
	public double getImaginaria() {
		return imag;
	}
	/**
	 * Retorna o quadrado do m�dulo do n�mero complexo que chama o m�todo.
	 * @return o quadrado do m�dulo
	 * @since 1.0
	 */
	public double getModulo2() {;
		return mod2;
	}
	/**
	 * Retorna o m�dulo do n�mero complexo que chama o m�todo.
	 * @return o m�dulo
	 * @since 1.0
	 */
	public double getModulo() {
		return mod;
	}
	/**
	 * Retorna o conjugado do n�mero complexo que chama o m�todo.
	 * @return o conjugado
	 * @since 1.0
	 */
	public Complex getConjugado() {
		return new Complex(getReal(), -1 * getImaginaria());
	}
	/**
	 * Retorna o inverso do n�mero complexo que chama o m�todo.
	 * @return o inverso
	 * @since 1.0
	 */
	public Complex getInverso() {
		return new Complex(getReal() / mod2, -1 * getImaginaria() / mod2);
	}
	/**
	 * Configura o n�mero de casas decimais das partes real e imagin�ria, podendo ir de 0 a 8 d�gitos.
	 * O valor padr�o � inicialmente de 4 d�gitos.
	 * @param p a quantidade de d�gitos decimais
	 * @since 1.0
	 */
	public static void setPrecisao(int p) {
		if (p < 0 || p > Double.BYTES) throw new IllegalArgumentException("precision out of the bounds [0, 8]");
		precis = p;
	}
	/**
	 * Retorna um complexo que � resultado da soma entre o complexo chamador do 
	 * m�todo e o passado como par�metro.
	 * @param c complexo a ser somado com o chamador do m�todo
	 * @return o resultado da soma de complexos
	 * @since 1.0
	 */
	public Complex mais(Complex c) {
		double real = this.real + c.real;
		double imag = this.imag + c.imag;
		return new Complex(real, imag);
	}
	/**
	 * Retorna um complexo que � resultado da subtra��o entre o complexo chamador do 
	 * m�todo e o passado como par�metro.
	 * @param c complexo a ser subtra�do com o chamador do m�todo
	 * @return o resultado da subtra��o de complexos
	 * @since 1.0
	 */
	public Complex menos(Complex c) {
		double real = this.real - c.real;
		double imag = this.imag - c.imag;
		return new Complex(real, imag);
	}
	/**
	 * Retorna um complexo que � resultado da multiplica��o entre o complexo chamador do 
	 * m�todo e o passado como par�metro.
	 * @param c complexo a ser multiplicado com o chamador do m�todo
	 * @return o resultado da multiplica��o de complexos
	 * @since 1.0
	 */
	public Complex vezes(Complex c) {
		double real = this.real * c.real - this.imag * c.imag;
		double imag = this.real * c.imag + this.imag * c.real ;
		return new Complex(real, imag);
	}
	/**
	 * Retorna um complexo que � resultado da divis�o entre o complexo chamador do 
	 * m�todo e o passado como par�metro.
	 * @param c complexo a ser dividido com o chamador do m�todo
	 * @return o resultado da divis�o de complexos
	 * @since 1.0
	 */
	public Complex divididoPor(Complex c) {
		Complex invC = c.getInverso();		
		return this.vezes(invC);
	}	
	/**
	 * Retorna um string com a representa��o do n�mero complexo no formato (R, I), onde
	 * R � a parte real e I a parte imagin�ria.
	 * @since 1.0
	 */
	public String toString() {
		return String.format("(%." + precis + "f, %." + precis + "f)",real, imag);
	}
}
