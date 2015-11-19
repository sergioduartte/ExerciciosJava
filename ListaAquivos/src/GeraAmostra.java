import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class GeraAmostra {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		geraAmostra();
		ProcessaArquivo.leDados();
		ProcessaArquivo.calculaMedia();
	}

	private static void geraAmostra() throws FileNotFoundException, IOException {
		ObjectOutputStream out = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream("saida_q1.dat")));
		try {
			for (int i = 0; i < 100 ; i++) {
				float valor = (float) (1.0 + (Math.random() * 100));
				out.writeFloat(valor);
			}
		} finally {
			out.close();
		}
	}
}
