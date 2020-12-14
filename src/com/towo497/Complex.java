package com.towo497;
/**
 * Esta classe dispõe métodos para realizar operações com números complexos.
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
	 * Constrói um número complexo dados suas partes real e imaginária.
	 * @param real a parte real
	 * @param imag a parte imaginária
	 * @since 1.0
	 */
	public Complex(double real, double imag) {
		this.real = real;
		this.imag = imag;
		mod2 = real * real + imag * imag;
		mod = Math.sqrt(mod2);	
	}	
	/**
	 * Retorna a parte real do número complexo que chama o método.
	 * @return a parte real
	 * @since 1.0
	 */
	public double getReal() {
		return real;
	}
	/**
	 * Retorna a parte imaginária do número complexo que chama o método.
	 * @return a parte imaginária
	 * @since 1.0
	 */
	public double getImaginaria() {
		return imag;
	}
	/**
	 * Retorna o quadrado do módulo do número complexo que chama o método.
	 * @return o quadrado do módulo
	 * @since 1.0
	 */
	public double getModulo2() {;
		return mod2;
	}
	/**
	 * Retorna o módulo do número complexo que chama o método.
	 * @return o módulo
	 * @since 1.0
	 */
	public double getModulo() {
		return mod;
	}
	/**
	 * Retorna o conjugado do número complexo que chama o método.
	 * @return o conjugado
	 * @since 1.0
	 */
	public Complex getConjugado() {
		return new Complex(getReal(), -1 * getImaginaria());
	}
	/**
	 * Retorna o inverso do número complexo que chama o método.
	 * @return o inverso
	 * @since 1.0
	 */
	public Complex getInverso() {
		return new Complex(getReal() / mod2, -1 * getImaginaria() / mod2);
	}
	/**
	 * Configura o número de casas decimais das partes real e imaginária, podendo ir de 0 a 8 dígitos.
	 * O valor padrão é inicialmente de 4 dígitos.
	 * @param p a quantidade de dígitos decimais
	 * @since 1.0
	 */
	public static void setPrecisao(int p) {
		if (p < 0 || p > Double.BYTES) throw new IllegalArgumentException("precision out of the bounds [0, 8]");
		precis = p;
	}
	/**
	 * Retorna um complexo que é resultado da soma entre o complexo chamador do 
	 * método e o passado como parâmetro.
	 * @param c complexo a ser somado com o chamador do método
	 * @return o resultado da soma de complexos
	 * @since 1.0
	 */
	public Complex mais(Complex c) {
		double real = this.real + c.real;
		double imag = this.imag + c.imag;
		return new Complex(real, imag);
	}
	/**
	 * Retorna um complexo que é resultado da subtração entre o complexo chamador do 
	 * método e o passado como parâmetro.
	 * @param c complexo a ser subtraído com o chamador do método
	 * @return o resultado da subtração de complexos
	 * @since 1.0
	 */
	public Complex menos(Complex c) {
		double real = this.real - c.real;
		double imag = this.imag - c.imag;
		return new Complex(real, imag);
	}
	/**
	 * Retorna um complexo que é resultado da multiplicação entre o complexo chamador do 
	 * método e o passado como parâmetro.
	 * @param c complexo a ser multiplicado com o chamador do método
	 * @return o resultado da multiplicação de complexos
	 * @since 1.0
	 */
	public Complex vezes(Complex c) {
		double real = this.real * c.real - this.imag * c.imag;
		double imag = this.real * c.imag + this.imag * c.real ;
		return new Complex(real, imag);
	}
	/**
	 * Retorna um complexo que é resultado da divisão entre o complexo chamador do 
	 * método e o passado como parâmetro.
	 * @param c complexo a ser dividido com o chamador do método
	 * @return o resultado da divisão de complexos
	 * @since 1.0
	 */
	public Complex divididoPor(Complex c) {
		Complex invC = c.getInverso();		
		return this.vezes(invC);
	}	
	/**
	 * Retorna um string com a representação do número complexo no formato (R, I), onde
	 * R é a parte real e I a parte imaginária.
	 * @since 1.0
	 */
	public String toString() {
		return String.format("(%." + precis + "f, %." + precis + "f)",real, imag);
	}
}
