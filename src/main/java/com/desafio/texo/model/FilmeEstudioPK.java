package com.desafio.texo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class FilmeEstudioPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Long idFilme;
	
	private static Long idEstudio;
	
	
	public FilmeEstudioPK() {
	}


	public static Long getIdFilme() {
		return idFilme;
	}


	public static void setIdFilme(Long idFilme) {
		FilmeEstudioPK.idFilme = idFilme;
	}


	public static Long getIdEstudio() {
		return idEstudio;
	}


	public static void setIdEstudio(Long idEstudio) {
		FilmeEstudioPK.idEstudio = idEstudio;
	}
	
	
	
	
}
