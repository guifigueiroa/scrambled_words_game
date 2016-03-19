package org.coursera.figueiroa.mecanicas;

public class FabricaMecanicaDoJogo {

	public static MecanicaDoJogo getMorteSubita(){
		return new MorteSubita();
	}
	
	public static MecanicaDoJogo getTresTentativas(){
		return new TresTentativas();
	}
}
