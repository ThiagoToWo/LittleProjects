package testes;

public class Fatorial {

	public static void main(String[] args) {
		long n = 15;
		System.out.println(fatorial(n));		

	}
	
	static long fatorial(long x) {
		if (x == 0)
				return 1;
		else
			return x * fatorial(x - 1);				
	}
}
