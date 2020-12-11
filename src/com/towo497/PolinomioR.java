package com.towo497;

public class PolinomioR {
	private double[] coef;
	private int grau;
	
	public PolinomioR(double[] coef) {
		this.coef = coef;
		grau = coef.length;
	}
	
	public double getCoeficiente(int i) {
		return coef[i];
	}
	
	private double[] getCoeficientes() {
		return coef;
	}
	
	public int getGrau() {
		return grau;
	}
	
	/*public PolinomioR soma(PolinomioR p) {
		
	}*/
	
	public String toString() {
		String pol = "" + getCoeficiente(0);
		for (int i = 1; i < getGrau(); i++ ) {
			pol += (getCoeficiente(i) >= 0 ? " +" + getCoeficiente(i) : " " + getCoeficiente(i)) 
					+ "x" + (i == 1 ? "" : "^" + i);
		}
		return pol;
	}
}
