
public class cursoSueco extends Curso {

	@Override
	public String cumprimenta(String nome) {
		return  "Hej hej! Jag heter " + nome + ". Trevligt att träffas.";
	}

	@Override
	public double calculaFacilidade(Proficiencia p) {
		return (0.1*p.getLeitura())+ (0.1*p.getEscrita())+ (0.3*p.getFala()) + (0.5*p.getEscuta());
	}

}
