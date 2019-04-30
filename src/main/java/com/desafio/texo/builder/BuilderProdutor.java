package com.desafio.texo.builder;

import com.desafio.texo.model.Produtor;
import com.desafio.texo.service.impl.ProdutorServiceImpl;

public class BuilderProdutor {

	public void buildDados(String dados) {
		String SEPARATOR1 = ",";
		String SEPARATOR2 = " and ";
		ProdutorServiceImpl impl= new ProdutorServiceImpl();
		String[] produtores = dados.split(SEPARATOR1);
		for (String prod: produtores) {
			if(prod.contains(SEPARATOR2)) {
				String[] produtoresAux = prod.split(SEPARATOR2);
				for (String aux : produtoresAux) {
					produtores[produtores.length+1] = aux;
				}
			}
		}
		
		for (String produtor : produtores) {
			Produtor prod = new Produtor();
			prod.setNome(produtor);
			
			impl.persistir(prod);	
		}
		
	}

}
