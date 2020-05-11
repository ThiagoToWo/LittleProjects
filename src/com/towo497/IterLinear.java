package com.towo497;

public class IterLinear {

	public static void main(String[] args) {
		double E = 0.5;
		// f(E) = M - E + e * sen(E) = 0
		for (int i = 1; i < 22; i++) {
			E = 0.5 + .2 * Math.sin(E);
			System.out.println(i + "\t" + E);
		}

	}

}
