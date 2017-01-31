package br.com.upperapps.domain;

public enum NivelConhecimento {
	
	INICIANTE("Iniciante"),
	INTERMEDIARIO("Intermediário"),
	AVANÇADO("Avançado");
	
	private String nivel;
	
	private NivelConhecimento(String nivel){
		this.nivel = nivel;
	}
	
	public String getNivel(){
		return nivel;
	}
}
