package com.desafio.texo.builder;

import java.util.ArrayList;
import java.util.List;

import com.desafio.texo.model.Estudio;
import com.desafio.texo.model.Filme;
import com.desafio.texo.model.Produtor;

public class Builder {

	public List<String> buildDadosFormatados(String dados) {
		String SEPARATOR1 = ",";
		String SEPARATOR2 = " and ";
		String[] dadosOrganizados = dados.split(SEPARATOR1);
		List<String> dadosFormatados = new ArrayList<String>();
		
		for (String dado : dadosOrganizados) {
			if(dado.contains(SEPARATOR2)) {
				String[] dadosAux = dado.split(SEPARATOR2);
				for (String aux : dadosAux) {
					dadosFormatados.add(aux);
				}
			}else {
				dadosFormatados.add(dado);
			}
		}
		return dadosFormatados;
	}
	
	public List<Produtor> buildProdutores(List<String> nomes) {
		List<Produtor> produtores = new ArrayList<Produtor>();
		for (String nome : nomes) {
			Produtor produtor = new Produtor();
			produtor.setNome(nome);
			produtores.add(produtor);
		}
		return produtores;
	}
	
	public List<Estudio> buildEstudios (List<String> nomes) {
		List<Estudio> estudios = new ArrayList<Estudio>();
	
		for (String nome : nomes) {
			Estudio estudio = new Estudio();
			estudio.setNome(nome);
			estudios.add(estudio);
		}
		return estudios;
	}
	
	public Filme buildFilme(String[] dadosFilme) {
		Filme filme = new Filme();
		filme.setAno(Long.parseLong(dadosFilme[0]));
		filme.setTitulo(dadosFilme[1]);
		filme.setGanhador(dadosFilme.length == 5 ? true : false);
		
		return filme;
	}
	
//	public FilmeEstudio buildFilmeEstudio(Filme filme, Estudio estudio) {
//		FilmeEstudio filmeEstudio = new FilmeEstudio();
//		filmeEstudio.setEstudio(estudio);
//		filmeEstudio.setFilme(filme);
//		return filmeEstudio;
//	}
//	
//	public FilmeProdutor buildFilmeProdutor(Filme filme, Produtor produtor) {
//		FilmeProdutor filmeProdutor = new FilmeProdutor();
//		filmeProdutor.setFilme(filme);
//		filmeProdutor.setProdutor(produtor);
//		
//		return filmeProdutor;
//	}
}
