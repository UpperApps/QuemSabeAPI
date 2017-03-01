package br.com.upperapps.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

@NodeEntity
public class Assunto {
	
	@GraphId
	private Long id;
	
	@NotEmpty(message="O nome não pode estar vazio.")
	@NotNull(message="O nome não pode ser nulo.")
	@Size(max=50, message="O nome deve conter no máximo 50 caracteres")
	private String nome;
	
	@Size(max=300, message="A descrição deve conter no máximo 300 caracteres")
	private String descricao;
	
	@NotNull(message="A categoria não pode ser nula.")
	@Relationship(type = "PERTENCE_A_CATEGORIA", direction = Relationship.OUTGOING)
	private Categoria categoria;
	
//	@Relationship(type = "CONHECE_UM", direction = Relationship.INCOMING)
//	private Set<Conhecimento> conhecimento = new HashSet<>();
	
	public Assunto(){
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

//	public Set<Conhecimento> getConhecimento() {
//		return conhecimento;
//	}
//
//	public void setConhecimento(Set<Conhecimento> conhecimento) {
//		this.conhecimento = conhecimento;
//	}
	
}
