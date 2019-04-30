package com.desafio.texo.builder;

public class BuilderEstudio {

	@SuppressWarnings("null")
	public void buildDados(String dados) {
		String SEPARATOR1 = ",";
		String SEPARATOR2 = " and ";
		String[] estudios = dados.split(SEPARATOR1);
		String[] estudiosFormatados = null;
		
		for (String estudio : estudios) {
			String[] estudiosAux = estudio.split(SEPARATOR2);
			for (String aux : estudiosAux) {
				estudiosFormatados[estudiosFormatados.length+1] = aux;
			}
		}
		
		
	}
}
