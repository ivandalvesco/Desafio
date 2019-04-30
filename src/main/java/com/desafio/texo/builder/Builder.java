package com.desafio.texo.builder;

import java.util.ArrayList;
import java.util.List;

import com.desafio.texo.model.Estudio;
import com.desafio.texo.model.Filme;
import com.desafio.texo.model.FilmeEstudio;
import com.desafio.texo.model.FilmeProdutor;
import com.desafio.texo.model.Produtor;
import com.desafio.texo.service.FilmeService;
import com.desafio.texo.service.impl.ProdutorServiceImpl;

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
	
	public Produtor buildProdutor(String nome) {
		Produtor produtor = new Produtor();
		produtor.setNome(nome);
		return produtor;
	}
	
	public Estudio buildEstudio (String nome) {
		Estudio estudio = new Estudio();
		estudio.setNome(nome);
		return estudio;
	}
	
	public Filme buildFilme(String[] dadosFilme) {
		Filme filme = new Filme();
		filme.setAno(Long.parseLong(dadosFilme[0]));
		filme.setTitulo(dadosFilme[1]);
		filme.setGanhador(dadosFilme.length == 5 ? true : false);
		
		return filme;
	}
	
	public FilmeEstudio buildFilmeEstudio(Filme filme, Estudio estudio) {
		FilmeEstudio filmeEstudio = new FilmeEstudio();
		filmeEstudio.setEstudio(estudio);
		filmeEstudio.setFilme(filme);
		return filmeEstudio;
	}
	
	public FilmeProdutor buildFilmeProdutor(Filme filme, Produtor produtor) {
		FilmeProdutor filmeProdutor = new FilmeProdutor();
		filmeProdutor.setFilme(filme);
		filmeProdutor.setProdutor(produtor);
		
		return filmeProdutor;
	}
}
