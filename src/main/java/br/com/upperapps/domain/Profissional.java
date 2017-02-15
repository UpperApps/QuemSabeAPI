package br.com.upperapps.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.voodoodyne.jackson.jsog.JSOGGenerator;

@NodeEntity
@JsonIdentityInfo(generator = JSOGGenerator.class)
public class Profissional {
	
	@GraphId
	private Long id;
	
	@NotEmpty(message="O nome não pode estar vazio.")
	@NotNull(message="O nome não pode ser nulo.")
	@Size(max=50, message="O nome deve conter no máximo 50 caracteres")
	private String nome;
	
	@NotEmpty(message="O e-mail não pode estar vazio.")
	@NotNull(message="O e-mail não pode ser nulo.")
	@Size(max=30, message="O email deve conter no máximo 30 caracteres")
	@Pattern(regexp = ".+@.+\\.[a-z]+", message="E email deve algo como: seuemail@dominio.com")
	private String email;
	
	public Profissional(){
		
	}
	
	public Profissional(String nome, String email) {
		this.nome = nome;
		this.email = email;
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
