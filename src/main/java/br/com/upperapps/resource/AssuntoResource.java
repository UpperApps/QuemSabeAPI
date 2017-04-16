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

import br.com.upperapps.domain.Assunto;
import br.com.upperapps.services.AssuntoService;


@RestController
@RequestMapping("quemsabe/assunto/")
public class AssuntoResource {
	
	@Autowired
	private AssuntoService assuntoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Assunto>> listar(){
		
		Iterable<Assunto> assunto = assuntoService.listar();
		
		return ResponseEntity.status(HttpStatus.OK).body(assunto);
	}
	
	@RequestMapping(value = ("/{id}"), method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Assunto> buscar(@PathVariable("id") Long id){
		Assunto assunto = assuntoService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(assunto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Assunto assunto){
		
		assunto = assuntoService.salvar(assunto);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(assunto.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Assunto assunto, @PathVariable("id") Long id) {
		assunto.setId(id);
		assuntoService.atualizar(assunto);

		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {

		assuntoService.deletar(id);

		return ResponseEntity.noContent().build();
	}

}
