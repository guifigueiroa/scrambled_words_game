package org.coursera.figueiroa.mecanicas;

import org.coursera.figueiroa.embaralhadores.Embaralhador;
import org.coursera.figueiroa.embaralhadores.FabricaDeEmbaralhadores;

/**
 * No tipo de jogo TresTentativas o jogador pode tentar acertar
 * cada palavra por 3 vezes.
 * O jogo termina somente quando ele erra ou quando 10 palavras são acertadas.
 * A pontuação do jogo é calculada somando 10 pontos para cada letra da 
 * palavra acertada.
 * 
 * @author guilhermefigueiroa
 *
 */
public class TresTentativas implements MecanicaDoJogo {

	private boolean jogoFinalizado = false;
	private int pontuacao;
	private Embaralhador embaralhador;
	private String palavra;
	private String palavraEmbaralhada;
	private int tentativas = 0;
	private int acertos = 0;
	
	TresTentativas(){
		embaralhador = FabricaDeEmbaralhadores.getEmbaralhadorAleatorio();
	}
	
	@Override
	public boolean jogoFinalizado() {
		if(tentativas >= 3 || acertos >= 10) {
			jogoFinalizado = true;
		}
		return jogoFinalizado;
	}

	@Override
	public boolean podeTentarNovamente() {
		if(tentativas < 3 && acertos < 10) {
			return true;
		} else {
			return false;	
		}
		
	}

	@Override
	public boolean adivinharPalavra(String palavra) {
		tentativas++;
		if (this.palavra.equalsIgnoreCase(palavra)){
			pontuacao += palavra.length() * 10;
			acertos++;
			return true;
		} else {
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
		tentativas = 0;
		
		return this.palavraEmbaralhada;
	}

}
