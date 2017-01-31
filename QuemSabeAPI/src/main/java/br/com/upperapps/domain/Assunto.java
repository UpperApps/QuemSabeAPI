package br.com.upperapps.domain;

import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Assunto {
	
	@GraphId
	private Long id;
	
	private String nome;
	
	@Relationship(type = "TEM_CATEGORIA", direction = "OUTGOING")
	private Categoria categoria;
	
	public Assunto(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
}
