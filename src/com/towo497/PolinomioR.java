package com.towo497;
/**
 * Esta classe disp�e m�todos para realizar opera��es com polin�mios de coeficientes reais.
 * @autor Thiago de O. Alves
 * @version 1.0
 */ 
public class PolinomioR {
	private double[] coef;
	private int grau;
	/**
	 * Constr�i um PolinomioR tendo como par�metro um array de reais que representam os coeficientes
	 * de cada termo, onde o grau do termo � o �ndice do elemento no array. Por exemplo, o polin�mio
	 * 21x� + x� - 6x, teria como array de coeficientes {0, -6, 1, 21}.
	 * @param coef array dos coeficientes reais do polin�mio.
	 * @since 1.0
	 */
	public PolinomioR(double[] coef) {
		this.coef = coef;
		grau = coef.length;
	}
	/**
	 * Retorna o coeficiente do termo de grau i. Por exemplo, para p = 21x� + x� - 6x, p.getCoeficiente(2)
	 * retornaria 1.0.
	 * @param i grau do tremo no polin�mio.
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
	 * Retorna o grau do polin�mio. Ou seja, o expoente do termo de maior grau. Por exemplo,
	 * para p = 21x� + x� - 6x, p.getGrau() retornaria 3.
	 * retornaria 1.0.
	 * @return o grau do polin�mio.
	 * @since 1.0
	 */
	public int getGrau() {
		return grau;
	}
	/**
	 * Retorna o oposto ou sim�trico do polin�mio que chama o m�todo. Ou seja, um polin�mio onde
	 * os sinais dos tremos s�o trocados. Por exemplo, para p = 21x� + x� - 6x, p.getOposto()
	 * retornaria pOp = -21x� - x� + 6x.
	 * @return o polin�mio oposto.
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
	 * Retorna um polin�mio que � resultado da soma entre o polin�mio chamador do 
	 * m�todo e o passado como par�metro. Este m�todo usa o m�todo est�tico {@link MyMath#somaVet(double[], double[])}
	 * para calcular a soma dos coeficientes.
	 * @param p polin�mio a ser somado com o chamador do m�todo.
	 * @return o resultado da soma de polin�mios.
	 * @see MyMath#somaVet(double[], double[])
	 * @since 1.0
	 */
	public PolinomioR soma(PolinomioR p) {
		double[] soma = MyMath.somaVet(this.getCoeficientes(), p.getCoeficientes());
		return new PolinomioR(soma);
	}
	/**
	 * Retorna um polin�mio que � resultado da subtra��o entre o polin�mio chamador do 
	 * m�todo e o passado como par�metro. Este m�todo usa o m�todo est�tico {@link MyMath#somaVet(double[], double[])}
	 * para calcular a soma dos coeficientes.
	 * @param p polin�mio a ser subtra�do com o chamador do m�todo.
	 * @return o resultado da subtra��o de polin�mios.
	 * @see MyMath#somaVet(double[], double[])
	 * @since 1.0 
	 */
	public PolinomioR subtrai(PolinomioR p) {
		PolinomioR pOp = p.getOposto();
		double[] soma = MyMath.somaVet(this.getCoeficientes(), pOp.getCoeficientes());
		return new PolinomioR(soma);
	}
	/**
	 * Retorna um polin�mio que � resultado da multiplica��o entre o polin�mio chamador do 
	 * m�todo e o passado como par�metro. 
	 * @param p polin�mio a ser multiplicado com o chamador do m�todo.
	 * @return o resultado da multiplica��o de polin�mios.
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
	 * Retorna um string com a representa��o do polin�mio no formato a0 +a1x +a2x^2 + ... +anx^n,
	 * onde a0, a1, a2, ..., an s�o os coeficientes.
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
