package br.com.upperapps.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;
import org.neo4j.ogm.annotation.typeconversion.DateString;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@JsonIdentityInfo(generator = JSOGGenerator.class)
@RelationshipEntity(type="CONHECE_UM")
public class Conhecimento {
	
	private Long id;
	
	@StartNode
	private Profissional profissional;
	
	@EndNode
	private Assunto assunto;
	
//	@NotNull(message="A data não pode ser nula.")
//	@NotEmpty(message="A data não pode ser vazia.")
	@DateString("dd/MM/yyyy")
	private Date conheceDesde;
	
//	@NotNull(message="O nível de conhecimento não pode ser nulo.")
//	@NotEmpty(message="O nível de conhecimento não pode estar vazio.")
//	private NivelConhecimento nivelConhecimento;
	
	public Conhecimento() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Profissional getProfissional() {
		return profissional;
	}

	public void setProfissional(Profissional profissional) {
		this.profissional = profissional;
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

//	public NivelConhecimento getNivelConhecimento() {
//		return nivelConhecimento;
//	}
//
//	public void setNivelConhecimento(NivelConhecimento nivelConhecimento) {
//		this.nivelConhecimento = nivelConhecimento;
//	}
}