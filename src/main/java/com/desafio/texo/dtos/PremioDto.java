package com.desafio.texo.dtos;

public class PremioDto {

	private String producer;
	private Long interval;
	private Long previousWin;
	private Long followingWin;

	public PremioDto() {
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

	public boolean equals(PremioDto premioCompare) {
		if(!premioCompare.getProducer().equals(this.producer) || !premioCompare.getInterval().equals(this.interval)
		|| !premioCompare.getFollowingWin().equals(this.followingWin) || !premioCompare.getPreviousWin().equals(this.previousWin)) {
			return false;
		}
	return true;
	}
}
