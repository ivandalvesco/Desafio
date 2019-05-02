package com.desafio.texo.response;

import java.util.List;

public class Response <T> {
	
	private T data;
	private List<String> erros;
	
	
	public Response() {
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	
}
