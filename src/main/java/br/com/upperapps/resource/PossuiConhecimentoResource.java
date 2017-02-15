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

import br.com.upperapps.domain.PossuiConhecimento;
import br.com.upperapps.services.PossuiConhecimentoService;

@RestController
@RequestMapping("possuiconhecimento/")
public class PossuiConhecimentoResource {

	@Autowired
	private PossuiConhecimentoService possuiConhecimentoService;

	@RequestMapping(method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Iterable<PossuiConhecimento>> listar() {

		Iterable<PossuiConhecimento> possuiConhecimento = possuiConhecimentoService.listar();

		return ResponseEntity.status(HttpStatus.OK).body(possuiConhecimento);
	}

	@RequestMapping(value = ("/{id}"), method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<PossuiConhecimento> buscar(@PathVariable("id") Long id) {
		PossuiConhecimento possuiConhecimento = possuiConhecimentoService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(possuiConhecimento);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Void> salvar(@Valid @RequestBody PossuiConhecimento possuiConhecimento) {

		possuiConhecimento = possuiConhecimentoService.salvar(possuiConhecimento);

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(possuiConhecimento.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody PossuiConhecimento possuiConhecimento, @PathVariable("id") Long id) {
		possuiConhecimento.setId(id);
		possuiConhecimentoService.atualizar(possuiConhecimento);

		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {

		possuiConhecimentoService.deletar(id);

		return ResponseEntity.noContent().build();
	}

}
