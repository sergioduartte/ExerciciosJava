/* 114211201 - Sergio de Sousa Duarte: LAB 04 - Turma 3 */
package lab4;

public class Musica {

	private String nome;
	private int duracao;
	private String tipo;

	public Musica(String nome, int duracao, String tipo) throws Exception {
		validaMusica(nome, duracao, tipo);
		this.nome = nome;
		this.duracao = duracao;
		this.tipo = tipo;
	}

	private void validaMusica(String nome, int duracao, String tipo) throws Exception {
		if (nome.trim().equals("")) {
			throw new Exception("Titulo da musica nao pode ser vazio.");
		} else if (duracao < 0){
			throw new Exception("Duracao da musica nao pode ser negativa.");
		} else if (tipo.trim().equals("")) {
			throw new Exception("Genero da musica nao pode ser vazio.");
		}
		
	}

	public String getNome() {
		return this.nome;
	}

	public Object getDuracao() {
		return this.duracao;
	}

	public String getTipo() {
		return this.tipo;
	}
	
	@Override
	public boolean equals(Object obj) {
		Musica mus = (Musica) obj;
		return (this.getNome().equals(mus.getNome()) && this.getDuracao().equals(mus.getDuracao()));
	}
}
