/* 114211201 - Sergio de Sousa Duarte: LAB 04 - Turma 2 */
package lab4Testes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import lab4.Album;
import lab4.Musica;
import lab4.Usuario;

public class TestaPerfilSimples {
	
	Usuario u1;
	Album a1;
	Musica m1;
	
	@Before
	public void inicializa(){
		try {
			u1 = new Usuario("usuario");
			a1 = new Album("artistaTemp", "Titulo", 1993);
			m1 = new Musica("The Well", 4, "eletro");
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void criaUsuario(){
		try{
			Usuario usuario = new Usuario("nome");
			Assert.assertEquals(0, usuario.getAlbuns().size());
			Assert.assertEquals(0, usuario.getFavoritos().size());
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
	@Test
	public void criaEAdicionaAlbum(){
		try {
			a1.addFaixa(m1);
			u1.adicionaAlbum(a1);
			
			Assert.assertEquals(1, u1.getAlbuns().size());
			Assert.assertEquals(0, u1.getFavoritos().size());
			
			u1.adicionaAosFavoritos(a1);
			
			Assert.assertEquals(1, u1.getAlbuns().size());
			Assert.assertEquals(1, u1.getFavoritos().size());
		} catch (Exception e) {
			Assert.fail();
		}
	}
	
}
