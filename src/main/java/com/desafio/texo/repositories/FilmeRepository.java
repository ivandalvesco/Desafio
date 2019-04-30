package com.desafio.texo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desafio.texo.model.Filme;

public interface FilmeRepository extends JpaRepository<Filme, Long>{

}
