package com.desafio.texo.model;

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
 * Classe modelo de mapeamento da entidade Produtor
 * @author Ivan-PC
 *
 */
@Entity
@Table(name = "tb_produtor")
public class Produtor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "nome", nullable = false)
	private String nome;
	
//	@OneToMany(mappedBy = "produtor", cascade = CascadeType.PERSIST)
//	private List<FilmeProdutor> filmes;
	
	@ManyToMany(targetEntity = Filme.class, fetch = FetchType.LAZY)
	@JoinTable(name = "tb_filme_produtor", joinColumns = {@JoinColumn(name = "id_filme")}, inverseJoinColumns = {@JoinColumn(name ="id_produtor")})
	List<Filme> filmes;

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

	public List<Filme> getFilmes() {
		return filmes;
	}

	public void setFilmes(List<Filme> filmes) {
		this.filmes = filmes;
	}

	
	@Override
	public String toString() {
		return this.nome;
	}

}
