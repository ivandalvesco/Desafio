package com.desafio.texo.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LerArquivoCsv {

	Logger logger = LoggerFactory.getLogger(LerArquivoCsv.class);
	private static final String SEPARATOR = ";";

	public List<String[]> lerArquivoCsv() {
		List<String[]> linhas = null;

		try {
			BufferedReader reader = new BufferedReader(
					new InputStreamReader(new FileInputStream("files/movielist.csv")));
			String linha = null;
			while ((linha = reader.readLine()) != null) {
				String[] dadosLinha = linha.split(SEPARATOR);
				linhas.add(dadosLinha);
			}
			reader.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return linhas;

	}

}
