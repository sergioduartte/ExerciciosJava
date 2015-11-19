
public class Proficiencia {

	private static final String ERRO_HAB_INVALIDA = "Nivel de proficiencia invalido. Deve ser entre 0 e 10.";
	
	private double escrita;
	private double escuta;
	private double fala;
	private double leitura;

	public Proficiencia(double escrita, double escuta, double fala, double leitura) throws Exception {
		setEscrita(escrita);
		setEscuta(escuta);
		setFala(fala);
		setLeitura(leitura);
	}

	public double getEscrita() {
		return escrita;
	}

	public void setEscrita(double escrita) throws Exception {
		if (escrita < 0) {
			throw new Exception(ERRO_HAB_INVALIDA);
		}
		this.escrita = escrita;
	}

	public double getEscuta() {
		return escuta;
	}

	public void setEscuta(double escuta) throws Exception {
		if (escuta < 0) {
			throw new Exception(ERRO_HAB_INVALIDA);
		}
		this.escuta = escuta;
	}

	public double getFala() {
		return fala;
	}

	public void setFala(double fala) throws Exception {
		if (fala < 0) {
			throw new Exception(ERRO_HAB_INVALIDA);
		}
		this.fala = fala;
	}

	public double getLeitura() {
		return leitura;
	}

	public void setLeitura(double leitura) throws Exception {
		if (leitura < 0) {
			throw new Exception(ERRO_HAB_INVALIDA);
		}
		this.leitura = leitura;
	}
	
}
