package com.desafio.texo.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LerArquivoCsv {

	Logger logger = LoggerFactory.getLogger(LerArquivoCsv.class);
	private static final String SEPARATOR = ";";

	public List<String[]> lerArquivoCsv() {
		List<String[]> linhas = new ArrayList<String[]>();

		try {

			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("src/main/resources/files/movielist.csv")));

			reader.lines().skip(1).forEach(linha -> {
				String[] dadosLinha = linha.split(SEPARATOR);
				linhas.add(dadosLinha);
			});
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return linhas;

	}

}
