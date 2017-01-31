package br.com.upperapps.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import br.com.upperapps.domain.Profissional;

@Repository
public interface ProfissionalRepository extends GraphRepository<Profissional>{
	
}
