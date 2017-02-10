package br.com.upperapps.domain;

import java.util.Date;

import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

@RelationshipEntity(type="POSSUI_CONHECIMENTO_EM")
public class PossuiConhecimento {

	@GraphId
	private Long id;
	
	@StartNode
	private Profissional profissional;
	
	@EndNode
	private Conhecimento conhecimento;
	
	private Date conheceDesde;
	
	private NivelConhecimento nivelConhecimento;
	
	public PossuiConhecimento() {
		
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

	public NivelConhecimento getNivelConhecimento() {
		return nivelConhecimento;
	}

	public void setNivelConhecimento(NivelConhecimento nivelConhecimento) {
		this.nivelConhecimento = nivelConhecimento;
	}
}