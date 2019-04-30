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

/**
 * Classe modelo de mapeamento da entidade Produtor
 * @author Ivan-PC
 *
 */
@Entity
@Table(name = "tb_produtor")
public class Produtor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;
	
	@OneToMany(mappedBy = "produtor", cascade = CascadeType.PERSIST)
	private List<FilmeProdutor> filmes;

	public Produtor() {
	}

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

	public List<FilmeProdutor> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<FilmeProdutor> filmes) {
		this.filmes = filmes;
	}
	
	

}
