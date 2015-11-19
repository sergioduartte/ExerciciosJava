import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestHelloWorld {

	private Aluno brad;
	private Aluno lisbeth;
	private Aluno miyazaki;

	@Before
	public void setUp() {
		//ordem de construcao: escrita, escuta, fala, leitura.
		try {
			brad = new Aluno("Brad Pitt", 500.0, 7.0, 10.0, 10.0, 7.5);
			lisbeth = new Aluno("Lisbeth Salander", 500, 10.0, 10.0, 6.0, 10.0);
			miyazaki = new Aluno("Hayao Miyazaki", 500, 10.0, 7.0, 5.0, 10.0);
			
		} catch (Exception e) {
			Assert.fail(); //nao deve entrar aqui.
		}
	}

	@Test
	public void testAluno() {
		try {
			// letra a.
			Assert.assertEquals("Brad Pitt", brad.getNome());
			Assert.assertEquals("Lisbeth Salander", lisbeth.getNome());
			Assert.assertEquals("Hayao Miyazaki", miyazaki.getNome());

			Assert.assertEquals(500, brad.getMensalidade(), 0.1);
			Assert.assertEquals(500, lisbeth.getMensalidade(), 0.1);
			Assert.assertEquals(500, miyazaki.getMensalidade(), 0.1);

			// letra b.
			// Brad Pitt: 7, 10, 10, 7.5
			Assert.assertEquals(7.0, brad.getEscrita(), 0.1);
			Assert.assertEquals(10.0, brad.getEscuta(), 0.1);
			Assert.assertEquals(10.0, brad.getFala(), 0.1);
			Assert.assertEquals(7.5, brad.getLeitura(), 0.1);

			// Lisbeth Salander: 10, 10, 6, 10
			Assert.assertEquals(10.0, lisbeth.getEscrita(), 0.1);
			Assert.assertEquals(10.0, lisbeth.getEscuta(), 0.1);
			Assert.assertEquals(6.0, lisbeth.getFala(), 0.1);
			Assert.assertEquals(10.0, lisbeth.getLeitura(), 0.1);

			// Hayao Miyazaki: 10, 7, 5, 10
			Assert.assertEquals(10.0, miyazaki.getEscrita(), 0.1);
			Assert.assertEquals(7.0, miyazaki.getEscuta(), 0.1);
			Assert.assertEquals(5.0, miyazaki.getFala(), 0.1);
			Assert.assertEquals(10.0, miyazaki.getLeitura(), 0.1);

			// LETRA C:
			miyazaki.matricula("Japones");
			lisbeth.matricula("Sueco");
			brad.matricula("Ingles");
			
			//LETRA D:
			Assert.assertEquals(8.6, brad.calculaFacilidadeMedia(), 0.1);
			Assert.assertEquals(9.0, lisbeth.calculaFacilidadeMedia(), 0.1);
			Assert.assertEquals(8.0, miyazaki.calculaFacilidadeMedia(), 0.1);
			
			/*
			  japones=(0.4*leitura)+ (0.6*escrita);
			  ingl�s =(0.1*leitura)+ (0.5*escrita)+ (0.4*fala);
			  sueco  =(0.1*leitura)+ (0.1*escrita)+ (0.3*fala) + (0.5*escuta)
			*/
			// Brad Pitt       : 7 , 10, 10, 7.5
			// Lisbeth Salander: 10, 10, 6 , 10
			// Hayao Miyazaki  : 10, 7 , 5 , 10
			Assert.assertEquals(8.2, brad.calculaFacilidade(), 0.1);
			Assert.assertEquals(8.8, lisbeth.calculaFacilidade(), 0.1);
			Assert.assertEquals(10.0, miyazaki.calculaFacilidade(), 0.1);
			
			//LETRA E:
			String hiBrad = "Hello! I am Brad Pitt. Nice to meet you.";
			String hiLisbeth = "Hej hej! Jag heter Lisbeth Salander. Trevligt att tr�ffas.";
			String hiMiyazaki= "Hajimemashite. Watashi ha Hayao Miyazaki desu.";
			Assert.assertEquals(hiBrad, brad.cumprimenta());
			Assert.assertEquals(hiLisbeth, lisbeth.cumprimenta());
			Assert.assertEquals(hiMiyazaki, miyazaki.cumprimenta());
			
			//LETRA F:
			List<Aluno> alunos = new ArrayList<Aluno>();
			alunos.add(lisbeth);
			alunos.add(miyazaki);
			alunos.add(brad);			
			//antes de ordenar
			Assert.assertEquals("Lisbeth Salander", alunos.get(0).getNome());
			Assert.assertEquals("Hayao Miyazaki", alunos.get(1).getNome());
			Assert.assertEquals("Brad Pitt", alunos.get(2).getNome());
			
			Collections.sort(alunos); //<-- ordenacao.
			//apos ordenar
			Assert.assertEquals("Brad Pitt", alunos.get(0).getNome());
			Assert.assertEquals("Hayao Miyazaki", alunos.get(1).getNome());
			Assert.assertEquals("Lisbeth Salander", alunos.get(2).getNome());
			
		} catch (Exception exception) {
			Assert.fail(); //nao deve entrar aqui.
		}
	}

	@Test
	public void testPolimorfismo(){
		try {			
			brad.matricula("Sueco");
			miyazaki.matricula("Ingles");
			
			//a pontuacao de facilidade especifica muda.
			Assert.assertEquals(9.4, brad.calculaFacilidade(), 0.1);
			Assert.assertEquals(8.0, miyazaki.calculaFacilidade(), 0.1);
			
			//as saudacoes de cada idioma mudam.
			String hiMiyazaki = "Hello! I am Hayao Miyazaki. Nice to meet you.";
			String hiBrad = "Hej hej! Jag heter Brad Pitt. Trevligt att tr�ffas.";
			Assert.assertEquals(hiBrad, brad.cumprimenta());
			Assert.assertEquals(hiMiyazaki, miyazaki.cumprimenta());
						
		} catch (Exception e) {
			Assert.fail(); //nao deve entrar aqui.
		}
	}
	
	@Test
	public void testExceptions(){
		try {
			Aluno madonna = new Aluno("Madonna",150.0,-8,7.5,10.0,7.5);
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Nivel de proficiencia invalido. Deve ser entre 0 e 10.", e.getMessage());
		}
		
		try {
			Aluno penelopeCruz = new Aluno("Penelope Cruz",200.0,8,7.5,10.0,7.5);
			penelopeCruz.matricula("Espanhol");
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("HelloWorld n�o ensina Espanhol", e.getMessage());
		}
		
		try {
			Aluno clint = new Aluno("Clint Eastwood",200.0,8,7.5,10.0,7.5);
			clint.calculaFacilidade();
			Assert.fail();
		} catch (Exception e) {
			Assert.assertEquals("Clint Eastwood ainda nao esta matriculado em nenhum curso.", e.getMessage());
		}
	}
}
