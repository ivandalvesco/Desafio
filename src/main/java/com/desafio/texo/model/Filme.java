package com.desafio.texo.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tb_filme")
public class Filme implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5630891300680221273L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "ano", nullable = false)
	private Long ano;
	
	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@Column(name = "is_ganhador", nullable = false)
	private boolean ganhador;
	
//	@OneToMany(mappedBy = "filme", cascade=CascadeType.PERSIST)
//	List<FilmeEstudio> estudios;
//	
//	@OneToMany(mappedBy = "produtor", cascade = CascadeType.PERSIST)
//	List<FilmeProdutor> produtores;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Produtor> produtores;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Estudio> estudios;
	
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

	public List<Produtor> getProdutores() {
		return produtores;
	}

	public void setProdutores(List<Produtor> produtores) {
		this.produtores = produtores;
	}

	public List<Estudio> getEstudios() {
		return estudios;
	}

	public void setEstudios(List<Estudio> estudios) {
		this.estudios = estudios;
	}
	
	@Override
	public String toString() {
		return "Titulo: "+ this.titulo + ", ano: "+ this.ano + ", produtor(es): "+ produtores.toString()+ ", estudio(s): "+ this.estudios.toString() + ", vencedor? "+ (isGanhador() ? "sim" : "não" );
	}

}
