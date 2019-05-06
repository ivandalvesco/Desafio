package com.desafio.texo.controllers;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.desafio.texo.dtos.IntervaloPremioDto;
import com.desafio.texo.dtos.PremioDto;
import com.desafio.texo.service.impl.FilmeServiceImpl;

@RunWith(SpringRunner.class)
@WebMvcTest(ConsultarPremiosController.class)
public class ConsultarPremiosControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private FilmeServiceImpl service;
	
	@InjectMocks
	ConsultarPremiosController controller;
	
	@Before
	 public void setUp() {
	      MockitoAnnotations.initMocks(this);
	    this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}
	
	@Test
	public void intervaloPremiosTest() throws Exception{
		
		PremioDto premioMin = new PremioDto("Joel Silver", 1L, 1990L, 1991L);
		PremioDto premioMax = new PremioDto("Matthew Vaughn", 13L, 2002L, 2015L);
		IntervaloPremioDto intervalo = new IntervaloPremioDto(Arrays.asList(premioMin), Arrays.asList(premioMax));
		List<PremioDto> premios = Arrays.asList(premioMin, premioMax);
		
		BDDMockito.given(service.getPremios()).willReturn(premios);
		BDDMockito.given(controller.listarIntervalosDePremiacao2().getBody()).willReturn(intervalo);
		
		mockMvc.perform(get("/piores-filmes/premiacoes2")
				.contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
		.andExpect(jsonPath("$.min", hasSize(1)))
		.andExpect(jsonPath("$.min[0].producer", is(premioMin.getProducer())))
		.andExpect(jsonPath("$.min[0].interval", is(premioMin.getInterval().intValue())))
		.andExpect(jsonPath("$.min[0].previousWin", is(premioMin.getPreviousWin().intValue())))
		.andExpect(jsonPath("$.min[0].followingWin", is(premioMin.getFollowingWin().intValue())))
		.andExpect(jsonPath("$.max", hasSize(1)))
		.andExpect(jsonPath("$.max[0].producer", is(premioMax.getProducer())))
		.andExpect(jsonPath("$.max[0].interval", is(premioMax.getInterval().intValue())))
		.andExpect(jsonPath("$.max[0].previousWin", is(premioMax.getPreviousWin().intValue())))
		.andExpect(jsonPath("$.max[0].followingWin", is(premioMax.getFollowingWin().intValue())));
		
	}

}
