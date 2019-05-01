package com.desafio.texo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desafio.texo.facade.IniciarAplicacaoFacade;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
		
 		new IniciarAplicacaoFacade().iniciarAplicacao();
	}

}
