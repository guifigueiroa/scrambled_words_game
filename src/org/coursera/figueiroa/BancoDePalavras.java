package org.coursera.figueiroa;

import java.util.ArrayList;

public class BancoDePalavras {

	private ArrayList<String> palavras;
	private static BancoDePalavras instancia;
	
	private BancoDePalavras(){}
	
	public static BancoDePalavras getInstancia(){
		if(instancia == null)
			instancia = new BancoDePalavras();
		return instancia;
	}
}
