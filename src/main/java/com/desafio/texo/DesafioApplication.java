package com.desafio.texo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desafio.texo.config.ConfigRepository;

@SpringBootApplication
@EnableAutoConfiguration
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
		
		ConfigRepository config = new ConfigRepository();
		config.iniciarAplicacaio();
		
	}

}
