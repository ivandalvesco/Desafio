package com.desafio.texo.model;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

public class FilmeProdutor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1359559711618567277L;

	@EmbeddedId
	private FilmeProdutorPK fileFilmeProdutorPK;

	@MapsId("idFilme")
	@ManyToOne
	@JoinColumn(name = "idFilme", referencedColumnName = "id")
	private Filme filme;

	@MapsId("idProdutor")
	@ManyToOne
	@JoinColumn(name = "idProdutor", referencedColumnName = "id")
	private Produtor produtor;

	public FilmeProdutor() {
	}

	public FilmeProdutorPK getFileFilmeProdutorPK() {
		return fileFilmeProdutorPK;
	}

	public void setFileFilmeProdutorPK(FilmeProdutorPK fileFilmeProdutorPK) {
		this.fileFilmeProdutorPK = fileFilmeProdutorPK;
	}

	public Filme getFilme() {
		return filme;
	}

	public void setFilme(Filme filme) {
		this.filme = filme;
	}

	public Produtor getProdutor() {
		return produtor;
	}

	public void setProdutor(Produtor produtor) {
		this.produtor = produtor;
	}

}
