package org.coursera.figueiroa.embaralhadores;

public class EmbaralhadorInverso implements Embaralhador {
	
	EmbaralhadorInverso(){}
	
	@Override
	public String getPalavraEmbaralhada(String palavra) {
		StringBuffer sb = new StringBuffer(palavra);
		sb.reverse();
		return sb.toString();
	}
	
	
}
