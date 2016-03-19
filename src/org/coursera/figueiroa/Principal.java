package org.coursera.figueiroa;

import java.io.IOException;
import java.util.Scanner;

import org.coursera.figueiroa.mecanicas.FabricaMecanicaDoJogo;
import org.coursera.figueiroa.mecanicas.MecanicaDoJogo;

public class Principal {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		MecanicaDoJogo mecanica = null;
		
		while(mecanica == null) {
			System.out.println("--------------------------------");
			System.out.println("Qual tipo de jogo deseja jogar?");
			System.out.println("1 - Três tentativas");
			System.out.println("2 - Morte súbita");
			
			String escolha = in.nextLine();
			if(escolha.equals("1")){
				mecanica = FabricaMecanicaDoJogo.getTresTentativas();
			} else if(escolha.equals("2")) {
				mecanica = FabricaMecanicaDoJogo.getMorteSubita();
			} else {
				System.out.println("Opção inválida");
			}
		}
		
		BancoDePalavras banco = null;
		try {
			banco = BancoDePalavras.getInstancia();
		} catch (IOException e) {
			System.err.println("Erro ao ler arquivo de palavras.\n" + e.getMessage());
			System.exit(1);
		}
		
		while(!mecanica.jogoFinalizado()){
			String palavraEmbaralhada = mecanica.novaRodada(banco.getPalavraAleatoria());
			boolean acertou = false;
			
			do {
				System.out.println("----------------------");
				System.out.println("Palavra embaralhada: " + palavraEmbaralhada);
				System.out.println("Que palavra é esta?");
				
				acertou = mecanica.adivinharPalavra(in.nextLine());
				
				if(acertou)
					System.out.println("Palavra correta. Pontuação atual: " + mecanica.getPontuacao());
				else
					System.err.println("Palavra incorreta.");
			} while(!acertou && mecanica.podeTentarNovamente());
		}
		
		System.out.println("----------------------");
		System.out.println("\nJogo finalizado");
		System.out.println("Pontuação: " + mecanica.getPontuacao());
		in.close();
	}
}
