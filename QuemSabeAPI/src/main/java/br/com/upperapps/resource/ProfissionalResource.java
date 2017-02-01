package br.com.upperapps.resource;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.upperapps.domain.Profissional;
import br.com.upperapps.service.ProfissionalService;

@RestController
@RequestMapping("profissional/")
public class ProfissionalResource {

	@Autowired
	private ProfissionalService profissionalService;
	
	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Profissional>> listar(){
		
		Iterable<Profissional> profissional = profissionalService.listar();
		
		return ResponseEntity.status(HttpStatus.OK).body(profissional);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Profissional profissional){
		
		profissional = profissionalService.salvar(profissional);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(profissional.getId()).toUri();
		
		return ResponseEntity.created(uri).build();
	}
}
