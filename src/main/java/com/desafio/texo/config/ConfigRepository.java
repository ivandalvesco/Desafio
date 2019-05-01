package com.desafio.texo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.desafio.texo.service.impl.IniciarAplicacaoServiceImpl;

@Configuration
public class ConfigRepository {

	@Autowired
	IniciarAplicacaoServiceImpl iniciarAplicacaoServiceImpl;
	
	@Bean
	public void iniciarAplicacaio(){
		iniciarAplicacaoServiceImpl.iniciarAplicacao();
	}
	
}
