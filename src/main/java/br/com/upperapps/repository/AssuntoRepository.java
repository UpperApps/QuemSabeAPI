package br.com.upperapps.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import br.com.upperapps.domain.Assunto;

@Repository
public interface AssuntoRepository extends GraphRepository<Assunto>{

}
