package com.desafio.texo.dtos;

import java.util.List;

public class IntervaloPremioDto {

	private List<PremioDto> min;

	private List<PremioDto> max;

	public IntervaloPremioDto() {
	}

	public List<PremioDto> getMin() {
		return min;
	}

	public void setMin(List<PremioDto> min) {
		this.min = min;
	}

	public List<PremioDto> getMax() {
		return max;
	}

	public void setMax(List<PremioDto> max) {
		this.max = max;
	}

}
