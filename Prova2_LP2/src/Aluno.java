
public class Aluno implements Comparable<Aluno>{ //wrapper

	private String nome;
	private double mensalidade;
	private Proficiencia proficiencia; //composicao
	private Curso curso; //composicao e polimorfismo
	
	public Aluno(String nome, double mensalidade, double escrita, double escuta, double fala, double leitura) throws Exception {
		this.nome = nome;
		this.mensalidade = mensalidade;
		proficiencia = new Proficiencia(escrita, escuta, fala, leitura);
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getMensalidade() {
		return mensalidade;
	}

	public void setMensalidade(double mensalidade) {
		this.mensalidade = mensalidade;
	}

	public double getEscuta() {
		return proficiencia.getEscuta(); // forwarding
	}

	public void setEscuta(double escuta) throws Exception {
		this.proficiencia.setEscuta(escuta); // forwarding
	}

	public double getFala() {
		return proficiencia.getFala(); // forwarding
	}

	public void setFala(double fala) throws Exception {
		this.proficiencia.setFala(fala); // forwarding
	}

	public double getLeitura() {
		return proficiencia.getLeitura(); // forwarding
	}

	public void setLeitura(double leitura) throws Exception {
		this.proficiencia.setLeitura(leitura); // forwarding
	}

	public double getEscrita() {
		return proficiencia.getEscrita(); // forwarding
	}

	public void setEscrita(double escrita) throws Exception {
		this.proficiencia.setEscrita(escrita); // forwarding
	}

	public Curso getCurso() {
		return curso;
	}

	public void matricula(String curso) throws Exception {
		this.curso = FactoryCurso.criaCurso(curso); //chamada polimorfica
	}

	public String cumprimenta() {
		return curso.cumprimenta(nome); //chamada polimorfica
	}

	public double calculaFacilidadeMedia() throws Exception { 
		if (curso == null) {
			throw new Exception(this.nome + " ainda nao esta matriculado em nenhum curso.");
		}
		return curso.calculaFacilidadeMedia(proficiencia); // upcasting
	}

	public double calculaFacilidade() throws Exception {
		if (curso == null) {
			throw new Exception(this.nome + " ainda nao esta matriculado em nenhum curso.");
		}
		return curso.calculaFacilidade(proficiencia);  //chamada polimorfica
	}
	
	@Override
	public int compareTo(Aluno a) {
		return this.getNome().compareTo(a.getNome());
	}


}
