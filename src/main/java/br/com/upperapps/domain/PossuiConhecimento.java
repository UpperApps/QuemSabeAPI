package br.com.upperapps.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@RelationshipEntity(type="POSSUI_CONHECIMENTO_EM")
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class PossuiConhecimento {
	
	@JsonProperty("id")
	private Long id;
	
	@StartNode
	private Profissional profissional;
	
	@EndNode
	private Conhecimento conhecimento;
	
//	@NotNull(message="A data não pode ser nula.")
//	@NotEmpty(message="A data não pode ser vazia.")
	private Date conheceDesde;
	
//	@NotNull(message="O nível de conhecimento não pode ser nulo.")
//	@NotEmpty(message="O nível de conhecimento não pode estar vazio.")
//	private NivelConhecimento nivelConhecimento;
	
	public PossuiConhecimento() {
		
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

	public Conhecimento getConhecimento() {
		return conhecimento;
	}

	public void setConhecimento(Conhecimento conhecimento) {
		this.conhecimento = conhecimento;
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