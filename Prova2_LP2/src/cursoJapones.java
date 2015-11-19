
public class cursoJapones extends Curso {
	
	@Override
	public String cumprimenta(String nome) {
		return "Hajimemashite. Watashi ha " + nome + " desu.";
	}

	@Override
	public double calculaFacilidade(Proficiencia p) {
		return (p.getLeitura() * 0.4) + (p.getEscrita() * 0.6);
	}
	


}
