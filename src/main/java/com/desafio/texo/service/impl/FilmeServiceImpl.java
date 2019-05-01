package com.desafio.texo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.texo.model.Filme;
import com.desafio.texo.repositories.FilmeRepository;
import com.desafio.texo.service.FilmeService;

@Service
public class FilmeServiceImpl implements FilmeService {

	@Autowired
	FilmeRepository filmeRepository;

	@Override
	public Filme persistir(Filme filme) {
		filmeRepository.save(filme);
		return filme;
	}

	@Override
	public List<Filme> persistirTodos(List<Filme> filmes) {
		filmeRepository.saveAll(filmes);
		return filmes;
	}
	
	
}
