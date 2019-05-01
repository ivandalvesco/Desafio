package com.desafio.texo.service.impl;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.texo.repositories.FilmeRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IniciarAplicacaoServiceImplTest {

	@Autowired
	IniciarAplicacaoServiceImpl iniciarAplicacaoServiceImpl;
	
	@Autowired
	FilmeRepository filmeRepository;
	
	@Test
	public void testIniciarAplicacao() {
		this.iniciarAplicacaoServiceImpl.iniciarAplicacao();
		
		assertTrue(filmeRepository.count() > 1); 	
	}
}
