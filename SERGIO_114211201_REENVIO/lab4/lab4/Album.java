/* 114211201 - Sergio de Sousa Duarte: LAB 04 - Turma 3 */
package lab4;

import java.util.ArrayList;

public class Album implements Comparable<Album> {

	private String artista;
	private String titulo;
	private int ano;
	ArrayList<Musica> faixas;

	public Album(String artista, String titulo, int ano) throws Exception {
		validaAlbum(artista, titulo, ano);

		this.artista = artista;
		this.titulo = titulo;
		this.ano = ano;
		faixas = new ArrayList<Musica>();
	}

	private void validaAlbum(String artista, String titulo, int ano) throws Exception {
		if (artista.trim().equals("")) {
			throw new Exception("Artista do album nao pode ser vazio.");
		}
		if (titulo.trim().equals("")) {
			throw new Exception("Titulo do album nao pode ser vazio.");
		}
		if (ano < 0) {
			throw new Exception("Ano do album nao pode ser negativo.");
		}
	}

	public int tamanho() {
		return this.faixas.size();
	}

	public void addFaixa(Musica musica) throws Exception {
		if (!faixas.contains(musica)) {
			this.faixas.add(musica);
		} else {
			throw new Exception(musica.getNome() + " ja esta contida no album.");
		}
	}

	public boolean contemMusica(Musica musica) {
		for (Musica mus : faixas) {
			if (mus.equals(musica)) {
				return true;
			}
		}
		return false;
	}

	public int indiceMusica(Musica musica) {
		for (int i = 0; i < faixas.size(); i++) {
			if (faixas.get(i).equals(musica)) {
				return i + 1;
			}
		}
		return -1;
	}

	public void removeMusica(Musica musica) throws Exception {
		if (faixas.contains(musica)) {
			this.faixas.remove(musica);
		} else {
			throw new Exception(musica.getNome() + " nao esta contida no album.");
		}

	}

	public String getTitulo() {
		return this.titulo;
	}

	public Musica getFaixa(int faixa) {
		return null;
	}

	public int getAno() {
		return this.ano;
	}

	@Override
	public int compareTo(Album outro) {
		if (this.getAno() > outro.getAno()) {
			return 1;
		} else if (this.getAno() == outro.getAno()) {
			return 0;
		}
		return -1;
	}

}
