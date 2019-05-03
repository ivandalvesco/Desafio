package com.desafio.texo.controllers;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.texo.dtos.IntervaloPremioDto;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsultarPremiosControllerTest {

	@Autowired
	private ConsultarPremiosController consultarPremiosController;

	@Test
	public void testListarIntervalosDePremiacao() {
		consultarPremiosController = mock(ConsultarPremiosController.class);
		when(consultarPremiosController.listarIntervalosDePremiacao())
				.thenReturn(new ResponseEntity<IntervaloPremioDto>(HttpStatus.OK));
	}
	
//	@Test
//	public void testVerificarObjetosIntervalorPremiacao() {
//		consultarPremiosController = new ConsultarPremiosController();
//		IntervaloPremioDto intervaloPremioDto = consultarPremiosController.listarIntervalosDePremiacao().getBody();
//		assertNotNull(intervaloPremioDto);
//		
//	}
}
