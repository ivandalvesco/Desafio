package com.desafio.texo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafio.texo.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

	@Query(value = "select " + "p.produtores, "
			+ "CAST((select min(f1.ano) from tb_filme f1 join produtores p1 on f1.id = p1.filme_id where p1.produtores = p.produtores and f1.is_ganhador = true) AS SIGNED) as menor_ano, "
			+ "CAST((select max(f1.ano) from tb_filme f1 join produtores p1 on f1.id = p1.filme_id where p1.produtores = p.produtores and f1.is_ganhador = true) AS SIGNED) as maior_ano, "
			+ "CAST((select max(f1.ano) from tb_filme f1 join produtores p1 on f1.id = p1.filme_id where p1.produtores = p.produtores and f1.is_ganhador = true) AS SIGNED) - "
			+ "CAST((select min(f1.ano) from tb_filme f1 join produtores p1 on f1.id = p1.filme_id where p1.produtores = p.produtores and f1.is_ganhador = true) AS SIGNED) as diferenca "
			+ "from tb_filme f " + "join produtores p on f.id = p.filme_id " + "where f.is_ganhador = true "
			+ "group by p.produtores " + "having count(f.id) > 1", nativeQuery = true)
	List<Object> findProdutores();
}
