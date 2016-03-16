package test;

import static org.junit.Assert.*;

import org.coursera.figueiroa.embaralhadores.EmbaralhadorInverso;
import org.coursera.figueiroa.embaralhadores.FabricaDeEmbaralhadores;
import org.junit.Test;

public class EmbaralhadorInversoTeste {

	@Test
	public void testeGetPalavraEmbaralhada() {
		EmbaralhadorInverso emb = FabricaDeEmbaralhadores.getEmbaralhadorInverso();
		String palavraEmbaralhada = emb.getPalavraEmbaralhada("guilherme");
		assertEquals("emrehliug", palavraEmbaralhada);
	}

}
