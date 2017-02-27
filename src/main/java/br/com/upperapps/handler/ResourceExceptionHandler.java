package br.com.upperapps.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.upperapps.domain.DetalhesErro;
import br.com.upperapps.services.exceptions.CategoriaExistenteException;
import br.com.upperapps.services.exceptions.CategoriaNaoEncontradaException;
import br.com.upperapps.services.exceptions.AssuntoExistenteException;
import br.com.upperapps.services.exceptions.AssuntoNaoEncontradoException;
import br.com.upperapps.services.exceptions.ProfissionalExistenteException;
import br.com.upperapps.services.exceptions.ProfissionalNaoEncontradoException;

/**
 * @author Rodrigo Melo Esta classe implementa o padrão Handler. É um
 *         interceptador que captura e trata excessões lançadas pela aplicação
 *         nos resources.
 */
@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ProfissionalExistenteException.class)
	public ResponseEntity<DetalhesErro> handleProfissionalExistenteException(ProfissionalExistenteException e,
			HttpServletRequest request) {
		
		// Carrega as informações que serão exibidas na mensagem de erro do console.
		DetalhesErro erro = new DetalhesErro();
		erro.setSatus(409l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.quemsabeapi.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(ProfissionalNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleProfissionalNaoEncontradoException(ProfissionalNaoEncontradoException e,
			HttpServletRequest request) {
		
		// Carrega as informações que serão exibidas na mensagem de erro do console.
		DetalhesErro erro = new DetalhesErro();
		erro.setSatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.quemsabeapi.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(CategoriaExistenteException.class)
	public ResponseEntity<DetalhesErro> handleCategoriaExistenteException(CategoriaExistenteException e,
			HttpServletRequest request) {
		
		// Carrega as informações que serão exibidas na mensagem de erro do console.
		DetalhesErro erro = new DetalhesErro();
		erro.setSatus(409l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.quemsabeapi.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(CategoriaNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro> handleCategoriaNaoEncontradaException(CategoriaNaoEncontradaException e,
			HttpServletRequest request) {
		
		// Carrega as informações que serão exibidas na mensagem de erro do console.
		DetalhesErro erro = new DetalhesErro();
		erro.setSatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.quemsabeapi.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(AssuntoExistenteException.class)
	public ResponseEntity<DetalhesErro> handleAssuntoExistenteException(AssuntoExistenteException e,
			HttpServletRequest request) {
		
		// Carrega as informações que serão exibidas na mensagem de erro do console.
		DetalhesErro erro = new DetalhesErro();
		erro.setSatus(409l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.quemsabeapi.com/409");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(AssuntoNaoEncontradoException.class)
	public ResponseEntity<DetalhesErro> handleAssuntoNaoEncontradoException(AssuntoNaoEncontradoException e,
			HttpServletRequest request) {
		
		// Carrega as informações que serão exibidas na mensagem de erro do console.
		DetalhesErro erro = new DetalhesErro();
		erro.setSatus(404l);
		erro.setTitulo(e.getMessage());
		erro.setMensagemDesenvolvedor("http://erros.quemsabeapi.com/404");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<DetalhesErro> handleDataIntegrityViolationException(DataIntegrityViolationException e,
			HttpServletRequest request) {
		
		// Carrega as informações que serão exibidas na mensagem de erro do console.
		DetalhesErro erro = new DetalhesErro();
		erro.setSatus(400l);
		erro.setTitulo("Requisição inválida.");
		erro.setMensagemDesenvolvedor("http://erros.quemsabeapi.com/400");
		erro.setTimestamp(System.currentTimeMillis());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
}
