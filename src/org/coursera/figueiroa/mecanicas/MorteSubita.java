package org.coursera.figueiroa.mecanicas;

import org.coursera.figueiroa.embaralhadores.Embaralhador;
import org.coursera.figueiroa.embaralhadores.FabricaDeEmbaralhadores;

/**
 * O tipo do jogo MorteSubita permite que o jogador tente acertar cada
 * palavra somente uma vez. E, para cada palavra acertada somam-se
 * 10 pontos ao score do jogador.
 * O jogo pode ser jogado infinitamente, até o primeiro erro.
 * 
 * @author guilhermefigueiroa
 *
 */
public class MorteSubita implements MecanicaDoJogo {

	private boolean jogoFinalizado = false;
	private int pontuacao;
	private Embaralhador embaralhador;
	private String palavra;
	private String palavraEmbaralhada;
	
	MorteSubita(){
		embaralhador = FabricaDeEmbaralhadores.getEmbaralhadorAleatorio();
	}
	
	@Override
	public boolean jogoFinalizado() {
		return jogoFinalizado;
	}

	@Override
	public boolean podeTentarNovamente() {
		return false;
	}

	@Override
	public boolean adivinharPalavra(String palavra) {
		if (this.palavra.equalsIgnoreCase(palavra)){
			pontuacao += 10;
			return true;
		} else {
			jogoFinalizado = true;
			return false;
		}
			
	}

	@Override
	public int getPontuacao() {
		return pontuacao;
	}

	@Override
	public String novaRodada(String palavra) {
		this.palavra = palavra;
		this.palavraEmbaralhada = embaralhador.getPalavraEmbaralhada(palavra);
		
		return this.palavraEmbaralhada;
	}

}
