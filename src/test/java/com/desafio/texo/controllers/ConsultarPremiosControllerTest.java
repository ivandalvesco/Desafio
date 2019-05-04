package com.desafio.texo.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.desafio.texo.dtos.IntervaloPremioDto;
import com.desafio.texo.dtos.PremioDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsultarPremiosControllerTest {

	@Autowired
	private ConsultarPremiosController consultarPremiosController;

	private ResponseEntity<IntervaloPremioDto> responseCompare;
	private IntervaloPremioDto intervalo;
	private List<PremioDto> min;
	private List<PremioDto> max;
	private PremioDto premioMin;
	private PremioDto premioMax;
	
	@Before
	public void setUp() {
		
		intervalo = new IntervaloPremioDto();
		min = new ArrayList<PremioDto>();
		max = new ArrayList<PremioDto>();
		premioMin = new PremioDto();
		premioMax = new PremioDto();
		
		premioMin.setProducer("Joel Silver");
		premioMin.setInterval(1L);
		premioMin.setPreviousWin(1990L);
		premioMin.setFollowingWin(1991L);
		
		premioMax.setProducer("Matthew Vaughn");
		premioMax.setInterval(13L);
		premioMax.setPreviousWin(2002L);
		premioMax.setFollowingWin(2015L);
		
		min.add(premioMin);
		max.add(premioMax);
		intervalo.setMin(min);
		intervalo.setMax(max);
		
		responseCompare = new ResponseEntity<IntervaloPremioDto>(intervalo, HttpStatus.OK);
		
	}
	
	@Test
	public void testListarIntervalosDePremiacao() {
		consultarPremiosController = mock(ConsultarPremiosController.class);
		when(consultarPremiosController.listarIntervalosDePremiacao())
				.thenReturn(new ResponseEntity<IntervaloPremioDto>(HttpStatus.OK));
	}
	
	@Test
	public void retornoResponseServicoPremiacoesTest() {
		RestTemplate restTemplate = mock(RestTemplate.class);
		consultarPremiosController = mock(ConsultarPremiosController.class);
		IntervaloPremioDto intervaloPremioDto = mock(IntervaloPremioDto.class);
		ResponseEntity<IntervaloPremioDto> response = mock(ResponseEntity.class);
		when(response.getBody()).thenReturn(intervaloPremioDto);
		when(restTemplate.exchange("http://localhost:8080/piores-filmes/premiacoes", HttpMethod.GET, null, IntervaloPremioDto.class)).thenReturn(response);	
	}
	
	@Test
	public void intervaloPremioDtoTest() {
		ResponseEntity<IntervaloPremioDto> response = consultarPremiosController.listarIntervalosDePremiacao();
		
		assertEquals(response.getStatusCode(), responseCompare.getStatusCode());
		assertNotNull(response.getBody());
		assertNotNull(response.getBody().getMin());
		assertNotNull(response.getBody().getMax());
		assertEquals(response.getBody().getMin().size(), responseCompare.getBody().getMin().size());
		assertEquals(response.getBody().getMax().size(), responseCompare.getBody().getMax().size());
		assertEquals(response.getBody(), responseCompare.getBody());
		
		
		
	}


}
