package br.com.upperapps.domain;

import java.util.Date;

import javax.validation.constraints.NotNull;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@RelationshipEntity(type="CONHECE_UM")
public class Conhecimento {
	
	@GraphId
	private Long id;
	
	@StartNode
	private Pessoa pessoa;
	
	@EndNode
	private Assunto assunto;
	
	@NotNull(message="A data não pode ser nula.")
	@DateString("dd/MM/yyyy")
	private Date conheceDesde;
	
	@NotNull(message="O nível de conhecimento não pode ser nulo.")
	private NivelConhecimento nivelConhecimento;
	
	public Conhecimento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	public Assunto getAssunto() {
		return assunto;
	}

	public void setAssunto(Assunto assunto) {
		this.assunto = assunto;
	}

	public Date getConheceDesde() {
		return conheceDesde;
	}

	public void setConheceDesde(Date conheceDesde) {
		this.conheceDesde = conheceDesde;
	}
	
	public NivelConhecimento getNivelConhecimento() {
		return nivelConhecimento;
	}

	public void setNivelConhecimento(NivelConhecimento nivelConhecimento) {
		this.nivelConhecimento = nivelConhecimento;
	}
}