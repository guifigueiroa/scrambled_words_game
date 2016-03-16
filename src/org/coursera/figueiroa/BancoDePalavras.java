package org.coursera.figueiroa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BancoDePalavras {

	private ArrayList<String> palavras;
	private static BancoDePalavras instancia;
	private static final String FILE_NAME = "palavras.txt";
	
	/**
	 * Construtor privado para leitura das palavras
	 * 
	 * @throws IOException
	 */
	private BancoDePalavras() throws IOException{
		palavras = new ArrayList<String>();
		
		FileReader arq = new FileReader(FILE_NAME);
		BufferedReader lerArq = new BufferedReader(arq);
			
		String palavra = lerArq.readLine();
			
		while (palavra != null) { 
			palavras.add(palavra.toUpperCase());
			palavra = lerArq.readLine();
		}
		
		lerArq.close();
	}
	
	/**
	 * Método para obter a instancia do singleton BancoDePalavras
	 * @return instancia
	 * @throws IOException
	 */
	public static BancoDePalavras getInstancia() throws IOException{
		if(instancia == null)
			instancia = new BancoDePalavras();
		return instancia;
	}
	
	/**
	 * Obtém palavra aleatória do banco de palavras
	 * @return
	 */
	public String getPalavraAleatoria(){
		int randomNum = (int)(Math.random() * palavras.size()); 
		return palavras.get(randomNum);
	}
}