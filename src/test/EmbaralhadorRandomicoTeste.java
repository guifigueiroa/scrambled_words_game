package test;

import static org.junit.Assert.*;

import org.coursera.figueiroa.embaralhadores.EmbaralhadorRandomico;
import org.junit.Test;

public class EmbaralhadorRandomicoTeste {

	@Test
	public void testeGetPalavraEmbaralhada() {
		EmbaralhadorRandomico r = new EmbaralhadorRandomico();
		String palavra = "guilherme";
		String embaralhada = r.getPalavraEmbaralhada(palavra);
		for(int i = 0; i < palavra.length(); i++) {
			String letra = palavra.substring(i, i+1);
			assertTrue(embaralhada.contains(letra));
		}
	}

}
