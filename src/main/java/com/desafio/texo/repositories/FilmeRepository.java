package com.desafio.texo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.desafio.texo.model.Filme;

@Repository
public interface FilmeRepository extends JpaRepository<Filme, Long> {

	// TODO resolver primeiro o problema dos registros de produtos e estudio
	// duplicados
//	@Query(
//			value = " SELECT "
//					+ "(select max(f1.ano) from tb_filme f1 where f1.produtor_id = p.id)"
//					+ " - "
//					+ "(select min(f1.ano) from tb_filme f1 where f1.produtor_id = p.id) as intervalo,"
//					+ "(select max(f1.ano) from tb_filme f1 where f1.produtor_id = p.id) as maior_ano, "
//					+ "(select min(f1.ano) from tb_filme f1 where f1.produtor_id = p.id) as menor_ano, "
//					+ "p.nome as produtor "
//					+ "FROM tb_filme f join tb_produtor p on p.id = f.produtor_id "
//					+ "WHERE f.is_ganhador = true group by p.id having count(f.id > 1) "
//					+ "ORDER BY intervalo ASC "
//					+ "LIMIT 1",
//			nativeQuery = true)
//	List<Object> findAllMenorPremiacao();
//	
//	
//	@Query(
//			value = " SELECT "
//					+ "(select max(f1.ano) from tb_filme f1 where f1.produtor_id = p.id)"
//					+ " - "
//					+ "(select min(f1.ano) from tb_filme f1 where f1.produtor_id = p.id) as intervalo,"
//					+ "(select max(f1.ano) from tb_filme f1 where f1.produtor_id = p.id) as maior_ano, "
//					+ "(select min(f1.ano) from tb_filme f1 where f1.produtor_id = p.id) as menor_ano, "
//					+ "p.nome as produtor "
//					+ "FROM tb_filme f join tb_produtor p on p.id = f.produtor_id "
//					+ "WHERE f.is_ganhador = true "
//					+ "GROUP BY p.id having count(f.id > 1) "
//					+ "ORDER BY intervalo DESC "
//					+ "LIMIT 1",
//			nativeQuery = true)
//	List<Object> findAllMaiorPremiacao();

	@Query( value = "select " + 
			"p.produtores, " + 
			"CAST((select min(f1.ano) from tb_filme f1 join produtores p1 on f1.id = p1.filme_id where p1.produtores = p.produtores) AS SIGNED) as menor_ano, " + 
			"CAST((select max(f1.ano) from tb_filme f1 join produtores p1 on f1.id = p1.filme_id where p1.produtores = p.produtores) AS SIGNED) as maior_ano, " + 
			"CAST((select max(f1.ano) from tb_filme f1 join produtores p1 on f1.id = p1.filme_id where p1.produtores = p.produtores) AS SIGNED) - " + 
			"CAST((select min(f1.ano) from tb_filme f1 join produtores p1 on f1.id = p1.filme_id where p1.produtores = p.produtores) AS SIGNED) as diferenca " + 
			"from tb_filme f " + 
			"join produtores p on f.id = p.filme_id " + 
			"where f.is_ganhador = true " + 
			"group by p.produtores " + 
			"having count(f.id) > 1", nativeQuery = true)
	List<Object> findProdutores();

}
