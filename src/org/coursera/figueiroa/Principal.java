package org.coursera.figueiroa;

import java.io.IOException;
import java.util.Scanner;

import org.coursera.figueiroa.mecanicas.FabricaMecanicaDoJogo;
import org.coursera.figueiroa.mecanicas.MecanicaDoJogo;

public class Principal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in); 
		MecanicaDoJogo mecanica = FabricaMecanicaDoJogo.getMorteSubita();
		BancoDePalavras banco = null;
		try {
			banco = BancoDePalavras.getInstancia();
		} catch (IOException e) {
			System.err.println("Erro ao ler arquivo de palavras.\n" + e.getMessage());
			System.exit(1);
		}
		
		while(!mecanica.jogoFinalizado()){
			String palavraEmbaralhada = mecanica.novaRodada(banco.getPalavraAleatoria());
			System.out.println("----------------------");
			System.out.println("Palavra embaralhada: " + palavraEmbaralhada);
			System.out.println("Que palavra é esta?");
			
			mecanica.adivinharPalavra(in.nextLine());
		}
		
		System.out.println("----------------------");
		System.out.println("\nJogo finalizado");
		System.out.println("Pontuação: " + mecanica.getPontuacao());
		in.close();
	}
}
