package com.desafio.texo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.texo.model.Produtor;
import com.desafio.texo.repositories.ProdutorRepository;
import com.desafio.texo.service.ProdutorService;

@Service
public class ProdutorServiceImpl implements ProdutorService{

	@Autowired
	private ProdutorRepository produtorRepository;

	@Override
	public Produtor persistir(Produtor produtor) {
		this.produtorRepository.save(produtor);
		return produtor;
	}
}
