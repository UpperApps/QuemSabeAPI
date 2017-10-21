package br.com.upperapps.DTO;

import java.util.List;

import org.springframework.data.neo4j.annotation.QueryResult;

import br.com.upperapps.domain.Assunto;
import br.com.upperapps.domain.Categoria;

@QueryResult
public class ConhecimentoPessoaDTO {
	private Categoria categoria;
	private List<Assunto> assuntos;

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Assunto> getAssuntos() {
		return assuntos;
	}

	public void setAssuntos(List<Assunto> assuntos) {
		this.assuntos = assuntos;
	}
	
}
