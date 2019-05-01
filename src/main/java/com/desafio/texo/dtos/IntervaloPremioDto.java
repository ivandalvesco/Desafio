package com.desafio.texo.dtos;

public class IntervaloPremioDto {

	
	private PremioDto min;
	
	private PremioDto max;

	public IntervaloPremioDto() {
	}
	
	public PremioDto getMin() {
		return min;
	}

	public void setMin(PremioDto min) {
		this.min = min;
	}

	public PremioDto getMax() {
		return max;
	}

	public void setMax(PremioDto max) {
		this.max = max;
	}
	
	
	
}
