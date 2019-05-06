package com.desafio.texo.dtos;

public class PremioDto {

	private String producer;
	private Long interval;
	private Long previousWin;
	private Long followingWin;

	public PremioDto() {
	}
	
	

	public PremioDto(String producer, Long interval, Long previousWin, Long followingWin) {
		super();
		this.producer = producer;
		this.interval = interval;
		this.previousWin = previousWin;
		this.followingWin = followingWin;
	}



	public String getProducer() {
		return producer;
	}

	public void setProducer(String producer) {
		this.producer = producer;
	}

	public Long getInterval() {
		return interval;
	}

	public void setInterval(Long interval) {
		this.interval = interval;
	}

	public Long getPreviousWin() {
		return previousWin;
	}

	public void setPreviousWin(Long previousWin) {
		this.previousWin = previousWin;
	}

	public Long getFollowingWin() {
		return followingWin;
	}

	public void setFollowingWin(Long followingWin) {
		this.followingWin = followingWin;
	}

	@Override
	public boolean equals(Object obj) {
		PremioDto premioCompare = (PremioDto) obj;

		if (premioCompare != null) {
			if (!premioCompare.getProducer().equals(this.producer) 
					|| !premioCompare.getInterval().equals(this.interval)
					|| !premioCompare.getFollowingWin().equals(this.followingWin)
					|| !premioCompare.getPreviousWin().equals(this.previousWin)) {
				return false;
			}
			return true;
		} else {
			return false;
		}
	}

}
