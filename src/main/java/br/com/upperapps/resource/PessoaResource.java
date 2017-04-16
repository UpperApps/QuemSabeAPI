package br.com.upperapps.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.upperapps.domain.Conhecimento;
import br.com.upperapps.domain.Pessoa;
import br.com.upperapps.services.PessoaService;

@RestController
@RequestMapping("quemsabe/pessoa/")
public class PessoaResource {

	@Autowired
	private PessoaService pessoaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Pessoa>> listar(){
		
		Iterable<Pessoa> pessoa = pessoaService.listar();
		
		return ResponseEntity.status(HttpStatus.OK).body(pessoa);
	}
	
	@RequestMapping(value = ("/{id}"), method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Pessoa> buscar(@PathVariable("id") Long id){
		Pessoa pessoa = pessoaService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(pessoa);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Pessoa pessoa){
		
		pessoa = pessoaService.salvar(pessoa);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(pessoa.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Pessoa pessoa, @PathVariable("id") Long id) {
		pessoa.setId(id);
		pessoaService.atualizar(pessoa);

		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {

		pessoaService.deletar(id);

		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = ("/{id}/conhecimentos"), method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Conhecimento>> buscarConhecimentosDaPessoa(@PathVariable("id") Long id){
		
		Iterable<Conhecimento> conhecimentos = pessoaService.buscarConhecimentosDoProfissiinal(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(conhecimentos);
		
	}
	
	@RequestMapping(value = ("/conheceassunto/{id}"), method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Conhecimento>> buscarPessoasQueConhecemUmAssunto(@PathVariable("id") Long id){
		
		Iterable<Conhecimento> conhecimentos = pessoaService.buscarPessoasQueConhecemUmAssunto(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(conhecimentos);
		
	}
}
