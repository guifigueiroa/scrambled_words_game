package org.coursera.figueiroa;

public interface MecanicaDoJogo {
	
	/**
	 * Retorna se jogo já foi finalizado
	 * @return jogo finalizado?
	 */
	public boolean jogoFinalizado();
	
	/**
	 * Retorna se jogador pode tentar acertar palavra novamente
	 * @return pode tentar novamente?
	 */
	public boolean podeTentarNovamente();
	
	/**
	 * Jogador tenta adivinhar a palavra
	 * @param palavra
	 * @return palavra foi adivinhada corretamente?
	 */
	public boolean adivinharPalavra(String palavra);
	
	/**
	 * Obtém a pontuação atual do jogador
	 * @return
	 */
	public int getPontuacao();
}
