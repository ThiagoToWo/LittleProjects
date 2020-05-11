package com.towo497;

public class QuadraticGraph {

		private double y;
		private double a, b, c;
		private int dominio;
		private double[] imagem;	
		//configurar função.
		public void setFunction(double a, double b, double c) {
			this.a = a;
			this.b = b;
			this.c = c;
		}		
		// configurar domínio.
		public void setDomain(int xMax) {
			dominio = xMax;
			imagem = new double[dominio + 1];
		}
		// calcular os valores da imagem e colocar em uma "tabela".
		public void tableCalc() {
			for (int x = 0; x <= dominio; x++) {
				y = a * x * x + b * x + c;
				imagem[x] = y;
			}
		}				
		// fazer o gráfico de cada elemento da tabela.
		public void build() {
			for (int x = 0; x <= dominio; x++) { 
				for (double im = imagem[x]; im > 0; im--) {
					System.out.print("_");
				}
				System.out.println(imagem[x]);
			}
		}	
}
