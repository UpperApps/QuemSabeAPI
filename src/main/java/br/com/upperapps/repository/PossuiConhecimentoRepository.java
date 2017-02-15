package br.com.upperapps.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import br.com.upperapps.domain.PossuiConhecimento;

public interface PossuiConhecimentoRepository extends GraphRepository<PossuiConhecimento>{
	
	@Query("MATCH p=()-[r:POSSUI_CONHECIMENTO_EM]->() RETURN p")
	Iterable<PossuiConhecimento> findAll();

}