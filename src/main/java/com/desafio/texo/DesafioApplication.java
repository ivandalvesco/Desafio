package com.desafio.texo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.desafio.texo.utils.LerArquivoCsv;

@SpringBootApplication
public class DesafioApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioApplication.class, args);
		
 		new LerArquivoCsv().lerArquivoCsv();
	}

}
