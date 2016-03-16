package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.coursera.figueiroa.BancoDePalavras;
import org.junit.Before;
import org.junit.Test;

public class BancoDePalavrasTeste {

	BancoDePalavras palavras;
	
	@Before
	public void setUp() throws IOException {
		palavras = BancoDePalavras.getInstancia();
	}

	@Test
	public void testeGetInstance() {
		assertNotNull(palavras);
	}
	
	@Test
	public void testeGetPalavraAleatoria(){
		String palavra = palavras.getPalavraAleatoria();
		assertTrue(palavra.length() > 0);
		System.out.println(palavra);
	}

}
