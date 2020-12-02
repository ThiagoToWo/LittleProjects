package testes;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class PrintSymbol {

	public static void main(String[] args) throws IOException {
		OutputStreamWriter os = new OutputStreamWriter(System.out, "UTF-8");
		char sym = 916;
		os.write(sym);

	}

}
