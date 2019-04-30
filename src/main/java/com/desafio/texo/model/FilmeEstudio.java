package com.desafio.texo.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class FilmeEstudio {

	@EmbeddedId
	private FilmeEstudioPK filmeEstudioPk = new FilmeEstudioPK();
	
	@MapsId("idFilme")
	@ManyToOne
	@JoinColumn(name = "idFilme", referencedColumnName = "id")
	private Filme filme;
	
	@MapsId("idEstudio")
	@ManyToOne
	@JoinColumn(name = "idEstudio", referencedColumnName = "id")
	private Estudio estudio;

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Estudio getEstudio() {
		return estudio;
	}

	public void setEstudio(Estudio estudio) {
		this.estudio = estudio;
	}
	
	
	
}
