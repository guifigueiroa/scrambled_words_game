package org.coursera.figueiroa;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class BancoDePalavras {

	private ArrayList<String> palavras;
	private static BancoDePalavras instancia;
	private static final String FILE_NAME = "palavras.txt";
	
	private BancoDePalavras() throws IOException{
		palavras = new ArrayList<String>();
		
		FileReader arq = new FileReader(FILE_NAME);
		BufferedReader lerArq = new BufferedReader(arq);
			
		String palavra = lerArq.readLine();
			
		while (palavra != null) { 
			palavras.add(palavra);
			palavra = lerArq.readLine();
		}
		
		lerArq.close();
	}
	
	public static BancoDePalavras getInstancia() throws IOException{
		if(instancia == null)
			instancia = new BancoDePalavras();
		return instancia;
	}
	
	public String getPalavraAleatoria(){
		int randomNum = (int)(Math.random() * palavras.size()); 
		return palavras.get(randomNum);
	}
}