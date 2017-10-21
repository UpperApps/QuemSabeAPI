package br.com.upperapps.repository;

import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.GraphRepository;

import br.com.upperapps.DTO.ConhecimentoPessoaDTO;
import br.com.upperapps.domain.Conhecimento;

public interface ConhecimentoRepository extends GraphRepository<Conhecimento>{

	@Query("match m=(p:Pessoa)-[r:CONHECE_UM]->(a:Assunto)-[r2:PERTENCE_A_CATEGORIA]->(c:Categoria)"
			+ " where id(p) = {0} return m")
	Iterable<Conhecimento> getConhecimentosDaPessoa(Long id);
	
	@Query("match m=(p:Pessoa)-[r:CONHECE_UM]->(a:Assunto)-[r2:PERTENCE_A_CATEGORIA]->(c:Categoria)"
			+ " where id(a) = {0} return m")
	Iterable<Conhecimento> getPessoasQueConhecemUmAssunto(Long id);
	
	@Query("match m=(p:Pessoa)-[r:CONHECE_UM]->(a:Assunto)-[r2:PERTENCE_A_CATEGORIA]->(c:Categoria)"
			+ "where id(p) = {0} return c as categoria, collect(a) as assuntos")
	Iterable<ConhecimentoPessoaDTO> getArvoreConhecimento(Long id);
}