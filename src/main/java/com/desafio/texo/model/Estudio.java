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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Classe de modelo mapeada para a entidade de estúdio
 * 
 * @author Ivan-PC
 *
 */
@Entity
@Table(name = "tb_estudio")
public class Estudio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
//	@OneToMany(mappedBy = "estudio", cascade=CascadeType.PERSIST)
//	List<FilmeEstudio> filmes;
	
	@ManyToMany(targetEntity = Filme.class, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_filme_estudio", joinColumns = {@JoinColumn(name = "id_filme")}, inverseJoinColumns = {@JoinColumn(name ="id_estudio")})
	List<Filme> filmes;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Override
	public String toString() {
		return this.nome;
	}
	
	
}
