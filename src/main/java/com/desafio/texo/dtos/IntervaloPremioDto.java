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

	@Override
	public boolean equals(Object obj) {

		IntervaloPremioDto intervaloCompare = (IntervaloPremioDto) obj;

		if (intervaloCompare != null) {
			if (this.max.equals(intervaloCompare.getMax()) && this.min.equals(intervaloCompare.getMin())) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
