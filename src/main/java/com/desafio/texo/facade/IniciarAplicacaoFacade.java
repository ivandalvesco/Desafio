package com.desafio.texo.facade;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.desafio.texo.builder.Builder;
import com.desafio.texo.model.Filme;
import com.desafio.texo.repositories.FilmeRepository;
import com.desafio.texo.service.impl.FilmeServiceImpl;
import com.desafio.texo.utils.LerArquivoCsv;

public class IniciarAplicacaoFacade {

	private static Logger logger = LoggerFactory.getLogger(IniciarAplicacaoFacade.class);
	
	private List<String[]> linhas = new ArrayList<String[]>();
	private Builder builder = new Builder();
	private List<Filme> filmes = new ArrayList<Filme>();

	@Autowired
	FilmeRepository filmeRepository;
	
	public void iniciarAplicacao() {
		logger.info("Iniciando aplicação");
		logger.info("Iniciando a leitura do arquivo .csv");
		
		linhas = new LerArquivoCsv().lerArquivoCsv();
		
		for (String[] linha : linhas) {
			List<String> estudios = builder.buildDadosFormatados(linha[2]);
			List<String> produtores = builder.buildDadosFormatados(linha[3]);
			
			Filme filme = new Filme();
			filme.setAno(Long.parseLong(linha[0]));
			filme.setTitulo(linha[1]);
			filme.setGanhador(linha.length > 4 ? true : false);
			filme.setEstudios(builder.buildEstudios(estudios));
			filme.setProdutores(builder.buildProdutores(produtores));
			System.out.println(filme.toString());
			filmeRepository.save(filme);
			filmes.add(filme);
		}

		logger.info("Filmes salvos no repositório");
		
		
		
		
	}
}
