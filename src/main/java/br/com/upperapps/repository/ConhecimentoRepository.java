package br.com.upperapps.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import br.com.upperapps.domain.Conhecimento;

public interface ConhecimentoRepository extends GraphRepository<Conhecimento>{
	
	@Query("match m=(p:Profissional)-[r:CONHECE_UM]->(a:Assunto)-[r2:PERTENCE_A_CATEGORIA]->(c:Categoria) return m")
	Iterable<Conhecimento> findAll();

}