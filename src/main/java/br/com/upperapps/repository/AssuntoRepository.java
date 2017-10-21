package br.com.upperapps.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import br.com.upperapps.domain.Assunto;

@Repository
public interface AssuntoRepository extends GraphRepository<Assunto>{
	
	//Retorna os assuntos que ainda não foram associados a uma pessoa.
	@Query("match (p:Pessoa)-[c:CONHECE_UM]->(a:Assunto)"
			+ " where id(p) = {0}"
			+ " with collect(a) as assuntos"
			+ " match (novosAssuntos:Assunto)"
			+ " where not(novosAssuntos in assuntos)"
			+ " return novosAssuntos")
	Iterable<Assunto> getNovosAssuntosParaPessoa(Long id);

}
