package br.com.upperapps.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonValue;


public enum NivelConhecimento {
	
	INICIANTE("D", "Iniciante", "Sem nenhuma experiência."),
	BASICO("C", "Básico", "Pouca experiência"),
	INTERMEDIARIO("B", "Intermediário", "Bom domínio do assunto."),
	AVANÇADO("A","Avançado", "Domínio completo do assunto");
	
	private String nivel;
	private String nome;
	private String descricao;
	
	private NivelConhecimento(String nivel, String nome, String descricao){
		this.nivel = nivel;
		this.nome = nome;
		this.descricao = descricao;
	}
	
	@JsonValue
	public String getNivel(){
		return nivel;
	}

	@JsonIgnore
	public String getNome() {
		return nome;
	}

	@JsonIgnore
	public String getDescricao() {
		return descricao;
	}
	
}
