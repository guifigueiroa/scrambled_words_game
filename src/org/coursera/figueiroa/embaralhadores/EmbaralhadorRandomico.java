package org.coursera.figueiroa.embaralhadores;

import java.util.Random;

public class EmbaralhadorRandomico implements Embaralhador {

	@Override
	public String getPalavraEmbaralhada(String palavra) {
		char[] letters = palavra.toCharArray();
		Random r = new Random();
		
		for(int i = 0; i < letters.length; i++){
			int random = r.nextInt(letters.length);
			char temp = letters[i];
			letters[i] = letters[random];
			letters[random] = temp;
		}
		
		return new String(letters);
	}


}
