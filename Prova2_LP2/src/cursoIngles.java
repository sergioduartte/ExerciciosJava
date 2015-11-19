
public class cursoIngles extends Curso {

	@Override
	public String cumprimenta(String nome) {
		return "Hello! I am "+ nome +". Nice to meet you.";
	}

	@Override
	public double calculaFacilidade(Proficiencia p) {
		return (0.1*p.getLeitura())+ (0.5*p.getEscrita())+ (0.4*p.getFala());
	}

}
