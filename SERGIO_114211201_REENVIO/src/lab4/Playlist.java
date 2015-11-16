/* 114211201 - Sergio de Sousa Duarte: LAB 04 - Turma 2 */
package lab4;

import java.util.ArrayList;

public class Playlist {

	private String nome;
	private ArrayList<Musica> musicas;

	public Playlist(String nome) {
		this.nome = nome;
		musicas = new ArrayList();
	}

	public String getNome() {
		return this.nome;
	}

	public void addFaixa(Musica m) {
		musicas.add(m);		
	}

}
