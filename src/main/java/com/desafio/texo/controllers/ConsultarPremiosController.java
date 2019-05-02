package com.desafio.texo.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.desafio.texo.dtos.IntervaloPremioDto;
import com.desafio.texo.dtos.PremioDto;
import com.desafio.texo.service.impl.FilmeServiceImpl;

@RestController
@RequestMapping(path = "/piores-filmes")
public class ConsultarPremiosController {

	@Autowired
	FilmeServiceImpl filmeService;

	@GetMapping(value = "/premiacoes")
	public ResponseEntity<IntervaloPremioDto> listarIntervalosDePremiacao() {
		List<PremioDto> premios = new ArrayList<PremioDto>();
		premios = filmeService.getPremios();

		IntervaloPremioDto intervalo = new IntervaloPremioDto();
		intervalo = filmeService.getIntervaloPremioDto(premios);

		
//		Response<IntervaloPremioDto> response = new Response<IntervaloPremioDto>();
//		response.setData(intervalo);
		if (premios.isEmpty()) {
			return ResponseEntity.badRequest().body(null);
		}

		return ResponseEntity.ok(intervalo);

	}

}
