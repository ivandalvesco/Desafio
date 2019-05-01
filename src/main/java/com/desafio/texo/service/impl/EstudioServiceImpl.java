package com.desafio.texo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.texo.model.Estudio;
import com.desafio.texo.repositories.EstudioRepository;
import com.desafio.texo.service.EstudioService;

@Service
public class EstudioServiceImpl implements EstudioService{

	@Autowired
	EstudioRepository estudioRepository;
	
	@Override
	public Estudio persistir(Estudio estudio) {
		estudioRepository.save(estudio);
		return estudio;
	}

	
}
