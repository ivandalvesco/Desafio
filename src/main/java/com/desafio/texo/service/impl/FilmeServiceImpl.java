package com.desafio.texo.service.impl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.texo.dtos.IntervaloPremioDto;
import com.desafio.texo.dtos.PremioDto;
import com.desafio.texo.model.Filme;
import com.desafio.texo.repositories.FilmeRepository;
import com.desafio.texo.service.FilmeService;

@Service
public class FilmeServiceImpl implements FilmeService {

	@Autowired
	FilmeRepository filmeRepository;

	public List<PremioDto> getPremios() {
		List<PremioDto> premios = new ArrayList<PremioDto>();
		List<Object> premiosObject = filmeRepository.findProdutores();
		premiosObject.stream().forEach(object -> {
			Object[] o = (Object[]) object;

			PremioDto premio = new PremioDto();
			premio.setProducer((String) o[0]);
			premio.setPreviousWin(Long.parseLong(o[1].toString()));
			premio.setFollowingWin(Long.parseLong(o[2].toString()));
			premio.setInterval(Long.parseLong(o[3].toString()));
			premios.add(premio);
		});

		return premios;
	}

	public IntervaloPremioDto getIntervaloPremioDto(List<PremioDto> premios) {
		IntervaloPremioDto intervalo = new IntervaloPremioDto();

		intervalo.setMin(premios.stream()
				.filter(premio -> premio.getInterval()
						.equals(premios.stream().min(Comparator.comparing(PremioDto::getInterval)).get().getInterval()))
				.collect(Collectors.toList()));

		intervalo.setMax(premios.stream()
				.filter(premio -> premio.getInterval()
						.equals(premios.stream().max(Comparator.comparing(PremioDto::getInterval)).get().getInterval()))
				.collect(Collectors.toList()));

		return intervalo;
	}

	public List<PremioDto> getPremiosIntervalo() {
		List<PremioDto> premios = new ArrayList<PremioDto>();

		List<Filme> filmes = filmeRepository.findByGanhadorTrue();

		Map<String, List<Filme>> mapProdutores = new HashMap<String, List<Filme>>();

		filmes.stream().forEach(filme -> {
			filme.getProdutores().forEach(produtor -> {
				if (!mapProdutores.containsKey(produtor)) {
					mapProdutores.put(produtor, new ArrayList<Filme>());
				}
				mapProdutores.get(produtor).add(filme);
				
			});
		});

		
		mapProdutores.entrySet().forEach(entry -> {
			if (entry.getValue().size() > 1) {
				PremioDto premio = new PremioDto();
				premio.setProducer(entry.getKey());
				premio.setPreviousWin(entry.getValue().stream().mapToLong(Filme::getAno).min().getAsLong());
				premio.setFollowingWin(
						entry.getValue().stream().filter(f -> f.getAno() > premio.getPreviousWin())
								.mapToLong(Filme::getAno).min().getAsLong());
				premio.setInterval(premio.getFollowingWin() - premio.getPreviousWin());
				premios.add(premio);
			}
		});
		
		return premios;
	}
}
