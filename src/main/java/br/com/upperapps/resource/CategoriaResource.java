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

import br.com.upperapps.domain.Categoria;
import br.com.upperapps.services.CategoriaService;

@RestController
@RequestMapping("quemsabe/categoria/")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;
	
	@RequestMapping(method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Iterable<Categoria>> listar(){
		
		Iterable<Categoria> categoria = categoriaService.listar();
		
		return ResponseEntity.status(HttpStatus.OK).body(categoria);
	}
	
	@RequestMapping(value = ("/{id}"), method = RequestMethod.GET, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Categoria> buscar(@PathVariable("id") Long id){
		Categoria categoria = categoriaService.buscar(id);
		return ResponseEntity.status(HttpStatus.OK).body(categoria);
	}
	
	@RequestMapping(method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<Categoria> salvar(@Valid @RequestBody Categoria categoria){
		
		Categoria novaCategoria = categoriaService.salvar(categoria);		
		return ResponseEntity.status(HttpStatus.OK).body(novaCategoria);
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@RequestBody Categoria categoria, @PathVariable("id") Long id) {
		categoria.setId(id);
		categoriaService.atualizar(categoria);

		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {

		categoriaService.deletar(id);

		return ResponseEntity.noContent().build();
	}
}
