import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ProcessaArquivo {
	
	private static final int TAMANHO_DA_AMOSTRA = 100;

	public static void leDados() throws FileNotFoundException, IOException {
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("saida_q1.dat")));
		try {
			String saida = "Amostra lida: ";
			for (int i = 0; i < TAMANHO_DA_AMOSTRA; i++) {
				saida += in.readFloat() + " ";
			}
			System.out.println(saida.trim());
		} finally {
			in.close();
		}
	}

	public static void calculaMedia() throws FileNotFoundException, IOException {
		ObjectInputStream in = new ObjectInputStream(new BufferedInputStream(new FileInputStream("saida_q1.dat")));
		float somaDosValores = 0;
		try {
			for (int i = 0; i < TAMANHO_DA_AMOSTRA; i++) {
				somaDosValores += in.readFloat();
			}
			System.out.println("A média dos dados é: " + (somaDosValores / TAMANHO_DA_AMOSTRA));
		} finally {
			in.close();
		}
		
		
	}

}
