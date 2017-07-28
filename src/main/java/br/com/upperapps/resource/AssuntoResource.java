package br.com.upperapps.resource;

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

import br.com.upperapps.domain.Assunto;
import br.com.upperapps.services.AssuntoService;


@RestController
@RequestMapping("quemsabe/assunto/")
public class AssuntoResource {
	
	@Autowired
	private AssuntoService assuntoService;
	
	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Assunto>> listar(){
		
		Iterable<Assunto> assuntos = assuntoService.listar();
		
		return ResponseEntity.status(HttpStatus.OK).body(assuntos);
	}
	
	@RequestMapping(value = ("/{id}"), method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Assunto> buscar(@PathVariable("id") Long id){
		Assunto assunto = assuntoService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(assunto);
	}
	
	@RequestMapping(value = ("/novos/pessoa/{id}"), method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Assunto>> listarNovosAssuntosParaPessoa(@PathVariable("id") Long id){
		
		Iterable<Assunto> assuntos = assuntoService.listarNovosAssuntosParaPessoa(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(assuntos);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Assunto> salvar(@Valid @RequestBody Assunto assunto){
		
		Assunto novoAssunto = assuntoService.salvar(assunto);		
		return ResponseEntity.status(HttpStatus.OK).body(novoAssunto);
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
