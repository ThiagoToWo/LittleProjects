package com.towo497;
/**
 * Esta classe dispõe métodos para realizar operações com polinômios de coeficientes reais.
 * @autor Thiago de O. Alves
 * @version 1.0
 */ 
public class PolinomioR {
	private double[] coef;
	private int grau;
	/**
	 * Constrói um PolinomioR tendo como parâmetro um array de reais que representam os coeficientes
	 * de cada termo, onde o grau do termo é o índice do elemento no array. Por exemplo, o polinômio
	 * 21x³ + x² - 6x, teria como array de coeficientes {0, -6, 1, 21}.
	 * @param coef array dos coeficientes reais do polinômio.
	 * @since 1.0
	 */
	public PolinomioR(double[] coef) {
		this.coef = coef;
		grau = coef.length;
	}
	/**
	 * Retorna o coeficiente do termo de grau i. Por exemplo, para p = 21x³ + x² - 6x, p.getCoeficiente(2)
	 * retornaria 1.0.
	 * @param i grau do tremo no polinômio.
	 * @return coeficiente do termo de grau i.
	 * @since 1.0
	 */
	public double getCoeficiente(int i) {
		return coef[i];
	}
	
	private double[] getCoeficientes() {
		return coef;
	}
	/**
	 * Retorna o grau do polinômio. Ou seja, o expoente do termo de maior grau. Por exemplo,
	 * para p = 21x³ + x² - 6x, p.getGrau() retornaria 3.
	 * retornaria 1.0.
	 * @return o grau do polinômio.
	 * @since 1.0
	 */
	public int getGrau() {
		return grau;
	}
	/**
	 * Retorna o oposto ou simétrico do polinômio que chama o método. Ou seja, um polinômio onde
	 * os sinais dos tremos são trocados. Por exemplo, para p = 21x³ + x² - 6x, p.getOposto()
	 * retornaria pOp = -21x³ - x² + 6x.
	 * @return o polinômio oposto.
	 * @since 1.0
	 */
	public PolinomioR getOposto() {
		double[] op = new double[this.getGrau()];
		for (int i = 0; i < getGrau(); i++) {
			op[i] = -1 * coef[i];
		}
		return new PolinomioR(op);
	}
	/**
	 * Retorna um polinômio que é resultado da soma entre o polinômio chamador do 
	 * método e o passado como parâmetro. Este método usa o método estático {@link MyMath#somaVet(double[], double[])}
	 * para calcular a soma dos coeficientes.
	 * @param p polinômio a ser somado com o chamador do método.
	 * @return o resultado da soma de polinômios.
	 * @see MyMath#somaVet(double[], double[])
	 * @since 1.0
	 */
	public PolinomioR soma(PolinomioR p) {
		double[] soma = MyMath.somaVet(this.getCoeficientes(), p.getCoeficientes());
		return new PolinomioR(soma);
	}
	/**
	 * Retorna um polinômio que é resultado da subtração entre o polinômio chamador do 
	 * método e o passado como parâmetro. Este método usa o método estático {@link MyMath#somaVet(double[], double[])}
	 * para calcular a soma dos coeficientes.
	 * @param p polinômio a ser subtraído com o chamador do método.
	 * @return o resultado da subtração de polinômios.
	 * @see MyMath#somaVet(double[], double[])
	 * @since 1.0 
	 */
	public PolinomioR subtrai(PolinomioR p) {
		PolinomioR pOp = p.getOposto();
		double[] soma = MyMath.somaVet(this.getCoeficientes(), pOp.getCoeficientes());
		return new PolinomioR(soma);
	}
	/**
	 * Retorna um polinômio que é resultado da multiplicação entre o polinômio chamador do 
	 * método e o passado como parâmetro. 
	 * @param p polinômio a ser multiplicado com o chamador do método.
	 * @return o resultado da multiplicação de polinômios.
	 * @see MyMath#somaVet(double[], double[])
	 * @since 1.0
	 */
	public PolinomioR multiplica(PolinomioR p) {
		double[] mult = new double[this.getGrau() + p.getGrau() - 1];
		for (int i = 0; i < this.getGrau(); i++) {
			for (int j = 0; j < p.getGrau(); j++) {
				mult[i + j] += this.getCoeficiente(i) * p.getCoeficiente(j);
			}
		}
		return new PolinomioR(mult);
	}
	/**
	 * Retorna um string com a representação do polinômio no formato a0 +a1x +a2x^2 + ... +anx^n,
	 * onde a0, a1, a2, ..., an são os coeficientes.
	 * @since 1.0
	 */
	public String toString() {
		String pol = "" + getCoeficiente(0);
		for (int i = 1; i < getGrau(); i++ ) {
			pol += (getCoeficiente(i) >= 0 ? " +" + getCoeficiente(i) : " " + getCoeficiente(i)) 
					+ "x" + (i == 1 ? "" : "^" + i);
		}
		return pol;
	}
}
