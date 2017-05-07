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
import br.com.upperapps.services.ConhecimentoService;

@RestController
@RequestMapping("quemsabe/conhece/")
public class ConhecimentoResource {

	@Autowired
	private ConhecimentoService conhecimentoService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Iterable<Conhecimento>> listar() {

		Iterable<Conhecimento> conhecimento = conhecimentoService.listar();

		return ResponseEntity.status(HttpStatus.OK).body(conhecimento);
	}

	@RequestMapping(value = ("/{id}"), method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Conhecimento> buscar(@PathVariable("id") Long id) {
		Conhecimento conhecimento = conhecimentoService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(conhecimento);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Conhecimento> salvar(@Valid @RequestBody Conhecimento conhecimento) {

		Conhecimento novoConhecimento = conhecimentoService.salvar(conhecimento);
		return ResponseEntity.status(HttpStatus.OK).body(novoConhecimento);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Conhecimento conhecimento, @PathVariable("id") Long id) {
		conhecimento.setId(id);
		conhecimentoService.atualizar(conhecimento);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {

		conhecimentoService.deletar(id);

		return ResponseEntity.noContent().build();
	}

}
