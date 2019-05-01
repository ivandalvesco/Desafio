package com.desafio.texo.service;

import java.util.List;

import com.desafio.texo.model.Filme;

public interface FilmeService {

	
	Filme persistir(Filme filme);
	
	List<Filme> persistirTodos(List<Filme> filmes);
}
