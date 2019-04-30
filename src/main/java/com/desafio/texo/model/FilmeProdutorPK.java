package com.desafio.texo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FilmeProdutorPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6568983495195646493L;

	private Long idFilme;
	
	private Long idProdutor;
	
	public FilmeProdutorPK() {
	
	}

	public Long getIdFilme() {
		return idFilme;
	}

	public void setIdFilme(Long idFilme) {
		this.idFilme = idFilme;
	}

	public Long getIdProdutor() {
		return idProdutor;
	}

	public void setIdProdutor(Long idProdutor) {
		this.idProdutor = idProdutor;
	}
	
	
	
}
