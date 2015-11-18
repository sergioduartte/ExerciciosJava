/* 114211201 - Sergio de Sousa Duarte: LAB 04 - Turma 2 */
package lab4;

import java.util.ArrayList;
import java.util.Collections;

public class Usuario {

	private String nome;
	private ArrayList<Album> albuns;
	private ArrayList<Album> favoritos;
	private ArrayList<Playlist> playlists;

	public Usuario(String nome) throws Exception {
		validaNome(nome);
		this.nome = nome;
		albuns = new ArrayList<Album>();
		favoritos = new ArrayList<Album>();
		playlists = new ArrayList<Playlist>();
	}

	private void validaNome(String nome) throws Exception {
		if (nome.trim().equals("")) {
			throw new Exception("Usuario nao pode ter nome vazio");
		}
	}

	public ArrayList<Album> getAlbuns() {
		return this.albuns;
	}

	public ArrayList<Album> getFavoritos() {
		return this.favoritos;
	}

	public void adicionaAlbum(Album album) {
		if (!albuns.contains(album)) {
			albuns.add(album);
		}
	}

	public void adicionaAosFavoritos(Album album) {
		if ((!favoritos.contains(album)) && albuns.contains(album)) {
			favoritos.add(album);
		}
	}

	public void adicionaPlaylist(String nome, String nomeAlbum, int faixa) throws Exception {
		if (nome.trim().equals("")) {
			throw new Exception("Nao eh possivel manipular playlist com nome vazio.");	
		}
		
		Playlist p = getPlaylist(nome);
		Album a = getAlbum(nomeAlbum);
		Musica m = a.getFaixa(faixa);
		p.addFaixa(m);
		}
		
	private Album getAlbum(String nomeAlbum) throws Exception {
		for (Album album : albuns) {
			if (album.getTitulo().equals(nomeAlbum)) {
				return album;
			}
		}
		throw new Exception("Album nao pertence ao perfil especificado");	
	}

	private Playlist getPlaylist(String nome) {
		for (Playlist p : playlists) {
			if (p.getNome().equals(nome)) {
				return p;
			}
		}
		return new Playlist(nome);
	}
	
	public void ordenaAlbunsPorAno(){
		Collections.sort(albuns);
	}
	
}
