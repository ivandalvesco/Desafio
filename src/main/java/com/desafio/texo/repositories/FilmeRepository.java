package com.desafio.texo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafio.texo.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

	@Query(value = "select distinct(tmp.produtores) as produtores," + "tmp.menor_ano,"
			+ "CAST((select min(f1.ano) from tb_filme f1 join produtores p1 on f1.id = p1.filme_id where p1.produtores = p.produtores and f1.is_ganhador = true and f1.ano > tmp.menor_ano) AS SIGNED) as maior_ano,"
			+ "(CAST((select min(f1.ano) from tb_filme f1 join produtores p1 on f1.id = p1.filme_id where p1.produtores = p.produtores and f1.is_ganhador = true and f1.ano > tmp.menor_ano) AS SIGNED) - tmp.menor_ano) as diferenca "
			+ "from produtores p " + "join (select " + "	prod.produtores,"
			+ "	CAST((select min(f1.ano) from tb_filme f1 join produtores prod1 on f1.id = prod1.filme_id where prod1.produtores = prod.produtores and f1.is_ganhador = true) AS SIGNED) as menor_ano"
			+ "	from tb_filme f " + "	join produtores prod on f.id = prod.filme_id " + "	where f.is_ganhador = true"
			+ "	group by prod.produtores having count(f.id) > 1"
			+ ") tmp on tmp.produtores = p.produtores", nativeQuery = true)
	List<Object> findProdutores();

	List<Filme> findByGanhadorTrue();
}
