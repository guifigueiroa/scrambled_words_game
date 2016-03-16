package org.coursera.figueiroa.embaralhadores;

public class FabricaDeEmbaralhadores {

	/**
	 * Obtém um embaralhador aleatório para o jogo
	 * @return
	 */
	public static Embaralhador getEmbaralhadorAleatorio(){
		int randomNum = (int)(Math.random() * 1);
		
		switch(randomNum) {
		case 0:
			return new EmbaralhadorInverso();
		default:
			return null;
		}
	}
	
	/**
	 * Obtém uma instancia de EmbaralhadorInverso
	 * @return instancia de EmbaralhadorInverso
	 */
	public static EmbaralhadorInverso getEmbaralhadorInverso(){
		return new EmbaralhadorInverso();
	}
	
	
}
