package com.desafio.texo.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.texo.model.Filme;
import com.desafio.texo.repositories.FilmeRepository;

@Service
public class IniciarAplicacaoServiceImpl {

	Logger logger = LoggerFactory.getLogger(IniciarAplicacaoServiceImpl.class);
	private static final String SEPARATOR_LINHA = ";";
	String SEPARATOR_COLUNA1 = ",";
	String SEPARATOR_COLUNA2 = " and ";

	List<Filme> filmes = new ArrayList<Filme>();

	@Autowired
	FilmeRepository filmeRepository;

	public void iniciarAplicacao() {
		logger.info("Iniciando aplicação");
		logger.info("Iniciando a leitura do arquivo .csv");

		List<String[]> linhas = new ArrayList<String[]>();

		try {

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/main/resources/files/movielist.csv")));

			reader.lines().skip(1).forEach(linha -> {
				String[] dadosLinha = linha.split(SEPARATOR_LINHA);
				linhas.add(dadosLinha);
			});
			reader.close();

			linhas.forEach(linha -> {
				Filme filme = new Filme();
				filme.setAno(Long.parseLong(linha[0]));
				filme.setTitulo(linha[1]);
				filme.setGanhador(linha.length > 4 ? true : false);
				Set<String> estudiosSet = new HashSet<String>();
				String[] estudios = linha[2].replaceAll(SEPARATOR_COLUNA2, SEPARATOR_COLUNA1).split(SEPARATOR_COLUNA1);
				Arrays.asList(estudios).stream().forEach(estudio -> {
					estudiosSet.add(estudio.trim());
				});
				filme.setEstudios(estudiosSet);

				Set<String> produtorSet = new HashSet<String>();
				String[] produtores = linha[3].replaceAll(SEPARATOR_COLUNA2, SEPARATOR_COLUNA1)
						.split(SEPARATOR_COLUNA1);
				Arrays.asList(produtores).stream().forEach(produtor -> {
					produtorSet.add(produtor.trim());
				});
				filme.setProdutores(produtorSet);
				filmeRepository.save(filme);
			});

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		logger.info("Filmes salvos no repositório");

	}
}
