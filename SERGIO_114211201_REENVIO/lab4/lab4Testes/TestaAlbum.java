/* 114211201 - Sergio de Sousa Duarte: LAB 04 - Turma 2 */
package lab4Testes;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import junit.framework.AssertionFailedError;
import lab4.Album;
import lab4.Musica;

@SuppressWarnings("deprecation")
public class TestaAlbum {
	Musica chandelier;
	Musica elasticHeart;
	Musica cellophane;
	Musica chandelierRemix;
	Musica musica1;
	Musica musica2;
	Album album;
	Album album2;
	
	@Before
	public void inicializaMusicas() throws Exception{
		chandelier = new Musica("Chandelier",3,"Pop");
		elasticHeart = new Musica("Elastic Heart",3,"Pop");
		cellophane = new Musica("Cellophane",4,"Pop");
		chandelierRemix = new Musica("ChandelierRemix",4,"Pop");
		musica1 = new Musica("musica1",4,"temp");
		musica2 = new Musica("musica2",5,"temp");
		album = new Album("artista", "titulo", 2015);
		album2 = new Album("artista2", "titulo2", 2014);
	}
	
	@Test
	public void testaAlbum(){
		try {
			Album album = new Album("artista", "titulo", 2015);
			Album album2 = new Album("artista2", "titulo2", 2014);
		}catch(Exception e){
			Assert.fail(); //nao deveria ter lancado nenhuma Exception nesse teste.
		}
	}
	
	@Test
	public void testAlbumInvalido(){
		try {
			Album artistaInvalido = new Album("","titulotemp",1999);
			Assert.fail(); //se chegar aqui da erro, pois deveria lancar exception.
		} catch (Exception e) {
			Assert.assertEquals("Artista do album nao pode ser vazio.", e.getMessage());
		}

		try {
			Album tituloInvalio = new Album("artistaTemp","", 2004);
			Assert.fail(); //se chegar aqui da erro, pois deveria lancar exception.
		} catch (Exception e) {
			Assert.assertEquals("Titulo do album nao pode ser vazio.", e.getMessage());
		}
		
		
		try {
			Album anoInvalido = new Album("artistaTemp","tituloTemp", -1);
			Assert.fail(); //se chegar aqui da erro, pois deveria lancar exception.
		} catch (Exception e) {
			Assert.assertEquals("Ano do album nao pode ser negativo.", e.getMessage());
		}
		
	}
	
	@Test
	public void addMusicasNoAlbum(){
		Assert.assertEquals(0, album.tamanho());
		Assert.assertEquals(0, album2.tamanho());
		try{
			album.addFaixa(chandelier);
			album.addFaixa(elasticHeart);
			album2.addFaixa(cellophane);
			album2.addFaixa(chandelierRemix);
		}catch(Exception e){
			Assert.fail();//nao deveria ter lancado nenhuma Exception nesse teste.
		}
		Assert.assertEquals(2, album.tamanho());
		Assert.assertEquals(2, album2.tamanho());
	}
	
	@Test
	public void addMusicaDuplicadaNoAlbum(){
		try{
			album.addFaixa(chandelier);
			album.addFaixa(chandelier);
			Assert.fail(); //se chegar aqui da erro, pois deveria lancar exception.
		} catch (Exception e){
			Assert.assertEquals("Chandelier ja esta contida no album.", e.getMessage());
		}
		try {
			album2.addFaixa(cellophane);
			album2.addFaixa(cellophane);
			Assert.fail(); //se chegar aqui da erro, pois deveria lancar exception.
		} catch (Exception e) {
			Assert.assertEquals("Cellophane ja esta contida no album.", e.getMessage());
		}
	}
	
	@Test
	public void verificaMusicasDoAlbum(){
		// verifica se contem a musica no album
		Assert.assertEquals(0, album.tamanho());
		Assert.assertFalse(album.contemMusica(chandelier));
		Assert.assertFalse(album.contemMusica(elasticHeart));
		Assert.assertFalse(album2.contemMusica(chandelierRemix));
		Assert.assertFalse(album.contemMusica(cellophane));
		
		// adiciona as musicas
		try{
			album.addFaixa(chandelier);
			album.addFaixa(elasticHeart);
			album2.addFaixa(cellophane);
			album2.addFaixa(chandelierRemix);
		}catch(Exception e){
			Assert.fail();//nao deveria ter lancado nenhuma Exception nesse teste.
		}
		
		// verifica se nao esta no album
		Assert.assertFalse(album.contemMusica(musica1));
		Assert.assertFalse(album.contemMusica(musica2));
		Assert.assertEquals(2, album.tamanho());
		Assert.assertEquals(2, album2.tamanho());
		
		// adiciona e verifica novamente
		try {
			album.addFaixa(musica1);
		} catch (Exception e) {
			Assert.fail(); //nao deveria ter lancado nenhuma Exception nesse teste.
		}
		Assert.assertTrue(album.contemMusica(musica1));
		
		// verifica a ordenacao das musicas no album
		Assert.assertEquals(2, album.indiceMusica(elasticHeart));
		Assert.assertEquals(1, album.indiceMusica(chandelier));
		Assert.assertEquals(3, album.indiceMusica(musica1));
		Assert.assertEquals(2, album2.indiceMusica(chandelierRemix));
		Assert.assertEquals(1, album2.indiceMusica(cellophane));
	}
	
	@Test
	public void removendoMusicas(){
		try{
			album.addFaixa(chandelier);
			album.addFaixa(elasticHeart);
			album2.addFaixa(cellophane);
			album2.addFaixa(chandelierRemix);
			album.addFaixa(musica1);
			album2.addFaixa(musica2);
		}catch(Exception e){
			Assert.fail();//nao deveria ter lancado nenhuma Exception nesse teste.
		}
		
		Assert.assertEquals(3, album.tamanho());
		Assert.assertEquals(3, album2.tamanho());
		
		try {
			album.removeMusica(musica1);
			album.removeMusica(chandelier);
			album2.removeMusica(cellophane);
			
		} catch (Exception e) {
			Assert.fail();//nao deveria ter lancado nenhuma Exception nesse teste.
		}

		
		Assert.assertEquals(1, album.tamanho());
		Assert.assertEquals(2, album2.tamanho());
		
		try {
			album2.removeMusica(cellophane);
			Assert.fail(); //se chegar aqui da erro, pois deveria lancar exception.
		} catch (Exception e) {
			Assert.assertEquals("Cellophane nao esta contida no album.", e.getMessage());
		}
		Assert.assertEquals(1, album.tamanho());
		Assert.assertEquals(2, album2.tamanho());
	}
}
