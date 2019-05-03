package com.desafio.texo.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_filme")
public class Filme implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5630891300680221273L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "ano", nullable = false)
	private Long ano;

	@Column(name = "titulo", nullable = false)
	private String titulo;

	@Column(name = "is_ganhador", nullable = false)
	private boolean ganhador;

	@ElementCollection
	@CollectionTable(name = "produtores")
	private Set<String> produtores = new HashSet<String>();

	@ElementCollection
	@CollectionTable(name = "estudios")
	private Set<String> estudios;

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

	public Set<String> getProdutores() {
		return produtores;
	}

	public void setProdutores(Set<String> produtores) {
		this.produtores = produtores;
	}

	public Set<String> getEstudios() {
		return estudios;
	}

	public void setEstudios(Set<String> estudios) {
		this.estudios = estudios;
	}

	@Override
	public String toString() {
		return "Titulo: " + this.titulo + ", ano: " + this.ano + ", produtor(es): " + produtores.toString()
				+ ", estudio(s): " + this.estudios.toString() + ", vencedor? " + (isGanhador() ? "sim" : "não");
	}

}
