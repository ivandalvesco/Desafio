package com.desafio.texo.controllers;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.desafio.texo.dtos.IntervaloPremioDto;
import com.desafio.texo.response.Response;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ConsultarPremiosControllerTest {

	@Autowired
	private ConsultarPremiosController consultarPremiosController;
	
	@Test
	public void testListarIntervalosDePremiacao() {
		ResponseEntity<Response<IntervaloPremioDto>> response = consultarPremiosController.listarIntervalosDePremiacao();
		Assert.assertThat(HttpStatus.OK, Matchers.is(response.getStatusCode()));
	}
}
