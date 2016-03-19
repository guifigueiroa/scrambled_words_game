package test;

import static org.junit.Assert.*;

import org.coursera.figueiroa.mecanicas.FabricaMecanicaDoJogo;
import org.coursera.figueiroa.mecanicas.MecanicaDoJogo;
import org.junit.Before;
import org.junit.Test;

public class MorteSubitaTeste {

	private MecanicaDoJogo mecanica;
	
	@Before
	public void setUp() throws Exception {
		mecanica = FabricaMecanicaDoJogo.getMorteSubita();
	}

	@Test
	public void testeRodada() {
		assertFalse(mecanica.jogoFinalizado());
		assertEquals(0, mecanica.getPontuacao());
		
		assertEquals("EMREHLIUG", mecanica.novaRodada("GUILHERME"));
		assertTrue(mecanica.adivinharPalavra("GuIlHeRmE"));
		assertFalse(mecanica.jogoFinalizado());
		assertEquals(10, mecanica.getPontuacao());
		
		assertEquals("EMREHLIUG", mecanica.novaRodada("GUILHERME"));
		assertFalse(mecanica.adivinharPalavra("OUTRAPALAVRA"));
		assertTrue(mecanica.jogoFinalizado());
		assertFalse(mecanica.podeTentarNovamente());
		
		assertEquals(10, mecanica.getPontuacao());
	}

}
