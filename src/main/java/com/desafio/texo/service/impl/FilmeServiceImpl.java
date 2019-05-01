package com.desafio.texo.service.impl;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desafio.texo.dtos.IntervaloPremioDto;
import com.desafio.texo.dtos.PremioDto;
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

		intervalo.setMin(premios.stream().min(Comparator.comparing(PremioDto::getInterval))
				.orElseThrow(NoSuchElementException::new));
		intervalo.setMax(premios.stream().max(Comparator.comparing(PremioDto::getInterval))
				.orElseThrow(NoSuchElementException::new));
		return intervalo;
	}
}