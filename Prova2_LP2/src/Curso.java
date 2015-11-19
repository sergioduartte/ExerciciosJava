
public abstract class Curso {

	public abstract String cumprimenta(String nome);

	public double calculaFacilidadeMedia(Proficiencia p){
		return (p.getEscrita() + p.getEscuta() + p.getFala() + p.getLeitura()) / 4.0 ;
	}

	public abstract double calculaFacilidade(Proficiencia p);
	
	
	
}
