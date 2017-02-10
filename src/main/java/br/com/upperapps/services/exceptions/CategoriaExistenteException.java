package br.com.upperapps.services.exceptions;

public class CategoriaExistenteException extends RuntimeException{
	
	private static final long serialVersionUID = 1869300553614629712L;

	public CategoriaExistenteException(String mensagem) {
		super(mensagem);
	}

	public CategoriaExistenteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}

}