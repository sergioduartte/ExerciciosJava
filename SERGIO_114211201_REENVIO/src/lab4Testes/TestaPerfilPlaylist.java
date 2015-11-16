/* 114211201 - Sergio de Sousa Duarte: LAB 04 - Turma 2 */
package lab4Testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lab4.Album;
import lab4.Musica;
import lab4.Playlist;
import lab4.Usuario;

public class TestaPerfilPlaylist {

	Usuario u1;
	Album a1;
	Musica m1;
	Playlist p1;

	@Before
	public void inializa() throws Exception {
		u1 = new Usuario("us1");
		a1 = new Album("artista", "titulo", 1231);
		m1 = new Musica("nome", 13, "tipo");
		u1.adicionaAlbum(a1);
		u1.adicionaAosFavoritos(a1);
	}

	@Test
	public void criaPlaylist() {
		try {
			u1.adicionaPlaylist("toCode", "titulo", 1);
		} catch (Exception e) {
			Assert.fail();
		}
	}

	@Test
	public void testaPlaylist() {
		try {
			u1.adicionaPlaylist("", "titulo", 1);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nao eh possivel manipular playlist com nome vazio.", e.getMessage());
		}
		
		try {
			u1.adicionaPlaylist("toCode", "titulo", 1);
			u1.adicionaPlaylist("toCode", "asd", 1);
		} catch (Exception e){
			Assert.assertEquals("Album nao pertence ao perfil especificado", e.getMessage());
		}
	}
}
