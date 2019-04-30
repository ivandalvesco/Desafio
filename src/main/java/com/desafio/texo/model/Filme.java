package com.desafio.texo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_filme")
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "ano", nullable = false)
	private Long ano;
	
	@Column(name = "ano", nullable = false)
	private String titulo;
	
	@Column(name = "is_ganhador", nullable = false)
	private boolean ganhador;
	
	@OneToMany(mappedBy = "filme", cascade=CascadeType.PERSIST)
	List<FilmeEstudio> estudios;
	
	@OneToMany(mappedBy = "produtor", cascade = CascadeType.PERSIST)
	List<FilmeProdutor> produtores;
	
	public Filme() {
	
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getAno() {
		return ano;
	}

	public void setAno(Long ano) {
		this.ano = ano;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public boolean isGanhador() {
		return ganhador;
	}

	public void setGanhador(boolean ganhador) {
		this.ganhador = ganhador;
	}
	
	

}
