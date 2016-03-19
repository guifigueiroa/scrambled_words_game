package test;

import static org.junit.Assert.*;

import org.coursera.figueiroa.mecanicas.FabricaMecanicaDoJogo;
import org.coursera.figueiroa.mecanicas.MecanicaDoJogo;
import org.junit.Before;
import org.junit.Test;

public class TresTentativasTeste {

	private MecanicaDoJogo mecanica;
	
	@Before
	public void setUp() throws Exception {
		mecanica = FabricaMecanicaDoJogo.getTresTentativas();
	}

	@Test
	public void testeAcertoRodada() {
		assertFalse(mecanica.jogoFinalizado());
		assertEquals(0, mecanica.getPontuacao());
		
		mecanica.novaRodada("GUILHERME");
		assertTrue(mecanica.adivinharPalavra("GuIlHeRmE"));
		assertEquals(90, mecanica.getPontuacao());
		assertFalse(mecanica.jogoFinalizado());
	}
	
	@Test
	public void testeTresErrosRodada() {
		assertFalse(mecanica.jogoFinalizado());
		assertEquals(0, mecanica.getPontuacao());
		
		mecanica.novaRodada("GUILHERME");
		
		// Primeira tentativa
		assertFalse(mecanica.adivinharPalavra("lalala"));
		assertEquals(0, mecanica.getPontuacao());
		assertFalse(mecanica.jogoFinalizado());
		assertTrue(mecanica.podeTentarNovamente());
		
		// Segunda tentativa
		assertFalse(mecanica.adivinharPalavra("lalala"));
		assertEquals(0, mecanica.getPontuacao());
		assertFalse(mecanica.jogoFinalizado());
		assertTrue(mecanica.podeTentarNovamente());
		
		// Última tentativa
		assertFalse(mecanica.adivinharPalavra("lalala"));
		assertEquals(0, mecanica.getPontuacao());
		assertTrue(mecanica.jogoFinalizado());
		assertFalse(mecanica.podeTentarNovamente());
		
	}
	
	@Test
	public void testeDezRodadas() {
		for(int i = 0; i < 10; i++){
			mecanica.novaRodada("GUILHERME");
			assertFalse(mecanica.jogoFinalizado());
			assertTrue(mecanica.adivinharPalavra("GuIlHeRmE"));
		}
		assertEquals(900, mecanica.getPontuacao());
		assertTrue(mecanica.jogoFinalizado());
	}

}
