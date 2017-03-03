package br.com.upperapps.repository;

import org.springframework.data.neo4j.repository.GraphRepository;
import org.springframework.stereotype.Repository;

import br.com.upperapps.domain.Pessoa;

@Repository
public interface PessoaRepository extends GraphRepository<Pessoa>{
	
}
